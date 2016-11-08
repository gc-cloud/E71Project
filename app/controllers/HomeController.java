package controllers;


import play.mvc.*;
import views.html.*;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
        return ok(index.render());
    }

    /**
     * Test method to render an HTML page with a welcome message, bootstrap and
     * Testorator menus
     */
    public Result testorama(){

        return ok(index.render());
    }

    /**
     * Test various page results
     *
     */
    public Result aResult(){
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
