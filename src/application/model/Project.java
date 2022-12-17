package application.model;

/**
 * Javadoc de Record: Project.java<br>
 * <br>
 * Holds project info.<br>
 * @param id The project's unique ID.<br>
 * @param title The project's human-readable title.<br>
 * @param description The project's human-readable description.<br>
 * @param path The path to the project.<br>
 * @param tags many tags (or none) to help for future Research feature
 */
public record Project(String id,
						String title,
						String description,
						String path,
						String tags,
						String p01_fichierOptions,
						String p02_fichierClasses,
						String p03_dossierSortie,
						String p04_dossierFichierClass) {
}
