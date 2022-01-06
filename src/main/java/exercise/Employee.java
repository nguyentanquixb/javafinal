package exercise;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "employee", catalog = "finalexercise")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "workingDay")
    private int workingDay;

    @Column(name = "workOverTime")
    private int workOverTime;

    @Column(name = "salary")
    private int salary;
    
    @Transient
    private RoleEnum role;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role roles;

    public Employee() {
    }

    public Employee(String name, RoleEnum role, int workingDay, int workOverTime) {
	this.name = name;
	this.role = role;
	this.workingDay = workingDay;
	this.workOverTime = workOverTime;
    }

    public Employee(String name, Role roles, int workingDay, int workOverTime, int salary) {
	this.name = name;
	this.roles = roles;
	this.workingDay = workingDay;
	this.workOverTime = workOverTime;
	this.salary = salary;
    }

   
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getWorkingDay() {
        return workingDay;
    }

    public void setWorkingDay(int workingDay) {
        this.workingDay = workingDay;
    }

    public int getWorkOverTime() {
        return workOverTime;
    }

    public void setWorkOverTime(int workOverTime) {
        this.workOverTime = workOverTime;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public RoleEnum getRole() {
        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }

    public Role getRoles() {
        return roles;
    }

    public void setRoles(Role roles) {
        this.roles = roles;
    }

    public String toString() {
	return "Employee[ name:" + name + ", role: " + role + ",workingDay: " + workingDay + ", workOverTime: "
		+ workOverTime + ", salary: " + salary + "]";

    }

}
