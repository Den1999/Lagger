package by.vsu.Lagger.dao;

import by.vsu.Lagger.entity.Child;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * Created by Zver.
 */
@Transactional
public interface ChildDao extends CrudRepository<Child, Long> {
}
