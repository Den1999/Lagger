package by.vsu.Lagger.controller;

import by.vsu.Lagger.entity.Parent;
import by.vsu.Lagger.services.ParentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Zver.
 */
@RestController
@RequestMapping("/parent")
public class ParentController {

    private static final Logger logger = LoggerFactory.getLogger(ParentController.class);
    @Autowired
    private ParentService parentService;


    /**
     * get parent by id
     *
     * @param id is id
     * @return parent
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    String getParent(@PathVariable("id") Long id) {
        return parentService.get(id).toString();
    }


    /**
     * get all parents
     *
     * @return all parents
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public
    @ResponseBody
    String getAllParents() {
        return parentService.getAll();
    }


    /**
     * add parent
     *
     * @param parent is parent
     * @return parent
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public
    @ResponseBody
    String createParent(@RequestBody Parent parent) {
        logger.info("Start create parent.");
        parentService.add(parent);
        return parent.toString();
    }


    /**
     * delete parent by id
     *
     * @param id is id
     * @return parent
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public
    @ResponseBody
    String deleteParent(@PathVariable("id") Long id) {
        logger.info("Start delete parent.");
        Parent parent = parentService.get(id);
        parentService.delete(id);
        return parent.toString();
    }


    /**
     * update parent by id
     *
     * @param id is id
     * @return parent
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public
    @ResponseBody
    String editParent(@PathVariable("id") Long id, @RequestBody Parent parent) {
        logger.info("Start update parent.");
        parentService.edit(parent, id);
        return parent.toString();
    }


    /**
     * add company to parent
     *
     * @param id     is id
     * @param parent is parent
     * @return parent
     */
    @RequestMapping(value = "/addcompany/{id}", method = RequestMethod.POST)
    public
    @ResponseBody
    String addCompany(@PathVariable("id") Long id, @RequestBody Parent parent) {
        logger.info("Start add company to parent.");
        parentService.addCompany(id, parent);
        return parentService.get(id).toString();
    }


    /**
     * add address to parent
     *
     * @param id     is id
     * @param parent is parent
     * @return parent
     */
    @RequestMapping(value = "/addaddress/{id}", method = RequestMethod.POST)
    public
    @ResponseBody
    String addAddress(@PathVariable("id") Long id, @RequestBody Parent parent) {
        logger.info("Start add address to parent.");
        parentService.addAddress(id, parent);
        return parentService.get(id).toString();
    }

    /**
     * add child to parent
     *
     * @param id     is id
     * @param parent is parent
     * @return child
     */
    @RequestMapping(value = "/addchild/{id}", method = RequestMethod.POST)
    public
    @ResponseBody
    String addChild(@PathVariable("id") Long id, @RequestBody Parent parent) {
        logger.info("Start add address to child.");
        parentService.addChild(id, parent);
        return parentService.get(id).toString();
    }
}
