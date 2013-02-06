package domain;

import javafx.collections.ObservableList;
import javafx.scene.image.Image;

public class Config {
	public static final int SCREEN_WIDTH=800;
	public static final int SCREEN_HEIGHT=500;
	public static final String IMAGE_DIR = "/images/";
	//Array of names of images
	private static final String[] IMAGES_NAMES = new String[]{
		"background.png",
		"cilinder.png",
		"disc/left1.png",
		"disc/center1.png",
		"disc/right1.png"
		
		

	};
	public static final int IMAGE_BACKGROUND = 0;
	public static final int IMAGE_TOWER = 1;
	public static final int IMAGE_DISC_LEFT = 2;
	public static final int IMAGE_DISC_CENTER = 3;
	public static final int IMAGE_DISC_RIGHT = 4;
	public static final int SHADOW_WIDTH = 10;
	public static final int TOWER_ONE_X = 130;
	public static final int TOWER_TWO_X = 395;
	public static final int TOWER_THREE_X = 660;
	//bottom of the tower
	public static final int BOTTOM = 385;
	
	
	public static final int WINDOW_BORDER = 3;
	public static final int TITLE_BAR_HEIGHT = 19;
	//Observable ArrayList of Images
	private static ObservableList<Image> images = javafx.collections.FXCollections.<Image>observableArrayList();
	
	public static ObservableList<Image> getImages() {
		return images;
	}

	public static void initialize(){
		for (String imageName : IMAGES_NAMES) {
			
			Image image = new Image(Config.class.getResourceAsStream(IMAGE_DIR + imageName));
			if (image.isError()) {
				System.out.println("Image " +imageName+" was not found");
			}
			images.add(image);
		}
	}
}
