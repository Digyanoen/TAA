package fr.istic.taa.Server.controller;

import fr.istic.taa.Server.Request.LoginRequest;
import fr.istic.taa.Server.Request.LoginResponse;
import fr.istic.taa.Server.Request.UserRequest;
import fr.istic.taa.Server.meteo.JSonHandler;
import fr.istic.taa.Server.model.User;
import fr.istic.taa.Server.repository.CityDAO;
import fr.istic.taa.Server.repository.UserDao;
import fr.istic.taa.Server.repository.WeatherConditionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 *  Rest Controller for CRUD action on anuser
 */

@Controller
@RequestMapping("/api/user")
public class UserController {

  /** user's DAO */
  @Autowired
  private UserDao userDao;

  @Autowired
  private JSonHandler jSonHandler;

  @Autowired
  private CityDAO cityDAO;

  @Autowired
  private WeatherConditionDAO weatherConditionDAO;


  /**
   * GET /create  --> Create a new user and save it in the database.
   */
  @RequestMapping(method= RequestMethod.POST, value = "/create", consumes = "application/json")
  @ResponseBody
  public String create(@RequestBody UserRequest userRequest) {
    String userId;
    User user = new User();
    user.setEmail(userRequest.getMail());
    user.setLogin(userRequest.getLogin());
    user.setPassword(userRequest.getPassword());
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


  @RequestMapping("/login")
  public LoginResponse login(LoginRequest loginRequest){
    String log = loginRequest.getLogin();
    String mdp = loginRequest.getPassword();
    User user = userDao.findByLoginAndPassword(log, mdp);
    if(user == null) return null;

    LoginResponse response = new LoginResponse();
    response.setId(user.getId());
    response.setLogin(user.getLogin());
    return response;


  }


}