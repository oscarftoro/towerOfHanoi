	/*
	 * Copyright (c) 2008, 2012 Oracle and/or its affiliates.
	 * All rights reserved. Use is subject to license terms.
	 *
	 * This file is available and licensed under the following license:
	 *
	 * Redistribution and use in source and binary forms, with or without
	 * modification, are permitted provided that the following conditions
	 * are met:
	 *
	 *  - Redistributions of source code must retain the above copyright
	 *    notice, this list of conditions and the following disclaimer.
	 *  - Redistributions in binary form must reproduce the above copyright
	 *    notice, this list of conditions and the following disclaimer in
	 *    the documentation and/or other materials provided with the distribution.
	 *  - Neither the name of Oracle Corporation nor the names of its
	 *    contributors may be used to endorse or promote products derived
	 *    from this software without specific prior written permission.
	 *
	 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
	 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
	 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
	 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
	 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
	 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
	 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
	 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
	 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
	 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
	 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
	 */
package gui;

import domain.Config;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

//domain by Ebbe Vang
//changeSize by Oracle
//Implementation Oscar Toro

public class Disc extends Parent{
	private final BooleanProperty dragModeActiveProperty =
            new SimpleBooleanProperty(this, "dragModeActive", true);
	private int size;
	private int height;
	private int width;
	public int getWidth() {
		return width;
	}
	//layoutX to dragg the disc from the middle
	private double layoutX;
	
	public static final int DEFAULT_SIZE = 2;
	
	public static final Image LEFT  = Config.getImages().get(Config.IMAGE_DISC_LEFT);
	public static final Image CENTER = Config.getImages().get(Config.IMAGE_DISC_CENTER);
	public static final Image RIGHT = Config.getImages().get(Config.IMAGE_DISC_RIGHT);

	private ImageView leftImageView;
	private ImageView centerImageView;
	private ImageView rightImageView;
	
	
	public Disc(int i) {
		// set size to i
		setSize(i);
		final Group group = new Group();
		leftImageView = new ImageView();
		leftImageView.setImage(LEFT);
		centerImageView = new ImageView();
		centerImageView.setImage(CENTER);
		centerImageView.setTranslateX(LEFT.getWidth());
		rightImageView = new ImageView();
		rightImageView.setImage(RIGHT);
		changeSize(7);
		makeDraggable(group);
		group.getChildren().addAll(leftImageView,centerImageView,rightImageView);
		
		
		getChildren().add(makeDraggable(group));
		//drag the disc from the middle
		this.setLayoutX(getLayoutXDisc());
	}
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void changeSize(int newSize) {
        this.size = newSize;
        width = size * 12 + 45;
        //define the center of the disc to not change the 
        layoutX = -(width/2);
        double rightWidth = RIGHT.getWidth() - Config.SHADOW_WIDTH;
        double centerWidth = width - LEFT.getWidth() - rightWidth;
        centerImageView.setViewport(new Rectangle2D(
            (CENTER.getWidth() - centerWidth) / 2, 0, centerWidth, CENTER.getHeight()));
        rightImageView.setTranslateX(width - rightWidth);
        
    }

	public double getLayoutXDisc() {
		return layoutX;
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
	@Override
	public String toString() {
		
		return Integer.toString(size);
	}
	 private static final class DragContext {
	        public double mouseAnchorX;
	        public double mouseAnchorY;
	        public double initialTranslateX;
	        public double initialTranslateY;
	 }
	
}
