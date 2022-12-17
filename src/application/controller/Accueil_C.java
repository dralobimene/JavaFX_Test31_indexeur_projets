package application.controller;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.ResourceBundle;

import application.Main;
import application.model.ClassPB;
import application.model.Project;
import application.model.ProjectUtils;

import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Javadoc de class: Accueil_C<br>
 * @author sambano<br>
 * <br>
 * fenetre indexeur de projets.<br>
 * 
 */
public class Accueil_C implements Initializable {
	
	
	// =======================================================

	// les references
	
	//
	private Main main;

	//
	private Stage F_accueil;
	
	// =======================================================
	
	// les controles
	
	@FXML
	private AnchorPane AP;
	
	@FXML
	private Pane P;
	
	@FXML
	private Button btn_quitter;
	
	@FXML
	private ScrollPane SCPane;
	
	@FXML
	private Pane contentSCPane;
	
	@FXML
	private Button btnChargerProjet01;
	
	@FXML
	private Button btnCopierFichiersDuProjet01;
	
	@FXML
	private Button btnExecuterProjet01;
	
	@FXML
	private Button btnChargerProjet02;
	
	@FXML
	private Button btnCopierFichiersDuProjet02;
	
	@FXML
	private Button btnExecuterProjet02;
	
	@FXML
	private Button btnChargerProjet03;
	
	@FXML
	private Button btnCopierFichiersDuProjet03;
	
	@FXML
	private Button btnExecuterProjet03;
	
	@FXML
	private Button btnChargerProjet04;
	
	@FXML
	private Button btnCopierFichiersDuProjet04;
	
	@FXML
	private Button btnExecuterProjet04;
	
	// ---------------------------------------------------
	
	// les variables
	
	/*
	 * indice du projet:
	 * définie a null, prend 1 valeur int
	 * qd on clique sur 1 des bouton censé
	 * lancer le projet attribué
	 */
	private int indiceProjet;
	
	// liste des projets (c'est 1 tableau)
	Project[] listeProjets = null;
	
	/*
	 * instance du fichier Record Project.java
	 */
	private Project projet;
	
	// pr la methode loadProjects02()
	// --- etape 01: declarer les variables necessaires
	// au Service. Portée class ---
	private Service<Project> serviceA;
	
	// pr la methode loadProjects02()
	// --- etape 01: declarer les variables necessaires
	// au Service. Portée class ---
	private Service<Project> serviceB;
	
	// prend la valeur de la variable loacale
	// process01 ds la methode loadProject02()
	Process process01;
	
	// =======================================================
	
	// constructeur(s)
	
	public Accueil_C() { }
	
	// =======================================================
	
	// methode initialize
	
	@Override
	public void initialize(URL p_url, ResourceBundle p_r_bdle) {
		
		System.out.println("");
		System.out.println("methode initialize()");
		System.out.println("");
		
		// ---------------------------------------------------
		
		// parametrage elts graphiques
		
		// parametrage du contentSCPane
		
		// taille min du contentSCPane
		// override la taille definie ds SceneBuilder
		contentSCPane.setPrefSize(600.0, 600.0);
		
		// couleur du contentSCPane
		contentSCPane.setStyle("-fx-background-color: cornsilk;");
		
		// parametrage SCPane
		
		// le contenu du SCPane
        SCPane.setContent(contentSCPane);
        
    	// ---------------------------------------------------
        
        // parametrage traitement des données
        
	
 		// charge la liste des projets en lisant
         // le fichier settings.properties qui se trouve
         // ds le repertoire reousrces01
         // utilise la valeur retour de la methode
         // loadProjects();
         // loadProjects02();
 		
 		/*
 		System.out.println("");
 		System.out.println("Nbre d'elts de listeProjets: " + listeProjets.length);
 		
 		System.out.println("");
 		System.out.println("Affichage du 1° projet");
 		System.out.println(listeProjets[0]);
 		
 		System.out.println("");
 		System.out.println("Affichage du nom du 1° projet");
 		System.out.println(listeProjets[0].title());
 		*/
 		
         // je ne sais pas a quoi cela sert
         // fonctionne avec et sans
         /*
 		//
 		final var javaHomeSystem = System.getenv("JAVA_HOME");
 		
 		// chemin du repertoire contenant le jdk
 		// ici: ???
 		// valeur identique a javaHome
 		System.out.println("valeur de JAVA_HOME (javaHomeSystem): " + javaHomeSystem);
 		*/
         
 		//
 		final var settings = new Properties();
 		
 		//
        try (final var input = Files.newInputStream(Paths.get(ProjectUtils.getSettings()))) {
         	
         	// chemin du fichier settings.properties depuis ce repertoire
         	// chemin defini ds la variable SETTINGS du fichier enumerat° ProjectUtils.java
         	System.out.println("chemin: " + Paths.get(ProjectUtils.getSettings()));
         	
         	//
             settings.load(input);
             
             // je ne sais pas  a quoi cela correspond?
             // peut etre l'adresse memoire du fichier settings.properties
             System.out.println("valeur de input: " + input);
             
             // settings est 1 new Properties()
             // qui contient le contenu du fichier qui est ds le workspace
             // fichier nommé settings.properties
             // settings contient dc
             // la liste des projets: c'est la 1° L
             // chacune des propriétes de chaque projet
             // settings n'est pas triée, tt arrive ds le desordre
             System.out.println("les differentes valeurs, propriétés de settings: " + settings);
             
         } catch (IOException except) {
 			except.printStackTrace();
 		 }
        
         // entraine 1 erreur
         // je ne sais pas a quoi cela sert
         // fonctionne sans
         /*
         final var javaHomeUser = settings.getProperty("java.home");
         System.out.println("valeur de javaHomeUser " + settings.getProperty("java.home"));
         
         //final var javaHome = (Objects.nonNull(javaHomeUser) ? javaHomeUser : javaHomeSystem).trim();
         
         if(Objects.nonNull(javaHomeUser)) {
         	final var javaHome = javaHomeUser.trim();
         	System.out.println("01: valeur de javaHome: " + javaHome);
         } else {
         	final var javaHome = javaHomeSystem.trim();
         	System.out.println("02: valeur de javaHome: " + javaHome);
         }
         */
         
         /*
         System.out.println("valeur de SETTINGS definie ds le fichier enumerat° ProjectsUtils.java");
         System.out.println("indique le chemin du fichier settings.properties");
         System.out.println("ici, on remonte d'1 niveau, on se trouve ds le workspace");
         System.out.println(ProjectUtils.getSettings());
         */
		
	}
	
	// =======================================================
	
	// les getters - setters
	
	// la main
	public Main getMain() {
		return main;
	}

	public void setMain(Main p_main) {
		this.main = p_main;
	}
	
	//
	public Stage getF_acceuil() {
		return F_accueil;
	}
	
	public void set_accueil(Stage p_fenetre) {
		this.F_accueil = p_fenetre;
	}
	
	// =======================================================
	
	// les autres methodes
	
	// --------------------------------------------------------
	
	@FXML
	private void quitter_appli() {
		
		//
		this.F_accueil.close();
		
		//
		Platform.exit();
		System.exit(0);
		
	}
	
	// --------------------------------------------------------
	
	/**
	 * Javadoc de methode: chargerProject01()<br>
	 * clic btn01<br>
	 * initialise la variable indiceProjet à 0<br>
	 * cad, le premier projet trouvé ds le fichier<br>
	 * settings.properties.<br>
	 * appel la methode loadProjects02 qui prend en<br>
	 * parametre indiceProjet
	 */
	@FXML
	private void chargerProject01() {
		
		System.out.println("fichier: Accueil_C.java");
		System.out.println("methode: chargerProject01()");
		
		indiceProjet = 0;
		
		loadProjects02(indiceProjet);
		
	}
	
	// --------------------------------------------------------
	
	/**
	 * Javadoc de methode: copierFichierProject01()<br>
	 */
	@FXML
	private void copierFichiersProject01() {}
	
	// --------------------------------------------------------
	
	/**
	 * Javadoc de methode: executerProject01()<br>
	 */
	@FXML
	private void executerProject01() {
		
		System.out.println("fichier: Accueil_C.java");
		System.out.println("methode: executerProject01()");
		
		indiceProjet = 0;
		
		executeProject(indiceProjet);
		
	}
	
	// --------------------------------------------------------
	
		/**
		 * Javadoc de methode: chargerProject02()<br>
		 * clic btn02<br>
		 * initialise la variable indiceProjet à 1<br>
		 * cad, le 2° projet trouvé ds le fichier<br>
		 * settings.properties.<br>
		 * appel la methode loadProjects02 qui prend en<br>
		 * parametre indiceProjet
		 */
		@FXML
		private void chargerProject02() {
			
			System.out.println("fichier: Accueil_C.java");
			System.out.println("methode: chargerProject02()");
			
			indiceProjet = 1;
			
			loadProjects02(indiceProjet);
			
		}
		
	// --------------------------------------------------------
	
	/**
	 * Javadoc de methode: copierFichierProject02()<br>
	 */
	@FXML
	private void copierFichiersProject02() {}
	
	// --------------------------------------------------------
	
	/**
	 * Javadoc de methode: executerProject02()<br>
	 */
	@FXML
	private void executerProject02() {
		System.out.println("fichier: Accueil_C.java");
		System.out.println("methode: executerProject02()");
		
		indiceProjet = 1;
		
		executeProject(indiceProjet);
	}
	
	// --------------------------------------------------------
	
	/**
	 * Javadoc de methode: chargerProject03()<br>
	 * clic btn03<br>
	 * initialise la variable indiceProjet à 2<br>
	 * cad, le 3° projet trouvé ds le fichier<br>
	 * settings.properties.<br>
	 * appel la methode loadProjects02 qui prend en<br>
	 * parametre indiceProjet
	 */
	@FXML
	private void chargerProject03() {
		
		System.out.println("fichier: Accueil_C.java");
		System.out.println("methode: chargerProject03()");
		
		indiceProjet = 2;
		
		loadProjects02(indiceProjet);
		
	}
	
	// --------------------------------------------------------
	
	/**
	 * Javadoc de methode: copierFichierProject03()<br>
	 */
	@FXML
	private void copierFichiersProject03() {}
	
	// --------------------------------------------------------
	
	/**
	 * Javadoc de methode: executerProject03()<br>
	 */
	@FXML
	private void executerProject03() {
		System.out.println("fichier: Accueil_C.java");
		System.out.println("methode: executerProject03()");
		
		indiceProjet = 2;
		
		executeProject(indiceProjet);
	}
	
	// --------------------------------------------------------
	
	/**
	 * Javadoc de methode: chargerProject04()<br>
	 * clic btn04<br>
	 * initialise la variable indiceProjet à 3<br>
	 * cad, le 4° projet trouvé ds le fichier<br>
	 * settings.properties.<br>
	 * appel la methode loadProjects02 qui prend en<br>
	 * parametre indiceProjet
	 */
	@FXML
	private void chargerProject04() {
		
		System.out.println("fichier: Accueil_C.java");
		System.out.println("methode: chargerProject04()");
		
		indiceProjet = 3;
		
		loadProjects02(indiceProjet);
		
	}
	
	// --------------------------------------------------------
	
	/**
	 * Javadoc de methode: copierFichierProject04()<br>
	 */
	@FXML
	private void copierFichiersProject04() {}
	
	// --------------------------------------------------------
	
	/**
	 * Javadoc de methode: executerProject04()<br>
	 */
	@FXML
	private void executerProject04() {
		System.out.println("fichier: Accueil_C.java");
		System.out.println("methode: executerProject04()");
		
		indiceProjet = 3;
		
		executeProject(indiceProjet);
	}
	
	// --------------------------------------------------------
	// --------------------------------------------------------
	
	/**
	 * Javadoc de methode: loadProjects()<br>
	 * <br>
	 * @return: 1 tableau d'instances de type Project<br>
	 * <br>
	 * le type Project est défini ds le fichier Record: Project.java<br>
	 * Utilise aussi le fichier enumeration: ProjectUtils.java<br>
	 * <br>
	 * valeur de retour utilisée ds la methode loadProjects02()
	 */
	@FXML
	private Project[] loadProjects() {
		
		System.out.println("");
		System.out.println("----------------------");
		System.out.println("methode loadProjects()");
		System.out.println("");
		
		// les variables
		
		//
		Project[] tabProjets = null;
		
		for(ProjectUtils pu:ProjectUtils.values()) {
			try {
				
				System.out.println("- " + pu.loadProjects());
				System.out.println("-- " + ProjectUtils.INSTANCE);
				System.out.println("--- " + ProjectUtils.INSTANCE.loadProjects());
				System.out.println("---- " + ProjectUtils.INSTANCE.loadProjects().toString());
				System.out.println("----- " + ProjectUtils.INSTANCE.loadProjects().length);
				
				// on remplit le tableau local tabProjets grace
				// a ...?
				tabProjets = pu.loadProjects();
				
				for(int i = 0; i < tabProjets.length; i++) {
					System.out.println("projet: " + i + ", " + tabProjets[i]);
				}
				
				// System.out.println(tabProjets.length);
				// System.out.println(tabProjets[0]);
				
			} catch (NullPointerException | IOException except) {
				except.printStackTrace();
			}
			
		}
		
		return tabProjets;
		
	}
	
	// --------------------------------------------------------	
	
	/**
	 * Javadoc de methode: loadProjects02()<br>
	 * utilise la valeur de retour de la methode<br>
	 * loadProjects() (implémentée au-dessus) et<br>
	 * execute le projet<br>
	 * <br>
	 * @param p_indiceProjet
	 */
	@FXML
	private void loadProjects02(int p_indiceProjet) {
		
		System.out.println("");
		System.out.println("----------------------");
		System.out.println("methode loadProjects02");
		System.out.println("");
		
		// variables
		
		// liste de tous les projets
		// listeProjets se voit assignée la valeur de retour
		// de la methode loadProjects() implementée au-dessus
		listeProjets = loadProjects();
		
		// 01 creer Service + Task, de type Project
		// --- etape 02, creer 1 instance de Service
		final Service<Project> service01 = new Service<Project>() {
			// --- etape 03, surcharger la methode createTask()
			@Override
			protected Task<Project> createTask() {
				return new Task<Project>() {
					// --- etape 04, ds la tache, surcharger la methode call()
					// pr effectuer le traitement de longue durée
					@Override
					protected Project call() throws Exception {
						
						// liste les propriétés du projet
						// qui a l'indice
						projet = listeProjets[p_indiceProjet];
						
						//
						return projet;
						
					}
				};
			}
		};
		
		//
		System.out.println("");
		System.out.println("Monitorage de l'instance service01");
		
		// 02
		// Monitorer les changements d'etat de
		// l'instance de Service (service01)
		// 1° possibilité, en plaçant 1 ecouteur
		service01.stateProperty().addListener(observable -> {
		    switch (serviceA.getState()) {
		    // Traiter les différents cas ici.
		    case SCHEDULED:
		    	System.out.println("en plaçant 1 ecouteur , service01 Planifié");
		    	break;
		    case READY:
		    	System.out.println("en plaçant 1 ecouteur , service01 Prêt");
		    	break;
		    case RUNNING:
		    	System.out.println("en plaçant 1 ecouteur , service01 En cours d'execution");
		    	break;
		    case SUCCEEDED:
		    	
		    	// ici projet est la valeur de retour de la methode loadProjects02()
		    	// c'est a dire cette methode ci
		    	// projet a la valeur de l'elt a l'indice 0 de listeProjets
		    	System.out.println("en plaçant 1 ecouteur , service01, etat, Succes, result = " + projet);
		    	System.out.println("retour de getValue() de service01: " + service01.getValue());
		    	System.out.println("ds cet ex: le retour de getValue est = à projet");
		    	System.out.println("id du projet: " + service01.getValue().id());
		    	System.out.println("title du projet: " + service01.getValue().title());
		    	System.out.println("description du projet: " + service01.getValue().description());
		    	System.out.println("path du projet: " + service01.getValue().path());
		    	System.out.println("tags du projet: " + service01.getValue().tags());
		    	System.out.println("p01_fichierOptions: " + service01.getValue().p01_fichierOptions());
		    	System.out.println("p02_fichierClasses: " + service01.getValue().p02_fichierClasses());
		    	System.out.println("p03_dossierSortie: " + service01.getValue().p03_dossierSortie());
		    	System.out.println("p04_dossierFichierClass: " + service01.getValue().p04_dossierFichierClass());
		    	
		    	// crée 1 processus pr compiler ts les fichiers .java
		    	// en fichiers .class en creant l'arborescence de repertoires
		    	// @resources01/	indique le rep ou se trouve les 2 fichiers options et classes
		    	//				fichier options qui est concaténé avec la variable indiceProjet
		    	//				fichier classes qui est concaténé avec la variable indiceProjet
		    	//				variable indiceProjet indique l'indice du projet ds le tab listeProjets
		        try {
		        	// cmd est 1 tableau qui contient
		        	// le nom du programme a executer (javac)
		        	// l'adresse complete du fichier options du projet
		        	// l'adresse complete du fichier classes du projet
		        	String[] cmd01 = {"/usr/bin/javac",
		        					"@resources01/" + service01.getValue().p01_fichierOptions() + indiceProjet,
		        					"@resources01/" + service01.getValue().p02_fichierClasses() + indiceProjet
		        					};
		        	
					process01 = Runtime.getRuntime().exec(cmd01);	
					
				} catch (IOException except) {
					except.printStackTrace();
				}
		    	
		    	break;
		    	
		    case FAILED:
		    	System.out.println("en plaçant 1 ecouteur , service01, etat, Echec");
		    	break;
		    case CANCELLED:
		    	System.out.println("en plaçant 1 ecouteur , service01, etat, Annulé");
		    	break;
		    default:
		    	System.out.println("Erreur prog 01");
		    } 
		});
		
		// demarrer l'instance de Service
		// la variable portée class
		// prend la valeur de la variable portée locale
		serviceA = service01;
		
		// on demarre l'instance service de Service
        serviceA.start();
		
	}
	
	// --------------------------------------------------------
	
	//
	@FXML
	private void executeProject(int p_indiceProjet) {
		
		System.out.println("");
		System.out.println("----------------------");
		System.out.println("methode executeProject()");
		System.out.println("");
		
		// les variables locales
		
		//
		final Service<Project> service02 = new Service<Project>() {
			
			@Override
			protected Task<Project> createTask() {
				
				return new Task<Project>() {
					
					@Override
					protected Project call() throws Exception {
						
						// liste les propriétés du projet
						// qui a l'indice
						projet = listeProjets[p_indiceProjet];
						
						//
						return projet;
						
					}
					
				};
				
			}
			
		};
		
		//
		System.out.println("");
		System.out.println("Monitorage de l'instance service02");
		
		service02.stateProperty().addListener(observable -> {
			
			switch (serviceB.getState()) {
			case SCHEDULED:
				System.out.println("en plaçant 1 ecouteur , service02 Planifié");
		    	break;
			case READY:
				System.out.println("en plaçant 1 ecouteur , service02 Prêt");
		    	break;
			case RUNNING:
				System.out.println("en plaçant 1 ecouteur , service02 En cours d'execution");
		    	break;
			case SUCCEEDED:
				System.out.println("en plaçant 1 ecouteur , service02, etat, Succes, result = " + projet);
				System.out.println("p03_dossierSortie: " + service02.getValue().p03_dossierSortie());
		    	System.out.println("p04_dossierFichierClass: " + service02.getValue().p04_dossierFichierClass());
				
				try {
					if(process01.waitFor() == 0) {
						String[] cmd02 = {"/usr/bin/java",
										"-p",
										service02.getValue().p03_dossierSortie(),
										"-m",
										service02.getValue().p04_dossierFichierClass()};
						
						try {
							Process process02 = Runtime.getRuntime().exec(cmd02);
						} catch (IOException except) {
							except.printStackTrace();
						}
					}
				} catch (InterruptedException except) {
					except.printStackTrace();
				}
				
				break;
			case FAILED:
				System.out.println("en plaçant 1 ecouteur , service02, etat, Echec");
		    	break;
			case CANCELLED:
				System.out.println("en plaçant 1 ecouteur , service02, etat, Annulé");
		    	break;
			default:
				System.out.println("Erreur prog 02");
			}
			
		});
		
		// demarrer l'instance de Service
		// la variable portée class
		// prend la valeur de la variable portée locale
		serviceB = service02;
		
		// on demarre l'instance service de Service
        serviceB.start();
		
	}
	
	
	// --------------------------------------------------------

}
