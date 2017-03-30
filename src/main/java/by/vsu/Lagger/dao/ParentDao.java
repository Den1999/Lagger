package by.vsu.Lagger.dao;

import by.vsu.Lagger.entity.Parent;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * Created by Zver.
 */
@Transactional
public interface ParentDao extends CrudRepository<Parent,Long> {
    Parent findById(Long id);
}
