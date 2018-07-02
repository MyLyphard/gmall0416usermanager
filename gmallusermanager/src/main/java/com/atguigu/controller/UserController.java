package com.atguigu.controller;

import com.atguigu.bean.UserInfo;
import com.atguigu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("gmallmanager")
public class UserController {
    @Autowired
    private UserService  userService;

    /**
     * 根据id获取用户
     * @param id
     * @return
     */
    @RequestMapping("/getUserInfoById/{id}")
    public UserInfo getUserInfoById(@PathVariable("id") String id){
        return userService.getUserInfoById(id);
    }

    /**
     * 模糊查询
     * @param request
     * @return
     */
    @RequestMapping("/getUserInfo")
    public List<UserInfo> getUserInfo(HttpServletRequest request){
        String nickName=request.getParameter("nickName");
        System.out.println("nickName====="+nickName);
        UserInfo userInfo=new UserInfo();
        userInfo.setNickName(nickName);
        return userService.getUserInfo(userInfo);
    }
    /**
     * 获取全部用户
     * @return
     */
    @RequestMapping(value="/getUserInfoList")
    public List<UserInfo> getUserInfoList(){
        return userService.getUserInfoList();
    }

    /**
     * 添加用户
     * @param userInfo
     */
    @RequestMapping(value="/addUserInfo",method = RequestMethod.POST)
    public void addUserInfo(UserInfo userInfo){
        userService.addUserInfo( userInfo);

    }

    /**
     * 修改用户
     * @param userInfo
     * @return
     */
    @RequestMapping(value="/updateUserInfo",method = RequestMethod.POST)
    public String updateUserInfo2(UserInfo userInfo){
        userService.updateUserInfo(userInfo);
        return "success";
    }
    /**
     * 模糊修改用户
     * @param userInfo
     * @return
     */
    @RequestMapping(value="/updateUserInfo2",method = RequestMethod.POST)
    public String updateUserInfo(UserInfo userInfo){
        UserInfo userInfoQuery = new UserInfo();
        userInfoQuery.setName(userInfo.getName());

        userInfo.setName(null);
        userService.updateUserInfo2(userInfo,userInfoQuery);
        return "success";
    }

    /**
     * 根据条件删除用户
     * @param userInfo
     */
    @RequestMapping(value = "deleteUserInfo",method = RequestMethod.POST)
    public void deleteUserInfo(UserInfo userInfo){
        userService.deleteUserInfo(userInfo);

    }

}
