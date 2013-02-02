package gui;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import domain.Config;
import domain.TowerOfHanoiGame;

public class Main extends Application{
	
	private static MainFrame mainFrame;
	ImageView background;
	
	public static void main(String[] args) {
		Application.launch(args);
		//		TowerOfHanoiGame game;
//		game = new TowerOfHanoiGame();
		
//		JFrame frame  =new JFrame("Tower of Hanoi");
//		frame.setSize(800,400);
//		frame.add(new HanoiGui());
//		frame.setVisible(true);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		Config.initialize();
		Group root = new Group();
		mainFrame = new MainFrame(root);
		
//		background = new ImageView();
//		background.setFocusTraversable(true);
//		background.setImage(Config.getImages().get(Config.IMAGE_BACKGROUND));
//		background.setFitWidth(Config.SCREEN_WIDTH);
//		background.setFitHeight(Config.SCREEN_HEIGHT);
//		background.requestFocus();
//		root.getChildren().add(background);
		
		
		stage.setTitle("Tower of Hanoi");
		stage.setResizable(false);
		stage.setWidth(Config.SCREEN_WIDTH);
		stage.setHeight(Config.SCREEN_HEIGHT);
		Scene scene = new Scene(root);
		scene.setFill(Color.AQUA);
		stage.setScene(scene);
		mainFrame.changeState(1);
		stage.show();
		
		
	}
	public class MainFrame {
		private Game game;
		public static final int GAME = 0;
		private int state = GAME;
		private Group root;
		
	
		private MainFrame(Group root){
			this.root = root;
		}
		public void changeState(int newState) {
			
			this.state = newState;
			//put the background
			if (state == 1){
				game = new Game();
				root.getChildren().add(game);
				
			}
			
		}
		
	}
}
