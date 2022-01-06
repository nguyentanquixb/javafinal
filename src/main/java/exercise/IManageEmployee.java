package exercise;

import java.util.List;

public interface IManageEmployee {
    int calculateSalary(Employee employee);

    void viewSalary(Employee employee);

    void viewSalary(List<Employee> employees);

    void viewMaxSalary(List<Employee> employees);

    void readFile(String path);
}
