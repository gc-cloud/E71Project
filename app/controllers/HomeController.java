package controllers;


import play.mvc.*;
import views.html.*;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    /**
     * Renders index page.
     */
    public Result index() {

        return ok(index.render());
    }


    /**
     * Manage various http request  results
     *
     */
    public Result oops(){
          Result ok = ok("Hello world!");
//        Result notFound = notFound();
//        Result pageNotFound = notFound("<h1>Page not found</h1>").as("text/html");
//        Result badRequest = badRequest(views.html.form.render(formWithErrors));
//        Result oops = internalServerError("Oops");
//        Result anyStatus = status(488, "Strange response type");
          return ok;
    }

    /**
     * Process request to generate exam
     *
     */

    public Result generateExams(){
        Result ok = ok(generateExams.render());
        return ok;

    }

    /**
     * Process request to view exams
     *
     */

    public Result viewExams(){
        Result ok = ok(viewExams.render());
        return ok;
    }

    /**
     * Process request to print exams
     *
     */
    public Result printExams(){
        Result ok = ok(printExams.render());
        return ok;
    }

    /**
     * Process request to signup
     *
     */
    public Result signup(){
        Result ok = ok(signup.render());
        return ok;
    }


}
