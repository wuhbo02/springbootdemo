package com.ygnet.springbootdemo.controller;

import com.ygnet.springbootdemo.pojo.Result;
import com.ygnet.springbootdemo.pojo.UserVO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
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

    @PostMapping("/add")//等价于下面的写法
     // @RequestMapping(value = "/add",method = RequestMethod.POST)
    Result addUser(@RequestBody UserVO user, HttpServletRequest request, HttpServletResponse response){
        String headerParam = request.getHeader("token");
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding("UTF-8");

        UserVO userVO = new UserVO();
        userVO.setUserName(user.getUserName()+"add");
        userVO.setChnName(user.getChnName()+"add");
        userVO.setAge(user.getAge()+100);
        return Result.ok("添加用户成功").setData(userVO);
    }


    @PutMapping("/update")//等价于下面的写法
        // @RequestMapping(value = "/update",method = RequestMethod.PUT)
    Result updateUser(@RequestBody UserVO user){
        UserVO userVO = new UserVO();
        userVO.setUserName(user.getUserName()+"update");
        userVO.setChnName(user.getChnName()+"update");
        userVO.setAge(user.getAge()+100);
        return Result.ok("更新用户成功").setData(userVO);
    }

    @DeleteMapping("/delete/{name}") //等价于下面的写法
        // @RequestMapping(value = "/delete/{name}",method = RequestMethod.DELETE)
    Result deleteUser(@PathVariable String name){
        UserVO userVO = new UserVO();
        userVO.setUserName("to delete user:"+name);
        userVO.setChnName("deleteUser");
        userVO.setAge(100);
        return Result.ok("删除用户成功").setData(userVO);
    }


}
