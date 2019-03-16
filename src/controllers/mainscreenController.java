package Farkle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class mainscreenController {
	
	@FXML private Button Legginnøvelse;
	@FXML private Button registrertreningsøkt;
	@FXML private Button registrergruppe;
	@FXML private Button legginnapparat;
	@FXML private Button sefavoritt;
	
	@FXML
	private void initialize() {
		
	}

	@FXML
	private void handleLegginnøvelse(ActionEvent event) {
		AnchorPane pane = FXMLLoader.load(getClass().getResource('legginnøvelse.fxml'))
	}
	
	@FXML
	private void handleregistrertreningsøkt(ActionEvent event) {
		AnchorPane pane = FXMLLoader.load(getClass().getResource('registrertreningsøkt.fxml'))
	}
	
	@FXML
	private void handleregistrergruppe(ActionEvent event) {
		AnchorPane pane = FXMLLoader.load(getClass().getResource('registrergruppe.fxml'))
	}

	@FXML
	private void handlelegginnappparat(ActionEvent event) {
		AnchorPane pane = FXMLLoader.load(getClass().getResource('legginnapparat.fxml'))
	}

	@FXML
	private void handlesefavoritt(ActionEvent event) {
		AnchorPane pane = FXMLLoader.load(getClass().getResource('sefavoritt.fxml'))
	}


