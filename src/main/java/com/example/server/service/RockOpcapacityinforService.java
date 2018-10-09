package com.example.server.service;

import com.example.server.core.universal.Service;
import com.example.server.model.RockOpcapacityinfo;
import com.example.server.model.RockOpmanage;

import java.util.List;
import java.util.Map;

public interface RockOpcapacityinforService extends Service<RockOpcapacityinfo>{

    RockOpcapacityinfo getLastCapacityInfoByEmpid(String empid);

    RockOpcapacityinfo getCapacityInfo(String empid, String date, String area);

    float  getMonthCapacityInfo(String empid, String monthdate, String area);

    float getYearCapacityInfo(String empid, String yeardate, String area);

    RockOpcapacityinfo getLastCapacityInfoByEmpidAndArea(String empid, String area);

    public List<Map<String,Object>> getMaxAndMinCapacity(String empid, String area);
}
