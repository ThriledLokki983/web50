package sample;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.Worker;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;

import java.security.Provider;

public class Controller {

   /* private Task<ObservableList<String>> task;*/

    @FXML
    private ListView listView;

    @FXML
    private ProgressBar progressBar;

    @FXML
    private Label progressLabel;

    private Service<ObservableList<String>> service;


    public void initialize(){
        /*task = new Task<ObservableList<String>>() {
            @Override
            protected ObservableList<String> call() throws Exception {
             */ /*  String[] names = {"Gideon Nimoh",
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
                *//*Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        listView.setItems(employees);
                    }
                });
                *//*
                return employees;*//*
            }
        };*/

        service = new EmployeeService();
        progressBar.progressProperty().bind(service.progressProperty());
        progressLabel.textProperty().bind(service.messageProperty());
        listView.itemsProperty().bind(service.valueProperty());
    }

    @FXML
    public void buttonPress(){
        if (service.getState() == Worker.State.SUCCEEDED){
            service.reset();
            service.start();
        }else if (service.getState() == Worker.State.READY){
            service.start();
        }
    }

}
