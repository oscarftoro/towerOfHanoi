package gui;

import domain.Config;

import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;

public class Game extends Parent {
	private ImageView background;
	private ImageView tower1;
	//wdwdw
	Game() {
		background = new ImageView();
		background.setFocusTraversable(true);
		background.setImage(Config.getImages().get(Config.IMAGE_BACKGROUND));
		background.setFitWidth(Config.SCREEN_WIDTH);
		background.setFitHeight(Config.SCREEN_HEIGHT);
		background.requestFocus();
		
		tower1 = new ImageView();
		tower1.setImage(Config.getImages().get(Config.IMAGE_TOWER));
		tower1.setFitWidth(50);
		tower1.setFitHeight(600);
		tower1.setLayoutX(30);
		tower1.setLayoutY(-30);
		
		
		
		Group group = new Group();
		group.getChildren().addAll(background,tower1);
		getChildren().add(group);
	}

}
