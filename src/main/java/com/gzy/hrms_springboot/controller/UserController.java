package com.gzy.hrms_springboot.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gzy.hrms_springboot.entity.User;
import com.gzy.hrms_springboot.mapper.UserMapper;
import com.gzy.hrms_springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

//    @Autowired
//    private UserMapper userMapper;

    @Autowired
    private UserService userService;

 //增加，删除，修改
    //返回要更改的条数，插入方法叫save
    //我们在前台传入一个json数据的时候Spring会自动调用对应的将其转换成相应的Java类实例
    //新增和修改
   @PostMapping
   public boolean save(@RequestBody User user) {
       return userService.saveUser(user);
   }

   //查询所有数据
    @GetMapping//get接口
    public List<User> findAll(){
//        return userMapper.findAll();

//        List<User> all = userMapper.findAll();
//        return all;
        return userService.list();
    }

    //删除
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id) {
       return userService.removeById(id);
    }

    @PostMapping("/del/batch")
    public boolean deleteBatch(@RequestBody List<Integer> ids) {
       return userService.removeByIds(ids);
    }

    //分页查询
    //接口路径：/user/page
    //@RequestParam接收?pageNum=1&pageSize=10
    //limit第一个参数=（pageNum-1）*pageSize
    //limit第二个参数pageSize
//    @GetMapping("/page")//get接口
//    public Map<String, Object> findPage(@RequestParam Integer pageNum,
//                                        @RequestParam Integer pageSize,
//                                        @RequestParam String username) {
//        pageNum = (pageNum - 1) * pageSize;
//        username = "%"+username+"%";
//        List<User> data = userMapper.selectPage(pageNum,pageSize,username);
//        Integer total = userMapper.selectTotal(username);
//        Map<String,Object> res = new HashMap<>();
//        res.put("data", data);
//        res.put("total", total);
//        return res;
//    }
    //分页查询-mybatis-plus的方式
//    @GetMapping("/page")//get接口
//    public IPage<User> findPage(@RequestParam Integer pageNum,
//                                @RequestParam Integer pageSize,
//                                @RequestParam String username) {
//       IPage<User> page = new Page<>(pageNum, pageSize);
//       QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//       queryWrapper.like("username", username);
//       return userService.page(page, queryWrapper);
//
//    }

    @GetMapping("/page")
    public IPage<User> findPage(
            @RequestParam Integer pageNum,
            @RequestParam Integer pageSize,
            @RequestParam(required = false) String username,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String address
    ) {
        IPage<User> page = new Page<>(pageNum, pageSize);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        if (username != null && !username.isEmpty()) {
            queryWrapper.like("username", username);
        }
        if (email != null && !email.isEmpty()) {
            queryWrapper.like("email", email);
        }
        if (address != null && !address.isEmpty()) {
            queryWrapper.like("address", address);
        }
        queryWrapper.orderByDesc("id");

        return userService.page(page, queryWrapper);
    }

}
