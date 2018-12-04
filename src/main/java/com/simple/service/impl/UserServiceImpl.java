package com.simple.service.impl;

import com.simple.common.ServerResponse;
import com.simple.dao.UserMapper;
import com.simple.pojo.User;
import com.simple.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Create By S I M P L E On 2018/12/04 14:35:54
 */
@Service("iUserService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    public ServerResponse register(User user) {
        int result = userMapper.insert(user);
        if (result > 0) {
            return ServerResponse.createBySuccessMessage("success");
        }
        return ServerResponse.createByErrorMessage("fail");
    }

    public ServerResponse<User> info(Integer id) {
        User user = userMapper.selectByPrimaryKey(id);
        if (user != null){
            return ServerResponse.createBySuccess("success",user);
        }
        return ServerResponse.createByErrorMessage("fail");
    }
}
