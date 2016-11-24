package controllers;

import models.*; // recognize Models
import com.avaje.ebean.Ebean;
import com.avaje.ebean.Transaction;
import javax.inject.Inject; // @Inject
import javax.persistence.PersistenceException;
import play.data.*; // FormFactory
import play.mvc.Controller;
import play.mvc.*;
//import views.html.*;
//import static play.data.Form.*;


/**
 * This controller contains methods to handle questions.
 */
public class QuestionController extends Controller {

    /* FormFactory allows to create forms on the fly given a class type
     e.g. Form<T> newForm = formFactory.form(T.class).fill(T.find.byId());*/
    private FormFactory formFactory;
    @Inject
    public QuestionController(FormFactory formFactory) {
        this.formFactory = formFactory;
    }

    /**
     * This result directly redirect to application home.
     */
    public Result GO_HOME = Results.redirect(
            routes.QuestionController.list(0, "name", "asc", "")
    );

    /**
     * List questions
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
     * Handle the 'new question form' submission
     */
    public Result save() {
        Form<Question> questionForm = formFactory.form(Question.class).bindFromRequest();
        if(questionForm.hasErrors()) {
            return badRequest(views.html.createForm.render(questionForm));
        }
        questionForm.get().save();
        flash("success", "Question " + questionForm.get().name + " has been created");
        return GO_HOME;
    }

    /**
     * Handle question deletion
     *
     */
    public Result delete(Long id) {
        Question.find.ref(id).delete();
        flash("success", "Question has been deleted");
        return GO_HOME;
    }

    /**
     * Display the 'edit form' of a existing Question.
     *
     * @param id Id of the computer to edit
     */
    public Result edit(Long id) {
        Form<Question> questionForm = formFactory.form(Question.class).fill(
                Question.find.byId(id)
        );
        return ok(
                views.html.editForm.render(id, questionForm)
        );
    }

    /**
     * Handle the 'edit form' submission
     *
     * @param id Id of the question to edit
     */
    public Result update(Long id) throws PersistenceException {
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
                savedQuestion.answer_description = newQuestionData.answer_description;

                savedQuestion.update();
                flash("success", "Question " + questionForm.get().name + " has been updated");
                txn.commit();
            }
        } finally {
            txn.end();
        }

        return GO_HOME;
    }



}
