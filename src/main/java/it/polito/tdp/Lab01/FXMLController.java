package it.polito.tdp.Lab01;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.Lab01.model.Parole;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Parole elenco ;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnInserisci;

    @FXML
    private Button btnReset;
    
    @FXML
    private Button btnCancella;

    @FXML
    private TextField txtParola;

    @FXML
    private TextArea txtResult;
    
    @FXML
    private TextArea txtTempo;

    @FXML
    void doCancel(ActionEvent event) {
    	
    	long tempoInizio = System.nanoTime();
    	
    	String parolaDaEliminare = txtResult.getSelectedText();
    	elenco.eliminaParola(parolaDaEliminare);  
    	
    	txtResult.clear();
    	String paroleInserite = "";
    	for(String s: elenco.getElenco()) {
    		paroleInserite = paroleInserite + s + "\n"; }
    	
    	txtResult.setText(paroleInserite);
    	
    	long tempoFine = System.nanoTime();
    	txtTempo.clear();
    	txtTempo.setText("[CANCELLA]: " + (tempoFine - tempoInizio));
    	}

    @FXML
    void doInsert(ActionEvent event) {
    	
    	long tempoInizio = System.nanoTime();

    	elenco.addParola(txtParola.getText());
    	txtResult.clear();
    	
    	String paroleInserite = "";
    	for(String s: elenco.getElenco()) {
    		paroleInserite = paroleInserite + s + "\n"; }
    	
    	txtResult.setText(paroleInserite);
    	txtParola.clear();
    	
    	long tempoFine = System.nanoTime();
    	txtTempo.clear();
    	txtTempo.setText("[INSERT]: " + (tempoFine - tempoInizio));
    }

    @FXML
    void doReset(ActionEvent event) {
    	
    	long tempoInizio = System.nanoTime();
    	
    	txtParola.clear();
    	txtResult.clear();
    	elenco.reset();
    	
    	long tempoFine = System.nanoTime();
    	txtTempo.clear();
    	txtTempo.setText("[RESET]: " + (tempoFine - tempoInizio));
    }

    @FXML
    void initialize() {
        assert btnCancella != null : "fx:id=\"btnCancella\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTempo != null : "fx:id=\"txtTempo\" was not injected: check your FXML file 'Scene.fxml'.";

        elenco = new Parole() ;
    }

}
