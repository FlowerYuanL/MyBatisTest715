package com.lsxp.mapper;

import com.lsxp.bean.UpdateParam;
import com.lsxp.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    /*增加信息*/
    void insertUser(User user);

    /*修改信息*/
    void updateUser(User user);

    /*删除信息*/
    void deleteUserById(int id);

    /*查询信息*/

    /*单个查询*/
    User selectUserById(int id);

    /*多个查询*/
    List<User> selectAll();


    /*dynamic SQL Language*/
    List<User> dncFindUsers(User user);

    List<User> dncFindUsers2(User user);

    int dncUpdateUser(User user);

    List<User> qureyByArray(int[] ids);

    List<User> queryByMap(Map<String, Object> map);

    int updateByMap(UpdateParam updateParam);

}
