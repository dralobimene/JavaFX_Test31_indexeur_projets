package applicationShowDate;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	
	@Override
    public void start(Stage primaryStage) {
        try {
            // Read file fxml and draw interface.
            Parent root = FXMLLoader.load(getClass().getResource("/applicationShowDate/fenetrePrincipale.fxml"));
        	// Parent root = FXMLLoader.load(getClass().getResource("fenetrePrincipale.fxml"));
        	// Parent root = FXMLLoader.load(getClass().getResource("/media/sambano/home_HDD_EXTERNE/Documents/java/workspace_eclipse/JavaFX_Test02_Desvstory/src/applicationShowDate/fenetrePrincipale.fxml"));
            
            // affiche le nom complet en incluant son package
            // de la classe de l'objet (ici root)
            // System.out.println(root.getClass().getName());

            primaryStage.setTitle("nom projet: JavaFX_Test02_Desvstory A");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
	
	public static void main(String[] args) {
		launch(args);
	}
}
