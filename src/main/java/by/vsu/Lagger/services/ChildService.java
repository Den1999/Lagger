package by.vsu.Lagger.services;

import by.vsu.Lagger.dao.ChildDao;
import by.vsu.Lagger.dao.SquadDao;
import by.vsu.Lagger.entity.Child;
import by.vsu.Lagger.entity.Parent;
import by.vsu.Lagger.entity.Squad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Objects;
import java.util.Set;

/**
 * Created by Zver.
 */
@Service("ChildService")
public class ChildService {

    @Autowired
    private ChildDao childDao;
    @Autowired
    private SquadDao squadDao;

    public Child get(Long id) {
        return childDao.findOne(id);
    }

    public void add(Child child) {
        childDao.save(child);
    }

    public String getAll() {
        return childDao.findAll().toString();
    }

    public void delete(Long id) {
        Child child = new Child(id);
        childDao.delete(child);
    }

    public void edit(Child child, Long id) {
        Child existingChild = childDao.findOne(id);
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

    public String addSquad(Long id, Child child) {
        Short count=0;
        for(Child c: childDao.findAll()){
            if(!StringUtils.isEmpty(c.getSquad())) {
                if (c.getSquad().getId().equals(child.getSquad().getId())) {
                    count++;
                }
            }
        }
        System.out.println(count+" "+squadDao.findOne(child.getSquad().getId()).getMaxChildren());
        if(Objects.equals(count, squadDao.findOne(child.getSquad().getId()).getMaxChildren())){
            return "Squad is even full!";
        }
        else {
            Child existingChild = childDao.findOne(id);
            existingChild.setSquad(child.getSquad());
            childDao.save(existingChild);
            return existingChild.toString();
        }
    }

    public void addAddress(Long id, Child child) {
        Child existingChild = childDao.findOne(id);
        existingChild.setAddress(child.getAddress());
        childDao.save(existingChild);
    }

    public void addParent(Long id, Child child) {
        Child existingChild = childDao.findOne(id);
        Parent parent = child.getParent();
        existingChild.setParent(parent);
        childDao.save(existingChild);
    }

    public void deleteParent(Long id){
        Child existingChild = childDao.findOne(id);
        existingChild.setParent(null);
        childDao.save(existingChild);
    }
}
