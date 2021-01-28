package se.joakimliden;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class UserDAOWithJPAImpl implements UserDAO{

    EntityManagerFactory emf = Persistence
            .createEntityManagerFactory("LabJPA");

    @Override
    public void create(User u) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(u);
        
        em.getTransaction().commit();
        System.out.println("User created!");
    }

    @Override
    public List<User> findByFirstName(String firstName) {
        List<User> list;
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        list = em.createQuery("FROM User u WHERE u.firstName LIKE :firstName", User.class)
                .setParameter("firstName", firstName)
                .getResultList();
        em.getTransaction().commit();
        return list;
    }

    @Override
    public List<User> findByUserName(String userName) {
        List<User> list;
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        list = em.createQuery("FROM User u WHERE u.userName LIKE :userName", User.class)
                .setParameter("userName", userName)
                .getResultList();
        em.getTransaction().commit();
        return list;
    }

    @Override
    public boolean updateUser(String id, String newUserName, String newFirstName, String newLastName) {
        boolean success = false;
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        User u = em.find(User.class, id);
        if (u != null) {
            u.setUserName(newUserName);
            u.setFirstName(newFirstName);
            u.setLastName(newLastName);
            success = true;
            System.out.println("User " + id + " has successfully been updated!");
        } else {
            System.out.println("ID: " + id + " not found.");
        }
        em.getTransaction().commit();
        return success;
    }

    @Override
    public boolean removeUser(String id) {
        boolean success = false;
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        User u = em.find(User.class, id);
        if (u != null) {
            em.remove(u);
            success = true;
            System.out.println(id + " has successfully been deleted!");
        } else {
            System.out.println(id + " not found.");
        }
        em.getTransaction().commit();
        return success;
    }
}
