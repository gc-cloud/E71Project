package models;

import com.avaje.ebean.Model;
import com.avaje.ebean.PagedList;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import java.util.*;
import play.data.format.*;
import play.data.validation.*;
import com.avaje.ebean.*;


/**
 * Created by mob 11/20
 *
 */
@Entity
public class Exam extends Model{
    private static final long serialVersionUID = 1L;

    @Id
    public Long id;

    @Constraints.Required
    public String name;

    /**
     * Generic query helper for entity Question with id Long
     */
    public static Find<Long, Exam> find = new Find<Long, Exam>(){};

    /**
     * Return a paged list of question
     *
     * @param page Page to display
     * @param pageSize Number of computers per page
     * @param sortBy Question property used for sorting
     * @param order Sort order (either or asc or desc)
     * @param filter Filter applied on the name column
     */
    public static PagedList<Exam> page(int page, int pageSize, String sortBy, String order, String filter) {
        return
                find.where()
                        .ilike("name", "%" + filter + "%")
                        .orderBy(sortBy + " " + order)
                        .fetch("category")
                        .findPagedList(page, pageSize);
    }


}
