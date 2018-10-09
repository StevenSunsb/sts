package com.example.server.dao;

import com.example.server.core.universal.Mapper;
import com.example.server.model.RockDailyworkstation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RockDailyworkstationMapper extends Mapper<RockDailyworkstation> {
    List<RockDailyworkstation> selectByDeptidAndShipflagAndDate(@Param("deptid") String deptid, @Param("date") String date);
    RockDailyworkstation selectByDeptidAndShipflagAndDateNew(@Param("deptid") String deptid,@Param("area") String area,@Param("shiftFlag") String shiftFlag, @Param("date") String date);
}