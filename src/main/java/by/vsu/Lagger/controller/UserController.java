package by.vsu.Lagger.controller;

import by.vsu.Lagger.entity.User;
import by.vsu.Lagger.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Zver.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;


    /**
     * get user by id
     *
     * @param id is id
     * @return user
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    User getUser(@PathVariable("id") Long id) {
        return userService.get(id);
    }


    /**
     * add user
     *
     * @param user is user
     * @return user
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public
    @ResponseBody
    User createUser(@RequestBody User user) {
        logger.info("Start createEmployee.");
        userService.add(user);
        return user;
    }


    /**
     * delete user by id
     *
     * @param id is id
     * @return user
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public
    @ResponseBody
    User deleteUser(@PathVariable("id") Long id) {
        logger.info("Start deleteEmployee.");
        User user = userService.get(id);
        userService.delete(id);
        return user;
    }


    /**
     * update user by id
     *
     * @param id is id
     * @return user
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public
    @ResponseBody
    User editUser(@PathVariable("id") Long id, @RequestBody User user) {
        logger.info("Start deleteEmployee.");
        userService.edit(user, id);
        return user;
    }
}
