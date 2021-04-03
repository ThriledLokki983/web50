package dataModel;
import java.time.LocalDate;

/**
 * Name: Gideon Nimoh
 * Date: 4/2/21
 * Time: 12:21 PM
 * To change this template use File | Settings | File and Code Templates.
 */


public class TodoItem {
    private final String shortDescription;
    private final String details;
    private final LocalDate deadLine;

    public TodoItem(String shortDescription, String details, LocalDate deadLine) {
        this.shortDescription = shortDescription;
        this.details = details;
        this.deadLine = deadLine;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getDetails() {
        return details;
    }


    public LocalDate getDeadLine() {
        return deadLine;
    }

}
