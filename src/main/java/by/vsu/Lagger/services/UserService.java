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

    public String add(User user) {
        for(User u: userDao.findAll()){
            if(u.getLogin().equals(user.getLogin())){
                return "User with this login already exists!";
            }
        }
        userDao.save(user);
        return user.toString();
    }

    public void delete(Long id) {
        User user = new User(id);
        userDao.delete(user);
    }

    public String getAll(){
        return userDao.findAll().toString();
    }

    public void edit(User user, Long id) {
        User existingUser = userDao.findOne(id);
        existingUser.setLogin(user.getLogin());
        existingUser.setPassword(user.getPassword());
        userDao.save(existingUser);
    }

    public String authorize(User user) {
        for(User u: userDao.findAll()){
            if(u.getLogin().equals(user.getLogin())){
                if(u.getPassword().equals(user.getPassword())){
                    if(user.getLogin().equals("admin")) {
                        u.setPrivilege("administrator");
                    }
                    else {
                        u.setPrivilege("user");
                    }
                    return u.getPrivilege();
                }
            }
        }
        return "User not exists!";
    }
}
