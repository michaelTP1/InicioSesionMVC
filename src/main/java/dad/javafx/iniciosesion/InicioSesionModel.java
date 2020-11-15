package dad.javafx.iniciosesion;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class InicioSesionModel {
	
	private StringProperty user = new SimpleStringProperty();
	private StringProperty password = new SimpleStringProperty();
	
	public final StringProperty usuarioProperty() {
		return this.user;
	}
	
	public final String getUser() {
		return this.usuarioProperty().get();
	}
	
	public final void setUser(String usuario) {
		this.usuarioProperty().set(usuario);
	}
	
	public final StringProperty passwordProperty() {
		return this.password;
	}
	
	public final String getPassword() {
		return this.passwordProperty().get();
	}
	
	public final void setPassword(String password) {
		this.passwordProperty().set(password);
	}
}
