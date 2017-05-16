package by.vsu.Lagger.controller;

import by.vsu.Lagger.entity.Squad;
import by.vsu.Lagger.services.SquadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Zver.
 */
@RestController
@RequestMapping("/squad")
public class SquadController {

    private static final Logger logger = LoggerFactory.getLogger(SquadController.class);
    @Autowired
    private SquadService squadService;


    /**
     * get squad by id
     *
     * @param id is id
     * @return squad
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    Squad getSquad(@PathVariable("id") Long id) {
        return squadService.get(id);
    }


    /**
     * add squad
     *
     * @param squad is squad
     * @return squad
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public
    @ResponseBody
    Squad createSquad(@RequestBody Squad squad) {
        logger.info("Start create squad.");
        squadService.add(squad);
        return squad;
    }


    /**
     * get all squads
     *
     * @return all squads
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public
    @ResponseBody
    String getAllSquads() {
        return squadService.getAll();
    }


    /**
     * delete squad by id
     *
     * @param id is id
     * @return squad
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public
    @ResponseBody
    String deleteSquad(@PathVariable("id") Long id) {
        logger.info("Start delete squad.");
        return squadService.delete(id);
    }


    /**
     * update squad by id
     *
     * @param id is id
     * @return squad
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public
    @ResponseBody
    Squad editSquad(@PathVariable("id") Long id, @RequestBody Squad squad) {
        logger.info("Start update squad.");
        squadService.edit(squad, id);
        return squad;
    }
}
