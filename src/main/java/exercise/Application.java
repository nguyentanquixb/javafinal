package exercise;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
	Employee employee1 = new Employee("Nguyen Van A", RoleEnum.DIRECTOR, 22, 1);
	Employee employee2 = new Employee("Nguyen Van B", RoleEnum.ENGINEER, 18, 10);
	Employee employee3 = new Employee("Nguyen Van C", RoleEnum.ACCOUNTANT, 5, 0);
	Employee employee4 = new Employee("Nguyen Van D", RoleEnum.SANITATION_WORKER, 22, 0);
	Employee employee5 = new Employee("Nguyen Van E", RoleEnum.RECEPTIONIST, 5, 11);

	ManageEmployee manageEmployee = new ManageEmployee(employee1);

	List<Employee> employees = new ArrayList<Employee>();
	employees.add(employee1);
	employees.add(employee2);
	employees.add(employee3);
	employees.add(employee4);
	employees.add(employee5);

	manageEmployee.viewSalary(employees);
	manageEmployee.viewMaxSalary(employees);
	manageEmployee.readFile("src/main/java/exercise/employee.txt");

//	new Thread(new Runnable() {
//
//	    public void run() {
//		EmployeeDAO emp = new EmployeeDAO();
//		RoleDAO role = new RoleDAO();
//
//		Role role1 = new Role(RoleEnum.DIRECTOR, RoleEnum.DIRECTOR.salary);
//		Role role2 = new Role(RoleEnum.ACCOUNTANT, RoleEnum.ACCOUNTANT.salary);
//		Role role3 = new Role(RoleEnum.ENGINEER, RoleEnum.ENGINEER.salary);
//		Role role4 = new Role(RoleEnum.SANITATION_WORKER, RoleEnum.SANITATION_WORKER.salary);
//		Role role5 = new Role(RoleEnum.RECEPTIONIST, RoleEnum.RECEPTIONIST.salary);
//
//		role.insert(role1);
//		role.insert(role2);
//		role.insert(role3);
//		role.insert(role4);
//		role.insert(role5);
//
//		Employee employee6 = new Employee("nguyenvanA", role1, 22, 1, 33300000);
//		Employee employee7 = new Employee("nguyenvanB", role2, 5, 0, 2500000);
//		Employee employee8 = new Employee("nguyenvanC", role3, 18, 10, 17400000);
//		Employee employee9 = new Employee("nguyenvanD", role4, 22, 0, 6600000);
//		Employee employee10 = new Employee("nguyenvanE", role5, 5, 11, 5050000);
//
//		emp.insert(employee6);
//		emp.insert(employee7);
//		emp.insert(employee8);
//		emp.insert(employee9);
//		emp.insert(employee10);
//	    }
//	}).start();
    }
}
