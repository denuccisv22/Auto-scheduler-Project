package scheduler;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JToolBar;
import javax.swing.table.TableColumn;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class ScheduleGUI {

	private JFrame frame;
	private JTextField yearField;
	private static JComboBox startDayBox;
	private static JComboBox monthBox;
	private static Year curYear = new Year(0, 's');
	private static Scheduler sMonth = new Scheduler();
	private static String[] dayNames = new String[7];
	private static String[] monthNums = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
	private JTable table;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public void runGUI() {
		//set up the dayNames in the dayNames array
		for(int i = 0; i < Main.days.length; i++) {
			dayNames[i] = "" + Main.days[i].getName();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScheduleGUI window = new ScheduleGUI();
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
	public ScheduleGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1280, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCurrentYear = new JLabel("Current Year:");
		lblCurrentYear.setBounds(10, 11, 101, 29);
		frame.getContentPane().add(lblCurrentYear);
		
		yearField = new JTextField();
		yearField.setBounds(94, 15, 86, 20);
		frame.getContentPane().add(yearField);
		yearField.setColumns(10);
		
		JLabel lblYearStartDay = new JLabel("Year Start Day:");
		lblYearStartDay.setBounds(217, 11, 111, 29);
		frame.getContentPane().add(lblYearStartDay);
		
		startDayBox = new JComboBox(dayNames);
		startDayBox.setBounds(338, 15, 48, 20);
		frame.getContentPane().add(startDayBox);
		
		JLabel lblCurrentMonth = new JLabel("Current Month:");
		lblCurrentMonth.setBounds(396, 11, 101, 29);
		frame.getContentPane().add(lblCurrentMonth);
		
		monthBox = new JComboBox(monthNums);
		monthBox.setBounds(507, 15, 48, 20);
		frame.getContentPane().add(monthBox);
		
		JButton btnSchedule = new JButton("Schedule");
		btnSchedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//get the info from the boxs, convert them to proper types, and create the necessary variables
				int year;
				String stringDay;
				char cDay;
				
				try {
					year = Integer.parseInt(yearField.getText());
					stringDay = (String) startDayBox.getSelectedItem();
					cDay = stringDay.charAt(0);
					curYear = new Year(year, cDay);
					curYear.generateYear();
					sMonth.monthSchedule(curYear.getMonths()[monthBox.getSelectedIndex()]);
				} catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "Invalid year");
				}
				
				//try {
					//create the table
					//add columns to the model
					DefaultTableModel m = new DefaultTableModel();
					LinkedList<Object> dayColumns = new LinkedList<Object>();
					for(int i = 0; i < curYear.getMonths()[monthBox.getSelectedIndex()].getWeeks().length; i++) {
						
						for(int j = 0; j < curYear.getMonths()[monthBox.getSelectedIndex()].getWeeks()[i].getWeeksDays().length; j++) {
							if(curYear.getMonths()[monthBox.getSelectedIndex()].getWeeks()[i] != null) {
								if(curYear.getMonths()[monthBox.getSelectedIndex()].getWeeks()[i].getWeeksDays()[j] != null) {
									
									dayColumns.add(curYear.getMonths()[monthBox.getSelectedIndex()].getWeeks()[i].getWeeksDays()[j].getName() + ":" + 
								    curYear.getMonths()[monthBox.getSelectedIndex()].getWeeks()[i].getWeeksDays()[j].getDate());
									
								}
								else {
									break;
								}
							}
							
							else {
								break;
							}
							
						}
						
					}
					dayColumns.addFirst("Employee Name");
					m.setColumnIdentifiers(dayColumns.toArray());
					
					//add rows to the model
					for(int i = 0; i < Main.employees.length; i++) {
						Object[] o = new Object[curYear.getMonths()[monthBox.getSelectedIndex()].calcTotalDays() + 1];
						System.out.println("Total Days Object Calc = " + (curYear.getMonths()[monthBox.getSelectedIndex()].calcTotalDays() + 1));
						if(Main.employees[i] != null) {
								
							o = Main.employees[i].getDayToPrintArray(curYear.getMonths()[monthBox.getSelectedIndex()].calcTotalDays(), curYear.getMonths()[monthBox.getSelectedIndex()].getWeeks()[0]
								.getWeeksDays()[0].getDate(), curYear.getMonths()[monthBox.getSelectedIndex()].getTotalDays());
							Main.employees[i].clearDaysWorking();
							//o[0] = Main.employees[i].getName();
							
						}
						else {
							break;
						}
						m.addRow(o);
					}
					table.setModel(m);
				/*} catch(Exception e1) {
					
					JOptionPane.showMessageDialog(null, "Table Creation Failed");
					
				}*/
				
			}
		});
		btnSchedule.setBounds(565, 14, 89, 23);
		frame.getContentPane().add(btnSchedule);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 48, 1884, 982);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Employee Name", "Day"
			}
		));
		scrollPane.setViewportView(table);
		table.setBackground(Color.WHITE);
	}
}
