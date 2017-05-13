package by.vsu.Lagger.services;

import by.vsu.Lagger.dao.SquadDao;
import by.vsu.Lagger.entity.Squad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Zver on 30.03.2017.
 */
@Service("SquadService")
public class SquadService {

    @Autowired
    private SquadDao squadDao;

    public Squad get(Long id) {
        return squadDao.findOne(id);
    }

    public void add(Squad squad) {
        squadDao.save(squad);
    }

    public void delete(Long id) {
        Squad squad = new Squad(id);
        squadDao.delete(squad);
    }

    public String getAll(){
        return squadDao.findAll().toString();
    }

    public void edit(Squad squad, Long id) {
        Squad existingSquad = new Squad(id);
        existingSquad.setMainFname(squad.getMainFname());
        existingSquad.setMainSname(squad.getMainSname());
        existingSquad.setMainPatron(squad.getMainPatron());
        existingSquad.setMaxChildren(squad.getMaxChildren());
        existingSquad.setNumber(squad.getNumber());
        squadDao.save(existingSquad);
    }
}
