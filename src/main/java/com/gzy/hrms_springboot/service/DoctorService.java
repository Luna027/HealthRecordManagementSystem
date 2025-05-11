package com.gzy.hrms_springboot.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gzy.hrms_springboot.entity.Doctor;
import com.gzy.hrms_springboot.mapper.DoctorMapper;
import org.springframework.stereotype.Service;
@Service

public class DoctorService extends ServiceImpl<DoctorMapper, Doctor> {
    public boolean saveDoctor(Doctor doctor) {
        return saveOrUpdate(doctor);
    }
}