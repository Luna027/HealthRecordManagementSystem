package com.gzy.hrms_springboot.service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gzy.hrms_springboot.common.Constants;
import com.gzy.hrms_springboot.entity.Doctor;
import com.gzy.hrms_springboot.mapper.DoctorMapper;
import org.springframework.stereotype.Service;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.log.Log;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gzy.hrms_springboot.controller.dto.DoctorDto;
import com.gzy.hrms_springboot.exception.ServiceException;

@Service
public class DoctorService extends ServiceImpl<DoctorMapper, Doctor> {
    private static final Log LOG = Log.get();

    // 新增和修改医生信息
    public boolean saveDoctor(Doctor doctor) {
        return this.saveOrUpdate(doctor);
    }
//    @Override
//    public boolean login(DoctorDto doctorDto) {
//        QueryWrapper<Doctor> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("name", doctorDto.getName());
//        queryWrapper.eq("password", doctorDto.getPassword());
//        Doctor one = getOne(queryWrapper);
//        return one != null ;
//    }


    // 医生登录
    public DoctorDto login(DoctorDto doctorDto) {
        QueryWrapper<Doctor> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", doctorDto.getName()); // 修改1：将 username 改为 name
        queryWrapper.eq("password", doctorDto.getPassword());
        Doctor one;
        try {
            one = (Doctor) this.getOne(queryWrapper);
        } catch (Exception e) {
            LOG.error(e);
            throw new ServiceException(Constants.CODE_500,"系统错误");
        }

        if (one != null) {
            BeanUtil.copyProperties(one, doctorDto, true);
            return doctorDto;
        } else {
            throw new ServiceException(Constants.CODE_600,"用户名或密码错误");
        }
    }

//    // 医生注册
//    public Doctor register(DoctorDto doctorDto) {
//        QueryWrapper<Doctor> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("name", doctorDto.getName()); // 修改2：将 username 改为 name
//        queryWrapper.eq("password", doctorDto.getPassword());
////        queryWrapper.eq("department", doctorDto.getDepartment()); // 修改3：新增 department 查询条件
////        queryWrapper.eq("position", doctorDto.getPosition()); // 修改4：新增 position 查询条件
//
//        Doctor one;
//        try {
//            one = (Doctor) this.getOne(queryWrapper);
//        } catch (Exception e) {
//            LOG.error(e);
//            throw new ServiceException("500", "系统错误");
//        }
//
//        if (one == null) {
//            one = new Doctor();
//            BeanUtil.copyProperties(doctorDto, one, true);
//            this.save(one);
//            return one;
//        } else {
//            throw new ServiceException("600", "用户已存在");
//        }
//    }
}






























































































































