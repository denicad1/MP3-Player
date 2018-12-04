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

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

/**
 * @author Anthony Denicolo
 *
 */

public class allSongsController implements Initializable {
	@FXML
	private MediaView mediaPlayer;
	private MediaPlayer mp;
	private Media me;
	@FXML
	Button pauseButton = new Button();
	@FXML
	Button backButton = new Button();
	@FXML
	ListView<String> songs;
	File inputFile = new File("../MP3 Players/src/application/Media.xml");
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder;
	ObservableList<String> tunes = FXCollections.observableArrayList();
	Document doc;
	NodeList nList;
	Node thing;
	Element stuff;

	public void listSongs() {

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

		try {
			dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();
			// System.out.println("Root element :" +
			// doc.getDocumentElement().getNodeName());
			nList = doc.getElementsByTagName("song");
			for (int i = 0; i < nList.getLength(); i++) {
				thing = nList.item(i);
				// System.out.println(nList.getLength());
				// System.out.println(thing.getNodeName());
				stuff = (Element) thing;
				tunes.add(stuff.getAttribute("name").toString());
				// System.out.println(stuff.getAttributeNode("name"));

				// System.out.println(tunes.size());

			}
			songs.setItems(tunes);

		} catch (Exception e) {
		}
	}

	public void songSelection(MouseEvent click) {
		if (mp != null) {
			mp.stop();
		}
		String selection = songs.getSelectionModel().getSelectedItem();
		for (int i = 0; i < nList.getLength(); i++) {
			thing = nList.item(i);
			stuff = (Element) thing;

			if (selection.equals(stuff.getAttribute("name").toString())) {

				String path = new String(nList.item(i).getChildNodes().item(1).getTextContent());
				me = new Media(new File(path).toURI().toString());
				mp = new MediaPlayer(me);
				mp.play();

			}
		}

	}

	public void pause(MouseEvent click) {
		if (mp.getStatus() == Status.PLAYING) {
			mp.pause();
		} else {
			mp.play();
		}

	}

	public void back(Event click) {
		Stage primaryStage = new Stage();
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/application/startWindow.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("iBucks MP3 Player");
			primaryStage.setAlwaysOnTop(true);
			primaryStage.setResizable(false);
			((javafx.scene.Node) (click.getSource())).getScene().getWindow().hide();

			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
