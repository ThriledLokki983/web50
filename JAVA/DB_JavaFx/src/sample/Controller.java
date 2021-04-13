package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import sample.Model.Album;
import sample.Model.Artist;
import sample.Model.DataSource;

public class Controller {

    @FXML
    private TableView artistTable;

    public void listArtist(){
        Task<ObservableList<Artist>> task = new GetAllArtistTask();
        artistTable.itemsProperty().bind(task.valueProperty());

        new Thread(task).start();
    }

    @FXML
    public void listAlbumsForArtist(){
        final Artist artist = (Artist) artistTable.getSelectionModel().getSelectedItem();
        if (artist == null){
            System.out.println("No Artist Selected");
            return;
        }
        Task<ObservableList<Album>> task = new Task<ObservableList<Album>>() {
            @Override
            protected ObservableList<Album> call() throws Exception {
                return FXCollections.observableArrayList(DataSource.getInstance().queryAlbumForArtistId(artist.getId()));
            }
        };
        artistTable.itemsProperty().bind(task.valueProperty());

        new Thread(task).start();
    }


}

 class GetAllArtistTask extends Task{
     @Override
     public ObservableList<Artist> call() {
         return FXCollections.observableArrayList(DataSource.getInstance().queryArtist(DataSource.ORDER_BY_DESC));
     }
 }
