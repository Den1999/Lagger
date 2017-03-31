package by.vsu.Lagger.services;

import by.vsu.Lagger.dao.ChildDao;
import by.vsu.Lagger.dao.ParentDao;
import by.vsu.Lagger.entity.Child;
import by.vsu.Lagger.entity.Parent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by Zver.
 */
@Service("ParentService")
public class ParentService {

    @Autowired
    private ParentDao parentDao;
    @Autowired
    private ChildDao childDao;
    @Autowired
    private ChildService childService;

    public Parent get(Long id) {
        return parentDao.findOne(id);
    }

    public void add(Parent parent) {
        parentDao.save(parent);
    }

    public void delete(Long id) {
        Parent parent = new Parent(id);
        parentDao.delete(parent);
    }

    public void edit(Parent parent, Long id) {
        Parent existingParent = parentDao.findOne(id);
        existingParent.setSname(parent.getSname());
        existingParent.setFname(parent.getFname());
        existingParent.setPatron(parent.getPatron());
        existingParent.setDob(parent.getDob());
        existingParent.setGender(parent.isGender());
        existingParent.setMphone(parent.getMphone());
        existingParent.setRelations(parent.getRelations());
        existingParent.setCompany(parent.getCompany());
        existingParent.setAddress(parent.getAddress());
        parentDao.save(existingParent);
    }

    public void addCompany(Long id, Parent parent) {
        Parent existingParent = parentDao.findOne(id);
        existingParent.setCompany(parent.getCompany());
        parentDao.save(existingParent);
    }

    public void addAddress(Long id, Parent parent) {
        Parent existingParent = parentDao.findOne(id);
        existingParent.setAddress(parent.getAddress());
        parentDao.save(existingParent);
    }

    public void addChild(Long id, Parent parent) {
        Parent existingParent = parentDao.findOne(id);
        Set<Child> children = parent.getChildren();
        existingParent.setChildren(children);
        for (Child c : children) {
            childService.addParent(c.getId(), c);
        }
        parentDao.save(existingParent);
    }
}
