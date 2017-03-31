package by.vsu.Lagger.services;

import by.vsu.Lagger.dao.CompanyDao;
import by.vsu.Lagger.dao.ChildDao;
import by.vsu.Lagger.dao.ParentDao;
import by.vsu.Lagger.entity.Company;
import by.vsu.Lagger.entity.Child;
import by.vsu.Lagger.entity.Parent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Zver.
 */
@Service("ChildService")
public class ChildService {

    @Autowired
    private ChildDao childDao;
    @Autowired
    private ParentDao parentDao;

    public Child get(Long id) {
        return childDao.findOne(id);
    }

    public void add(Child child) {
        childDao.save(child);
    }

    public void delete(Long id) {
        Child child = new Child(id);
        childDao.delete(child);
    }

    public void edit(Child child, Long id) {
        Child existingChild =  childDao.findOne(id);
        existingChild.setSname(child.getSname());
        existingChild.setFname(child.getFname());
        existingChild.setPatron(child.getPatron());
        existingChild.setDob(child.getDob());
        existingChild.setGender(child.isGender());
        existingChild.setMphone(child.getMphone());
        existingChild.setAddress(child.getAddress());
        existingChild.setSquad(child.getSquad());
        childDao.save(existingChild);
    }

    public void addSquad(Long id, Child child){
        Child existingChild =  childDao.findOne(id);
        existingChild.setSquad(child.getSquad());
        childDao.save(existingChild);
    }

    public void addAddress(Long id, Child child){
        Child existingChild =  childDao.findOne(id);
        existingChild.setAddress(child.getAddress());
        childDao.save(existingChild);
    }

    public void addParent(Long id, Child child){
        Child existingChild =  childDao.findOne(id);
        Set<Parent> parents = child.getParents();
        existingChild.setParents(parents);
        childDao.save(existingChild);
    }
}
