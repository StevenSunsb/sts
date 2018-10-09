package com.example.server.controller;

import com.example.server.core.ret.RetResponse;
import com.example.server.core.ret.RetResult;
import com.example.server.model.RockOpemp;
import com.example.server.model.RockOpmanage;
import com.example.server.service.RockOpempService;
import com.example.server.service.RockOpmanagerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("rockOpmanager")
@Api(tags={"各科室预约参数接口操作"},description = "RockOpmanagerController")
public class RockOpmanagerController {
    @Resource
    private RockOpmanagerService rockOpmanagerService;

    @ApiOperation(value = "查询科室预约参数",notes = "通过科室id查询预约参数（提前预约天数）")
    @ApiImplicitParams({
            @ApiImplicitParam(name="deptid",value = "科室id",required = true,dataType = "String",paramType = "query")
    })
    @GetMapping("/getOpmanagerData")
    public RetResult<RockOpmanage> getOpmanagerData(String deptid){
        RockOpmanage rockOpmanage = rockOpmanagerService.selectByDeptId(deptid);
        return RetResponse.makeOKRsp(rockOpmanage);
    }
}
