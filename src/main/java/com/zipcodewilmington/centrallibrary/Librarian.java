package com.zipcodewilmington.centrallibrary;

// extends means the librarian has everything from "person" file

    public class Librarian extends Person {
    private String employeeId;
    private String department;
    private double salary;
    private Library library; // choosing to making Library object a private field because it models the reality we
    //re working with, a librarian who only works at one library. I know it means chaning every place we already construct
    //a librarian like MainApplicationTest, but I think it's best practice. - J-note :)
    
  // Super is calling what we did in "person" file
// super(name,age,email,phoneNumber)

// constructor
  public Librarian(String name, int age, String email, String phoneNumber,
                 String employeeId, String department, double salary, Library library) {
      super (name, age, email, phoneNumber);              
                
       this.employeeId = employeeId;
       this.department = department;
       this.salary = salary;   
       this.library = library;     
                
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

public void addItemToLibrary (LibraryItem item){
    // TODO: implement when library class is complete
    library.addItem(item);
}

public void removeItemFromLibrary (LibraryItem item) {
    // TODO: implement when library class is complete
    library.removeItem(item);
}

    }
