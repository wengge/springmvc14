package com.newer.service;

import com.newer.bean.UserInfo;
import com.newer.dao.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userInfoService")
@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
public class UserInfoServiceImpl implements UserInfoService{

    @Autowired
    private UserInfoMapper userInfoMapper;

    public UserInfo login(UserInfo userInfo) {
        return userInfoMapper.findByNameAndPwd(userInfo);
    }

    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,rollbackFor = Exception.class)
    public int updatePwd(UserInfo userInfo) {
        return userInfoMapper.updatePwd(userInfo);
    }

    public int findUserName(String username) {
        return userInfoMapper.findUserName(username);
    }

    public List<UserInfo> findAll() {
        return userInfoMapper.findAll();
    }
}
