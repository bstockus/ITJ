package demos.gui;

import java.awt.TextArea;
import java.awt.Frame;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowAdapter;

import java.awt.Color;
import java.awt.Font;
import java.awt.BorderLayout;

@SuppressWarnings("unused")
public class Example1 extends WindowAdapter {
	public static void main(String[] args) {
		Example1 instance = new Example1();
	}

	@SuppressWarnings("deprecation")
	public Example1() {
		Frame f = new Frame("TextArea Example");
		f.setLayout(new BorderLayout());

		// Make a text area, set its font and color, then add it to the frame
		TextArea text = new TextArea();
		Font font = new Font("Serif", Font.ITALIC, 20);
		text.setFont(font);
		text.setForeground(Color.blue);
		text.setBackground(Color.red);
		f.add(text, BorderLayout.CENTER);

		// Listen for the user to click the frame's close box
		f.addWindowListener(this);
		f.setSize(400, 400);
		f.show();
	}

	public void windowClosing(WindowEvent evt) {
		System.exit(0);
	}

}
