package controllers;



//import static play.data.Form.*;
import models.*; // recognize Models
//import com.avaje.ebean.Ebean;
//import com.avaje.ebean.Transaction;
//import play.mvc.*;
import javax.inject.Inject; // @Inject
//import javax.persistence.PersistenceException;

import play.data.*; // FormFactory

import play.mvc.Controller;
import play.mvc.*;
import views.html.*;

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
     * This is a test method to list prepopulated
     * data
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
     * Display the 'edit form' of a existing Question.
     *
     * @param id Id of the computer to edit
     */
    public Result edit(Long id) {
        Form<Question> questionForm = formFactory.form(Question.class).fill(
                Question.find.byId(id)
        );
        return ok(
              //  views.html.editForm.render(id, questionForm)
        );
    }


    /**
     * Process request to add Questions
     *
     */
    public Result addQuestions(){

        Result ok = ok(addQuestions.render());
        return ok;
    }

    /**
     * Process request to edit questions
     *
     */
    public Result editQuestions(){
        Result ok = ok(editQuestions.render());
        return ok;
    }

    /**
     * Process request to submit
     *
     */
    public Result submit(){
        Result ok = ok(addQuestions.render());
        return ok;
    }
}
