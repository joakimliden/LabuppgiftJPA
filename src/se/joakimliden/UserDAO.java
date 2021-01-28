package se.joakimliden;

import java.util.List;

public interface UserDAO {

    void create(User u);
    // creates new user

    List<User> findByFirstName(String firstName);
    // returns all users with correct firstname

    List<User> findByUserName(String userName);
    // returns user with correct username

    boolean updateUser (String id, String userName, String firstName, String lastName);
    // updates users username, firstname, or lastname (returns success/failure)

    boolean removeUser(String id);
    //removes the product (return success/failure)
}
