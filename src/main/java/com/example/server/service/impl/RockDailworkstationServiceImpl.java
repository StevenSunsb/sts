package com.example.server.service.impl;

import com.example.server.core.ret.ServiceException;
import com.example.server.core.universal.AbstractService;
import com.example.server.dao.RockBookdetailMapper;
import com.example.server.dao.RockDailyworkstationMapper;
import com.example.server.model.RockBookdetail;
import com.example.server.model.RockDailyworkstation;
import com.example.server.service.RockBookdetailService;
import com.example.server.service.RockDailyworkstationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class RockDailworkstationServiceImpl extends AbstractService<RockDailyworkstation> implements RockDailyworkstationService {
    @Resource
    private RockDailyworkstationMapper rockDailyworkstationMapper;

    @Override
    public List<RockDailyworkstation> selectByDeptidAndShipflagAndDate(String deptid, String date){
        List<RockDailyworkstation> rockDailyworkstations = rockDailyworkstationMapper.selectByDeptidAndShipflagAndDate(deptid,date);
        if(rockDailyworkstations == null){
            throw new ServiceException("无记录");
        }
        return rockDailyworkstations;
    }

    @Override
    public RockDailyworkstation selectByDeptidAndShipflagAndDate(String deptid,String area,String shiftFlag,String date){
        RockDailyworkstation rockDailyworkstation = rockDailyworkstationMapper.selectByDeptidAndShipflagAndDateNew(deptid,area,shiftFlag,date);
        return  rockDailyworkstation;
    }
}
