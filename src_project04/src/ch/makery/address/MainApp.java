package ch.makery.address;

import java.io.IOException;

import ch.makery.address.model.Person;
import ch.makery.address.view.PersonOverviewController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    private ObservableList<Person> personData = FXCollections.observableArrayList();
    
    /*
     * Constructeur(s)
     */
    
    public MainApp() {
		// Add some sample data
		personData.add(new Person("Hans", "Muster"));
		personData.add(new Person("Ruth", "Mueller"));
		personData.add(new Person("Heinz", "Kurz"));
		personData.add(new Person("Cornelia", "Meier"));
		personData.add(new Person("Werner", "Meyer"));
		personData.add(new Person("Lydia", "Kunz"));
		personData.add(new Person("Anna", "Best"));
		personData.add(new Person("Stefan", "Meier"));
		personData.add(new Person("Martin", "Mueller"));
	}

    //
    @Override
    public void start(Stage primaryStage) {
    	
    	//
        this.primaryStage = primaryStage;
        
        //
        this.primaryStage.setTitle("AddressApp V2.0");

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
            
        } catch (IOException err) {
        	
        	//
            err.printStackTrace();
        }
    }

    /**
     * Shows the person overview inside the root layout.
     */
    public void showPersonOverview() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            
            //
            loader.setLocation(MainApp.class.getResource("view/PersonOverview.fxml"));
            
            //
            AnchorPane personOverview = loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(personOverview);

            // Give the controller access to the main app.
            PersonOverviewController controller = loader.getController();
            
            //
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    } 
    
	/**
	 * Returns the main stage.
	 * @return
	 */
	public Stage getPrimaryStage() {
		
		//
		return primaryStage;
	}
	
	/**
	 * Returns the data as an observable list of Persons. 
	 * @return
	 */
	public ObservableList<Person> getPersonData() {
		return personData;
	}

    public static void main(String[] args) {
        launch(args);
    }
}