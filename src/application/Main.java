package application;
	
import java.io.IOException;

import application.controller.Accueil_C;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;


public class Main extends Application {
	
		// =======================================================
	
		// les references
		
		// la fenetre principale, l'accueil
		private Stage F_accueil;
		
		// =======================================================
		
		// les controllers
		
		// controleur du fichier Accueil.java
		private Accueil_C ctrl_accueil;
		
		// =======================================================
		
		// les variables
		
		// =======================================================
		
		// le(s) constructeur(s)
		
		// declarer 1 contructeur vide
		public Main() { }
		
		// =======================================================
		
		@Override
		public void start(Stage p_Stage) {
			
			// pr faire apparaitre la fenetre accueil
			init_accueil();
		
		}
		
		// =======================================================
		
		// les methodes
		
		// ouvre la fenetre accueil
		public void init_accueil() {
			
			// variables
			FXMLLoader loader_accueil;
			AnchorPane AP;
			Scene scene_accueil;
			
			try {
				
				//
				F_accueil = new Stage();
				
				//
				F_accueil.initModality(Modality.APPLICATION_MODAL);
				
				//
				loader_accueil = new FXMLLoader();
	        	loader_accueil.setLocation(Main.class.getResource("view/accueil.fxml"));
	       		AP = (AnchorPane) loader_accueil.load();
	           
	        	//
	        	scene_accueil = new Scene(AP);
	           
	        	//
	       		F_accueil.setScene(scene_accueil);
	            
	        	//
	        	F_accueil.setTitle("fenetre accueil");
	        	
	        	//
		        ctrl_accueil = new Accueil_C();
		        ctrl_accueil = loader_accueil.getController();
		        
		        // obligatoire pr ouvrir la F01
	        	ctrl_accueil.setMain(this);
	        	
	        	// obligatoire pr fermer la fenetre accueil
	        	ctrl_accueil.set_accueil(F_accueil);
	           
		        //
		        F_accueil.show();
					
			} catch(IOException except) {
					
				//
				except.printStackTrace();
				
			}
		}
		
		// =======================================================
	
	public static void main(String[] args) {
		launch(args);
	}
}
