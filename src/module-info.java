module JavaFX_Test31_indexeur_projets {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.base;
	requires javafx.graphics;
	requires javafx.swing;
	
	// requires java.sql;
	// requires java.sql.rowset;
	
	exports application;
	
	opens application.view to javafx.graphics, javafx.fxml;
	opens application.controller to javafx.graphics, javafx.fxml, javafx.controls, javafx.base;
	// opens application.UtilsDB to javafx.graphics, javafx.fxml;
	// opens application.DAO to javafx.graphics, javafx.fxml;
	// opens application.UtilsGetImages to javafx.graphics, javafx.fxml;
	// opens application.model to javafx.graphics, javafx.fxml, javafx.base;
	// opens application.resource to javafx.graphics, javafx.fxml, javafx.base;
	
	opens application to javafx.graphics, javafx.fxml;
}
