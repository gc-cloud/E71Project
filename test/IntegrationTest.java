import org.junit.*;

import play.mvc.*;
import play.test.*;
import play.twirl.api.Content;

import static play.test.Helpers.*;
import static org.junit.Assert.*;

import static org.fluentlenium.core.filter.FilterConstructor.*;

public class IntegrationTest {

    /**
     * add your integration test here
     * in this example we just check if the welcome page is being shown
     */

    @Test
    public void testProductionLikeHome() {
        running(testServer(9000, fakeApplication(inMemoryDatabase())), HTMLUNIT, browser -> {
            browser.goTo("http://e71project-test-gccloud.boxfuse.io/");
            assertTrue(browser.pageSource().contains("Driving innovation"));
        });
    }

    @Test
    public void testProductionLikeViewExams() {
        running(testServer(9000, fakeApplication(inMemoryDatabase())), HTMLUNIT, browser -> {
            browser.goTo("http://e71project-test-gccloud.boxfuse.io/viewExams");
            assertTrue(browser.pageSource().contains("List Exams"));
        });
    }

    @Test
    public void testProductionLikeGenerateExams() {
        running(testServer(9000, fakeApplication(inMemoryDatabase())), HTMLUNIT, browser -> {
            browser.goTo("http://e71project-test-gccloud.boxfuse.io/generateExams");
            assertTrue(browser.pageSource().contains("Generate Exams"));
        });
    }

    @Test
    public void testProductionLikeEditQuestion() {
        running(testServer(9000, fakeApplication(inMemoryDatabase())), HTMLUNIT, browser -> {
            browser.goTo("http://e71project-test-gccloud.boxfuse.io/questions/4");
            assertTrue(browser.pageSource().contains("Edit Question"));
        });
    }


}
