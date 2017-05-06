package by.vsu.Lagger.services;

import by.vsu.Lagger.dao.UserDao;
import by.vsu.Lagger.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Zver.
 */
@Service("UserService")
public class UserService {
    
    @Autowired
    private UserDao userDao;

    public User get(Long id) {
        return userDao.findOne(id);
    }

    public void add(User user) {
        userDao.save(user);
    }

    public void delete(Long id) {
        User user = new User(id);
        userDao.delete(user);
    }

    public void edit(User user, Long id) {
        User existingUser = userDao.findOne(id);
        existingUser.setLogin(user.getLogin());
        existingUser.setPassword(user.getPassword());
        userDao.save(existingUser);
    }
}
