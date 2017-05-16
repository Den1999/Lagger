package by.vsu.Lagger.services;

import by.vsu.Lagger.dao.ChildDao;
import by.vsu.Lagger.dao.CompanyDao;
import by.vsu.Lagger.dao.ParentDao;
import by.vsu.Lagger.entity.Child;
import by.vsu.Lagger.entity.Company;
import by.vsu.Lagger.entity.Parent;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zver on 30.03.2017.
 */
@Service("CompanyService")
public class CompanyService {

    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private ParentDao parentDao;
    @Autowired
    private ChildDao childDao;

    public Company get(Long id) {
        return companyDao.findOne(id);
    }
    
    public void add(Company company) {
        companyDao.save(company);
    }

    public String getAll(){
        return companyDao.findAll().toString();
    }

    public String delete(Long id) {
        List<Long> parents = new ArrayList<>();
        List<Long> children = new ArrayList<>();

        for(Parent p : parentDao.findAll()){
            if(!StringUtils.isEmpty(p.getCompany())) {
                if(p.getCompany().getId().equals(id)){
                    parents.add(p.getId());
                }
            }
        }

        for(Child c : childDao.findAll()){
            if(!StringUtils.isEmpty(c.getParent())) {
                if(parents.contains(c.getParent().getId())){
                    children.add(c.getId());
                }
            }
        }

        for (Long l : children){
            childDao.delete(new Child(l));
        }

        for (Long l : parents){
            parentDao.delete(new Parent(l));
        }

       companyDao.delete(new Company(id));
       return "Company was deleted successfully";
    }

    public void edit(Company company, Long id) {
        Company existingCompany =  new Company(id);
        existingCompany.setPermits(company.getPermits());
        existingCompany.setTitle(company.getTitle());
       companyDao.save(existingCompany);
    }
}
