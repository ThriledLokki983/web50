package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import sample.dataModel.Contact;

/**
 * Name: Gideon Nimoh
 * Date: 4/4/21
 * Time: 9:25 AM
 * To change this template use File | Settings | File and Code Templates.
 */


public class ContactController {
    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField phoneNumberField;

    @FXML
    private TextField notesField;

    public Contact getContact(){
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String phoneNumber = phoneNumberField.getText();
        String notes = notesField.getText();

        /*
        * Add Validation here yourself
        * */

        return new Contact(firstName, lastName, phoneNumber, notes);
    }

    public void editContact(Contact e){
        firstNameField.setText(e.getFirstName());
        lastNameField.setText(e.getLastName());
        phoneNumberField.setText(e.getPhoneNumber());
        notesField.setText(e.getNotes());
    }

    public void updateContact(Contact e){
        e.setFirstName(firstNameField.getText());
        e.setLastName(lastNameField.getText());
        e.setPhoneNumber(phoneNumberField.getText());
        e.setNotes(notesField.getText());
    }
}
