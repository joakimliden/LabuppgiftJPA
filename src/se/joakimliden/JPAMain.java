package se.joakimliden;

public class JPAMain {
    public static void main(String[] args) {

        UserDAO udao = new UserDAOWithJPAImpl();

        /**
         * Creates a new user
         */
//        User u  = new User();
//        u.setId("920730-4735");
//        u.setFirstName("Joakim");
//        u.setLastName("Lidén");
//        u.setUserName("joli");
//        udao.create(u);

        /**
         * Updates existing user using ID
         */
//        udao.updateUser("920730-4735",
//                "joli",
//                "Joakim",
//                "Axell");

        /**
         * Deletes user using userName (the hibernate SQL for remove only seems to work if you use the primary key)
         */
//        udao.removeUser("920730-4735");

        System.out.println(udao.findByUserName("joli"));

        System.out.println(udao.findByFirstName("Joakim"));


    }
}
