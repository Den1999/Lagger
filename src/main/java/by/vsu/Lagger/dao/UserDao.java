package by.vsu.Lagger.dao;

import by.vsu.Lagger.entity.User;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * Created by Zver.
 */
@Transactional
public interface UserDao extends CrudRepository <User, Long> {

    User findById(Long id);
}
