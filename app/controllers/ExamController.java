package controllers;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.Transaction;
import models.Question;
import models.Exam;
import play.mvc.*;
import views.html.*;
import play.data.*; // FormFactory
import javax.inject.Inject;
import javax.persistence.PersistenceException;
import java.util.*;
import util.pdf.PDF;
//import
import static sun.security.ssl.Debug.println;
//import static play.data.*;


/**
 * This controller contains methods to handle questions.
 */
public class ExamController extends Controller {

    /* FormFactory allows to create forms on the fly given a class type
     e.g. Form<T> newForm = formFactory.form(T.class).fill(T.find.byId());*/
    private FormFactory formFactory;
    @Inject
    public ExamController(FormFactory formFactory) {
        this.formFactory = formFactory;
    }

    /**
     * This result directly redirect to application home.
     */
    public Result GO_HOME = Results.redirect(
            routes.ExamController.list(0, "name", "asc", "")
    );

    /**
     * List exams
     *
     */
    public Result list(int page, String sortBy, String order, String filter) {
        return ok(
                views.html.list.render(
                        Question.page(page, 10, sortBy, order, filter),
                        sortBy, order, filter
                )
        );
    }

    /**
     * Display the 'new question form'.
     */
    public Result create() {
        Form<Question> questionForm = formFactory.form(Question.class);
        return ok(
               views.html.createForm.render(questionForm)

        );
    }

    /**
     * Handle the 'new exam form' submission
     */
    public Result save() {
        Form<Exam> examForm = formFactory.form(Exam.class).bindFromRequest();
        Set<Question> questions = new HashSet<Question>();
        String[] postAction = request().body().asFormUrlEncoded().get("action");
        String action = postAction[0];
        if ("random".equals(action)) {
            int questionAmount=6;
            List<Question> questionlist= Question.find.all();
            long seed = System.nanoTime();
            Collections.shuffle(questionlist, new Random(seed));
            for(int m=0;m<questionAmount;m++){
                questions.add(questionlist.get(m));
            }
        }else {
            Map<String, String[]> formUrlEncoded = request().body().asFormUrlEncoded();
            // iterate through the keys to find values and pre-fill required Set(s)
            for (String key : formUrlEncoded.keySet()) {
                String[] values = formUrlEncoded.get(key);
                for (String val : values) {
                    if ("select".equals(key)) questions.add(Question.find.ref(Long.valueOf(val)));
                }
            }
        }
        // Check if form has no errors and if it contains questions
        if (examForm.hasErrors() || questions.size() < 1) {
            return badRequest();
        }

        // Create an Exam, fill with data from form, save
        Exam exam = new Exam();
        exam = examForm.get();
        exam.questions = questions;
        exam.save();
        flash("success", "Exam " + examForm.get().name + " has been created");
        return ok(
                views.html.viewExamDetails.render(exam.id,examForm,questions,true)
        );
    }

    /**
     * Handle question deletion
     */
    public Result delete(Long id) {
        Question.find.ref(id).delete();
        flash("success", "Question has been deleted");
        return GO_HOME;
    }

    /**
     * Display the 'view detail' of a existing Exam.
     *
     * @param id Id of the computer to edit
     */
    public Result view(Long id) {
        Exam exam = Exam.find.byId(id);
        Set<Question> questions = exam.questions;
        Form<Exam> examForm = formFactory.form(Exam.class).fill(exam);
        return ok(
                views.html.viewExamDetails.render(id,examForm,questions,true)
        );

    }

    /**
     * Display the 'PDF view ' of a existing Exam.
     *
     * @param id Id of the computer to edit
     */
    public Result pdfView(Long id,boolean withAnswer) {
        Exam exam = Exam.find.byId(id);
        Set<Question> questions = exam.questions;
        Form<Exam> examForm = formFactory.form(Exam.class).fill(exam);
        return PDF.ok(views.html.viewExamDetails.render(id,examForm,questions,withAnswer));
    }

    /**
     * Handle the 'edit form' submission
     *
     * @param id Id of the question to edit
     */
/*    public Result update(Long id) throws PersistenceException {
        Form<Question> questionForm = formFactory.form(Question.class).bindFromRequest();
        if(questionForm.hasErrors()) {
            return badRequest(views.html.editForm.render(id, questionForm));
        }

        Transaction txn = Ebean.beginTransaction();
        try {
            Question savedQuestion = Question.find.byId(id);
            if (savedQuestion != null) {
                Question newQuestionData = questionForm.get();

                savedQuestion.category = newQuestionData.category;
                savedQuestion.name = newQuestionData.name;
                savedQuestion.answer1 = newQuestionData.answer1;
                savedQuestion.answer2 = newQuestionData.answer2;
                savedQuestion.answer3 = newQuestionData.answer3;
                savedQuestion.answer4 = newQuestionData.answer4;
                savedQuestion.correct_answer = newQuestionData.correct_answer;

                savedQuestion.update();
                flash("success", "Question " + questionForm.get().name + " has been updated");
                txn.commit();
            }
        } finally {
            txn.end();
        }

        return GO_HOME;
    }*/


    /**
     * Process request to generate exam
     *
     *
     */

    public Result generateExams(int page, String sortBy, String order, String filter){
        return ok(
                views.html.generateExams.render(
                Question.page(page, 10, sortBy, order, filter),
                sortBy,order,filter
                )
        );
    }

    /**
     * Process request to generate exam
     */

    public Result viewExams(int page, String sortBy, String order, String filter){
        return ok(
                views.html.viewExams.render(
                        Exam.page(page, 10, sortBy, order, filter),
                        sortBy, order, filter
                ));
    }

    /**
     * Process request to generate exam
     *
     */

    public Result printExams(){
        return ok();
    }

}
