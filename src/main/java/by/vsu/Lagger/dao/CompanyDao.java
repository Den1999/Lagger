package by.vsu.Lagger.dao;

import by.vsu.Lagger.entity.Company;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * Created by Zver on 30.03.2017.
 */
@Transactional
public interface CompanyDao extends CrudRepository<Company, Long> {
    Company findById(Long Id);
}
