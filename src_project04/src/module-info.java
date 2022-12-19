module JavaFX_Test04_Code_Makery_Ch {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.base;
	requires javafx.graphics;
	
	// opens ch.makery.address to javafx.graphics, javafx.fxml;
	exports ch.makery.address;
	opens ch.makery.address.view to javafx.graphics, javafx.fxml;
}
