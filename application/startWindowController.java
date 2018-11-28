package application;

import java.awt.event.MouseEvent;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class startWindowController implements Initializable {
	@FXML
	private ListView<String> startMenu;
	@FXML
	private ObservableList<String> items;
	@FXML
	private Button playlist;
	@FXML
	private Button play;
	@FXML
	private MediaView mediaPlayer;
	@FXML
	private MediaPlayer mp;
	@FXML
	private Media me;

	@Override
	/*
	 * this populates the starting window with a menu to choose what you want to do.
	 */
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		items = FXCollections.observableArrayList("All Songs", "Artist", "Album", "Genre", "Playlists");
		startMenu.setItems(items);

	}

	/**
	 * maybe put a forward and backward button. maybe need to put that on further
	 * windows. starting window might need nothing.
	 */
	private void listChoice(MouseEvent click) {
		/*
		 * figure out a way to make it so that you can click an item in the menu and it
		 * will select it and go to the next window. or try to make it so it will set
		 * the stage with a new scene that way it isn't a bunch of windows
		 **/
		System.out.println(startMenu.getSelectionModel().getSelectedItem());

	}

}
