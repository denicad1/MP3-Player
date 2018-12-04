/**
 * 
 */
package application;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

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
	private ListView<Object> playlists;
	private ObservableList<Object> items;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		items = FXCollections.observableArrayList("hey", "hello", "derp");
		playlists.setItems(items);
	}

	/**
	 * keep working on creating playlists, then shuffle. might need to create a new
	 * window to actually create the playlist versus display it
	 */

	public void createPlaylist(Event event) {

		ArrayList<Object> newPlaylist = new ArrayList<>();
		newPlaylist.add("well");

	}

	public void playSong(ActionEvent event) {
		File inputFile = new File("../MP3 Players/src/application/Media.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		NodeList nList = null;
		/**
		 * still need to create way to make playlist, shuffle songs, finish making
		 * guis,and create all the starting window option
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

	}

}
