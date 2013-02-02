package domain;

import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

//domain by Ebbe Vang

public class Disc extends Parent{
	private int size;
	private int height;
	private int width;

	
	public static final Image LEFT  = Config.getImages().get(Config.IMAGE_DISC_LEFT);
	public static final Image CENTER = Config.getImages().get(Config.IMAGE_DISC_CENTER);
	public static final Image RIGHT = Config.getImages().get(Config.IMAGE_DISC_RIGHT);

	private ImageView leftImageView;
	private ImageView centerImageView;
	private ImageView rightImageView;
	
	public Disc(int i) {
		// set size to i
		setSize(i);
		Group group = new Group();
		leftImageView = new ImageView();
		leftImageView.setImage(LEFT);
		centerImageView = new ImageView();
		centerImageView.setImage(CENTER);
		rightImageView = new ImageView();
		rightImageView.setImage(RIGHT);
		group.getChildren().addAll(leftImageView,centerImageView,rightImageView);
		getChildren().add(group);
		
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return Integer.toString(size);
	}
	
}
