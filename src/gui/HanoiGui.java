package gui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;

public class HanoiGui extends JPanel {

	/**
	 * Create the panel.
	 */
	public HanoiGui() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panelNorth = new JPanel();
		add(panelNorth, BorderLayout.NORTH);
		panelNorth.setLayout(new BorderLayout(0, 0));
		
		JLabel labelHighScore = new JLabel("New label");
		labelHighScore.setHorizontalAlignment(SwingConstants.RIGHT);
		panelNorth.add(labelHighScore);
		
		JPanel panelSouth = new JPanel();
		add(panelSouth, BorderLayout.SOUTH);
		
		JLabel labelCopyright = new JLabel("by ebbv");
		panelSouth.add(labelCopyright);
		
		//JPanel panelGame = new JPanel();
		// implement own panelClass
		HanoiPanel panelGame = new HanoiPanel();
		
		panelGame.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
			}
		});
		add(panelGame, BorderLayout.CENTER);

	}

}
