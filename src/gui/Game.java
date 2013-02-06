package gui;

import domain.Config;

import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;

public class Game extends Parent {
	
	private ImageView background;
	private ImageView tower1;
	private ImageView tower2;
	private ImageView tower3;
	private Disc disc1;
	
	
	
	Game() {
		initializeGui();
		disc1 = new Disc(1);
		
		disc1.relocate(Config.TOWER_ONE_X-(disc1.getWidth()/2), Config.BOTTOM);

		
		Group group = new Group();
		group.getChildren().addAll(background,tower1,tower2,tower3, disc1);
		getChildren().add(group);
		
		
	}



	


	private void initializeGui() {
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
		tower1.setLayoutX(Config.TOWER_ONE_X);
		tower1.setLayoutY(80);
		
		tower2 = new ImageView();
		tower2.setImage(Config.getImages().get(Config.IMAGE_TOWER));
		tower2.setFitWidth(15);
		tower2.setFitHeight(321);
		tower2.setLayoutX(Config.TOWER_TWO_X);
		tower2.setLayoutY(80);
		
		tower3 = new ImageView();
		tower3.setImage(Config.getImages().get(Config.IMAGE_TOWER));
		tower3.setFitWidth(15);
		tower3.setFitHeight(321);
		tower3.setLayoutX(Config.TOWER_THREE_X);
		tower3.setLayoutY(80);
	}
	private void initStartingTimeLine(){
		new Timeline();
	}
	public void moveDisc(Disc disc,double newX,double newY){
		double x = newX;
		double y = newY;
		
		disc.setTranslateX(x);
		disc.setTranslateY(y);
		
	}
	

}
