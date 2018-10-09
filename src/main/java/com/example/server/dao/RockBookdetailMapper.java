package com.example.server.dao;

import com.example.server.core.universal.Mapper;
import com.example.server.model.RockBookdetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface RockBookdetailMapper extends Mapper<RockBookdetail> {
    RockBookdetail selectByEmpIdAndDate(@Param("empid") String empid,@Param("date") String date);
    List<Map<String,Object>> selectByEmpIdAndDateMonth(@Param("empid") String empid, @Param("date") String date);
    List<Map<String,Object>> selectByEmpIdAndDateMonthBai(@Param("empid") String empid, @Param("date") String date);
    List<Map<String,Object>> selectByEmpIdAndDateMonthYe(@Param("empid") String empid, @Param("date") String date);
    List<Map<String,Object>> selectByEmpIdAndDateWeek(@Param("empid") String empid, @Param("startdate") String startdate,@Param("enddate") String enddate);
    List<RockBookdetail> selectByEmpIdAndDateMonthDetail(@Param("empid") String empid, @Param("date") String date);
    List<RockBookdetail> selectByDeptIdAndAreaAndDateDay(@Param("deptid")String deptid,@Param("area")String area, @Param("date") String date);
    List<RockBookdetail> selectByDeptIdAndAreaAndDateAndShiftflagDay(@Param("deptid")String deptid,@Param("area")String area,@Param("shiftFlag")String shiftFlag, @Param("date") String date);
    List<RockBookdetail> selectFutureByEmpId(@Param("empid")String empid);
    List<RockBookdetail> selectByEmpIdAndFirstAndLast(@Param("empid") String empid, @Param("firstDate") String firstDate,@Param("lastDate") String lastDate);
}