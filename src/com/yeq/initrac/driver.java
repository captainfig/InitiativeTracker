package com.yeq.initrac;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;



public class driver extends Application {
	TableView<Character> table;
	Stage window;
	Scene main, add;

	TextField nameField, initField, dexField;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		window = primaryStage;
		window.setTitle("Initiative Tracker");
		
		// Name Column
		TableColumn<Character, String> nameColumn = new TableColumn<>("Name");
		nameColumn.setMinWidth(200);
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		
		// Initiative Column
		TableColumn<Character, Integer> initColumn = new TableColumn<>("Initiative");
		initColumn.setMinWidth(100);
		initColumn.setCellValueFactory(new PropertyValueFactory<>("init"));
				
		// Dex Column
		TableColumn<Character, Integer> dexColumn = new TableColumn<>("Dex Mod");
		dexColumn.setMinWidth(100);
		dexColumn.setCellValueFactory(new PropertyValueFactory<>("dex"));
		
		// TableView
		table = new TableView<>();
		table.setItems(getCharTable());
		table.getColumns().addAll(nameColumn, initColumn, dexColumn);
		
		
		// Buttons to add / remove from table
		Button closeButton = new Button("Close");
		closeButton.setOnAction(e -> window.close());
		
		Button deleteButton = new Button("Remove");
		deleteButton.setOnAction(e -> deleteButtonClicked());
		
		Button addButton = new Button("Add");
		addButton.setOnAction(e -> addButtonClicked());

		// Layout for bottom interface
		HBox bottomText = new HBox();
		
		
		nameField = new TextField();
		nameField.setPromptText("Name");
		initField = new TextField();
		initField.setPromptText("Initiative");
		dexField = new TextField();
		dexField.setPromptText("Dex Mod");
		
		
		bottomText.getChildren().addAll(nameField, initField, dexField, addButton, deleteButton, closeButton);
		bottomText.setPadding(new Insets(10, 10, 10, 10));
		bottomText.setSpacing(10);
		
		// Main layout
		VBox mainLayout = new VBox();
		mainLayout.getChildren().addAll(table, bottomText);
		mainLayout.setPadding(new Insets(20, 10, 10, 10));
		
		Scene scene = new Scene(mainLayout);
		window.setScene(scene);
		window.show();
	}
	
	private void deleteButtonClicked() {
		ObservableList<Character> characterSelected, allCharacters;
		allCharacters = table.getItems();
		characterSelected = table.getSelectionModel().getSelectedItems();
		characterSelected.forEach(allCharacters::remove);
	}

	public void addButtonClicked() {
		Character newChar = new Character();
		newChar.setName(nameField.getText());
		newChar.setInit(Integer.parseInt(initField.getText()));
		newChar.setDex(Integer.parseInt(initField.getText()));
		table.getItems().add(newChar);
		nameField.clear();
		initField.clear();
		dexField.clear();		
	}

	public ObservableList<Character> getCharTable() {
		ObservableList<Character> charTable = FXCollections.observableArrayList();
		charTable.add(new Character("Ginjeet", 5, 5));
		charTable.add(new Character("Grond", 12, 2));
		charTable.add(new Character("Tippa", 26, 4));
		charTable.add(new Character("Thaliyah", 24, 5));
		return charTable;
	}

}
