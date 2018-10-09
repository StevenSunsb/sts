package com.example.server.controller;

import com.example.server.core.ret.RetResponse;
import com.example.server.core.ret.RetResult;
import com.example.server.model.RockOpemp;
import com.example.server.service.RockOpempService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("rockOpemp")
@Api(tags={"用户接口操作"},description = "RockOpempController")
public class RockOpempController {
    @Resource
    private RockOpempService rockOpempService;

    @ApiOperation(value = "登录操作",notes = "输入工号和密码进行登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name="empid",value = "用户ID",required = true,dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="password",value = "用户密码",required = true,dataType = "String",paramType = "query")
    })
    @GetMapping("/login")
    public RetResult<RockOpemp> login(String empid, String password){
        RockOpemp rockOpemp = rockOpempService.selectByEmpId(empid);
        if(rockOpemp.getId().equals(null)){
            return RetResponse.makeErrRsp("未找到该用户！");
        }
        if(rockOpemp.getPassword().equals(password)){
            return RetResponse.makeOKRsp(rockOpemp);
        }
        else {
            return RetResponse.makeErrRsp("密码不正确！");
        }
    }

    @ApiOperation(value = "更改密码",notes = "更改密码")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value = "OpempId（主键，不是工号）",required = true,dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="password",value = "预约人工号",required = true,dataType = "String",paramType = "query")
    })
    @GetMapping("/changePassword")
    public RetResult changePassword(String id,String password){
        RockOpemp rockOpemp = new RockOpemp();
        rockOpemp.setId(Integer.parseInt(id));
        rockOpemp.setPassword(password);
        int rusult = rockOpempService.update(rockOpemp);
        if(rusult==1){
            return RetResponse.makeOKRsp(rusult);
        }
        else {
            return RetResponse.makeErrRsp("变更密码失败！");
        }
    }

    @ApiOperation(value = "通过工号，旧密码更改密码",notes = "更改密码")
    @ApiImplicitParams({
            @ApiImplicitParam(name="empid",value = "工号）",required = true,dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="oldPassword",value = "旧密码",required = true,dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="newPassword",value = "新密码",required = true,dataType = "String",paramType = "query")
    })
    @GetMapping("/changePasswordByEmpid")
    public RetResult changePasswordByEmpid(String empid,String oldPassword,String newPassword){
        RockOpemp rockOpemp = rockOpempService.selectByEmpId(empid);
        if(oldPassword.equals(rockOpemp.getPassword().toString())){
            rockOpemp.setPassword(newPassword);
            int rusult = rockOpempService.update(rockOpemp);
            if(rusult==1){
                return RetResponse.makeOKRsp(rusult);
            }
            else {
                return RetResponse.makeErrRsp("变更密码失败！");
            }
        }else {
            return RetResponse.makeErrRsp("旧密码错误！");
        }
    }
}
