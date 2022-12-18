package ch.makery.address;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;

// import de Scene qui represente
// le 1° elt posé sur
// la fenetre (Stage) de l'application
import javafx.scene.Scene;

// import de AnchorPane qui est le
// 1° elt posé sur la Scene ds le fichier
// PersonOverview.fxml
import javafx.scene.layout.AnchorPane;

// import de BorderPane qui est le
// 1° elt posé sur la Scene ds la fichier
// RootLayout.fxml
import javafx.scene.layout.BorderPane;

// import de Stage qui est la fenetre
// de l'applicat°
import javafx.stage.Stage;

/**
 * @author sambano<br>
 * Javadoc de class: MainApp<br>
 * Descript°:<br>
 * Class qui execute l'applicat°.<br>
 * REMARQUE:<br>
 * - la class MainApp est 1 "JavaFX Main Class"<br>
 * - la class principale hérite TJS de<br>
 * Application.<br>
 */
public class MainApp extends Application {

	// déclarat° d'1 attribut de type Stage
    private Stage primaryStage;
    
    // déclarat° d'1 attribut de type BorderPane
    private BorderPane rootLayout;

    //
    @Override
    public void start(Stage primaryStage) {
    	
    	//
        this.primaryStage = primaryStage;
        
        //
        this.primaryStage.setTitle("AddressApp");

        // Appel de la méthode qui est déclarée
        // ds ce fichier en dessous
        initRootLayout();

        // appel de la methode qui est déclarée
        // ds ce fichier en dessous
        showPersonOverview();
    }
    
    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
    	
        try {
        
        	// attribut de type FXMLoader
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            
            //
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            
            // initialisation de l'attribut rootLayout
            rootLayout = (BorderPane) loader.load();
            
            // attribut de type Scene
            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            
            // initialisat° de l'attribut primaryStage
            // (de type Stage)
            primaryStage.setScene(scene);
            
            //
            primaryStage.show();
            
        } catch (Exception excep) {
        	
        	//
            excep.printStackTrace();
        }
    }

    /**
     * Shows the person overview inside the root layout.
     */
    public void showPersonOverview() {
        
    	//
    	try {
    		
    		// attribut de type FXMLLoader
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            
            //
            loader.setLocation(MainApp.class.getResource("view/PersonOverview.fxml"));
            
            // attribut de type AnchorPane
            AnchorPane personOverview = (AnchorPane) loader.load();
            
            //
            // Set person overview into the center of root layout.
            rootLayout.setCenter(personOverview);
            
        } catch (Exception excep) {
            
        	//
        	excep.printStackTrace();
        }
    }
    
	/**
	 * Javadoc de fct°: getPrimaryStage()<br>
	 * Descript°:<br>
	 * Returns the main stage.<br>
	 * @return<br>
	 * NOTE 01:<br>
	 * Si mis en commentaire, ne semble<br>
	 * avoir aucune incidence sur le fonctionnement<br>
	 * de l'applicat°.
	 */
    
	public Stage getPrimaryStage() {
		
		//
		return primaryStage;
	}
	
    
    public static void main(String[] args) {
        launch(args);
    }
}