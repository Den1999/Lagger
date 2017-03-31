package by.vsu.Lagger.dao;

import by.vsu.Lagger.entity.Squad;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * Created by Zver.
 */
@Transactional
public interface SquadDao extends CrudRepository<Squad, Long> {
    Squad findById(Long Id);
}
