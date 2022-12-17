package application.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Properties;
 
/**
 * Javadoc d'Enumerat°: ProjectUtils.java<br>
 * <br>
 * fichier enumeration qui charge le fichier settings.properties qui se<br> 
 * trouve ds resources01/settings.properties.<br>
 * le fichier .properties sert a indexer tous les projets<br>
 * que l'on souhaite.<br>
 * il faut l'editer manuellement pr<br>
 * ajouter ou retirer 1 projet
 */
public enum ProjectUtils {
	
	//
    INSTANCE;
	
	// --------------------------------------------------------------------------
	// modification permise
	// emplacement du fichier .properties
	
	// le dossier qui contient ts les dossiers de projets (c-a-d, le workspace)
	// private static String SETTINGS = "../settings.properties";
	
	// la racine du projet: a cote du dossier src
	// private static String SETTINGS = "settings.properties";
	
	// le dossier resources
	private static String SETTINGS = "resources01/settings.properties";
 
	// --------------------------------------------------------------------------
	
    /**
     * Load project descriptors from settings file.
     *
     * @return A [@code Project[]} instance, never {@code null}.
     * @throws IOException          In case of IO error.
     * @throws NullPointerException If missing projects definition.
     */
    public Project[] loadProjects() throws IOException, NullPointerException {
        final var settings = new Properties();
        try (final var input = Files.newInputStream(Paths.get(SETTINGS))) {
            settings.load(input);
        }
        final var projects = settings.getProperty("projects");
        final var ids = projects.split(", "); // Pas besoin de se casser la tete avec une regexp compliquee.
        
        System.out.println("loadProjects()");
        
        return Arrays.stream(ids)
                .map(id -> idToProject(settings, id))// Extraire le projet de la map.
                .filter(this::validateProject)// Valider le projet.
                .toArray(Project[]::new);
    }
 
    /**
     * Creates project info from ID.
     * @param settings The settings.
     * @param id The project id.
     * @return A {@code Project} instance, never {@code null}.
     */
    // on peut rajouter des propriétes aux projets
    // à cet emplacement
    private Project idToProject(final Properties settings, final String id) {
        final var title = settings.getProperty(id + ".title");
        final var description = settings.getProperty(id + ".description");
        final var path = settings.getProperty(id + ".path");
        final var tags = settings.getProperty(id + ".tags");
        final var p01_fichierOptions = settings.getProperty(id + ".p01_fichierOptions");
        final var p02_fichierClasses = settings.getProperty(id + ".p02_fichierClasses");
        final var p03_dossierSortie = settings.getProperty(id + ".p03_dossierSortie");
        final var p04_dossierFichierClass = settings.getProperty(id + ".p04_dossierFichierClass");
        System.out.println("idToProject()");
        return new Project(id,
        					title,
        					description,
        					path,
        					tags,
        					p01_fichierOptions,
        					p02_fichierClasses,
        					p03_dossierSortie,
        					p04_dossierFichierClass);
    }
 
    /**
     * Validate project.
     * @param project The project to test.
     * @return Returns {@code true} if project is valid, {@code false} otherwise.
     */
    private boolean validateProject(final Project project) {
    	System.out.println("validateProject()");
        // TODO: faire plus de tests.
        return true;
    }

	public static String getSettings() {
		return SETTINGS;
	}

	public static void setSettings(String settings) {
		SETTINGS = settings;
	}
}
