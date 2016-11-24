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
    public void test() {
//        running(testServer(3333, fakeApplication(inMemoryDatabase())), HTMLUNIT, browser -> {
//            browser.goTo("http://localhost:3333");
//            assertTrue(browser.pageSource().contains("Your new application is ready."));
//        });

    }


    @Test
    public void testSomething() {
        running(testServer(9000, fakeApplication(inMemoryDatabase())), HTMLUNIT, browser -> {
            browser.goTo("http://e71project-test-gccloud.boxfuse.io:9000/");
            assertTrue(browser.pageSource().contains("Testorama"));
        });



    }

}
