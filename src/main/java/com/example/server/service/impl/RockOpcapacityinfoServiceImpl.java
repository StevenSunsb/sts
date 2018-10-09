package com.example.server.service.impl;

import com.example.server.core.ret.ServiceException;
import com.example.server.core.universal.AbstractService;
import com.example.server.dao.RockOpcapacityinfoMapper;
import com.example.server.dao.RockOpmanageMapper;
import com.example.server.model.RockOpcapacityinfo;
import com.example.server.model.RockOpmanage;
import com.example.server.service.RockOpcapacityinforService;
import com.example.server.service.RockOpmanagerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class RockOpcapacityinfoServiceImpl extends AbstractService<RockOpcapacityinfo> implements RockOpcapacityinforService {
    @Resource
    private RockOpcapacityinfoMapper rockOpcapacityinfoMapper;

    @Override
    public RockOpcapacityinfo getCapacityInfo(String empid,String date,String area){
        RockOpcapacityinfo rockOpcapacityinfo = rockOpcapacityinfoMapper.getCapacityInfo(empid,date,area);
        return rockOpcapacityinfo;
    }

    @Override
    public RockOpcapacityinfo getLastCapacityInfoByEmpid(String empid){
        RockOpcapacityinfo rockOpcapacityinfo = rockOpcapacityinfoMapper.getLastCapacityInfoByEmpid(empid);
        return rockOpcapacityinfo;
    }

    @Override
    public float getMonthCapacityInfo(String empid, String monthdate, String area){
        List<Map<String,Object>> result = null;
        result = rockOpcapacityinfoMapper.getMonthCapacityInfo(empid,monthdate,area);
        String temp = result.get(0).get("monthtotal").toString();
        float monthvalue = Float.parseFloat(temp);
        return monthvalue;
    }

    @Override
    public float getYearCapacityInfo(String empid, String yeardate, String area){
        List<Map<String,Object>> result = null;
        result = rockOpcapacityinfoMapper.getYearCapacityInfo(empid,yeardate,area);
        String temp = result.get(0).get("yeartotal").toString();
        float yearvalue = Float.parseFloat(temp);
        return yearvalue;
    }

    @Override
    public RockOpcapacityinfo getLastCapacityInfoByEmpidAndArea(String empid, String area){
        RockOpcapacityinfo rockOpcapacityinfo = rockOpcapacityinfoMapper.getLastCapacityInfoByEmpidAndArea(empid,area);
        return rockOpcapacityinfo;
    }

    @Override
    public  List<Map<String,Object>> getMaxAndMinCapacity(String empid,String area){
        List<Map<String,Object>> result = rockOpcapacityinfoMapper.getMaxAndMinCapacity(empid,area);
        return result;
    }
}
