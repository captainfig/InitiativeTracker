package com.yeq.initrac;

import java.util.ArrayList;
import java.util.Collections;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CharBox {
	
	public static void display(ObservableList<Character> charTable) {
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Add Character");
		window.setMinWidth(250);

		
		Button submitButton = new Button("Add");
		TextField nameField = new TextField();
		TextField initField = new TextField();
		Label nameLabel = new Label("Character Name: ");
		Label initLabel = new Label("Character Initiative: ");
		GridPane.setConstraints(submitButton, 0, 2);
		GridPane.setConstraints(nameField, 1, 0);
		GridPane.setConstraints(initField, 1, 1);
		GridPane.setConstraints(nameLabel, 0, 0);
		GridPane.setConstraints(initLabel, 0, 1);
		
		submitButton.setOnAction( e-> {
			String name = nameField.getText();
			String initStr = initField.getText();
			int dex = 0;
			
			try {
				int init = Integer.parseInt(initStr);
				charTable.add(new Character(name, init, dex));
				Collections.sort(charTable, new CharComparator());
				window.close();
			}
			catch (NumberFormatException ex) {
				AlertBox.display("Error", "Please enter a number");
				initField.clear();
			}
			
		});
		
		window.setOnCloseRequest(e -> {
			window.close();
		});
		
		GridPane layout = new GridPane();
		layout.setPadding(new Insets(10, 10, 10, 10));
		layout.setVgap(8);
		layout.setHgap(10);
		
		
		layout.getChildren().addAll(submitButton, nameField, initField, nameLabel, initLabel);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
		
	}
}
