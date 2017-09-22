package fr.istic.taa.Server.Controller;

import fr.istic.taa.Server.Model.Activity;
import fr.istic.taa.Server.Model.User;
import fr.istic.taa.Server.Repository.ActivityDAO;
import fr.istic.taa.Server.Repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;
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
    public String create(@RequestBody  Activity activity){

        try {
            activityDAO.save(activity);
        }
        catch (Exception ex) {
            return "Error creating the activity: " + ex.toString();
        }
        return "Activity succesfully created with id = " + activity.getId();
    }

    @RequestMapping("/find/{id}")
    @ResponseBody
    public String find(@PathVariable("id") int id){
        String activityId;
        try {
            Activity activity = activityDAO.findOne(id);
            activityId = String.valueOf(activity.getId());
        }
        catch (Exception ex) {
            return "Activity not found";
        }
        return "The activity id is: " + activityId;
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String delete(@PathVariable("id") int id){
        try {
            activityDAO.delete(activityDAO.findOne(id));
        }
        catch (Exception ex) {
            return "Error deleting the activity:" + ex.toString();
        }
        return "Activity succesfully deleted!";
    }

    @RequestMapping("/update")
    @ResponseBody
    public String update(@RequestBody Activity o){
        try {
            activityDAO.save(o);
        }
        catch (Exception ex) {
            return "Error updating the activity: " + ex.toString();
        }
        return "Activity succesfully updated!";
    }

}
