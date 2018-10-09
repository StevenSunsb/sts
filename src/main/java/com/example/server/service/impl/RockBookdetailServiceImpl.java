package com.example.server.service.impl;

import com.example.server.core.ret.ServiceException;
import com.example.server.core.universal.AbstractService;
import com.example.server.dao.RockBookdetailMapper;
import com.example.server.dao.RockDailyworkstationMapper;
import com.example.server.model.RockBookdetail;
import com.example.server.model.RockDailyworkstation;
import com.example.server.service.RockBookdetailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

@Service
public class RockBookdetailServiceImpl extends AbstractService<RockBookdetail> implements RockBookdetailService {
    @Resource
    private RockBookdetailMapper rockBookdetailMapper;
    @Resource
    private RockDailyworkstationMapper rockDailyworkstationMapper;

    @Override
    public RockBookdetail selectByEmpIdAndDate(String empid,String date){
        RockBookdetail rockBookdetail = rockBookdetailMapper.selectByEmpIdAndDate(empid,date);
        if(rockBookdetail == null){
            throw new ServiceException("无上班记录");
        }
        return rockBookdetail;
    }

    @Override
    public Object selectByEmpIdAndDateMonth(String empid, String date){
        List<Map<String,Object>> result = null;
        result = rockBookdetailMapper.selectByEmpIdAndDateMonth(empid,date);
        if(result == null){
            throw new ServiceException("无上班记录");
        }
        return result.get(0).get("monthtotal");
    }

    @Override
    public Object selectByEmpIdAndDateMonthBai(String empid, String date){
        List<Map<String,Object>> result = null;
        result = rockBookdetailMapper.selectByEmpIdAndDateMonthBai(empid,date);
        if(result == null){
            throw new ServiceException("无上班记录");
        }
        return result.get(0).get("monthtotalbai");
    }

    @Override
    public Object selectByEmpIdAndDateMonthYe(String empid, String date){
        List<Map<String,Object>> result = null;
        result = rockBookdetailMapper.selectByEmpIdAndDateMonthYe(empid,date);
        if(result == null){
            throw new ServiceException("无上班记录");
        }
        return result.get(0).get("monthtotalye");
    }

    @Override
    public  Object selectByEmpIdAndDateWeek(String empid,String startdate,String enddate){
        List<Map<String,Object>> result = null;
        result = rockBookdetailMapper.selectByEmpIdAndDateWeek(empid,startdate,enddate);
        if(result == null){
            throw new ServiceException("无上班记录");
        }
        return result.get(0).get("weektotal");
    }

    @Override
    public List<RockBookdetail> selectByEmpIdAndDateMonthDetail(String empid, String date){
        List<RockBookdetail> rockBookdetails = rockBookdetailMapper.selectByEmpIdAndDateMonthDetail(empid,date);
        if(rockBookdetails == null){
            throw new ServiceException("无预约记录");
        }
        return rockBookdetails;
    }

    @Override
    public List<RockBookdetail> selectByDeptIdAndAreaAndDateDay(String deptid,String area,String date){
        List<RockBookdetail> rockBookdetails = rockBookdetailMapper.selectByDeptIdAndAreaAndDateDay(deptid,area,date);
        if(rockBookdetails==null){
            throw new ServiceException("无预约记录");
        }
        return rockBookdetails;
    }

    @Override
    public  List<RockBookdetail> selectByDeptIdAndAreaAndDateAndShiftflagDay(String deptid,String area,String shiftFlag,String date){
        List<RockBookdetail> rockBookdetails = rockBookdetailMapper.selectByDeptIdAndAreaAndDateAndShiftflagDay(deptid,area,shiftFlag,date);
        if(rockBookdetails==null){
            throw new ServiceException("无预约记录");
        }
        return rockBookdetails;
    }

    @Override
    public List<RockBookdetail> selectFutureByEmpId(String empid){
        List<RockBookdetail> rockBookdetails = rockBookdetailMapper.selectFutureByEmpId(empid);
        if(rockBookdetails==null){
            throw new ServiceException("无预约记录");
        }
        return rockBookdetails;
    }

    @Override
    public int cancelReserveById(String id,String reasonForCancel){

        RockBookdetail rockBookdetail = new RockBookdetail();
        rockBookdetail.setId(Long.parseLong(id));
        RockBookdetail rockBookdetailInfo = rockBookdetailMapper.selectByPrimaryKey(rockBookdetail);

        //check 12h


        //Cell取消预约审批，其他照旧  取消此逻辑  2018.08.02
        if(rockBookdetailInfo.getDeptid()==999999){
            rockBookdetail.setCancelflag((long)1);
            //释放工位
            String deptid_this =  rockBookdetailInfo.getDeptid().toString();
            String shiftFlag_this = rockBookdetailInfo.getShiftflag().toString();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String date_this =formatter.format(rockBookdetailInfo.getDate());
            RockDailyworkstation rockDailyworkstation = rockDailyworkstationMapper.selectByDeptidAndShipflagAndDateNew(deptid_this,rockBookdetailInfo.getArea(),shiftFlag_this,date_this);
            if(shiftFlag_this.equals("1")){
                long temp = rockDailyworkstation.getBookeddaynumber()-1;
                rockDailyworkstation.setBookeddaynumber(temp);
                int result = rockDailyworkstationMapper.updateByPrimaryKeySelective(rockDailyworkstation);
            }else {
                long temp = rockDailyworkstation.getBookednightnumber()-1;
                rockDailyworkstation.setBookednightnumber(temp);
                int result = rockDailyworkstationMapper.updateByPrimaryKeySelective(rockDailyworkstation);
            }
        }
        else{
            rockBookdetail.setCancelflag((long)3);
        }
        rockBookdetail.setReasonforcancel(reasonForCancel);
        int result = rockBookdetailMapper.updateByPrimaryKeySelective(rockBookdetail);
        return result;
    }

    @Override
    public int cancelReserveByIdReplace(String id,String reasonForCancel,String empidReplace){
        RockBookdetail rockBookdetail = new RockBookdetail();
        rockBookdetail.setId(Long.parseLong(id));
        rockBookdetail.setCancelflag((long)3);
        rockBookdetail.setEmpidReplace(empidReplace);
        rockBookdetail.setReasonforcancel(reasonForCancel);
        int result = rockBookdetailMapper.updateByPrimaryKeySelective(rockBookdetail);
        return result;
    }

    @Override
    public List<RockBookdetail> selectByEmpIdAndFirstAndLast(String empid,String firstDate,String lastDate){
        List<RockBookdetail> rockBookdetails = rockBookdetailMapper.selectByEmpIdAndFirstAndLast(empid,firstDate,lastDate);
        if(rockBookdetails==null){
            throw new ServiceException("无预约记录");
        }
        return rockBookdetails;
    }
}
