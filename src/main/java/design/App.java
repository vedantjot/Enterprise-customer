package design;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import Model.Form;
import design.*;
import design.search_C;
public class App extends Application
{
	public void start(Stage primaryStage) {
		try {
			
			FXMLLoader fXMLLoader = new FXMLLoader();
			
		    fXMLLoader.setLocation(getClass().getResource("/design/form.fxml"));
			
			Scene scene = new Scene((Parent) fXMLLoader.load(),625,470);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} 
		catch(Exception e)
		    {
			
			e.getCause();
			
			e.printStackTrace();
		}
	}
	
    public static void main( String[] args )
    {
    	launch(args);
    }
}
