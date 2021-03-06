package by.vsu.Lagger.controller;

import by.vsu.Lagger.entity.Company;
import by.vsu.Lagger.services.CompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Zver.
 */
@RestController
@RequestMapping("/company")
public class CompanyController {

    private static final Logger logger = LoggerFactory.getLogger(CompanyController.class);
    @Autowired
    private CompanyService companyService;


    /**
     * get company by id
     *
     * @param id is id
     * @return company
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    Company getCompany(@PathVariable("id") Long id) {
        return companyService.get(id);
    }


    /**
     * get all companies
     *
     * @return all companies
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public
    @ResponseBody
    String getAllCompanies() {
        return companyService.getAll();
    }


    /**
     * add company
     *
     * @param company is company
     * @return company
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public
    @ResponseBody
    Company createCompany(@RequestBody Company company) {
        logger.info("Start create Company.");
        companyService.add(company);
        return company;
    }


    /**
     * delete company by id
     * @param id is id
     * @return company
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public
    @ResponseBody
    String deleteCompany(@PathVariable("id") Long id) {
        logger.info("Start delete Company.");
       return companyService.delete(id);
    }


    /**
     * update company by id
     *
     * @param id is id
     * @return company
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public
    @ResponseBody
    Company editCompany(@PathVariable("id") Long id, @RequestBody Company company) {
        logger.info("Start update Company.");
        companyService.edit(company,id);
        return company;
    }
}
