package design;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import Model.Form;
import backend.FormDao;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.control.*;
import javafx.fxml.FXMLLoader;

public class form_C implements Initializable 
{
	
	
	@FXML
	private TextField name,number,city,ID;
	@FXML
	public void create()
	{
		FormDao fd = new FormDao();
		Form f = new Form(name.getText(),number.getText(),city.getText());
		fd.saveStudent(f);
		
		
		String s=  name.getText()+" Added Successfully...!";
		Alert alert =new Alert(Alert.AlertType.INFORMATION,s);
		alert.setHeaderText(null);
		alert.setTitle("");
		alert.showAndWait();
		
		name.clear();
		number.clear();
		city.clear();
	}
	/*@FXML
	public void search()
	{
		FormDao fd = new FormDao();
		int i=Integer.parseInt(ID.getText());
		
	Form f=	fd.getStudent(i);
	if (f==null)
	{
		Alert alert =new Alert(Alert.AlertType.INFORMATION,"No record found!");
		alert.setHeaderText(null);
		alert.setTitle("");
		alert.showAndWait();
	}
	else {
	name.setText(f.getName());
	number.setText(f.getNumber());
	city.setText(f.getCity());
	
		
	}
	}*/
	
	
	@FXML
	public void search()
	{
		try {
		System.out.println("yess..");
		search_C obj = new search_C();
		
		 Stage s = new Stage();
		 obj.setStage(s);
        FXMLLoader fXMLLoader = new FXMLLoader();
		
		
		
		fXMLLoader.setLocation(getClass().getResource("/design/SearchWindow.fxml"));
		fXMLLoader.setController(obj);
		
		
		Scene scene = new Scene((Parent) fXMLLoader.load(),745,420);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		s.setScene(scene);
		s.showAndWait();
		int i=1;
		ID.setText(Integer.toString(obj.node.getID()));
		name.setText(obj.node.getName());
		number.setText(obj.node.getNumber());
		city.setText(obj.node.getCity());
		
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	 }
	
	public void delete()
	{
		FormDao fd = new FormDao();
		int i=Integer.parseInt(ID.getText());
		fd.deleteStudent(i);
		name.clear();
		number.clear();
		city.clear();
		ID.clear();
		String s=  " Deleated Successfully...!";
		Alert alert =new Alert(Alert.AlertType.INFORMATION,s);
		alert.setHeaderText(null);
		alert.setTitle("");
		alert.showAndWait();
		
	}
	
	@FXML
	 private MediaView mv;
	@FXML
	MediaPlayer mp;
	
	@Override
	 public void initialize(URL url, ResourceBundle rb)
	 {
		//File f= new File("D://DevlopmentTools/eclipse/vid.mp4");
		// URI u = f.toURI();
		 Media media = new Media(getClass().getClassLoader().getResource("design/vid.mp4").toString());
		 
		 mp = new MediaPlayer(media);
		 mv.setFitHeight(470);
		 mv.setFitWidth(625);
		 mv.setMediaPlayer(mp);
		 
		 	mp.play();
			 mp.setCycleCount(mp.INDEFINITE);
	 }
	 
	 @FXML
	 public void b()
	 {
		
		
		 System.out.print("yes");
	 }
	
	

	 
	  

	
	
	
	
}
