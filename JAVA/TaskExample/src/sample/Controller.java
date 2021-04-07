package sample;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;

public class Controller {

    private Task<ObservableList<String>> task;

    @FXML
    private ListView listView;

    @FXML
    private ProgressBar progressBar;

    @FXML
    private Label progressLabel;


    public void initialize(){
        task = new Task<ObservableList<String>>() {
            @Override
            protected ObservableList<String> call() throws Exception {
                String[] names = {"Gideon Nimoh",
                        "Kwame Agyin",
                        "Paapa Nimoh",
                        "Joan Andrews",
                        "Elizabeth Osei",
                        "Dennis Prempeh",
                        "Dominic McDonald"};

                ObservableList<String> employees = FXCollections.observableArrayList();
                for (int i = 0; i < 7; i++){
                    employees.add(names[i]);
                    updateMessage("Added: " + names[i]);
                    updateProgress(i + 1, 7);
                    Thread.sleep(200);
                }
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
        progressBar.progressProperty().bind(task.progressProperty());
        progressLabel.textProperty().bind(task.messageProperty());
        listView.itemsProperty().bind(task.valueProperty());
    }

    @FXML
    public void buttonPress(){
        new Thread(task).start();
    }

}
