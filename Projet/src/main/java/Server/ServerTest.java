package Server;

import Server.Model.Activity;
import Server.Model.User;
import Server.Repository.ActivityDAO;
import Server.Repository.DAOFactory;
import Server.Repository.UserDAO;
import Server.jpa.EntityManagerHelper;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class ServerTest {

    public static void main(String args[]){
        EntityManager manager = EntityManagerHelper.getEntityManager();



      //  EntityManagerHelper.beginTransaction();
        try {
/*
            Query q1 = manager.createNativeQuery("DELETE FROM USER_ACTIVITY");
            Query q2 = manager.createNativeQuery("DELETE FROM WEATHERCONDITION");
            Query q3 = manager.createNativeQuery("DELETE FROM ACTIVITY");
            Query q4 = manager.createNativeQuery("DELETE FROM USER");

            q1.executeUpdate();
            q2.executeUpdate();
            q3.executeUpdate();
            q4.executeUpdate();
*/
            Activity bowling = new Activity();
            bowling.setName("bowling");
            bowling.setLevel("hardcore");
            Activity sport = new Activity();
            sport.setName("volley");
            sport.setLevel("nul");


            List<Activity> slist= new ArrayList<Activity>();
            slist.add(bowling);
            slist.add(sport);

            User jean = new User();
            User paul = new User();
            User jacques = new User();

            jean.setLogin("jeannotlebo");
            jean.setActivities(slist);
            paul.setLogin("poildecarrot");
            paul.setActivities(slist);
            jacques.setLogin("jacadiadit");
            jacques.setActivities(slist);

            List<User> list= new ArrayList<User>();
            list.add(jean);
            list.add(jacques);
            list.add(paul);

            bowling.setUsers(list);
            sport.setUsers(list);


            DAOFactory.getActivityDAO().create(bowling);
            DAOFactory.getActivityDAO().create(sport);
            DAOFactory.getUserDAO().create(jean);
            DAOFactory.getUserDAO().create(paul);
            DAOFactory.getUserDAO().create(jacques);


        } catch (Exception e) {
            e.printStackTrace();
        }

        EntityManagerHelper.closeEntityManagerFactory();
        /*EntityManagerHelper.commit();

        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory(); */

    }
}
