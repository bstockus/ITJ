package chapter8.assignment19;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ButtonDemo extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = -5527373732891207835L;
	public static final int WIDTH = 400;
	public static final int HEIGHT = 350;
	
	public static final Color[] COLORS = { Color.BLACK, Color.WHITE, Color.BLUE, Color.GREEN, Color.GRAY, Color.CYAN, Color.MAGENTA, Color.ORANGE, Color.YELLOW, Color.PINK, Color.RED};
	public static final String[] COLOR_NAMES = {"Black", "White", "Blue", "Green", "Gray", "Cyan", "Magenta", "Orange", "Yellow", "Pink", "Red"};
	
	private static final Color LIGHT_BACKGROUND_COLOR = Color.WHITE;
	private static final Color DARK_BACKGROUND_COLOR = Color.BLACK;
	
	private static final Float COLOR_NAME_FONT_SIZE = (float) 78.0;
	private static final Float COLOR_DETAILS_FONT_SIZE = (float) 24.0;
	
	private Integer currentColor = -1;
	private String[] colorDetails;
	private Color[] backgroundColors;
	private JButton[] colorButtons;
	private JPanel colorPanel;
	private JPanel buttonPanel;
	private JLabel colorNameLabel;
	private JLabel colorDetailsLabel;
	private Font normalButtonFont;
	private Font highlightedButtonFont;
	
	public ButtonDemo() {
		setSize(WIDTH, HEIGHT);
		WindowDestroyer listener = new WindowDestroyer();
		addWindowListener(listener);
		
		Container contentPane = getContentPane();
		contentPane.setBackground(Color.WHITE);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));
		this.buttonPanel = new JPanel(new FlowLayout());
		contentPane.add(this.buttonPanel);
		this.colorPanel = new JPanel(new FlowLayout());
		contentPane.add(this.colorPanel);
		this.colorNameLabel = new JLabel("");
		this.colorNameLabel.setFont(this.colorNameLabel.getFont().deriveFont(ButtonDemo.COLOR_NAME_FONT_SIZE));
		this.colorPanel.add(this.colorNameLabel);
		this.colorDetailsLabel = new JLabel("");
		this.colorDetailsLabel.setFont(this.colorDetailsLabel.getFont().deriveFont(ButtonDemo.COLOR_DETAILS_FONT_SIZE));
		this.colorPanel.add(this.colorDetailsLabel);
		
		this.colorButtons = new JButton[ButtonDemo.COLOR_NAMES.length];
		this.backgroundColors = new Color[ButtonDemo.COLOR_NAMES.length];
		this.colorDetails = new String[ButtonDemo.COLOR_NAMES.length];
		
		for (Integer index = 0; index < ButtonDemo.COLOR_NAMES.length; index ++) {
			String colorName = ButtonDemo.COLOR_NAMES[index];
			Color color = ButtonDemo.COLORS[index];
			JButton button = new JButton("");
			button.setBackground(color);
			button.setFont(button.getFont().deriveFont(Font.PLAIN));
			button.setActionCommand(colorName);
			button.addActionListener(this);
			button.setPreferredSize(new Dimension(50, 50));
			this.buttonPanel.add(button);
			this.colorButtons[index] = button;
			Integer red = color.getRed();
			Integer blue = color.getBlue();
			Integer green = color.getBlue();
			this.colorDetails[index] = String.format("Red = %d Blue = %d Green = %d", red, blue, green);
			Double composite = ((red / 255.0) + (blue / 255.0) + (green / 255.0)) / 3.0;
			if (composite > 0.5) {
				this.backgroundColors[index] = ButtonDemo.DARK_BACKGROUND_COLOR;
			} else {
				this.backgroundColors[index] = ButtonDemo.LIGHT_BACKGROUND_COLOR;
			}
		}
		
		this.normalButtonFont = this.colorButtons[0].getFont();
		this.highlightedButtonFont = this.normalButtonFont.deriveFont(Font.BOLD);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		
		for (int index = 0; index < ButtonDemo.COLOR_NAMES.length; index++) {
			if (ButtonDemo.COLOR_NAMES[index].equals(actionCommand)) {
				this.colorPanel.setBackground(ButtonDemo.COLORS[index]);
				this.colorNameLabel.setBackground(ButtonDemo.COLORS[index]);
				this.colorNameLabel.setForeground(this.backgroundColors[index]);
				this.colorNameLabel.setText(ButtonDemo.COLOR_NAMES[index]);
				this.colorDetailsLabel.setBackground(ButtonDemo.COLORS[index]);
				this.colorDetailsLabel.setForeground(this.backgroundColors[index]);
				this.colorDetailsLabel.setText(this.colorDetails[index]);
				if (this.currentColor != -1) {
					this.colorButtons[this.currentColor].setFont(this.normalButtonFont);
				}
				this.currentColor = index;
				this.colorButtons[this.currentColor].setFont(this.highlightedButtonFont);
				return;
			}
		}
		System.out.println("Error in button interface");
		
	}
	
}
