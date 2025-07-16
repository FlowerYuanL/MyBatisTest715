package com.lsxp.mapper;

import com.lsxp.bean.UpdateParam;
import com.lsxp.pojo.User;
import com.lsxp.utils.FieldWhiteListUtil;
import com.lsxp.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;

public class UserMapperTest {

    UserMapper userMapper = null;
    SqlSession sqlSession = null;


    @Before
    public void setUp() throws Exception {
        sqlSession = MyBatisUtils.getSession();
        userMapper = sqlSession.getMapper(UserMapper.class);
    }

    @After
    public void tearDown() throws Exception {
        sqlSession.close();
    }

    @Test
    public void insertUser() {
        User user = new User();
        user.setName("test2");
        user.setAge(21);

        userMapper.insertUser(user);
        sqlSession.commit();
    }

    @Test
    public void updateUser() {
    }

    @Test
    public void deleteUser() {
    }

    @Test
    public void selectUserById() {
    }

    @Test
    public void selectAll() {
        List<User> users = userMapper.selectAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void dncFindUser() {
        User user = new User();
        /*user.setName("test");*/
        //user.setPosition("员");
        List<User> users = userMapper.dncFindUsers(user);
        for (User user1 : users) {
            System.out.println(user1);
        }
    }

    @Test
    public void dncFindUser2() {
        User user = new User();
        user.setName("test2");
        user.setPosition("ob");
        System.out.println(user);
        List<User> users = userMapper.dncFindUsers2(user);
        for (User user1 : users) {
            System.out.println(user1);
        }
    }

    @Test
    public void dncUpdateUser() {
        User user = new User();
        user.setId(4);
        user.setName("UpdateUser");
        user.setAge(21);
        userMapper.dncUpdateUser(user);
        sqlSession.commit();
    }

    @Test
    public void dncUpdateUser2() {
        User user = new User();
        user.setId(4);
        user.setName("UpdateUser2");
        user.setAge(21);
        int rows = userMapper.dncUpdateUser(user);
        if (rows > 0) {
            System.out.println("Successfully Updated " + rows + " Rows Of Users");
        }else {
            System.out.println("Update Failed");
        }
        sqlSession.commit();
    }

    @Test
    public void queryByArray(){
        int[] ids = {1,2,3};
        List<User> users = userMapper.qureyByArray(ids);
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void queryByMap(){
        Map<String,Object> map = new HashMap<String,Object>();
        int[] ids = {1,2,3,4};
        map.put("ids",ids);
        map.put("position","p1");
        List<User> users = userMapper.queryByMap(map);
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void updateByMap(){
        /*通过Java Bean 传递参数*/
        UpdateParam updateParam = new UpdateParam();
        Map<String,String> map1 = new HashMap<>();
        map1.put("position","up_position");
        map1.put("name","up_name");
        updateParam.setColumns(map1);

        Integer[] ids = {3,4};
        updateParam.setIds(ids);

        int rows = userMapper.updateByMap(updateParam);

        if (rows > 0) {
            System.out.println("Successfully Updated " + rows + " Rows Of Users");
        }else {
            System.out.println("Update Failed");
        }
        sqlSession.commit();
    }

    /*更安全的测试类*/
    /*可以在Service层中使用*/
    @Test
    public void safeUpdateUser(){
        //构建即将测试的类
        /*通过  Java Bean 传递参数*/
        UpdateParam updateParam = new UpdateParam();
        Map<String,String> map1 = new HashMap<>();
        map1.put("position","up_position");
        map1.put("name","up_name");
        updateParam.setColumns(map1);

        Integer[] ids = {5,6};
        updateParam.setIds(ids);

        //校验 positions 字段名是否合法
        Set<String> allowedFields = FieldWhiteListUtil.getUpdateFields(User.class);
        for(String key : updateParam.getColumns().keySet()){
            if(!allowedFields.contains(key)){
                /*主动报错,终止程序,不在运行后续函数*/
                throw new IllegalArgumentException("非法字段名:"+key);
            }
        }
        System.out.println("更新字段合法");
        int rows = userMapper.updateByMap(updateParam);
        if (rows > 0) {
            System.out.println("Successfully Updated " + rows + " Rows Of Users");
        }else{
            System.out.println("Update Failed");
        }
        sqlSession.commit();
    }
}

