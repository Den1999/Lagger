package by.vsu.Lagger.services;

import by.vsu.Lagger.dao.CompanyDao;
import by.vsu.Lagger.entity.Company;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Zver on 30.03.2017.
 */
@Service("CompanyService")
public class CompanyService {

    @Autowired
    private CompanyDao companyDao;

    public Company get(Long id) {
        return companyDao.findOne(id);
    }
    
    public void add(Company company) {
        companyDao.save(company);
    }

    public String getAll(){
        return companyDao.findAll().toString();
    }

    public void delete(Long id) {
       Company company = new Company(id);
       companyDao.delete(company);
    }

    public void edit(Company company, Long id) {
        Company existingCompany =  new Company(id);
        existingCompany.setPermits(company.getPermits());
        existingCompany.setTitle(company.getTitle());
       companyDao.save(existingCompany);
    }
}
