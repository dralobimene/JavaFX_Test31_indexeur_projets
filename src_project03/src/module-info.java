module JavaFX_Test03_Code_Makey_Ch {
	requires javafx.controls;
	requires javafx.fxml;
	
	opens ch.makery.address to javafx.graphics, javafx.fxml;
}
