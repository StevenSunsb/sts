package com.example.server.service.impl;

import com.example.server.core.ret.ServiceException;
import com.example.server.core.universal.AbstractService;
import com.example.server.dao.RockOpempMapper;
import com.example.server.dao.RockOpmanageMapper;
import com.example.server.model.RockOpemp;
import com.example.server.model.RockOpmanage;
import com.example.server.service.RockOpempService;
import com.example.server.service.RockOpmanagerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RockOpmanagerServiceImpl extends AbstractService<RockOpmanage> implements RockOpmanagerService {
    @Resource
    private RockOpmanageMapper rockOpmanageMapper;

    @Override
    public RockOpmanage selectByDeptId(String deptid){
        RockOpmanage rockOpmanage = rockOpmanageMapper.selectByDeptId(deptid);
        if(rockOpmanage == null){
            throw new ServiceException("未注册参数");
        }
        return rockOpmanage;
    }
}
