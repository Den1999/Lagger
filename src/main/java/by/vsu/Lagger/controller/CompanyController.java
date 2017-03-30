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
@Controller
@RequestMapping("/company")
public class CompanyController {

    private static final Logger logger = LoggerFactory.getLogger(CompanyController.class);
    @Autowired
    private CompanyService companyService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    Company getCompany(@PathVariable("id") Long id) {
        return companyService.get(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public
    @ResponseBody
    Company createCompany(@RequestBody Company company) {
        logger.info("Start createEmployee.");
        companyService.add(company);
        return company;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public @ResponseBody Company deleteCompany(@PathVariable("id") Long id) {
        logger.info("Start deleteEmployee.");
        Company company = companyService.get(id);
        companyService.delete(id);
        return company;
    }
}
