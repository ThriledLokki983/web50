package com.gideon.todolist;

import dataModel.TodoItem;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    private List<TodoItem> todoItems;
    @FXML
    private ListView<TodoItem> todoListView;

    @FXML
    private TextArea itemDetailsTextArea;

    @FXML
    private Label deadlineLabel;

    public void initialize(){
        TodoItem item1 = new TodoItem("Email to my boss", "Buy a 30th birthday card for John",
                LocalDate.of(2021, Month.APRIL, 2));
        TodoItem item2 = new TodoItem("Announce DB Upgrade", "Send announcement on the database upgrade over the holiday period",
                LocalDate.of(2021, Month.MAY, 23));
        TodoItem item3 = new TodoItem("Doctor's Appointment", "See Doctor Smith, bring with your the insurance card",
                LocalDate.of(2021, Month.APRIL, 8));
        TodoItem item4 = new TodoItem("Design proposal", "Help with the design of Frank's new project",
                LocalDate.of(2021, Month.MARCH, 2));
        TodoItem item5 = new TodoItem("Complete Java", "Finish with the Java Programming language course on udemy and start with JavaScript",
                LocalDate.of(2021, Month.JUNE, 6));
        TodoItem item6 = new TodoItem("New course", "Want to upgrade your skills, quickly continue with the React skill development on udemy",
                LocalDate.of(2021, Month.APRIL, 14));

        todoItems = new ArrayList<TodoItem>();
        todoItems.add(item1);
        todoItems.add(item2);
        todoItems.add(item3);
        todoItems.add(item4);
        todoItems.add(item5);
        todoItems.add(item6);
        todoListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TodoItem>() {
            @Override
            public void changed(ObservableValue<? extends TodoItem> observableValue, TodoItem todoItem, TodoItem newValue) {
                if (newValue != null){
                    TodoItem item = todoListView.getSelectionModel().getSelectedItem();
                    itemDetailsTextArea.setText(item.getDetails());
                    DateTimeFormatter df = DateTimeFormatter.ofPattern("MMM d, yyyy");
                    deadlineLabel.setText(df.format(item.getDeadLine()));
                }
            }
        });

        todoListView.getItems().setAll(todoItems);
        todoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        todoListView.getSelectionModel().selectFirst();
    }

    @FXML
    public void handleClickListView(){
        TodoItem item = todoListView.getSelectionModel().getSelectedItem();
        itemDetailsTextArea.setText(item.getDetails());
        deadlineLabel.setText(item.getDeadLine().toString());
//        System.out.println("The selected item is: " + item); // This prints to the console
//        StringBuilder sb = new StringBuilder(item.getDetails());
//        sb.append("\n\n\n\n");
//        sb.append("Due: ");
//        sb.append(item.getDeadLine().toString());
//        itemDetailsTextArea.setText(sb.toString());
    }



}
