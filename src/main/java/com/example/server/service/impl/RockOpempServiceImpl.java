package com.example.server.service.impl;

import com.example.server.core.ret.ServiceException;
import com.example.server.dao.RockOpempMapper;
import com.example.server.core.universal.AbstractService;
import com.example.server.model.RockOpemp;
import com.example.server.service.RockOpempService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RockOpempServiceImpl extends AbstractService<RockOpemp> implements RockOpempService {
    @Resource
    private RockOpempMapper rockOpempMapper;

    @Override
    public RockOpemp selectByEmpId(String empid){
        RockOpemp rockOpemp = rockOpempMapper.selectByEmpId(empid);
        if(rockOpemp == null){
            throw new ServiceException("暂无用户");
        }
        return rockOpemp;
    }
}
