package jpa;

import Server.Sport;
import Server.User;
import Server.WeatherCondition;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class JpaTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("dev");
        EntityManager manager = factory.createEntityManager();

        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        try {
            Sport bowling = new Sport();
            bowling.setName("bowling");
            bowling.setLevel("hardcore");

            User jean = new User();
            User paul = new User();
            User jacques = new User();

            jean.setLogin("jeannotlebo");
            paul.setLogin("poildecarrot");
            jacques.setLogin("jacadiadit");

            List<User> list= new ArrayList<User>();
            list.add(jean);
            list.add(jacques);
            list.add(paul);

            bowling.setUsers(list);

            manager.persist(jean);
            manager.persist(paul);
            manager.persist(jacques);

        } catch (Exception e) {
            e.printStackTrace();
        }
        tx.commit();

        manager.close();
        factory.close();
    }

}
