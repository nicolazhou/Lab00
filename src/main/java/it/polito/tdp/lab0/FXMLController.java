package it.polito.tdp.lab0;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class FXMLController {

	int tentativi = 0;
	int tentativiMax = 3;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonAccedi;

    @FXML
    private Button buttonClear;

    @FXML
    private Label txtMessaggio;

    @FXML
    private TextField txtNome;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private Label txtTentativi;

    private boolean checkPassword(String testo) {
    	
    	boolean ris = false;
    	
    	String lettere[] = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "l", "m", "j", "k", "n", "o", "p", "q", "r", "s", "t", "u", "v", "z", "x","w","y"};
    	String lettereM[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "L", "M", "J", "K", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "Z", "X","W","Y"};
    	
    	String numeri[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    	String segni[] = {"!", "?", "@", "#"};
    	
    	boolean checkL = false;
    	boolean checkLM = false;
    	boolean checkN = false;
    	boolean checkS = false;
    	
    	for(int i = 0; i < lettere.length; i++) {
    		if(testo.contains(lettere[i])) {
    			checkL = true;
    		}
    	}
    	for(int i = 0; i < lettereM.length; i++) {
    		if(testo.contains(lettereM[i])) {
    			checkLM = true;
    		}
    	}
    	
    	for(int i = 0; i < numeri.length; i++) {
    		if(testo.contains(numeri[i])) {
    			checkN = true;
    		}
    	}
    	
    	for(int i = 0; i < segni.length; i++) {
    		if(testo.contains(segni[i])) {
    			checkS = true;
    		}
    	}
    	
    	if(checkL && checkLM && checkN && checkS && testo.length() >= 7) {
    		ris = true;
    	}
    	
    	return ris;
    }
    
    @FXML
    void doAccedi(ActionEvent event) {
    	
    	boolean check = false;
    	
    	if(txtNome.getText().compareTo("")==0) {
    		txtMessaggio.setText("Inserire il tuo nome");
    	}
    	else if(txtPassword.getText().length()<7) {
    		txtMessaggio.setText("La password deve essere di almeno 7 caratteri");
    	}
    	else if(!checkPassword(txtPassword.getText())) {
    		txtMessaggio.setText("La password deve contenere almeno una lettera\n" + "maiuscola, un numero e un segno tra !?@#");
    	} 
    	else if(checkPassword(txtPassword.getText())) {
    		txtMessaggio.setText("OK");
    		
    		check = true;
    		
    	}
    	
    	
    	// Esercizio 2 
    	
    	if(!check) {
    		
    		txtNome.setEditable(false);
    		txtNome.setDisable(true);
    		
    		tentativi++;
    		
    		txtTentativi.setText("Tentativi rimasti: " + (tentativiMax-tentativi));
    		
    	} else {
    		
        	txtNome.setText("");
        	txtPassword.setText("");
        	
        	txtTentativi.setText("Tentativi rimasti: 0");
        	
        	txtNome.setEditable(true);
        	txtNome.setDisable(false);
        	buttonAccedi.setDisable(false);
        	buttonClear.setDisable(true);
        	tentativi = 0;
        	
    	}
    	
    	
    	if(tentativi == tentativiMax) {
    		buttonAccedi.setDisable(true);
    		buttonClear.setDisable(false);
    	}
    
    	
    	
    }

    @FXML
    void doClear(ActionEvent event) {
    	
    	txtNome.setText("");
    	txtPassword.setText("");
    	
    	txtTentativi.setText("Tentativi rimasti: 0");
    	
    	txtNome.setEditable(true);
    	txtNome.setDisable(false);
    	buttonAccedi.setDisable(false);
    	buttonClear.setDisable(true);
    	tentativi = 0;

    }

    @FXML
    void initialize() {
        assert buttonAccedi != null : "fx:id=\"buttonAccedi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert buttonClear != null : "fx:id=\"buttonClear\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtMessaggio != null : "fx:id=\"txtMessaggio\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtPassword != null : "fx:id=\"txtPassword\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTentativi != null : "fx:id=\"txtTentativi\" was not injected: check your FXML file 'Scene.fxml'.";

    }

}