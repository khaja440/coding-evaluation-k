package com.aa.act.interview.org;

import java.util.Optional;

public abstract class Organization {

	private Position root;
	private int EmpId = 1;
	
	public Organization() {
		root = createOrganization();
	}
	
	protected abstract Position createOrganization();
	
	/**
	 * hire the given person as an employee in the position that has that title
	 * 
	 * @param person
	 * @param title
	 * @return the newly filled position or empty if no position has that title
	 */
	public Optional<Position> hire(Name person, String title) {
		
				// created an instance of employee object expecting an identifier and a string.
				Employee e=new Employee(EmpId, person);

				//setting position by passing employee object and title of the employee.
        		Position p=new Position(title, e);
                System.out.println("Newly Hired Employee is "+p.toString());
                EmpId++;
		return Optional.of(p);
	}

	@Override
	public String toString() {
		return printOrganization(root, "");
	}
	
	private String printOrganization(Position pos, String prefix) {
		StringBuffer sb = new StringBuffer(prefix + "+-" + pos.toString() + "\n");
		for(Position p : pos.getDirectReports()) {
			sb.append(printOrganization(p, prefix + "\t"));
		}
		return sb.toString();
	}
}
