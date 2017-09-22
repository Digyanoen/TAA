package fr.istic.taa.Server.Controller;

import fr.istic.taa.Server.Repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import fr.istic.taa.Server.Model.User;

/**
 *  Rest Controller for CRUD action on anuser
 */

@Controller
@RequestMapping("/user")
public class UserController {

  /** user's DAO */
  @Autowired
  private UserDao userDao;


  /**
   * GET /create  --> Create a new user and save it in the database.
   */
  @RequestMapping(method= RequestMethod.POST, value = "/create", consumes = "application/json")
  @ResponseBody
  public String create(@RequestBody User user) {
    String userId;
    try {
      userDao.save(user);
      userId = String.valueOf(user.getId());
    }
    catch (Exception ex) {
      ex.printStackTrace();
      return "Error creating the user: " + ex.toString();
    }
    return "User succesfully created with id = " + userId;
  }
  
  /**
   * GET /delete  --> Delete the user having the passed id.
   */
  @RequestMapping(value="/delete/{id}")
  @ResponseBody
  public String delete(@PathVariable("id") int id) {
    try {
      User user = userDao.findOne(id);
      userDao.delete(user);
    }
    catch (Exception ex) {
      return "Error deleting the user:" + ex.toString();
    }
    return "User succesfully deleted!";
  }
  
  /**
   * GET /get-by-email  --> Return the id for the user having the passed
   * email.
   */
  @RequestMapping("/get-by-email")
  @ResponseBody
  public String getByEmail(String email) {
    String userId;
    try {
      User user = userDao.findByEmail(email);
      userId = String.valueOf(user.getId());
    }
    catch (Exception ex) {
      return "User not found";
    }
    return "The user id is: " + userId;
  }
  
  /**
   * GET /update  --> Update the email and the name for the user in the 
   * database having the passed id.
   */
  @RequestMapping("/update")
  @ResponseBody
  public String updateUser(@RequestBody User user) {
    try {
      userDao.save(user);
    }
    catch (Exception ex) {
      return "Error updating the user: " + ex.toString();
    }
    return "User succesfully updated!";
  }


}