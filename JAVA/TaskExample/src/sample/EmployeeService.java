package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;


/**
 * Name: Gideon Nimoh
 * Date: 4/7/21
 * Time: 5:08 PM
 * To change this template use File | Settings | File and Code Templates.
 */


public class EmployeeService extends Service<ObservableList<String>> {

    @Override
    protected Task<ObservableList<String>> createTask() {
        return new Task<ObservableList<String>>() {
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
    }
}
