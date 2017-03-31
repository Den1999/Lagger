package by.vsu.Lagger.controller;

import by.vsu.Lagger.entity.Child;
import by.vsu.Lagger.services.ChildService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Zver.
 */
@Controller
@RequestMapping("/child")
public class ChildController {

    private static final Logger logger = LoggerFactory.getLogger(ChildController.class);
    @Autowired
    private ChildService childService;


    /**
     * get child by id
     *
     * @param id is id
     * @return child
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    String getChild(@PathVariable("id") Long id) {
        return childService.get(id).toString();
    }


    /**
     * add child
     *
     * @param child is child
     * @return child
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public
    @ResponseBody
    String createChild(@RequestBody Child child) {
        logger.info("Start create child.");
        childService.add(child);
        return child.toString();
    }


    /**
     * delete child by id
     *
     * @param id is id
     * @return child
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public
    @ResponseBody
    String deleteChild(@PathVariable("id") Long id) {
        logger.info("Start delete child.");
        Child child = childService.get(id);
        childService.delete(id);
        return child.toString();
    }


    /**
     * update child by id
     *
     * @param id is id
     * @return child
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public
    @ResponseBody
    String editChild(@PathVariable("id") Long id, @RequestBody Child child) {
        logger.info("Start update child.");
        childService.edit(child, id);
        return child.toString();
    }


    /**
     * add squad to child
     *
     * @param id    is id
     * @param child is child
     * @return child
     */
    @RequestMapping(value = "/addsquad/{id}", method = RequestMethod.POST)
    public
    @ResponseBody
    String addCompany(@PathVariable("id") Long id, @RequestBody Child child) {
        logger.info("Start add squad to child.");
        childService.addSquad(id, child);
        return childService.get(id).toString();
    }


    /**
     * add address to child
     *
     * @param id    is id
     * @param child is child
     * @return child
     */
    @RequestMapping(value = "/addaddress/{id}", method = RequestMethod.POST)
    public
    @ResponseBody
    String addAddress(@PathVariable("id") Long id, @RequestBody Child child) {
        logger.info("Start add address to child.");
        childService.addAddress(id, child);
        return childService.get(id).toString();
    }
}
