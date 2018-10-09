package com.example.server.controller;

import com.example.server.core.configurer.WebConfigurer;
import com.example.server.core.ret.RetResponse;
import com.example.server.core.ret.RetResult;
import com.example.server.dao.RockBookdetailMapper;
import com.example.server.dao.RockDailyworkstationMapper;
import com.example.server.model.RockBookdetail;
import com.example.server.model.RockDailyworkstation;
import com.example.server.model.RockOpemp;
import com.example.server.service.RockBookdetailService;
import com.example.server.service.RockDailyworkstationService;
import com.example.server.service.RockOpempService;
import com.sun.javafx.collections.MappingChange;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("rockBookdetail")
@Api(tags={"预约详情操作"},description = "RockBookdetailController")
public class RockBookdetailController {
    private final static Logger LOGGER = LoggerFactory.getLogger(RockBookdetailController.class);
    @Resource
    private RockBookdetailService rockBookdetailService;
    @Resource
    private RockOpempService rockOpempService;
    @Resource
    private RockDailyworkstationService rockDailyworkstationService;
    private RockBookdetailMapper rockBookdetailMapper;
    /**
     * 每周的第一天和最后一天
     * @param dataStr
     * @param dateFormat
     * @param resultDateFormat
     * @return
     * @throws ParseException
     */
    public  String getFirstAndLastOfWeek(String dataStr,String dateFormat,String resultDateFormat) throws ParseException {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new SimpleDateFormat(dateFormat).parse(dataStr));
        int d = 0;
        if (cal.get(Calendar.DAY_OF_WEEK) == 1) {
            d = -6;
        } else {
            d = 2 - cal.get(Calendar.DAY_OF_WEEK);
        }
        cal.add(Calendar.DAY_OF_WEEK, d);
        // 所在周开始日期
        String data1 = new SimpleDateFormat(resultDateFormat).format(cal.getTime());
        cal.add(Calendar.DAY_OF_WEEK, 6);
        // 所在周结束日期
        String data2 = new SimpleDateFormat(resultDateFormat).format(cal.getTime());
        return data1 + "_" + data2;

    }

    @ApiOperation(value = "获取个人某日预约详情",notes = "根据工号和日期查询当日上班记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name="empid",value = "用户工号",required = true,dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="date",value = "日期（格式2018-07-07）",required = true,dataType = "String",paramType = "query")
    })
    @GetMapping("/getBookdetail")
    public RetResult<RockBookdetail> getBookdetail(String empid, String date){
        RockBookdetail rockBookdetail = rockBookdetailService.selectByEmpIdAndDate(empid,date);
        if(rockBookdetail.getId().equals(null)){
            return RetResponse.makeErrRsp("未预约记录！");
        }
        else {
            return RetResponse.makeOKRsp(rockBookdetail);
        }
    }

    @ApiOperation(value = "获取个人某月上班情况汇总",notes = "根据工号和日期查询当月上班汇总记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name="empid",value = "用户工号",required = true,dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="date",value = "日期（格式2018-07-07）",required = true,dataType = "String",paramType = "query")
    })
    @GetMapping("/getBookdetailMonth")
    public RetResult<HashMap> getBookdetailMonth(String empid, String date){
        String newdate = date.substring(0,7)+'%';
        Object o = rockBookdetailService.selectByEmpIdAndDateMonth(empid, newdate);
        Object oB = rockBookdetailService.selectByEmpIdAndDateMonthBai(empid, newdate);
        Object oY = rockBookdetailService.selectByEmpIdAndDateMonthYe(empid, newdate);
        HashMap<String,Object> hashMap = new HashMap<String, Object>();
        hashMap.put("monthAll",o.toString());
        hashMap.put("monthBai",oB.toString());
        hashMap.put("monthYe",oY.toString());
        return RetResponse.makeOKRsp(hashMap);
    }

    @ApiOperation(value = "获取个人某月上班情况详情",notes = "根据工号和日期查询当月上班详情记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name="empid",value = "用户工号",required = true,dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="date",value = "日期（格式2018-07-07）",required = true,dataType = "String",paramType = "query")
    })
    @GetMapping("/getBookdetailMonthDetail")
    public RetResult<List<RockBookdetail>> getBookdetailMonthDetail(String empid, String date){
        String newdate = date.substring(0,7)+'%';
        List<RockBookdetail> bookdetailList = rockBookdetailService.selectByEmpIdAndDateMonthDetail(empid,newdate);
        if(bookdetailList.size()==0){
            return RetResponse.makeErrRsp("无预约记录！");
        }
        else {
            return RetResponse.makeOKRsp(bookdetailList);
        }
    }

    @ApiOperation(value = "获取某天某班次所有预约情况详情",notes = "根据科室号和日期查询当天所有上班详情记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name="deptid",value = "科室号",required = true,dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="area",value = "区域",required = true,dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="date",value = "日期（格式2018-07-07）",required = true,dataType = "String",paramType = "query")
    })
    @GetMapping("/getBookdetailDay")
    public RetResult<List<RockBookdetail>> getBookdetailDay(String deptid,String area, String date){
        List<RockBookdetail> bookdetailList = rockBookdetailService.selectByDeptIdAndAreaAndDateDay(deptid,area,date);
        if(bookdetailList.size()==0){
            return RetResponse.makeErrRsp("无预约记录！");
        }
        else {
            return RetResponse.makeOKRsp(bookdetailList);
        }
    }

    @ApiOperation(value = "获取某天某班次(区分白班夜班)所有预约情况详情",notes = "根据科室号和日期查询当天(区分白班夜班)所有上班详情记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name="deptid",value = "科室号",required = true,dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="area",value = "区域",required = true,dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="shiftFlag",value = "白夜班标志（白：1，夜：2）",required = true,dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="date",value = "日期（格式2018-07-07）",required = true,dataType = "String",paramType = "query")
    })
    @GetMapping("/getBookdetailDayWithShiftflag")
    public RetResult<List<RockBookdetail>> getBookdetailDayWithShiftflag(String deptid,String area,String shiftFlag,String date){
        List<RockBookdetail> bookdetailList = rockBookdetailService.selectByDeptIdAndAreaAndDateAndShiftflagDay(deptid,area,shiftFlag,date);
        if(bookdetailList.size()==0){
            return RetResponse.makeErrRsp("无预约记录！");
        }
        else {
            return RetResponse.makeOKRsp(bookdetailList);
        }
    }

    @ApiOperation(value = "获取个人某周上班情况汇总",notes = "根据工号和日期查询当周上班汇总记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name="empid",value = "用户工号",required = true,dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="date",value = "日期（格式2018-07-07）",required = true,dataType = "String",paramType = "query")
    })
    @GetMapping("/getBookdetailWeek")
    public RetResult<HashMap> getBookdetailWeek(String empid, String date){
        String week = "";
        try {
             week = getFirstAndLastOfWeek(date,"yyyy-MM-dd","yyyy-MM-dd");
        }catch (Exception e){

        }
        if(week.length()>1){
            String startdate = week.split("_")[0];
            String enddate = week.split("_")[1];
            Object o = rockBookdetailService.selectByEmpIdAndDateWeek(empid, startdate,enddate);
            HashMap<String,Object> hashMap = new HashMap<String, Object>();
            hashMap.put("weekTotal",o.toString());
            return RetResponse.makeOKRsp(hashMap);
        }
        else {
            return  RetResponse.makeErrRsp("内部错误");
        }
    }

    @ApiOperation(value = "获取个人未来上班情况",notes = "根据工号查询未来预约记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name="empid",value = "用户工号",required = true,dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="firstDate",value = "开始时间",required = true,dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="lastDate",value = "结束时间",required = true,dataType = "String",paramType = "query")
    })
    @GetMapping("/getBookdetailBetween")
    public RetResult<List<RockBookdetail>> getBookdetailBetween(String empid,String firstDate,String lastDate){
        List<RockBookdetail> rockBookdetails = rockBookdetailService.selectByEmpIdAndFirstAndLast(empid,firstDate,lastDate);
        if(rockBookdetails !=null){
            return RetResponse.makeOKRsp(rockBookdetails);
        }
        else {
            return  RetResponse.makeErrRsp("无预约记录");
        }
    }

    @ApiOperation(value = "获取个人某个时间段的上班情况",notes = "根据工号和起止时间查询某段时间预约记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name="empid",value = "用户工号",required = true,dataType = "String",paramType = "query")
    })
    @GetMapping("/getReserveFuture")
    public RetResult<List<RockBookdetail>> getReserveFuture(String empid){
        List<RockBookdetail> rockBookdetails = rockBookdetailService.selectFutureByEmpId(empid);
        if(rockBookdetails !=null){
            return RetResponse.makeOKRsp(rockBookdetails);
        }
        else {
            return  RetResponse.makeErrRsp("无预约记录");
        }
    }


    @ApiOperation(value = "取消预约",notes = "根据预约记录ID取消预约")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value = "预约记录id",required = true,dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="reasonForCancel",value = "取消预约原因",required = true,dataType = "String",paramType = "query")
    })
    @GetMapping("/cancelReserveById")
    public RetResult cancelReserveById(String id,String reasonForCancel){

        int result = rockBookdetailService.cancelReserveById(id,reasonForCancel);

        if(result==1){
            return RetResponse.makeOKRsp(result);
        }
        else {
            return  RetResponse.makeErrRsp("取消预约失败");
        }
    }

    @ApiOperation(value = "有替班员工取消预约",notes = "根据预约记录ID取消预约，带有替班员工")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value = "预约记录id",required = true,dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="reasonForCancel",value = "取消预约原因",required = true,dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="empidReplace",value = "替班员工工号",required = true,dataType = "String",paramType = "query")
    })
    @GetMapping("/cancelReserveByIdReplace")
    public RetResult cancelReserveByIdReplace(String id,String reasonForCancel,String empidReplace){
        RockBookdetail rockBookdetail = rockBookdetailService.selectById(id);
        RockOpemp rockOpempReplace = rockOpempService.selectByEmpId(empidReplace);
        if(rockOpempReplace ==null){
            return  RetResponse.makeErrRsp("未查询到该员工信息！");
        }
        if(rockOpempReplace.getRoleflag()==3){
            return  RetResponse.makeErrRsp("替班员工尚处于学徒期！");
        }
        ////check area
        if(!rockOpempReplace.getArea().contains(rockBookdetail.getArea())){
            return  RetResponse.makeErrRsp("替班员工不具备预约岗位的操作权限！");
        }
        //check already reserved
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(rockBookdetail.getDate());
        try {
            RockBookdetail rockBookdetailToday = rockBookdetailService.selectByEmpIdAndDate(empidReplace,dateString);
            if(rockBookdetailToday!=null){
                return  RetResponse.makeErrRsp("替班员工当天已经预约，无法再预约！");
            }
        }
        catch (Exception e){

        }

        int result = rockBookdetailService.cancelReserveByIdReplace(id,reasonForCancel,empidReplace);

        if(result==1){
            return RetResponse.makeOKRsp(result);
        }
        else {
            return  RetResponse.makeErrRsp("取消预约失败");
        }
    }

    @ApiOperation(value = "预约",notes = "预约")
    @ApiImplicitParams({
            @ApiImplicitParam(name="date",value = "预约日期（格式 2018-07-03）",required = true,dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="empid",value = "预约人工号",required = true,dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="area",value = "预约区域",required = true,dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="stuid",value = "徒弟工号（若是普通员工或师傅独自上班则为空）",required = false,dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="shiftflag",value = "白夜班标记（白班为1，夜班为2）",required = true,dataType = "String",paramType = "query")
    })
    @GetMapping("/reserve")
    public synchronized RetResult reserve(String date,String empid,String area,String stuid,String shiftflag){
        LOGGER.info("*********************************************************************************");
        LOGGER.info("======预约请求参数：date-"+date+"|empid-"+empid+"|area-"+area+"|stuid-"+stuid+"|shiftflag-"+shiftflag+"=========");
        RockOpemp opempShifu = rockOpempService.selectByEmpId(empid);
        LOGGER.info("======1.人员信息获取成功！预约人："+opempShifu.getEmpname());
        //check area
        if(!opempShifu.getArea().contains(area)){
            LOGGER.error("errmsg:您不具备预约工位："+area+" 的操作权限，若有疑问请联系科室管理员。");
            return  RetResponse.makeErrRsp("您不具备预约工位："+area+" 的操作权限，若有疑问请联系科室管理员。");
        }
        LOGGER.info("======2.工位权限验证通过！");
        //check already reserved
        try {
            RockBookdetail rockBookdetailToday = rockBookdetailService.selectByEmpIdAndDate(empid,date);
            if(rockBookdetailToday!=null){
                LOGGER.error("errmsg:您今天已经预约，无法再预约！");
                return  RetResponse.makeErrRsp("您今天已经预约，无法再预约！");
            }
        }
        catch (Exception e){

        }
        LOGGER.info("======3.当天尚未预约验证通过！");

        //check ye zhuan bai
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date dateDate = null;
        Calendar calendar = new GregorianCalendar();
        try {
            dateDate = format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(shiftflag.equals("1")){
            calendar.setTime(dateDate);
            calendar.add(calendar.DATE,-1);
            Date yesterday=calendar.getTime();
            String yesterdayStr =formatter.format(yesterday);
            try {
                RockBookdetail rockBookdetailYesterday = rockBookdetailService.selectByEmpIdAndDate(empid,yesterdayStr);
                if(rockBookdetailYesterday.getShiftflag()==2){
                    LOGGER.error("errmsg:预约日期的前一天为夜班，无法继续预约白班！");
                    return  RetResponse.makeErrRsp("预约日期的前一天为夜班，无法继续预约白班！");
                }
            }
            catch (Exception e){
            }
        }
        LOGGER.info("======4.夜班转白班验证通过！");
        //check over 6 days for work
        calendar.setTime(dateDate);
        calendar.add(calendar.DATE,-1);
        Date yesterday=calendar.getTime();
        String yesterdayStr =formatter.format(yesterday);
        calendar.add(calendar.DATE,-5);
        Date beginDay=calendar.getTime();
        String beginDayStr =formatter.format(beginDay);
        //Cell,CF分厂取消连续预约六天的限制
       /* if(opempShifu.getDeptid()!=409 && opempShifu.getDeptid() != 410 && opempShifu.getDeptid() != 132){
            try {
                List<RockBookdetail> rockBookdetailPastSix = rockBookdetailService.selectByEmpIdAndFirstAndLast(empid,beginDayStr,yesterdayStr);
                if(rockBookdetailPastSix.size()==6){
                    LOGGER.error("errmsg:你已连续预约六天班次，无法再预约，请注意休息！");
                    return  RetResponse.makeErrRsp("你已连续预约六天班次，无法再预约，请注意休息！");
                }
                LOGGER.info("======5.连续6天上班验证通过！");
            }
            catch (Exception e){
            }
        }
        else {
            LOGGER.info("======5.Cell分厂取消连续6天上班验证！科室id="+opempShifu.getDeptid().toString());
        }*/
        //check workstation count

        try {
            RockDailyworkstation rockDailyworkstation = rockDailyworkstationService.selectByDeptidAndShipflagAndDate(opempShifu.getDeptid().toString(),area,shiftflag,date);
            if(shiftflag.equals("1")){
                if(rockDailyworkstation.getBookeddaynumber()==rockDailyworkstation.getDaynumber()){
                    LOGGER.error("errmsg:目标工位已满，请尝试其他工位或时间！");
                    return  RetResponse.makeErrRsp("目标工位已满，请尝试其他工位或时间！");
                }
                LOGGER.info("======6.工位数量验证通过！日期："+date+" 白班 工位："+area+" 总数量："+rockDailyworkstation.getDaynumber()+" 已预约数量："+ rockDailyworkstation.getBookeddaynumber()+" ");
            }else{
                if(rockDailyworkstation.getBookednightnumber()==rockDailyworkstation.getNightnumber()){
                    LOGGER.error("errmsg:目标工位已满，请尝试其他工位或时间！");
                    return  RetResponse.makeErrRsp("目标工位已满，请尝试其他工位或时间！");
                }
                LOGGER.info("======6.工位数量验证通过！日期："+date+" 夜班 工位："+area+" 总数量："+rockDailyworkstation.getNightnumber()+" 已预约数量："+ rockDailyworkstation.getBookednightnumber()+" ");
            }

            //check reserve time
            if( rockDailyworkstation.getBookStartTime()!=null){
                Date beignTime = rockDailyworkstation.getBookStartTime();
                SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String beignTimeStr =formatter1.format(beignTime);
                Long continuedTime = rockDailyworkstation.getContinuedTime();
                if(continuedTime==0){
                    //不限制结束时间
                    Date now = new Date();
                    if(now.getTime()<beignTime.getTime()){
                        LOGGER.error("errmsg:尚未到该天班次开放时间！开放时间为"+beignTimeStr);
                        return  RetResponse.makeErrRsp("尚未到该天班次开放时间！开放时间为"+beignTimeStr);
                    }
                }else{

                    Date now = new Date();
                    calendar.setTime(beignTime);
                    calendar.add(Calendar.HOUR_OF_DAY, continuedTime.intValue());
                    Date endTime = calendar.getTime();
                    String endTimeStr =formatter1.format(endTime);
                    if(now.getTime()<beignTime.getTime()){
                        LOGGER.error("errmsg:尚未到该天班次开放时间！开放时间为"+beignTimeStr);
                        return  RetResponse.makeErrRsp("尚未到该天班次开放时间！开放时间为"+beignTimeStr);
                    }
                    if(now.getTime()>endTime.getTime()){
                        LOGGER.error("errmsg:已超该天班次预约结束日期！结束时间为"+endTimeStr);
                        return  RetResponse.makeErrRsp("已超该天班次预约结束日期！结束时间为"+endTimeStr);
                    }
                }
            }
        }
        catch (Exception e){
            LOGGER.error("errmsg:"+e.getMessage());
            return  RetResponse.makeErrRsp(e.getMessage());
        }
        LOGGER.info("======7.预约开始时间验证通过！");
        RockBookdetail rockBookdetail= new RockBookdetail();

        rockBookdetail.setDate(dateDate);
        rockBookdetail.setFactory(opempShifu.getFactory());
        rockBookdetail.setDeptid(opempShifu.getDeptid());
        rockBookdetail.setArea(area);
        rockBookdetail.setEmpName(opempShifu.getEmpname());
        rockBookdetail.setEmpid(opempShifu.getEmpid());
        rockBookdetail.setStuid(stuid);
        rockBookdetail.setShiftflag(Long.valueOf(shiftflag));
        rockBookdetail.setWorkconfirm((long)1);
        rockBookdetail.setCancelflag((long)2);
        rockBookdetail.setCreateuser(opempShifu.getEmpname());
        rockBookdetail.setCreatetime(new Date());
        int result = rockBookdetailService.insert(rockBookdetail);

        if(result==1){
            RockDailyworkstation rockDailyworkstation = rockDailyworkstationService.selectByDeptidAndShipflagAndDate(opempShifu.getDeptid().toString(),area,shiftflag,date);
            if(shiftflag.equals("1")){
                long bookedDay = rockDailyworkstation.getBookeddaynumber();
                bookedDay = bookedDay+1;
                rockDailyworkstation.setBookeddaynumber(bookedDay);
                int resultOfDailyWork = rockDailyworkstationService.update(rockDailyworkstation);
                LOGGER.info("======8.工位数量更新成功！当前工位数量："+bookedDay);
                if(stuid != null){
                    if(!stuid.equals("")){
                        RockOpemp rockOpempTudi = rockOpempService.selectByEmpId(stuid);
                        RockBookdetail rockBookdetailTudi= new RockBookdetail();

                        rockBookdetailTudi.setDate(dateDate);
                        rockBookdetailTudi.setFactory(opempShifu.getFactory());
                        rockBookdetailTudi.setDeptid(opempShifu.getDeptid());
                        rockBookdetailTudi.setArea(area);
                        rockBookdetailTudi.setEmpName(rockOpempTudi.getEmpname());
                        rockBookdetailTudi.setEmpid(rockOpempTudi.getEmpid());
                        rockBookdetailTudi.setShiftflag(Long.valueOf(shiftflag));
                        rockBookdetailTudi.setWorkconfirm((long)1);
                        rockBookdetailTudi.setCancelflag((long)2);
                        rockBookdetailTudi.setCreateuser(opempShifu.getEmpname());
                        rockBookdetailTudi.setCreatetime(new Date());
                        int resultTudi = rockBookdetailService.insert(rockBookdetailTudi);
                        LOGGER.info("======8.5.徒弟预约成功："+rockOpempTudi.getEmpname()+"|"+rockOpempTudi.getEmpid().toString());
                    }
                }
            }else {
                long bookedNight = rockDailyworkstation.getBookednightnumber();
                bookedNight = bookedNight+1;
                rockDailyworkstation.setBookednightnumber(bookedNight);
                int resultOfDailyWork = rockDailyworkstationService.update(rockDailyworkstation);
                LOGGER.info("======8.工位数量更新成功！当前已预约工位数量："+bookedNight);
                if(stuid != null ){
                    if(!stuid.equals("")){
                        RockOpemp rockOpempTudi = rockOpempService.selectByEmpId(stuid);
                        RockBookdetail rockBookdetailTudi= new RockBookdetail();

                        rockBookdetailTudi.setDate(dateDate);
                        rockBookdetailTudi.setFactory(opempShifu.getFactory());
                        rockBookdetailTudi.setDeptid(opempShifu.getDeptid());
                        rockBookdetailTudi.setArea(area);
                        rockBookdetailTudi.setEmpName(rockOpempTudi.getEmpname());
                        rockBookdetailTudi.setEmpid(rockOpempTudi.getEmpid());
                        rockBookdetailTudi.setShiftflag(Long.valueOf(shiftflag));
                        rockBookdetailTudi.setWorkconfirm((long)1);
                        rockBookdetailTudi.setCancelflag((long)2);
                        rockBookdetailTudi.setCreateuser(opempShifu.getEmpname());
                        rockBookdetailTudi.setCreatetime(new Date());
                        int resultTudi = rockBookdetailService.insert(rockBookdetailTudi);
                        LOGGER.info("======8.5.徒弟预约成功："+rockOpempTudi.getEmpname()+"|"+rockOpempTudi.getEmpid().toString());
                    }
                }
            }
            LOGGER.info("======9.预约成功");
            return RetResponse.makeOKRsp(result);
        }
        else {
            LOGGER.error("errmsg:预约信息插入失败！");
            return  RetResponse.makeErrRsp("预约失败");
        }
    }
}
