package gui;

import domain.Config;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

public class Game extends Parent {
	private final BooleanProperty dragModeActiveProperty =
            new SimpleBooleanProperty(this, "dragModeActive", true);
	private ImageView background;
	private ImageView tower1;
	private ImageView tower2;
	private ImageView tower3;
	private Disc disc1;
	
	
	
	Game() {
		initializeGui();
		Disc disc1 = new Disc(1);
		final Node disc = makeDraggable(disc1);
		
		
		disc.relocate(Config.TOWER_ONE_X-(disc1.getWidth()/2), Config.BOTTOM);

		
		Group group = new Group();
		group.getChildren().addAll(background,tower1,tower2,tower3, disc);
		getChildren().add(group);
		
		
	}



	private Node makeDraggable(final Node node) {
        final DragContext dragContext = new DragContext();
        final Group wrapGroup = new Group(node);

        wrapGroup.addEventFilter(
                MouseEvent.ANY,
                new EventHandler<MouseEvent>() {
                    public void handle(final MouseEvent mouseEvent) {
                        if (dragModeActiveProperty.get()) {
                            // disable mouse events for all children
                            mouseEvent.consume();
                        }
                    }
                });

        wrapGroup.addEventFilter(
                MouseEvent.MOUSE_PRESSED,
                new EventHandler<MouseEvent>() {
                    public void handle(final MouseEvent mouseEvent) {
                        if (dragModeActiveProperty.get()) {
                            // remember initial mouse cursor coordinates
                            // and node position
                            dragContext.mouseAnchorX = mouseEvent.getX();
                            dragContext.mouseAnchorY = mouseEvent.getY();
                            dragContext.initialTranslateX =
                                    node.getTranslateX();
                            dragContext.initialTranslateY =
                                    node.getTranslateY();
                        }
                    }
                });

        wrapGroup.addEventFilter(
                MouseEvent.MOUSE_DRAGGED,
                new EventHandler<MouseEvent>() {
                    public void handle(final MouseEvent mouseEvent) {
                        if (dragModeActiveProperty.get()) {
                            // shift node from its initial position by delta
                            // calculated from mouse cursor movement
                            node.setTranslateX(
                                    dragContext.initialTranslateX
                                        + mouseEvent.getX()
                                        - dragContext.mouseAnchorX);
                            node.setTranslateY(
                                    dragContext.initialTranslateY
                                        + mouseEvent.getY()
                                        - dragContext.mouseAnchorY);
                        }
                    }
                });
                
        return wrapGroup;
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
	 private static final class DragContext {
	        public double mouseAnchorX;
	        public double mouseAnchorY;
	        public double initialTranslateX;
	        public double initialTranslateY;
	    }

}
