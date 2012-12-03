package chapter8.assignment19;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ButtonDemo extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = -5527373732891207835L;
	public static final int WIDTH = 400;
	public static final int HEIGHT = 300;
	
	public static final Color[] COLORS = { Color.BLACK, Color.WHITE, Color.BLUE, Color.GREEN, Color.GRAY, Color.CYAN, Color.MAGENTA, Color.ORANGE, Color.YELLOW, Color.PINK, Color.RED};
	public static final String[] COLOR_NAMES = {"Black", "White", "Blue", "Green", "Gray", "Cyan", "Magenta", "Orange", "Yellow", "Pink", "Red"};
	
	public ButtonDemo() {
		setSize(WIDTH, HEIGHT);
		WindowDestroyer listener = new WindowDestroyer();
		addWindowListener(listener);
		
		Container contentPane = getContentPane();
		contentPane.setBackground(Color.WHITE);
		
		contentPane.setLayout(new FlowLayout());
		
		for (String colorName : ButtonDemo.COLOR_NAMES) {
			JButton button = new JButton(colorName);
			button.addActionListener(this);
			contentPane.add(button);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		Container contentPane = getContentPane();
		
		for (int index = 0; index < ButtonDemo.COLOR_NAMES.length; index++) {
			if (ButtonDemo.COLOR_NAMES[index].equals(actionCommand)) {
				contentPane.setBackground(ButtonDemo.COLORS[index]);
				return;
			}
		}
		System.out.println("Error in button interface");
		
	}
	
}
