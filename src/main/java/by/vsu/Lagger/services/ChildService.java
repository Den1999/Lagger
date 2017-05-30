package by.vsu.Lagger.services;

import by.vsu.Lagger.dao.ChildDao;
import by.vsu.Lagger.dao.ParentDao;
import by.vsu.Lagger.dao.SquadDao;
import by.vsu.Lagger.entity.Child;
import by.vsu.Lagger.entity.Company;
import by.vsu.Lagger.entity.Parent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Zver.
 */
@Service("ChildService")
public class ChildService {

    @Autowired
    private ChildDao childDao;
    @Autowired
    private SquadDao squadDao;
    @Autowired
    private ParentDao parentDao;

    public Child get(Long id) {
        return childDao.findOne(id);
    }

    public String add(Child child) {

        //checking for maximum permits of a company
        Company company = parentDao.findOne(child.getParent().getId()).getCompany();
        Integer permits = company.getPermits();
        Integer childrenWithSquad = 0;
        List<Long> parentsId = new ArrayList<>();
        for (Parent p : parentDao.findAll()) {
            if (!StringUtils.isEmpty(p.getCompany())) {
                if (p.getCompany().getId().equals(company.getId())) {
                    parentsId.add(p.getId());
                }
            }
        }
        for (Child c : childDao.findAll()) {
            if (!StringUtils.isEmpty(c.getSquad())) {
                if (parentsId.contains(c.getParent().getId())) {
                    childrenWithSquad++;
                }
            }
        }

        if (Objects.equals(permits, childrenWithSquad)) {
            return "No more permits for this company!";
        } else {

            //checking for maximum places of the squad
            Short childrenInSquad = 0;
            for (Child c : childDao.findAll()) {
                if (!StringUtils.isEmpty(c.getSquad())) {
                    if (c.getSquad().getId().equals(child.getSquad().getId())) {
                        childrenInSquad++;
                    }
                }
            }
            if (!StringUtils.isEmpty(child.getSquad())) {
                if (Objects.equals(childrenInSquad, squadDao.findOne(child.getSquad().getId()).getMaxChildren())) {
                    return "Squad is even full!";
                } else {
                    childDao.save(child);
                    return child.toString();
                }
            }
            else {
                childDao.save(child);
                return child.toString();
            }
        }
    }

    public String getAll() {
        return childDao.findAll().toString();
    }

    public String delete(Long id) {
        childDao.delete(new Child(id));
        return "Child was deleted successfully!";
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

        //checking for maximum permits of a company
        Company company = parentDao.findOne(child.getParent().getId()).getCompany();
        Integer permits = company.getPermits();
        Integer childrenWithSquad = 0;
        List<Long> parentsId = new ArrayList<>();
        for (Parent p : parentDao.findAll()) {
            if (!StringUtils.isEmpty(p.getCompany())) {
                if (p.getCompany().getId().equals(company.getId())) {
                    parentsId.add(p.getId());
                }
            }
        }
        for (Child c : childDao.findAll()) {
            if (!StringUtils.isEmpty(c.getSquad())) {
                if (parentsId.contains(c.getParent().getId())) {
                    childrenWithSquad++;
                }
            }
        }

        if (Objects.equals(permits, childrenWithSquad)) {
            return "No more permits for this company!";
        } else {

            //checking for maximum places of the squad
            Short childrenInSquad = 0;
            for (Child c : childDao.findAll()) {
                if (!StringUtils.isEmpty(c.getSquad())) {
                    if (c.getSquad().getId().equals(child.getSquad().getId())) {
                        childrenInSquad++;
                    }
                }
            }
            if (!StringUtils.isEmpty(child.getSquad()))  {
                if (Objects.equals(childrenInSquad, squadDao.findOne(child.getSquad().getId()).getMaxChildren())) {
                    return "Squad is even full!";
                } else {
                    existingChild.setSquad(child.getSquad());
                    childDao.save(existingChild);
                    return existingChild.toString();
                }
            }
            else{
                existingChild.setSquad(child.getSquad());
                childDao.save(existingChild);
                return existingChild.toString();
            }
        }
    }

    public void deleteParent(Long id) {
        Child existingChild = childDao.findOne(id);
        existingChild.setParent(null);
        childDao.save(existingChild);
    }
}
