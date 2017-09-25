package Server;

import Server.Model.Activity;
import Server.Model.User;
import Server.Repository.DaoFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ServerTest {

    @Autowired
    public DaoFactory daoFactory;

    public ServerTest(){

    }


    public void run(String... args){


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


            daoFactory.getActivityDAO().save(bowling);
            daoFactory.getActivityDAO().save(sport);
            daoFactory.getUserDAO().save(jean);
            daoFactory.getUserDAO().save(paul);
            daoFactory.getUserDAO().save(jacques);

    }


}
