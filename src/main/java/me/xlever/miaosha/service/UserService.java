package me.xlever.miaosha.service;

import me.xlever.miaosha.dao.UserDao;
import me.xlever.miaosha.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    @Autowired
    UserDao userDao;



    public User getById(int id){
        return userDao.getById(id);
    }


    @Transactional
    public boolean tx() {
        User user1 = new User();
        user1.setId(2);
        user1.setName("222");
        userDao.insert(user1);
        User user2 = new User();
        user2.setId(1);
        user2.setName("111");
        userDao.insert(user2);
        return true;
    }
}
