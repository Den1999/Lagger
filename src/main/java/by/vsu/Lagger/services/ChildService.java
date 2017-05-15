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

    public String add(Child child) {
        Short count=0;
        for(Child c: childDao.findAll()){
            if(!StringUtils.isEmpty(c.getSquad())) {
                if (c.getSquad().getId().equals(child.getSquad().getId())) {
                    count++;
                }
            }
        }
        if(Objects.equals(count, squadDao.findOne(child.getSquad().getId()).getMaxChildren())){
            return "Squad is even full!";
        }
        else {
            childDao.save(child);
            return child.toString();
        }
    }

    public String getAll() {
        return childDao.findAll().toString();
    }

    public void delete(Long id) {
        Child child = new Child(id);
        childDao.delete(child);
    }

    public String edit(Child child, Long id) {
        Child existingChild = childDao.findOne(id);
        existingChild.setSname(child.getSname());
        existingChild.setFname(child.getFname());
        existingChild.setPatron(child.getPatron());
        existingChild.setDob(child.getDob());
        existingChild.setGender(child.isGender());
        existingChild.setMphone(child.getMphone());
        existingChild.setAddress(child.getAddress());
        existingChild.setParent(child.getParent());
        Short count=0;
        for(Child c: childDao.findAll()){
            if(!StringUtils.isEmpty(c.getSquad())) {
                if (c.getSquad().getId().equals(child.getSquad().getId())) {
                    count++;
                }
            }
        }
        if(Objects.equals(count, squadDao.findOne(child.getSquad().getId()).getMaxChildren())){
            return "Squad is even full!";
        }
        else {
            existingChild.setSquad(child.getSquad());
            childDao.save(existingChild);
            return existingChild.toString();
        }
    }

    public void deleteParent(Long id){
        Child existingChild = childDao.findOne(id);
        existingChild.setParent(null);
        childDao.save(existingChild);
    }
}
