package exercise;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ManageEmployee implements IManageEmployee {

    private Employee employee;

    public ManageEmployee(Employee employee) {
	this.employee = employee;
    }

    public int calculateSalary(Employee employee) {
	int salary = (employee.getRole().salary * employee.getWorkingDay()) + (employee.getWorkOverTime() * 300000);
	return salary;
    }

    public void viewSalary(Employee employee) {
	boolean hasPermission = checkPermission(this.employee.getRole());
	if (hasPermission) {
	    employee.setSalary(calculateSalary(employee));
	    ;
	    System.out.println("View salary: " + employee.toString());
	} else {
	    System.out.println("access denied. The employee does not have permission to access view salary ");
	}
    }

    public void viewSalary(List<Employee> employees) {
	boolean hasPermission = checkPermission(this.employee.getRole());
	if (hasPermission) {
	    for (Employee employee : employees) {
		employee.setSalary(calculateSalary(employee));
		System.out.println("view salary: " + employee.toString());
	    }

	} else {
	    System.out.println("access denied. The employee does not have permission to access view salary ");
	}

    }

    public void viewMaxSalary(List<Employee> employees) {
	if (this.employee.getRole().equals(RoleEnum.DIRECTOR)) {
	    for (Employee employee : employees) {
		employee.setSalary(calculateSalary(employee));
	    }
	    Collections.sort(employees, new Comparator<Employee>() {

		public int compare(Employee employee1, Employee employee2) {
		    return employee1.getSalary() < employee2.getSalary() ? 1 : -1;
		}

	    });
	    employees.removeIf(new Predicate<Employee>() {

		public boolean test(Employee employee) {
		    return employee.getRole().equals(RoleEnum.DIRECTOR);
		}

	    });
	    if (employees.size() > 0) {
		System.out.println("View Max salary: " + employees.get(0).toString());
	    }
	} else {
	    System.out.println("access denied. The employee does not have permission to access view max salary ");
	}

    }

    private boolean checkPermission(RoleEnum role) {
	if (role.equals(RoleEnum.DIRECTOR) || role.equals(RoleEnum.ACCOUNTANT)) {
	    return true;
	} else {
	    return false;
	}
    }

    public void readFile(String path) {

	try {
	    List<Employee> employees = new ArrayList<Employee>();
	    FileInputStream fileInputStream = new FileInputStream(path);
	    DataInputStream dataInputStream = new DataInputStream(fileInputStream);
	    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(dataInputStream));
	    String line;
	    while ((line = bufferedReader.readLine()) != null) {
		String[] lines = line.split(" ");
		Employee employee = new Employee();
		employee.setName(lines[0]);
		RoleEnum role = RoleEnum.getRole(lines[1]);
		employee.setRole(role);
		employee.setWorkingDay(Integer.valueOf(lines[2]));
		employee.setWorkOverTime(Integer.valueOf(lines[3]));
		employee.setSalary(Integer.valueOf(lines[4]));
		employees.add(employee);
	    }
	    dataInputStream.close();
	    System.out.println("---------------Read file----------------");
	    for (Employee employee : employees) {
		System.out.println("Employee: " + employee.toString());
	    }
	} catch (Exception e) {
	    System.out.println("Error read file: " + e.getMessage());
	}

    }

}
