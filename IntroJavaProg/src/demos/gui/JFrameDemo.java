package demos.gui;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;


@SuppressWarnings("serial")
public class JFrameDemo extends JFrame implements ActionListener {
	// ******** INSTANTIATE NEW INSTANCES OF JMenuBar, JMenu, JLabel,
	// JTextField, JButton
	// ------------------ MENU BAR ----------------------- create a menu bar for
	// the frame
	// mainBar is the name of the menu bar
	JMenuBar mainBar = new JMenuBar();

	// menus 1 and 2 are options on the main menu bar
	JMenu menu1 = new JMenu("File");
	JMenuItem exit = new JMenuItem("Exit");

	JMenu menu2 = new JMenu("Programs");
	JMenuItem grossPayProgram = new JMenuItem("Run GetGrossPay");
	JMenuItem ifElseProgram = new JMenuItem("Run IfElseProgram");
	JMenuItem fontProgram = new JMenuItem("Run Example1");

	// ------------------ TEXT AREA ----------------------- create a textArea
	// Field
	JTextArea textArea = new JTextArea(10, 15);

	// ------------------ LABELS ----------------------- create labels
	// create labels for the frame
	JLabel label1 = new JLabel("    Becky's Graphics Program    ");
	JLabel label2 = new JLabel();
	JLabel infoLabel1 = new JLabel();
	JLabel infoLabel2 = new JLabel();
	JLabel infoLabel3 = new JLabel();
	JLabel blank = new JLabel();

	// ------------------ TEXT FIELD ----------------------- create a text field
	// for the frame
	JTextField nameField = new JTextField(24);
	// create a button for the frame

	// ------------------ BUTTON ----------------------- create a button
	JButton button = new JButton("OK");

	// ******** Completed (NEW INSTANCES OF JMenuBar, JMenu, JLabel, JTextField,
	// JButton)

	public static void main(String[] args) {
		JFrameDemo frame = new JFrameDemo();

		// SETS BACKGROUND COLOR, SIZE, VISIBILITY OF THE FRAME
		frame.getContentPane().setBackground(Color.BLUE);

		// SETS SIZE OF FRAME
		frame.setSize(850, 700);
		frame.setVisible(true);

	}

	public JFrameDemo() {// START jfRAMEdEMO
							// setTitle is the title of the frame
		setTitle("Becky's Graphics Sample for Intro to Java");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// ******** Now, we will "Lay Out" the frame
		setLayout(new FlowLayout());

		// ------------------ MENU BAR (name: menu1, menu2)
		// ----------------------------------------
		// set the menu bar properties and add them to the frame
		setJMenuBar(mainBar);
		mainBar.setBackground(Color.GREEN);
		// ADD TO FRAME
		mainBar.add(menu1);// file <exit>
		mainBar.add(menu2);// programs <grossPay & if/else demo>

		// set the sub menu (FILE) properties
		menu1.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
		// set the sub sub menu (EXIT) properties
		exit.setBackground(Color.RED);
		exit.setForeground(Color.WHITE);
		exit.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
		// add MENUBAR/EXIT to the frame
		menu1.add(exit);

		// set the sub menu (PROGRAM) properties and add to frame
		menu2.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
		// set the sub sub menu (Get Gross & If/else Demo) properties
		grossPayProgram.setBackground(Color.GREEN);
		grossPayProgram.setForeground(Color.WHITE);
		grossPayProgram.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
		ifElseProgram.setBackground(Color.GREEN);
		ifElseProgram.setForeground(Color.WHITE);
		ifElseProgram.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
		fontProgram.setBackground(Color.GREEN);
		fontProgram.setForeground(Color.WHITE);
		fontProgram.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
		menu2.add(grossPayProgram);
		menu2.add(ifElseProgram);
		menu2.add(fontProgram);

		// ------------------ LABEL 1 - Becky's Graphics Program (name: label1)
		// ----------------------------------------
		// set label1 properties (displays the Title of the frame) and add to
		// frame
		label1.setFont(new Font("trebuchet ms", Font.BOLD, 36));
		label1.setForeground(Color.WHITE);
		add(label1);

		// ------------------ BLANK (name: blank)
		// ----------------------------------------
		// add a line and add to frame
		blank.setText("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		blank.setForeground(Color.WHITE);
		add(blank);

		// ------------------ INFO LABEL 1 (name: infoLabel1)
		// ----------------------------------------
		// set properties for infoLabel1 and add to frame
		// infoLabel writes a bit about the program
		infoLabel1.setFont(new Font("times new roman", Font.ITALIC, 18));
		infoLabel1.setForeground(Color.WHITE);
		infoLabel1
				.setText("    This is a program which is designed to show some of the components of Java's Graphics package.");
		infoLabel1.setSize(800, 200);
		add(infoLabel1);

		// ------------------ INFO LABEL 2 (name: infoLabel2)
		// ----------------------------------------
		// set properties for infoLabel2 and add to frame
		// infoLabel2 writes MORE about the program
		infoLabel2.setFont(new Font("times new roman", Font.ITALIC, 18));
		infoLabel2.setForeground(Color.WHITE);
		infoLabel2
				.setText("    Although this is a very (very!) crude program, it does contain the code for the major JFrame components.");
		add(infoLabel2);

		// ------------------ TEXT BOX LABLE INFO LABEL 3 (name: infoLabel3)
		// ----------------------------------------
		// set properties for textbox label (ENTER NAME) and add to frame
		infoLabel3.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		infoLabel3.setForeground(Color.WHITE);
		infoLabel3.setText("Enter Name (then click OK button):");
		add(infoLabel3);

		// ------------------ TEXT FIELD (name: nameField)
		// ----------------------------------------
		// set text box properties and add to frame
		nameField.setBackground(Color.WHITE);
		nameField.setForeground(Color.BLUE);
		nameField.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
		nameField.setAlignmentX(LEFT_ALIGNMENT);// sets text alignment
		nameField.setLocation(20, 20);// doesn't work
		add(nameField);

		// ------------------ BUTTON (name: button)
		// ----------------------------------------
		// button
		add(button);

		// ------------------ TEXT FIELD AREA (name: textArea)
		// ----------------------------------------
		// text field area
		textArea.setBackground(Color.GREEN);
		textArea.setFont(new Font("trebuchet ms", Font.ITALIC, 18));
		textArea.setForeground(Color.BLUE);
		String a = "This area represents a Text Area.\n";
		String b = "The JTextArea example allows the user to enter text on more than one line.\n";
		String c = "Create the Text Area like this:  JTextArea textArea = new JTextArea(25,25)";
		textArea.setText(a + b + c);
		add(textArea);

		// ------------------ LABEL (name: label2) DISPLAYS
		// "----, choose a program from the top menu" ---------------------
		// set properties for label2 and add to frame
		// label2 is where the information is printed when a Menu Bar selection
		// is made
		label2.setFont(new Font("trebuchet ms", Font.ITALIC, 22));
		label2.setSize(800, 200);
		label2.setOpaque(true);
		label2.setVisible(true);
		label2.setBackground(Color.cyan);
		add(label2);

		// ------------------ "listen" FOR ACTIONS ON THESE COMPONENTS
		// ----------------------------------------
		// SET THESE MENU ITEMS SO THE ACTION LISTENER "listens" for them
		exit.addActionListener(this);
		grossPayProgram.addActionListener(this);
		ifElseProgram.addActionListener(this);
		fontProgram.addActionListener(this);
		button.addActionListener(this);

	}// END jfRAMEdEMO

	public void actionPerformed(ActionEvent e) {

		// Use if/else statements to test for which element invoked the Action
		// Listener
		Object source = e.getSource();
		String text = "  ";

		// TEST FOR EXIT CHOICE
		if (source == exit)
			System.exit(0);

		// TEST FOR Run GetGrossPay
		else if (source == grossPayProgram) {
			text = "Running the Get Gross Pay Program.";
			label2.setText(text);
			repaint();
			GetGross gross = new GetGross();
			gross.main();
			text = "Get Gross Pay Program is complete. Solution displays in console.";
			label2.setText(text);
			repaint();
		}

		// TEST FOR Run IfElseProgram
		else if (source == ifElseProgram) {
			text = "Running the If Else Demo Program.";
			label2.setText(text);
			repaint();
			IfElseDemo ifElse = new IfElseDemo();
			ifElse.main();
			text = "If Else Demo Program is complete. Solution displays in console.";
			label2.setText(text);
			repaint();
		}

		// TEST FOR Run FontProgram
//		else if (source == fontProgram) {
//			text = "Running the Font Frame Program.";
//			label2.setText(text);
//			repaint();
//			JFontFrame fontProgram = new JFontFrame();
//			fontProgram.main();
//			text = "If Font Frame Program is complete.";
//			label2.setText(text);
//			repaint();
//		}

		// check for button click
		if (e.getSource() == button) {
			text = nameField.getText()
					+ ", choose a program from the top menu.";
			label2.setText(text);
			repaint();

			// add message box
			text = textArea.getText();
			JOptionPane.showMessageDialog(null, text, "HEADER",
					JOptionPane.QUESTION_MESSAGE);

		}
	}// end JFrameDemo

}// end class
