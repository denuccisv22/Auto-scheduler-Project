package scheduler;

import java.util.LinkedList;

public class Scheduler {

	private Month curMonth = null;
	private int yearName = 0;
	private Year year = new Year(0, 's');

	public Scheduler() {

	}

	// creates a new scheduler object, sets the current month to January
	public Scheduler(int yearName, char startDay) {

		this.yearName = yearName;
		this.year = new Year(this.yearName, startDay);
		this.curMonth = this.year.getMonths()[0];

	}

	//schedule a day
	public void daySchedule(Day d) {
		String[] reqShifts = d.getRequiredShifts();
		int curShiftLoc = 0;
		boolean dayAssigned = false;

		// for all the required shifts on any given day
		for (int i = 0; i < reqShifts.length; i++) {

			if (reqShifts[i] != null) {

				//set the shift to unassigned
				boolean shiftAssigned = false;
				// find where the req shift is in the main shifts array
				for (int j = 0; j < Main.shifts.length; j++) {

					if (Main.shifts[j] != null) {

						if (Main.shifts[j].getName().equals(reqShifts[i])) {

							curShiftLoc = j;

						}

					} 
					else {
						break;
					}

				}

				// check to see if the employee works that day, if they do, assign them that day
				// and increment their hours worked by
				// the shift length

				// for all of the employees in the list located at the current shift location
				for (int j = 0; j < Main.orgShifts.get(curShiftLoc).size(); j++) {
					
					// get the current employees work days
					Employee tempEmp = Main.orgShifts.get(curShiftLoc).get(j);
					Day[] tempEmpWD = Main.orgShifts.get(curShiftLoc).get(j).getWorkDays();

					// check to see if the employee works on the given day and isn't over their
					// hours
					for (int k = 0; k < tempEmpWD.length; k++) {

						if (tempEmpWD[k] != null) {
							
							//check to see if the employee works on the given day, if their hours worked are less than their max hours, if adding this shift
							//would put the employee over their max hours, and if the given shift has already been assigned
							if (tempEmpWD[k].getName() == d.getName() && tempEmp.getHoursWorked() < tempEmp.getMaxHours() && tempEmp.getHoursWorked()
								+ Main.shifts[curShiftLoc].getHours() <= tempEmp.getMaxHours() && shiftAssigned == false) {

								//if the day is Sunday or Saturday
								if(d.getName() == 's' || d.getName() == 'S') {
									
									//is the given employee assigned to work weekends?
									if(!tempEmp.getWorksWeekends()) {
										break;
									}
									
								}
								
								// add the day to the temporary employees days working
								LinkedList<Integer> tempDaysWorking = tempEmp.getDaysWorking();
								tempDaysWorking.add(d.getDate());
								tempEmp.setDaysWorking(tempDaysWorking);

								// add the hours to the temporary employees hours worked
								tempEmp.setHoursWorked(tempEmp.getHoursWorked() + Main.shifts[curShiftLoc].getHours());
								shiftAssigned = true;

								// update the employee in the main employee array
								for (int l = 0; l < Main.employees.length; l++) {

									if (Main.employees[l] != null) {

										if (Main.employees[l].getEmployeeNum() == tempEmp.getEmployeeNum()) {

											Main.employees[l] = tempEmp;
											//System.out.println(tempEmp.getName() + " was assigned " + Main.shifts[curShiftLoc].getName() + " on " + d.getName() + " the " + d.getDate());

										}
									}
									else {
										break;
									}

								}

							}
						}
						
						else {
							break;
						}

					}

				}

			} else {
				break;
			}
		}
	}

	//schedule a month
	public void monthSchedule(Month m) {
		
		Week[] mWeeks = m.getWeeks();
		for(int i = 0; i < mWeeks.length; i++) {
			
			if(m.getWeeks()[i] != null) {
				System.out.println("Week " + (i + 1));
				mWeeks[i].generateWeekSchedule();
			}
			else {
				return;
			}
			
		}
		
	}
}
