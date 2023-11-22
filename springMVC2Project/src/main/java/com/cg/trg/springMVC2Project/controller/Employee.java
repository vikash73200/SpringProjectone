package com.cg.trg.springMVC2Project.controller;

import java.time.LocalDate;

public class Employee {
private  int EmpId;
private String name;
private LocalDate birthDate;
private String gender;
private String role;
public Employee() {
	super();
}
public Employee(int empId, String name, LocalDate birthDate, String gender, String role) {
	super();
	EmpId = empId;
	this.name = name;
	this.birthDate = birthDate;
	this.gender = gender;
	this.role = role;
}
public int getEmpId() {
	return EmpId;
}
public void setEmpId(int empId) {
	EmpId = empId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public LocalDate getBirthDate() {
	return birthDate;
}
public void setBirthDate(LocalDate birthDate) {
	this.birthDate = birthDate;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
@Override
public String toString() {
	return "Employee [EmpId=" + EmpId + ", name=" + name + ", birthDate=" + birthDate + ", gender=" + gender + ", role="
			+ role + "]";
}



}
