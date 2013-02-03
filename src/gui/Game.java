package gui;

import domain.Config;

import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;

public class Game extends Parent {
	private ImageView background;
	private ImageView tower1;
	private ImageView tower2;
	private ImageView tower3;
	
	Game() {
		background = new ImageView();
		background.setFocusTraversable(true);
		background.setImage(Config.getImages().get(Config.IMAGE_BACKGROUND));
		background.setFitWidth(Config.SCREEN_WIDTH);
		background.setFitHeight(Config.SCREEN_HEIGHT);
		background.requestFocus();
		
		tower1 = new ImageView();
		tower1.setImage(Config.getImages().get(Config.IMAGE_TOWER));
		tower1.setFitWidth(15);
		tower1.setFitHeight(321);
		tower1.setLayoutX(130);
		tower1.setLayoutY(80);
		
		tower2 = new ImageView();
		tower2.setImage(Config.getImages().get(Config.IMAGE_TOWER));
		tower2.setFitWidth(15);
		tower2.setFitHeight(321);
		tower2.setLayoutX(395);
		tower2.setLayoutY(80);
		
		tower3 = new ImageView();
		tower3.setImage(Config.getImages().get(Config.IMAGE_TOWER));
		tower3.setFitWidth(15);
		tower3.setFitHeight(321);
		tower3.setLayoutX(660);
		tower3.setLayoutY(80);
		Group group = new Group();
		group.getChildren().addAll(background,tower1,tower2,tower3);
		getChildren().add(group);
	}

}
