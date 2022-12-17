module JavaFX_Test01_Hello_Devstory {
	requires javafx.controls;

	opens application to javafx.graphics, javafx.fxml;
	exports application;
}
