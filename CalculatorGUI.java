import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*
    A class that evaluates infix expressions through a GUI.
    COMPSCI 105
	Assignment 2 - Part 1
	Name: Yin Yue	
	UPI: yyin888
*/

public class CalculatorGUI extends JFrame implements ActionListener // JFrames as a container to represent a window.
{
	/* Buttons are declared as part of the class so these can be referred to throughout the class. */
	private JButton zero_button, one_button, two_button, three_button, four_button, five_button, six_button;
	private JButton seven_button, eight_button, nine_button, add_button, subtract_button, multiply_button;
	private JButton divide_button, clear_button, quit_button, equals_button, open_button, close_button, back_button;
	

	private JLabel display = new JLabel("                                "); // The infix expression is displayed in this JLabel object
	private JPanel button_container = new JPanel();		//JPanel object to hold calculator buttons

	String currentInfix = "";
	String empty_string = "                                ";

	public CalculatorGUI()
	{
		super("Calculator"); // Set the text in the title bar of the window
		setSize(new Dimension(200, 200)); // Sets the window size
		setResizable(false);  //Window cannot be resized
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		
		//Set button labels
		zero_button = new JButton("0");
		one_button = new JButton("1");
		two_button = new JButton("2");
		three_button = new JButton("3");
		four_button = new JButton("4");
		five_button = new JButton("5");
		six_button = new JButton("6");
		seven_button = new JButton("7");
		eight_button = new JButton("8");
		nine_button = new JButton("9");
		add_button = new JButton("+");
		subtract_button = new JButton("-");
		multiply_button = new JButton("*");
		divide_button = new JButton("/");
		clear_button = new JButton("C");
		quit_button = new JButton("Q");
		equals_button = new JButton("=");
		open_button = new JButton("(");
		close_button = new JButton(")");
		back_button = new JButton("<");

		// Listener definition
		zero_button.addActionListener(this);
		one_button.addActionListener(this);
		two_button.addActionListener(this);
		three_button.addActionListener(this);
		four_button.addActionListener(this);
		five_button.addActionListener(this);
		six_button.addActionListener(this);
		seven_button.addActionListener(this);
		eight_button.addActionListener(this);
		nine_button.addActionListener(this);
		add_button.addActionListener(this);
		subtract_button.addActionListener(this);
		multiply_button.addActionListener(this);
		divide_button.addActionListener(this);
		clear_button.addActionListener(this);
		quit_button.addActionListener(this);
		equals_button.addActionListener(this);
		open_button.addActionListener(this);
		close_button.addActionListener(this);
		back_button.addActionListener(this);
		zero_button.setActionCommand("0");
		one_button.setActionCommand("1");
		two_button.setActionCommand("2");
		three_button.setActionCommand("3");
		four_button.setActionCommand("4");
		five_button.setActionCommand("5");
		six_button.setActionCommand("6");
		seven_button.setActionCommand("7");
		eight_button.setActionCommand("8");
		nine_button.setActionCommand("9");
		add_button.setActionCommand("+");
		subtract_button.setActionCommand("-");
		multiply_button.setActionCommand("*");
		divide_button.setActionCommand("/");
		clear_button.setActionCommand("C");
		quit_button.setActionCommand("Q");
		equals_button.setActionCommand("=");
		open_button.setActionCommand("(");
		close_button.setActionCommand(")");
		back_button.setActionCommand("<");
		// end listener definition

		display.setMinimumSize(new Dimension(180, 20));
		add(display, BorderLayout.NORTH);

		button_container.setLayout(new GridLayout(5, 4)); // creates a 4 by 5 grid for the buttons
		
		//Add buttons in order to the grid
		button_container.add(clear_button);
		button_container.add(back_button);
		button_container.add(quit_button);
		button_container.add(divide_button);
		button_container.add(seven_button);
		button_container.add(eight_button);
		button_container.add(nine_button);
		button_container.add(multiply_button);
		button_container.add(four_button);
		button_container.add(five_button);
		button_container.add(six_button);
		button_container.add(subtract_button);
		button_container.add(one_button);
		button_container.add(two_button);
		button_container.add(three_button);
		button_container.add(add_button);
		button_container.add(zero_button);
		button_container.add(open_button);
		button_container.add(close_button);
		button_container.add(equals_button);
		add(button_container, BorderLayout.CENTER);

		setVisible(true);
	} // end constructor

	public void actionPerformed(ActionEvent e)
	{
		String cmd = e.getActionCommand();
		if (cmd.equals("Q"))
			System.exit(0);
		else if (cmd.equals("<") && currentInfix.length() > 0)
			currentInfix = currentInfix.substring(0, currentInfix.length()-1);
		else if (cmd.equals("C"))
			currentInfix = "";
		else if (cmd.equals("="))
		{
			System.out.println(currentInfix);
			double answer = Infix.evaluateInfix(currentInfix);
			System.out.println(answer);
			if (answer == Double.NaN)
			{
				currentInfix = "";
				display.setText("ERROR");
				return;
			}
			else if (answer == Double.POSITIVE_INFINITY)
			{
				currentInfix = "";
				display.setText("DIVISION BY ZERO");
				return; 
			}
			else
			{
				currentInfix = "";
				display.setText(Integer.toString((int)answer));
				return;
			}
		}
		else
			currentInfix += cmd;

		if (currentInfix.length() > 0)
			display.setText(currentInfix);
		else
			display.setText(empty_string);
	} // end actionPerformed

	public static void main(String[] args)
	{
		CalculatorGUI gui = new CalculatorGUI();
	} // end main
}