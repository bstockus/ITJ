package experiments.drawing;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class SwingPaintDemo {
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
	
	private static void createAndShowGUI() {
		JFrame frame = new JFrame("SwingPaintDemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new DrawingPanel());
		frame.pack();
		frame.setVisible(true);
	}
	
}
