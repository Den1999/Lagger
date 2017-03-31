package by.vsu.Lagger.services;

import by.vsu.Lagger.dao.CompanyDao;
import by.vsu.Lagger.dao.AddressDao;
import by.vsu.Lagger.entity.Company;
import by.vsu.Lagger.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Zver.
 */
@Service("AddressService")
public class AddressService {

    @Autowired
    AddressDao addressDao;

    public Address get(Long id) {
        return addressDao.findOne(id);
    }

    public void add(Address address) {
        addressDao.save(address);
    }

    public void delete(Long id) {
        Address address = new Address(id);
        addressDao.delete(address);
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
