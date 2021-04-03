package com.gideon.todolist;

import dataModel.TodoData;
import dataModel.TodoItem;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

public class Controller {
    private List<TodoItem> todoItems;
    @FXML
    private ListView<TodoItem> todoListView;

    @FXML
    private TextArea itemDetailsTextArea;

    @FXML
    private Label deadlineLabel;

    @FXML
    private BorderPane mainBorderPane;

    public void initialize(){
/**
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
           TodoData.getInstance().setTodoItems(todoItems);
**/


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

        todoListView.getItems().setAll(TodoData.getInstance().getTodoItems());
        todoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        todoListView.getSelectionModel().selectFirst();
    }

    @FXML
    public void showNewItemDialog(){
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        dialog.setTitle("Add New Todo Item");
        dialog.setHeaderText("Use this pane to create a new todo Item");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("todoItemDialogue.fxml"));
        try{
            dialog.getDialogPane().setContent(fxmlLoader.load());

        }catch (IOException e){
            System.out.println("Couldn't load the dialog");
            e.printStackTrace();
        }
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && result.get() ==  ButtonType.OK){
            DialogController controller = fxmlLoader.getController();
            TodoItem newItem = controller.processResult();
            todoListView.getItems().setAll(TodoData.getInstance().getTodoItems());
            todoListView.getSelectionModel().select(newItem);
            System.out.println("OK Pressed");
        }else{
            System.out.println("Cancel Pressed");
        }
    }

    @FXML
    public void handleClickListView(){
        TodoItem item = todoListView.getSelectionModel().getSelectedItem();
        itemDetailsTextArea.setText(item.getDetails());
        deadlineLabel.setText(item.getDeadLine().toString());
    }



}