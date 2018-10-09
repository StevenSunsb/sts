package com.example.server.service;

import com.example.server.core.universal.Service;
import com.example.server.model.RockDailyworkstation;

import java.util.List;

public interface RockDailyworkstationService extends Service<RockDailyworkstation>{
    List<RockDailyworkstation> selectByDeptidAndShipflagAndDate(String deptid, String date);
    RockDailyworkstation selectByDeptidAndShipflagAndDate(String deptid,String area,String shiftFlag, String date);
}
