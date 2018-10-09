package com.example.server.service;

import com.example.server.core.universal.Service;
import com.example.server.model.RockBookdetail;

import java.util.List;
import java.util.Map;

public interface RockBookdetailService extends Service<RockBookdetail>{
    RockBookdetail selectByEmpIdAndDate(String empid,String date);
    Object selectByEmpIdAndDateMonth(String empid,String date);
    Object selectByEmpIdAndDateMonthBai(String empid,String date);
    Object selectByEmpIdAndDateMonthYe(String empid,String date);
    Object selectByEmpIdAndDateWeek(String empid,String startdate,String enddate);

    List<RockBookdetail> selectByEmpIdAndDateMonthDetail(String empid, String date);
    List<RockBookdetail> selectByDeptIdAndAreaAndDateDay(String deptid,String area,String date);
    List<RockBookdetail> selectByDeptIdAndAreaAndDateAndShiftflagDay(String deptid,String area,String shiftFlag,String date);
    List<RockBookdetail> selectFutureByEmpId(String empid);
    List<RockBookdetail> selectByEmpIdAndFirstAndLast(String empid,String firstDate,String lastDate);
    int cancelReserveById(String id,String reasonForCancel);
    int cancelReserveByIdReplace(String id,String reasonForCancel,String empidReplace);
}
