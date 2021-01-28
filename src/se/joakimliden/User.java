package se.joakimliden;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Users2")
public class User {

    @Id
    private String id;

    private String userName;

    private String firstName;

    private String lastName;

    public String getId() {
        return id;
    }

    public void setId(String id) { this.id = id; }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String toString() {
        return id + "  " + userName + "  " + firstName + " " + lastName + "\n";
    }
}
