package fr.istic.taa.Server.Controller;

import fr.istic.taa.Server.Model.Activity;
import fr.istic.taa.Server.Model.User;
import fr.istic.taa.Server.Repository.ActivityDAO;
import fr.istic.taa.Server.Repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * see inheritance doc
 * @author NFortun
 */
@Controller
@RequestMapping("/activity")
public class ActivityController{

    @Autowired
    private ActivityDAO activityDAO;

    @Autowired
    private UserDao userDao;


    @RequestMapping("/create")
    @ResponseBody
    public String create(String name, String level, int userId){

        try {
            Activity activity = new Activity();
            activity.setName(name);
            activity.setLevel(level);
            List<User> users = activity.getUsers();
            if(users == null) users = new ArrayList<User>();
            users.add(userDao.findOne(userId));
            activity.setUsers(users);
            activityDAO.save(activity);
        }
        catch (Exception ex) {
            return "Error creating the activity: " + ex.toString();
        }
        return "Activity succesfully created with id = " + userId;
    }

    @RequestMapping("/find")
    @ResponseBody
    public String find(int id){
        String userId;
        try {
            Activity activity = activityDAO.findOne(id);
            userId = String.valueOf(activity.getId());
        }
        catch (Exception ex) {
            return "Activity not found";
        }
        return "The activity id is: " + userId;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete(Activity o){
        try {
            activityDAO.delete(o);
        }
        catch (Exception ex) {
            return "Error deleting the activity:" + ex.toString();
        }
        return "Activity succesfully deleted!";
    }

    @RequestMapping("/update")
    @ResponseBody
    public String update(Activity o){
        try {
            activityDAO.save(o);
        }
        catch (Exception ex) {
            return "Error updating the activity: " + ex.toString();
        }
        return "Activity succesfully updated!";
    }

}
