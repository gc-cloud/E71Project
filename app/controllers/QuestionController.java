package controllers;


import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

/**
 * This controller contains methods to handle questions.
 */
public class QuestionController extends Controller {

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
