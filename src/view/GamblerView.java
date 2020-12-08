package view;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Gokspel;

public class GamblerView {
	private Stage stage = new Stage();		
		
	public GamblerView(Gokspel gokspel){
		stage.setTitle("GAMBLER VIEW");
		stage.initStyle(StageStyle.UTILITY);
		stage.setX(20);
		stage.setY(20);
		GridPane rootPane = new GridPane();
		Scene scene = new Scene(rootPane, 900, 600);
		GridPane gridPane = new GamblerTopPane(gokspel);
		GridPane gridPane2 = new GamblerMiddlePane(gokspel);
		gridPane.prefWidthProperty().bind(scene.widthProperty());
		gridPane2.prefWidthProperty().bind(scene.widthProperty());
		rootPane.setConstraints(gridPane, 0,0);
		rootPane.setConstraints(gridPane2,0,1);
		rootPane.getChildren().addAll(gridPane, gridPane2);
		stage.setScene(scene);
		stage.sizeToScene();			
		stage.show();		
	}
}
