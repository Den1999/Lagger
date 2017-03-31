package by.vsu.Lagger.controller;

import by.vsu.Lagger.entity.Address;
import by.vsu.Lagger.services.AddressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Zver.
 */
@Controller
@RequestMapping("/address")
public class AddressController {

    private static final Logger logger = LoggerFactory.getLogger(AddressController.class);
    @Autowired
    private AddressService addressService;


    /**
     * get address by id
     *
     * @param id is id
     * @return address
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    Address getAddress(@PathVariable("id") Long id) {
        return addressService.get(id);
    }


    /**
     * add address
     *
     * @param address is address
     * @return address
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public
    @ResponseBody
    Address createAddress(@RequestBody Address address) {
        logger.info("Start create address.");
        addressService.add(address);
        return address;
    }


    /**
     * delete address by id
     *
     * @param id is id
     * @return address
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public
    @ResponseBody
    Address deleteAddress(@PathVariable("id") Long id) {
        logger.info("Start delete address.");
        Address address = addressService.get(id);
        addressService.delete(id);
        return address;
    }


    /**
     * update address by id
     *
     * @param id is id
     * @return address
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public
    @ResponseBody
    Address editAddress(@PathVariable("id") Long id, @RequestBody Address address) {
        logger.info("Start update address.");
        addressService.edit(address, id);
        return address;
    }
}
