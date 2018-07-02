package com.atguigu.service;

import com.atguigu.bean.UserInfo;

import java.util.List;

public interface UserService {

    public UserInfo getUserInfoById(String id);

    public List<UserInfo> getUserInfoList();

    public void addUserInfo(UserInfo userInfo);

    public void updateUserInfo(UserInfo userInfo);

    public List<UserInfo> getUserInfo(UserInfo userInfo);

    public void  updateUserInfo2(UserInfo userInfo,UserInfo userInfoQuery);

    public void deleteUserInfo(UserInfo userInfo);
}
