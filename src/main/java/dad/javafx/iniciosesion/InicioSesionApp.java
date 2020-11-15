package dad.javafx.iniciosesion;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class InicioSesionApp extends Application{
	
	
	private InicioSesionController controller;

	public void start(Stage primaryStage) throws Exception {

		controller = new InicioSesionController();

		Scene scene = new Scene(controller.getView(), 320, 200);

		primaryStage.setTitle("Iniciar sesión");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
