module JavaFX_Test02_Desvstory {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.base;
	requires javafx.graphics;
	requires javafx.swing;
	
	exports applicationShowDate;
	opens applicationShowDate to javafx.graphics, javafx.fxml, javafx.base;
}
