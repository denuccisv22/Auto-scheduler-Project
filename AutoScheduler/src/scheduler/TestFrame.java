package scheduler;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class TestFrame {

	private JFrame frame;
	private JTextField textField;
	private JLabel lblJlabel;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextArea textArea = new JTextArea();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestFrame window = new TestFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TestFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1200, 702);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnSchedule = new JButton("Schedule");
		btnSchedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//JOptionPane message display
				//JOptionPane.showMessageDialog(null, "Button Test");
				lblJlabel.setText("Button Test");
			}
		});
		btnSchedule.setForeground(Color.BLACK);
		btnSchedule.setBackground(Color.WHITE);
		btnSchedule.setBounds(335, 11, 89, 23);
		frame.getContentPane().add(btnSchedule);
		
		textField = new JTextField();
		textField.setBounds(20, 12, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		lblJlabel = new JLabel("JLabel");
		lblJlabel.setBounds(116, 15, 127, 14);
		frame.getContentPane().add(lblJlabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(20, 116, 109, 38);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(139, 116, 109, 38);
		frame.getContentPane().add(textField_2);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			/*
			 * Demo for buttons and text fields addition
			 */
			public void actionPerformed(ActionEvent e) {
				int num1 = 0;
				int num2 = 0;
				int answer = 0;
				try {
					
					num1 = Integer.parseInt(textField_1.getText());
					num2 = Integer.parseInt(textField_2.getText());
					answer = num1 + num2;
					
					textArea.setText(Integer.toString(answer));
					
					
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "Enter valid numbers");
				}
			}
		});
		btnNewButton.setBounds(272, 116, 89, 38);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnSubtract = new JButton("Subtract");
		btnSubtract.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num1 = 0;
				int num2 = 0;
				int answer = 0;
				try {
					
					num1 = Integer.parseInt(textField_1.getText());
					num2 = Integer.parseInt(textField_2.getText());
					answer = num1 - num2;
					
					textArea.setText(Integer.toString(answer));
					
					
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "Enter valid numbers");
				}
			}
		});
		btnSubtract.setBounds(369, 116, 89, 38);
		frame.getContentPane().add(btnSubtract);
		
		textArea = new JTextArea();
		textArea.setBackground(Color.WHITE);
		textArea.setBounds(20, 179, 223, 23);
		frame.getContentPane().add(textArea);
		
		JLabel lblAnswer = new JLabel("Answer");
		lblAnswer.setBounds(283, 179, 46, 28);
		frame.getContentPane().add(lblAnswer);
	}
}
