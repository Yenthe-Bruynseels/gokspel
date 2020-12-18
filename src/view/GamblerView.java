package view;

import controller.GamblerViewController;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class GamblerView {
	private Stage stage = new Stage();
		
	public GamblerView(GamblerViewController gambie){
		stage.setTitle("GAMBLER VIEW");
		stage.initStyle(StageStyle.UTILITY);
		stage.setX(20);
		stage.setY(20);
		Group root = new Group();
		Scene scene = new Scene(root, 900, 600);
		GridPane gridPane = new GamblerMainPane(gambie);
		gridPane.prefWidthProperty().bind(scene.widthProperty());
		gridPane.prefHeightProperty().bind(scene.heightProperty());
		root.getChildren().add(gridPane);
		stage.setScene(scene);
		stage.sizeToScene();			
		stage.show();
	}
}
