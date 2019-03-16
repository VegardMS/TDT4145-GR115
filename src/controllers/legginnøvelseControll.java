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
	
    @FXML private Button registrerbutton;
    
    @FXML privat TextField navnfield;
    @FXML privat TextField kilofield;
    @FXML privat TextField settfield;
    @FXML privat TextField beskrivelsefield;

	
	@FXML
	private void initialize() {
		
	}

	@FXML
	private void handlelegginnøvelse(ActionEvent event) {
		AnchorPane pane = FXMLLoader.load(getClass().getResource('mainscreen.fxml'))
	}

