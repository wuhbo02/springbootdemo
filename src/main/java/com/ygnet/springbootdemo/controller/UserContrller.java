package com.ygnet.springbootdemo.controller;

import com.ygnet.springbootdemo.pojo.UserVO;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.tags.Param;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

@RestController
//@RequestMapping(value = "/user")
public class UserContrller {

    @RequestMapping(value = "/queryUsers",method = RequestMethod.GET)
    //@GetMapping("/queryUsers")
    List<UserVO> queryUsers( String userNames, int age, @RequestParam String otherParameter){
        //实际上这里是查询数据库或调其他业务接口返回的数据对象，
        //这里直接生成数据对象返回
        String []userNamesArray = userNames.split(",");
        List<UserVO> list = new ArrayList<UserVO>();
        for(int i=0;i<userNamesArray.length;i++){
            UserVO userVO = new UserVO();
            userVO.setUserName(userNamesArray[i]);
            userVO.setAge(18);
            userVO.setChnName("小明"+userNamesArray[i]);
            list.add(userVO);
        }

        return list;
    }



    @GetMapping("/getByName/{userName}")//等价于下面的写法
    //@RequestMapping(value = "/getByName/{userName}",method = RequestMethod.GET)
    UserVO getUserByUserName(@PathVariable String userName){
        //实际上这里是查询数据库或调其他业务接口返回的数据对象，
        //这里直接生成一个数据对象返回
        UserVO userVO = new UserVO();
        userVO.setUserName(userName);
        userVO.setAge(18);
        userVO.setChnName("小明");

        return userVO;
    }


}
