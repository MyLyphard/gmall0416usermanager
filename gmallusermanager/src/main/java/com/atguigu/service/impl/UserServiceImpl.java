package com.atguigu.service.impl;

import com.atguigu.bean.UserInfo;
import com.atguigu.mapper.UserMapper;
import com.atguigu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;


import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;

    public UserInfo getUserInfoById(String id){
        UserInfo userInfo = userMapper.selectByPrimaryKey(id);
        return userInfo;
    }

    @Override
    public List<UserInfo> getUserInfoList() {
        List<UserInfo> userInfoList = userMapper.selectAll();
        return userInfoList;
    }

    @Override
    public void addUserInfo(UserInfo userInfo) {
        userMapper.insertSelective(userInfo);
    }

    @Override
    public void updateUserInfo(UserInfo userInfo) {

       userMapper.updateByPrimaryKeySelective(userInfo);
    }

    @Override
    public List<UserInfo> getUserInfo(UserInfo userInfo) {
        Example example = new Example(UserInfo.class);
        example.createCriteria().andLike("nickName","%"+userInfo.getNickName()+"%");
        List<UserInfo> list = userMapper.selectByExample(example);
        return list;
    }

    @Override
    public void  updateUserInfo2(UserInfo userInfo,UserInfo userInfoQuery) {
        //按名称匹配更新
        Example example = new Example(UserInfo.class);
        example.createCriteria().andLike("name","%"+userInfoQuery.getName()+"%");
        userMapper.updateByExampleSelective(userInfo,example);
    }

    @Override
    public void deleteUserInfo(UserInfo userInfo) {
        Example example = new Example(UserInfo.class);
        example.createCriteria().andLike("name","%"+userInfo.getName()+"%");
        userMapper.deleteByExample(example);
    }

}
