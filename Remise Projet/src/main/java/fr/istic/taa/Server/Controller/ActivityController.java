package fr.istic.taa.Server.Controller;

import fr.istic.taa.Server.Model.Activity;
import fr.istic.taa.Server.Repository.ActivityDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * see inheritance doc
 * @author NFortun
 */
@Controller
public class ActivityController{

    @RequestMapping("/create")
    @ResponseBody
    public String create(){
        String userId = "";
        try {
            Activity activity = new Activity();
            ActivityDAO.save(activity);
            userId = String.valueOf(activity.getId());
        }
        catch (Exception ex) {
            return "Error creating the user: " + ex.toString();
        }
        return "User succesfully created with id = " + userId;
    }

    @RequestMapping("/find")
    @ResponseBody
    public String find(int id){
        String userId = "";
        try {
            Activity activity = ActivityDAO.findOne(id);
            userId = String.valueOf(activity.getId());
        }
        catch (Exception ex) {
            return "User not found";
        }
        return "The user id is: " + userId;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete(Activity o){
        try {
            ActivityDAO.delete(o);
        }
        catch (Exception ex) {
            return "Error deleting the user:" + ex.toString();
        }
        return "User succesfully deleted!";
    }

    @RequestMapping("/update")
    @ResponseBody
    public String update(Activity o){
        try {
        }
        catch (Exception ex) {
            return "Error updating the user: " + ex.toString();
        }
        return "User succesfully updated!";
    }

    @Autowired
    private ActivityDAO ActivityDAO;
}
