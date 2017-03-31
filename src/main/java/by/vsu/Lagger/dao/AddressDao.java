package by.vsu.Lagger.dao;

import by.vsu.Lagger.entity.Address;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * Created by Zver.
 */
@Transactional
public interface AddressDao extends CrudRepository<Address, Long> {
    Address findById(Long Id);
}
