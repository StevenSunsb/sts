package com.example.server.dao;

import com.example.server.core.universal.Mapper;
import com.example.server.model.RockOpcapacityinfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface RockOpcapacityinfoMapper extends Mapper<RockOpcapacityinfo> {
    RockOpcapacityinfo getLastCapacityInfoByEmpid(@Param("empid") String empid);

    RockOpcapacityinfo getCapacityInfo(@Param("empid")String empid, @Param("date")String date, @Param("area")String area);

    List<Map<String,Object>> getMonthCapacityInfo(@Param("empid")String empid, @Param("monthdate")String monthdate, @Param("area")String area);

    List<Map<String,Object>> getYearCapacityInfo(@Param("empid")String empid, @Param("yeardate")String yeardate, @Param("area")String area);

    RockOpcapacityinfo getLastCapacityInfoByEmpidAndArea(@Param("empid")String empid,  @Param("area")String area);

    List<Map<String,Object>> getMaxAndMinCapacity(@Param("empid")String empid,  @Param("area")String area);
}