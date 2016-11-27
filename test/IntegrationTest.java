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
            assertTrue(browser.pageSource().contains("Testorama"));
        });
    }

    @Test
    public void testProductionLikeQuestions() {
        running(testServer(9000, fakeApplication(inMemoryDatabase())), HTMLUNIT, browser -> {
            browser.goTo("http://e71project-test-gccloud.boxfuse.io/listQuestions");
            assertTrue(browser.pageSource().contains("Testorama"));
        });
    }

    @Test
    public void testProductionLikeExam() {
        running(testServer(9000, fakeApplication(inMemoryDatabase())), HTMLUNIT, browser -> {
            browser.goTo("http://e71project-test-gccloud.boxfuse.io/viewExams");
            assertTrue(browser.pageSource().contains("Testorama"));
        });
    }

    @Test
    public void testLiveHome() {
        running(testServer(80, fakeApplication(inMemoryDatabase())), HTMLUNIT, browser -> {
            browser.goTo("http://www.testorama.online/");
            assertTrue(browser.pageSource().contains("Testorama"));
        });
    }

    @Test
    public void testLiveQuestions() {
        running(testServer(9000, fakeApplication(inMemoryDatabase())), HTMLUNIT, browser -> {
            browser.goTo("http://www.testorama.online/listQuestions");
            assertTrue(browser.pageSource().contains("Testorama"));
        });
    }

    @Test
    public void testLiveExams() {
        running(testServer(9000, fakeApplication(inMemoryDatabase())), HTMLUNIT, browser -> {
            browser.goTo("http://www.testorama.online/viewExams");
            assertTrue(browser.pageSource().contains("Testorama"));
        });
    }

}
