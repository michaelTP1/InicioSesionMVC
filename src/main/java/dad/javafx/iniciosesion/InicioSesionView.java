package dad.javafx.iniciosesion;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class InicioSesionView extends GridPane {
	
	private Label usuarioLabel;
	private TextField usuarioText;
	private Label passwordLabel;
	private PasswordField passwordPField;
	
	private Button accederButton;
	private Button cancelarButton;
	
	public InicioSesionView() {
		
		super();
		
		usuarioLabel = new Label("Usuario:");
		usuarioLabel.setPrefWidth(80);
		usuarioText = new TextField();
		usuarioText.setPromptText("Usuario");
		passwordLabel = new Label("Contraseña:");
		passwordLabel.setPrefWidth(80);
		passwordPField = new PasswordField();
		passwordPField.setPromptText("Contraseña");
		
		accederButton = new Button("Acceder");
		accederButton.setDefaultButton(true);
		cancelarButton = new Button("Cancelar");
		
		setAlignment(Pos.CENTER);
		setVgap(5);
		setPadding(new Insets(20));
		add(usuarioLabel, 0, 0);
		add(usuarioText, 1, 0);
		add(passwordLabel, 0, 2);
		add(passwordPField, 1, 2);
		setFillWidth(usuarioText, true);
		HBox buttonBox = new HBox(20, accederButton, cancelarButton);
		buttonBox.setAlignment(Pos.CENTER);
		buttonBox.setPadding(new Insets(10,0,0,0));
		add(buttonBox, 0, 3);
		setColumnSpan(buttonBox, 2);
		
		
	}
	
	public Label getUsuarioLabel() {
		return usuarioLabel;
	}
	
	public TextField getUsuarioText() {
		return usuarioText;
	}
	
	public Label getPasswordLabel() {
		return passwordLabel;
	}
	
	public PasswordField getPasswordPass() {
		return passwordPField;
	}
	
	public Button getAccederButton() {
		return accederButton;
	}
	
	public Button getCalcelarButton() {
		return cancelarButton;
	}
	
}