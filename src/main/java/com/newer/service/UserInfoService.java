package com.newer.service;

import com.newer.bean.UserInfo;

import java.util.List;

public interface UserInfoService {

    UserInfo login(UserInfo userInfo);

    int updatePwd(UserInfo userInfo);

    int findUserName(String username);

    List<UserInfo> findAll();
}
