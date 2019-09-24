package com.rimi.bms.dao;

import com.rimi.bms.entity.User;

/**
 * @author shangzf
 * @date 2019/9/20 16:58
 */
public interface IUserDao {
    User selectByUsername(String username);
}
