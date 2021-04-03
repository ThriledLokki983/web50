package com.gideon.todolist;

import dataModel.TodoData;
import dataModel.TodoItem;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.time.LocalDate;

/**
 * Name: Gideon Nimoh
 * Date: 4/3/21
 * Time: 8:59 AM
 * To change this template use File | Settings | File and Code Templates.
 */


public class DialogController {
    @FXML
    private TextField shortDescription;
    @FXML
    private TextArea detailsArea;
    @FXML
    private DatePicker deadlinePicker;

    public TodoItem processResult(){
        String shortDes = shortDescription.getText().trim();
        String details = detailsArea.getText().trim();
        LocalDate deadline = deadlinePicker.getValue();

        TodoItem newItem = new TodoItem(shortDes, details, deadline);
        TodoData.getInstance().addTodoItem(newItem);
        return newItem;
    }
}
