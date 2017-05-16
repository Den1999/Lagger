package by.vsu.Lagger.services;

import by.vsu.Lagger.dao.ChildDao;
import by.vsu.Lagger.dao.ParentDao;
import by.vsu.Lagger.entity.Child;
import by.vsu.Lagger.entity.Parent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zver.
 */
@Service("ParentService")
public class ParentService {

    @Autowired
    private ParentDao parentDao;
    @Autowired
    private ChildDao childDao;

    public Parent get(Long id) {
        return parentDao.findOne(id);
    }

    public String getAll() {
        return parentDao.findAll().toString();
    }

    public void add(Parent parent) {
        parentDao.save(parent);
    }

    public String delete(Long id) {
        List<Long> children = new ArrayList<>();

        for(Child c : childDao.findAll()){
            if(!StringUtils.isEmpty(c.getParent())) {
                if(c.getParent().getId().equals(id)){
                    children.add(c.getId());
                }
            }
        }

        for (Long l : children){
            childDao.delete(new Child(l));
        }
        parentDao.delete(new Parent(id));
        return "Parent was deleted successfully";
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
}
