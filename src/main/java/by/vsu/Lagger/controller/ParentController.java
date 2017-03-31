package by.vsu.Lagger.controller;

import by.vsu.Lagger.entity.Company;
import by.vsu.Lagger.entity.Parent;
import by.vsu.Lagger.services.ParentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Zver.
 */
@Controller
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
    Parent getParent(@PathVariable("id") Long id) {
        return parentService.get(id);
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
    Parent createParent(@RequestBody Parent parent) {
        logger.info("Start create parent.");
        parentService.add(parent);
        return parent;
    }


    /**
     * delete parent by id
     * @param id is id
     * @return parent
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public
    @ResponseBody
    Parent deleteParent(@PathVariable("id") Long id) {
        logger.info("Start delete parent.");
        Parent parent = parentService.get(id);
        parentService.delete(id);
        return parent;
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
    Parent editParent(@PathVariable("id") Long id, @RequestBody Parent parent) {
        logger.info("Start update parent.");
        parentService.edit(parent,id);
        return parent;
    }

    /**
     * add company to parent
     * @param id is id
     * @param parent is parent
     * @return parent
     */
    @RequestMapping(value = "/addcompany/{id}", method = RequestMethod.POST)
    public
    @ResponseBody
    Parent addCompany(@PathVariable("id") Long id, @RequestBody Parent parent) {
        logger.info("Start add company to parent.");
        parentService.addCompany(id,parent);
        return parentService.get(id);
    }
}
