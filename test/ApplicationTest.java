import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import org.junit.*;

import play.mvc.*;
import play.test.*;
import play.data.DynamicForm;
import play.data.validation.ValidationError;
import play.data.validation.Constraints.RequiredValidator;
import play.i18n.Lang;
import play.libs.F;
import play.libs.F.*;
import play.twirl.api.Content;

import static play.test.Helpers.*;
import static org.junit.Assert.*;

/**
 *
 * Simple (JUnit) tests that can call all parts of a play app.
 * If you are interested in mocking a whole application, see the wiki for more details.
 *
 */
public class ApplicationTest {

    /* Confirm a simple test works */
    @Test
    public void simpleTest() {
        int a = 1 + 1;
        assertEquals(2, a);
    }

    /* Confirm boostrap href is loaded to body */
    @Test
    public void renderBootstrap() {
        Content html = views.html.index.render();
        assertEquals("text/html", html.contentType());
        assertTrue(html.body().contains("<link href=\"/assets/stylesheets/bootstrap.min.css\" rel=\"stylesheet\">"));
    }

    /* Confirm CSS  is loaded to body */
    @Test
    public void renderCSS() {
        Content html = views.html.index.render();
        assertEquals("text/html", html.contentType());
        assertTrue(html.body().contains("<link href=\"/assets/stylesheets/modern-business.css\" rel=\"stylesheet\">"));
    }



}
