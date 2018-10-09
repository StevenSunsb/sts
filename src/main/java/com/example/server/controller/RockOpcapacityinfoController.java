package com.example.server.controller;

import com.example.server.core.ret.RetResponse;
import com.example.server.core.ret.RetResult;
import com.example.server.model.RockOpcapacityinfo;
import com.example.server.model.RockOpmanage;
import com.example.server.service.RockBookdetailService;
import com.example.server.service.RockOpcapacityinforService;
import com.example.server.service.RockOpmanagerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.*;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("rockOpcapacityinfo")
@Api(tags={"员工产能情况接口"},description = "RockOpcapacityinfoController")
public class RockOpcapacityinfoController {
    private final static Logger LOGGER = LoggerFactory.getLogger(RockOpcapacityinfoController.class);
    @Resource
    private RockOpcapacityinforService rockOpcapacityinforService;

    @ApiOperation(value = "查看员工产能情况（开发中）",notes = "通过科室id查询预约参数（提前预约天数）")
    @ApiImplicitParams({
            @ApiImplicitParam(name="empid",value = "员工工号",required = true,dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="date",value="日期，格式（2018-09-01）",required = true,dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="area",value="工位名称",required = true,dataType = "String",paramType = "query")
    })
    @GetMapping("/getCapacityInfo")
    public RetResult<HashMap> getCapacityInfo(String empid, String date, String area){
        HashMap<String,Object> hashMap = new HashMap<String, Object>();
        RockOpcapacityinfo rockOpcapacityinfo = rockOpcapacityinforService.getCapacityInfo(empid,date,area);
        //RockOpcapacityinfo rockOpcapacityinfoLast = rockOpcapacityinforService.getLastCapacityInfoByEmpidAndArea(empid,area);
        if(rockOpcapacityinfo==null){
            return RetResponse.makeErrRsp("未找到该员工产能信息");
        }else{
            //RockOpcapacitymax rockOpcapacitymax = rockOpcapacitymaxService.getLastCapacityMax(empid,area);
            //rockOpcapacityinfo.setMaxcapacity(rockOpcapacityinfoLast.getMaxcapacity());
            //rockOpcapacityinfo.setMincapacity(rockOpcapacityinfoLast.getMincapacity());
            hashMap.put("dailyInfo",rockOpcapacityinfo);
            //hashMap.put("maxInfo",rockOpcapacitymax);
            //获取最大最低产能
            List<Map<String,Object>> maxResult = rockOpcapacityinforService.getMaxAndMinCapacity(empid,area);
            hashMap.put("maxInfo",maxResult.get(0));
            String year = date.split("-")[0];
            String month = date.split("-")[1];
            ArrayList<String> monthList = new ArrayList<String>(){
                {add("01");add("02");add("03");add("04");add("05");add("06");add("07");add("08");add("09");add("10");add("11");add("12");}
            };
            if(monthList.contains(month)){
                for(int i = monthList.size()-1;i>=0;i--){
                    if(!monthList.get(i).equals(month)){
                        monthList.remove(i);
                    }else {
                        break;
                    }
                }
            }
           //获取每月的信息
            ArrayList<Map<String,Object>> monthInfoList = new ArrayList<>();

            Iterator<String> iterator = monthList.iterator();
            while(iterator.hasNext()) {
                HashMap<String,Object> monthMap = new HashMap<String, Object>();
               String monthdate = year+"-"+iterator.next();
               float monthvalue =  rockOpcapacityinforService.getMonthCapacityInfo(empid,monthdate+"%",area);
                monthMap.put("month",monthdate.split("-")[1]+"月");
                monthMap.put("capacity",monthvalue);
                monthInfoList.add(monthMap);
            }
            hashMap.put("monthInfo",monthInfoList);

            //获取当年的产能信息
            float yearvalue =  rockOpcapacityinforService.getYearCapacityInfo(empid,year+"%",area);
            hashMap.put("yearInfo",yearvalue);
            return RetResponse.makeOKRsp(hashMap);
        }
    }

    @ApiOperation(value = "获取员工最后一笔产能情况",notes = "通过员工工号empid获取员工最后一笔产能情况，用于初始显示")
    @ApiImplicitParams({
            @ApiImplicitParam(name="empid",value = "员工工号",required = true,dataType = "String",paramType = "query")
    })
    @GetMapping("/getLastCapacityInfoByEmpid")
    public RetResult<RockOpcapacityinfo>  getLastCapacityInfoByEmpid(String empid){
        RockOpcapacityinfo rockOpcapacityinfo = rockOpcapacityinforService.getLastCapacityInfoByEmpid(empid);
        if(rockOpcapacityinfo==null){
            return RetResponse.makeErrRsp("未找到该员工产能信息");
        }else{
            return  RetResponse.makeOKRsp(rockOpcapacityinfo);
        }
    }
}
