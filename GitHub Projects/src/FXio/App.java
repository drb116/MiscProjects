package FXio;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
	    
	    @Override
	    public void start(Stage stage) throws Exception {
	    	
	    	PaneOrganizer organizer = new PaneOrganizer();
	    	Scene scene = new Scene(organizer.getRoot(),300,170);
	    	stage.setScene(scene);
	    	stage.show();
	    
	    }
		
		public static void main(String[] args) { launch(args); }
}