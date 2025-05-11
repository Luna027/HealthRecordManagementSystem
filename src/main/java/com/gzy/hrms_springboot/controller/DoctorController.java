package com.gzy.hrms_springboot.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gzy.hrms_springboot.entity.Doctor; // 修改1：导入Doctor类
import com.gzy.hrms_springboot.service.DoctorService; // 修改2：导入DoctorService类
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin
@RestController
@RequestMapping("/doctor") // 修改3：将请求映射改为/doctor
public class DoctorController {

    @Autowired
    private DoctorService doctorService; // 修改4：将UserService改为DoctorService

    //新增和修改
    @PostMapping
    public boolean save(@RequestBody Doctor doctor) { // 修改5：将User改为Doctor
        return doctorService.saveDoctor(doctor); // 修改6：将saveUser方法改为saveDoctor方法
    }

    //查询所有数据
    @GetMapping // get接口
    public List<Doctor> findAll() { // 修改7：将User改为Doctor
        return doctorService.list(); // 修改8：调用DoctorService的list方法
    }

    //删除
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id) {
        return doctorService.removeById(id);
    }

    @PostMapping("/del/batch")
    public boolean deleteBatch(@RequestBody List<Integer> ids) {
        return doctorService.removeByIds(ids);
    }

    @GetMapping("/page")
    public IPage<Doctor> findPage( // 修改9：将User改为Doctor
                                   @RequestParam Integer pageNum,
                                   @RequestParam Integer pageSize,
                                   @RequestParam(required = false) String name, // 修改10：将username改为name
                                   @RequestParam(required = false) String department, // 修改11：如果Doctor类没有email字段，需要改为Doctor类中的对应字段
                                   @RequestParam(required = false) String position // 修改12：如果Doctor类没有phone字段，需要改为Doctor类中的对应字段
    ) {
        IPage<Doctor> page = new Page<>(pageNum, pageSize); // 修改13：将User改为Doctor
        QueryWrapper<Doctor> queryWrapper = new QueryWrapper<>(); // 修改14：将User改为Doctor

        if (name != null && !name.isEmpty()) {
            queryWrapper.like("name", name); // 修改15：将username改为name（数据库中的字段名）
        }
        if (department != null && !department.isEmpty()) {
            queryWrapper.like("department", department); // 修改16：如果字段名不是email，改为Doctor类中的对应字段名
        }
        if (position != null && !position.isEmpty()) {
            queryWrapper.like("position", position); // 修改17：如果字段名不是phone，改为Doctor类中的对应字段名
        }
        queryWrapper.orderByDesc("id");

        return doctorService.page(page, queryWrapper); // 修改18：调用DoctorService的page方法
    }
}