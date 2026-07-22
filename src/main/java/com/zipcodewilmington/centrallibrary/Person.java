public abstract class Person {

    private String name;
    private int age;
    private String email;
    private String phoneNumber;
}

// constructor- lets you create a person with values
// "this." take the value that was passed in and store it in this object's name field

public Person (String name, int age, String email, String phoneNumber) {
    this.name = name;
    this.age = age;
    this.email = email;
    this.phoneNumber = phoneNumber;
}

// getters is like you can't walk into the bank and grab money
// you have to ask the teller to GET the money for you

public String getName () {
    return name;
}
public int getAge () {
    return age;
}
public String getEmail () {
    return email;
}
public String getPhoneNumber () {
    return phoneNumber;
}

//setters- lets another class change a private variable

public void setName (String name) {
    this.name = name;
}

// need else statement to catch error
public void setAge(int age) {
    if (age >= 0) {
        this.age = age;
        }
    }

    public void setEmail(String email) {
        this.email = email;
}

public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
    }