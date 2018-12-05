package com.simple.service;

import com.github.pagehelper.PageInfo;
import com.simple.common.ServerResponse;
import com.simple.pojo.User;

/**
 * Create By S I M P L E On 2018/12/04 14:35:34
 */
public interface IUserService {

    ServerResponse register(User user);

    ServerResponse<User> info(Integer id);

    ServerResponse<PageInfo> getAllUser(int pageNum, int pageSize);
}
