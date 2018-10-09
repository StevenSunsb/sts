package com.example.server.controller;

import com.example.server.core.ret.RetResponse;
import com.example.server.core.ret.RetResult;
import com.example.server.model.RockBookdetail;
import com.example.server.model.RockDailyworkstation;
import com.example.server.service.RockBookdetailService;
import com.example.server.service.RockDailyworkstationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("rockDailyworkstation")
@Api(tags={"每日工位管理"},description = "RockDailyworkstationController")
public class RockDailyworkstationController {
    @Resource
    private RockDailyworkstationService rockDailyworkstationService;
    private RockBookdetailService rockBookdetailService;

    @ApiOperation(value = "获取某日工位数量详情",notes = "根据科室和日期查询当日工位数量详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name="deptid",value = "科室id",required = true,dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="date",value = "日期（格式2018-07-07）",required = true,dataType = "String",paramType = "query")
    })
    @GetMapping("/getDailyWorkstation")
    public RetResult<List<RockDailyworkstation>> getDailyWorkstation(String deptid, String date){
        List<RockDailyworkstation> rockDailyworkstations = rockDailyworkstationService.selectByDeptidAndShipflagAndDate(deptid,date);

        if(rockDailyworkstations.size()==0){
            return RetResponse.makeErrRsp("无工位信息！");
        }
        else {
            return RetResponse.makeOKRsp(rockDailyworkstations);
        }
    }
}
