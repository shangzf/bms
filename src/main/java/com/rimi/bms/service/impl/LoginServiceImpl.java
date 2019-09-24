package com.rimi.bms.service.impl;

import com.rimi.bms.dao.IUserDao;
import com.rimi.bms.dao.impl.UserDaoImpl;
import com.rimi.bms.entity.User;
import com.rimi.bms.service.ILoginService;

/**
 * @author shangzf
 * @date 2019/9/20 16:53
 */
public class LoginServiceImpl implements ILoginService {

    private IUserDao userDao = new UserDaoImpl();

    @Override
    public boolean login(String username, String password) {
        // 调用dao中的方法
        User user = userDao.selectByUsername(username);
        // 判断密码是否一致
        return user != null && user.getPassword().equals(password);
    }
}
