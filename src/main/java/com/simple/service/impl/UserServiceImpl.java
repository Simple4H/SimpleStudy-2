package com.simple.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.simple.common.ServerResponse;
import com.simple.dao.UserMapper;
import com.simple.pojo.User;
import com.simple.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create By S I M P L E On 2018/12/04 14:35:54
 */
@Service("iUserService")
public class UserServiceImpl implements IUserService {

    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

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

    public ServerResponse<PageInfo> getAllUser(int pageNum,int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> userList = userMapper.getAllList();
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        return ServerResponse.createBySuccess("success",pageInfo);
    }
}
