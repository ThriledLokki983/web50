package sample;

import dataModel.Contact;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

public class Controller {
    private TableView<Contact> myContacts = new TableView<>();






    public void initialize(){
        myContacts item1 =  new Contact("Gideon", "Nimoh", "0626603494", "This is just a test note");

    }




}
