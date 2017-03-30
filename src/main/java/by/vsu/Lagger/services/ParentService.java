package by.vsu.Lagger.services;

import by.vsu.Lagger.dao.ParentDao;
import by.vsu.Lagger.entity.Parent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Zver.
 */
@Service("ParentService")
public class ParentService {
    
    @Autowired
    ParentDao parentDao;

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
        Parent existingParent =  new Parent(id);
        existingParent.setSname(parent.getSname());
        existingParent.setFname(parent.getFname());
        existingParent.setPatron(parent.getPatron());
        existingParent.setDob(parent.getDob());
        existingParent.setGender(parent.isGender());
        existingParent.setMphone(parent.getMphone());
        existingParent.setRelations(parent.getRelations());
        parentDao.save(existingParent);
    }
}
