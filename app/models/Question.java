package models;

import java.util.*;
import javax.persistence.*;

import com.avaje.ebean.Model;
import play.data.format.*;
import play.data.validation.*;

import com.avaje.ebean.*;

/**
 * Created by gerardocastaneda on 11/11/16.
 *
 */
@Entity
public class Question extends Model{
    private static final long serialVersionUID = 1L;

    @Id
    public Long id;

    @Constraints.Required
    public String name;

    @Constraints.Required
    public String answer1;
    @Constraints.Required
    public String answer2;
    @Constraints.Required
    public String answer3;
    @Constraints.Required
    public String answer4;

    @Constraints.Required
    public String correct_answer;

    //TODO: this should be mandatory
    @Constraints.Required
    @ManyToOne
    public Category category;

    @ManyToMany(cascade=CascadeType.ALL)
    public Set<Exam> exams = new HashSet<Exam>();

    /**
     * Generic query helper for entity Question with id Long
     */
    public static Find<Long,Question> find = new Find<Long,Question>(){};

    /**
     * Return a paged list of question
     *
     * @param page Page to display
     * @param pageSize Number of computers per page
     * @param sortBy Question property used for sorting
     * @param order Sort order (either or asc or desc)
     * @param filter Filter applied on the name column
     */
    public static PagedList<Question> page(int page, int pageSize, String sortBy, String order, String filter) {
        return
                find.where()
                        .ilike("name", "%" + filter + "%")
                        .orderBy(sortBy + " " + order)
                        .fetch("category")
                        .findPagedList(page, pageSize);
    }


}
