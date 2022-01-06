package exercise;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "role",catalog = "finalexercise")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    RoleEnum name;

    @Column(name = "salary")
    int salary;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "roles")
    private Set<Employee> listEmployees = new HashSet<Employee>();
    
    public Role(RoleEnum name, int salary) {
	this.name = name;
	this.salary = salary;
    }

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public int getSalary() {
	return salary;
    }

    public void setSalary(int salary) {
	this.salary = salary;
    }

    public Set<Employee> getListEmployees() {
        return listEmployees;
    }

    public void setListEmployees(Set<Employee> listEmployees) {
        this.listEmployees = listEmployees;
    }

    public RoleEnum getName() {
	return name;
    }

    public void setName(RoleEnum name) {
	this.name = name;
    }

}
