package view;

import controller.InstellingenController;
import controller.SpelersController;
import controller.SpelverloopController;
import controller.StatistiekenController;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Gokspel;

public class AdminView {
	private Stage stage = new Stage();		
		
	public AdminView(InstellingenController instie, SpelersController spellie, SpelverloopController spellopie, StatistiekenController statie){
		stage.setTitle("ADMIN VIEW");
		stage.initStyle(StageStyle.UTILITY);
		stage.setX(930);
		stage.setY(20);
		Group root = new Group();
		Scene scene = new Scene(root, 600, 600);
		BorderPane borderPane = new AdminMainPane(instie, spellie, spellopie, statie);
		borderPane.prefHeightProperty().bind(scene.heightProperty());
		borderPane.prefWidthProperty().bind(scene.widthProperty());
		root.getChildren().add(borderPane);
		stage.setScene(scene);
		stage.sizeToScene();			
		stage.show();		
	}
}
