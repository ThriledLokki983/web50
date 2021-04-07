package sample;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class Controller {

    private Task<ObservableList<String>> task;

    @FXML
    private ListView listView;


    public void initialize(){
        task = new Task<ObservableList<String>>() {
            @Override
            protected ObservableList<String> call() throws Exception {
                Thread.sleep(1000);
                ObservableList<String> employees = FXCollections.observableArrayList(
                        "Gideon Nimoh",
                        "Kwame Agyin",
                        "Paapa Nimoh",
                        "Joan Andrews",
                        "Elizabeth Osei",
                        "Dennis Prempeh",
                        "Dominic McDonald");
                /*Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        listView.setItems(employees);
                    }
                });
                */
                return employees;
            }
        };
        listView.itemsProperty().bind(task.valueProperty());
    }

    @FXML
    public void buttonPress(){
        new Thread(task).start();
    }

}
