package com.zipcodewilmington.centralibrary;

// extends means the librarian has everything from "person" file

    public class Librarian extends Person {
    private String employeeId;
    private String department;
    private double salary;
    
  // Super is calling what we did in "person" file
// super(name,age,email,phoneNumber)

// constructor
  public Librarian(String name, int age, String email, String phoneNumber,
                 String employeeId, String department, double salary) {
      super (name, age, email, phoneNumber);              
                
       this.employeeId = employeeId;
       this.department = department;
       this.salary = salary;        
                
    } 
    

//getters

public String getEmployeeId() {
    return employeeId;
}

public String getDepartment () {
    return department;
}

public double getSalary () {
    return salary;
}

//Setters

public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
}

public void setDepartment(String department) {
        this.department = department;
}

public void setSalary(double salary) {
        this.salary = salary;
}

//

//Methods

public void addItemToLibrary (){
    // TODO: implement when library class is complete
}

public void removeItemFromLibrary () {
    // TODO: implement when library class is complete
}

    }
