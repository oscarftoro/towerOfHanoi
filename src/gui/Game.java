package gui;

import domain.Config;

import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;

public class Game extends Parent {
	private ImageView background;
	
	Game() {
		background = new ImageView();
		background.setFocusTraversable(true);
		background.setImage(Config.getImages().get(Config.IMAGE_BACKGROUND));
		background.setFitWidth(Config.SCREEN_WIDTH);
		background.setFitHeight(Config.SCREEN_HEIGHT);
		background.requestFocus();
		
		Group group = new Group();
		group.getChildren().add(background);
		getChildren().add(group);
	}

}
