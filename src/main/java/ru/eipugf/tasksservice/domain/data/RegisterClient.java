package ru.eipugf.tasksservice.domain.data;

public class RegisterClient extends BaseTask {
    private String firstName;
    private String lastName;
    private Integer gender;

    public RegisterClient() {
    }

    public RegisterClient(String firstName, String lastName, Integer gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "RegisterClient{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                '}';
    }
}


