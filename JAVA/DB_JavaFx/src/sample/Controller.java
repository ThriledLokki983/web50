package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import sample.Model.Artist;
import sample.Model.DataSource;

public class Controller {


}

 class GetAllArtistTask extends Task{

     @Override
     public ObservableList<Artist> call() {
         return FXCollections.observableArrayList(DataSource.getInstance().queryArtist(DataSource.ORDER_BY_ASC));
     }
 }
