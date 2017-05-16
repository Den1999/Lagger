package by.vsu.Lagger.services;

import by.vsu.Lagger.dao.ChildDao;
import by.vsu.Lagger.dao.SquadDao;
import by.vsu.Lagger.entity.Child;
import by.vsu.Lagger.entity.Squad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * Created by Zver on 30.03.2017.
 */
@Service("SquadService")
public class SquadService {

    @Autowired
    private SquadDao squadDao;
    @Autowired
    private ChildDao childDao;

    public Squad get(Long id) {
        return squadDao.findOne(id);
    }

    public void add(Squad squad) {
        squadDao.save(squad);
    }

    public String delete(Long id) {
        for(Child c : childDao.findAll()){
            if(!StringUtils.isEmpty(c.getSquad())) {
                if(c.getSquad().getId().equals(id)){
                    c.setSquad(null);
                }
            }
        }
        squadDao.delete(new Squad(id));
        return "Squad was deleted successfully!";
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
