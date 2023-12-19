package com.practice.streams;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamsPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Employee e1= new Employee(1, "A", 100);
		Employee e2= new Employee(2, "B", 110);
		Employee e3= new Employee(3, "C", 120);
		Employee e4= new Employee(4, "D", 150);
		
		List<Employee> empList=new ArrayList<>();
		empList.add(e1);
		empList.add(e2);
		empList.add(e3);
		empList.add(e4);
		
		empList.stream().
		filter(e->e.getSalary()<=120).
		forEach(e->System.out.println(e));
		
		//List<Employee> salaries=empList.stream().map(e->increementSalary(e))
		//.collect(Collectors.toList());
		
		empList.stream().map(e->increementSalary(e))
		.forEach(e->System.out.println(e));
		
		
		
		
		//empList.stream().collect(toMap(e->e, e->e.getSalary()));

	}
	
	private static Employee increementSalary(Employee e) {
		
		e.setSalary(e.getSalary()+10);
		return e;
		
	}

}

class Employee{
	
	private int id;
	private String name;
	private int salary;
	public Employee(int id, String name, int salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + salary;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (salary != other.salary)
			return false;
		return true;
	}
	
	
	
	
}
