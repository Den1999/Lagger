package by.vsu.Lagger.services;

import by.vsu.Lagger.dao.ChildDao;
import by.vsu.Lagger.dao.CompanyDao;
import by.vsu.Lagger.dao.AddressDao;
import by.vsu.Lagger.dao.ParentDao;
import by.vsu.Lagger.entity.Child;
import by.vsu.Lagger.entity.Company;
import by.vsu.Lagger.entity.Address;
import by.vsu.Lagger.entity.Parent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * Created by Zver.
 */
@Service("AddressService")
public class AddressService {

    @Autowired
    AddressDao addressDao;
    @Autowired
    ParentDao parentDao;
    @Autowired
    ChildDao childDao;

    public Address get(Long id) {
        return addressDao.findOne(id);
    }

    public void add(Address address) {
        addressDao.save(address);
    }

    public String delete(Long id) {
        for(Parent p : parentDao.findAll()){
            if(!StringUtils.isEmpty(p.getAddress())) {
                if(p.getAddress().getId().equals(id)){
                    p.setAddress(null);
                }
            }
        }
        for(Child c : childDao.findAll()){
            if(!StringUtils.isEmpty(c.getAddress())) {
                if(c.getAddress().getId().equals(id)){
                    c.setAddress(null);
                }
            }
        }
        addressDao.delete(new Address(id));
        return "Address was deleted successfully!";
    }

    public String getAll(){
        return addressDao.findAll().toString();
    }

    public void edit(Address address, Long id) {
        Address existingAddress =  addressDao.findOne(id);
        existingAddress.setCity(address.getCity());
        existingAddress.setStreet(address.getStreet());
        existingAddress.setHouse(address.getHouse());
        existingAddress.setPavilion(address.getPavilion());
        existingAddress.setFlat(address.getFlat());
        existingAddress.setPhone(address.getPhone());
        addressDao.save(existingAddress);
    }
}
