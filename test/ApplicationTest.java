
import org.junit.*;
import models.Question; // recognize Models
import models.Category;

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

    /* Confirm Category Save */
    @Test
    public void testCategoryRead() {
        running(fakeApplication(), new Runnable() {
            public void run() {
                Category findMe = Category.find.byId(1L);
                assertEquals(findMe.name,"Network"); // "Network" loaded with evolution
            }
        });
    }

    /* Confirm Category Read from DB */
    @Test
    public void testCategorySave() {
        running(fakeApplication(), new Runnable() {
            public void run() {
                Category newCategory = new Category();
                newCategory.name = "To be or not to be";
                newCategory.save();
                assertNotNull(newCategory);
            }
        });
    }

    /* Confirm Question Name Save  */
    @Test
    public void testQuestionNameSave() {
        running(fakeApplication(), new Runnable() {
            public void run() {
                Question savedQuestion = new Question();
                savedQuestion.name = "To be or not to be";
                savedQuestion.save();
                Question findMe = Question.find.byId(savedQuestion.id);
                assertEquals(findMe.name,"To be or not to be");
            }
        });
    }

    /* Confirm Question Answer1 Save  */
    @Test
    public void testQuestionAnswer1Save() {
        running(fakeApplication(), new Runnable() {
            public void run() {
                Question savedQuestion = new Question();
                savedQuestion.answer1 = "yes";
                savedQuestion.save();
                Question findMe = Question.find.byId(savedQuestion.id);
                assertEquals(findMe.answer1,"yes");
            }
        });
    }

    /* Confirm Question Answer2 Save  */
    @Test
    public void testQuestionAnswer2Save() {
        running(fakeApplication(), new Runnable() {
            public void run() {
                Question savedQuestion = new Question();
                savedQuestion.answer2 = "no";
                savedQuestion.save();
                Question findMe = Question.find.byId(savedQuestion.id);
                assertEquals(findMe.answer2,"no");
            }
        });
    }

    /* Confirm Question Answer3 Save  */
    @Test
    public void testQuestionAnswer3Save() {
        running(fakeApplication(), new Runnable() {
            public void run() {
                Question savedQuestion = new Question();
                savedQuestion.answer3 = "probably";
                savedQuestion.save();
                Question findMe = Question.find.byId(savedQuestion.id);
                assertEquals(findMe.answer3,"probably");
            }
        });
    }

    /* Confirm Question Answer4 Save  */
    @Test
    public void testQuestionAnswer4Save() {
        running(fakeApplication(), new Runnable() {
            public void run() {
                Question savedQuestion = new Question();
                savedQuestion.answer4 = "all of the above";
                savedQuestion.save();
                Question findMe = Question.find.byId(savedQuestion.id);
                assertEquals(findMe.answer4,"all of the above");
            }
        });
    }

    /* Confirm Question Correct Answer Save  */
    @Test
    public void testQuestionCorrectAnswerSave() {
        running(fakeApplication(), new Runnable() {
            public void run() {
                Question savedQuestion = new Question();
                savedQuestion.correct_answer = "why did the chicken cross the road?";
                savedQuestion.save();
                Question findMe = Question.find.byId(savedQuestion.id);
                assertEquals(findMe.correct_answer,"why did the chicken cross the road?");
            }
        });
    }



}
