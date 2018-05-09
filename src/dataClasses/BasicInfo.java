package dataClasses;

import java.io.Serializable;

public class BasicInfo implements Serializable {

    private String firstName;
    private String middleName;
    private String lastName;
    private String DOB;

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDOB() {
        return DOB;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public BasicInfo() {
        this.firstName = "N/A";
        this.middleName = "N/A";
        this.lastName = "N/A";
        DOB = "N/A";
    }
}
