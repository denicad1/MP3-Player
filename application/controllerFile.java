/**
 * 
 */
package application;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * @author Anthony Denicolo
 *
 */
public class controllerFile implements Initializable {
	@FXML
	private MediaView mediaPlayer;
	private MediaPlayer mp;
	private Media me;
	@FXML
	private Button playlist;
	@FXML
	private Button play;
	@FXML
	private ListView<String> startMenu = new ListView<>();
	@FXML
	private ObservableList<String> items;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	}

	public void createPlaylistWindow(Event event) {
		Parent root;
		FXMLLoader fxmlLoader;
		Stage stage;
		try {
			fxmlLoader = new FXMLLoader(getClass().getResource("createPlaylist.fxml"));
			root = fxmlLoader.load();
			stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.initStyle(StageStyle.DECORATED);
			stage.setTitle("Create Playlist");
			stage.setScene(new Scene(root));
			((Node) (event.getSource())).getScene().getWindow().hide();
			stage.show();

		} catch (Exception e) {
		}
	}

	public void playSong(ActionEvent event) {
		File inputFile = new File("../MP3 Players/src/application/Media.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		NodeList nList = null;
		/**
		 * it is reading the path of the file to play the song. need to fill xml file
		 * and media package so it can play everything. still need to create way to make
		 * playlist, shuffle songs, finish making guis,and fill xml file to contain the
		 * info about each song and create all the starting window option
		 */
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc;
			doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();
			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			nList = doc.getElementsByTagName("song");
			nList.item(0).getBaseURI();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String path = new String(nList.item(0).getTextContent());
		me = new Media(new File(path).toURI().toString());
		mp = new MediaPlayer(me);
		mp.play();
		/** below is pause function for media player */
		// mp.pause;
	}

}
