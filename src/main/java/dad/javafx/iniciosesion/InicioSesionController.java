package dad.javafx.iniciosesion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.codec.digest.DigestUtils;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class InicioSesionController {
	private InicioSesionModel model = new InicioSesionModel();
	private InicioSesionView view = new InicioSesionView();


	public InicioSesionController() {
		
		model.usuarioProperty().bindBidirectional(view.getUsuarioText().textProperty());
		
		model.passwordProperty().bindBidirectional(view.getPasswordPass().textProperty());
		
		view.getAccederButton().setOnAction(e -> onAccederAction(e));
		view.getCalcelarButton().setOnAction(e1 -> onCancelarAction(e1));
		
	}

	private void onAccederAction(ActionEvent e) {

		String user = model.getUser();
		String password = model.getPassword();
		boolean found = false;

		String encryptedPass = DigestUtils.md5Hex(password).toUpperCase();
		String currentLine = "";
		String[] currentLineData;

		FileReader reader;
		BufferedReader bufferedReader;

		try {
			ClassLoader classLoader = getClass().getClassLoader();
			reader = new FileReader(new File(classLoader.getResource("users.csv").getFile()));
			bufferedReader = new BufferedReader(reader);

			while ((currentLine = bufferedReader.readLine()) != null) {
				currentLineData = currentLine.split(",");
				if (currentLineData[0].equals(user) && currentLineData[1].equals(encryptedPass)) {
					found = true;
					correctData(user);
				}
			}

			if (!found) {
				wrongData(user);
			}

			reader.close();
			bufferedReader.close();

		} catch (IOException e1) {
//			e1.printStackTrace();
			System.out.println("No se pudo abrir users.csv");
		}

	}

	private void correctData(String user) {

		Alert successAlert = new Alert(AlertType.INFORMATION);
		successAlert.setTitle("Iniciar sesión");
		successAlert.setHeaderText("Acceso permitido");
		successAlert.setContentText("Las credenciales de acceso son válidas.");

		successAlert.showAndWait();

		Platform.exit();

	}

	private void wrongData(String user) {

		Alert failureAlert = new Alert(AlertType.ERROR);
		failureAlert.setTitle("Iniciar sesión");
		failureAlert.setHeaderText("Acceso denegado");
		failureAlert.setContentText("El usuario y/o la contraseña no son válidos.");

		failureAlert.showAndWait();

		model.setUser("");
		model.setPassword("");

	}

	private void onCancelarAction(ActionEvent e1) {
		Platform.exit();
	}

	public InicioSesionView getView() {
		return view;
	}
}
