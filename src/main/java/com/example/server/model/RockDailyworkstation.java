package com.example.server.model;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Table(name = "rock_dailyworkstation")
public class RockDailyworkstation {
    @Id
    private Long id;

    /**
     * 日期
     */
    private Date date;

    /**
     * 分厂
     */
    private String factory;

    /**
     * 科室ID
     */
    private Long deptid;

    /**
     * 区域
     */
    private String area;

    /**
     * 白班工位数
     */
    @Column(name = "dayNumber")
    private Long daynumber;

    /**
     * 夜班工位数
     */
    @Column(name = "nightNumber")
    private Long nightnumber;

    /**
     * 已预约白班工位数
     */
    @Column(name = "bookedDayNumber")
    private Long bookeddaynumber;

    /**
     * 已预约夜班工位数
     */
    @Column(name = "bookedNightNumber")
    private Long bookednightnumber;

    /**
     * 工作内容及注意事项
     */
    @Column(name = "workContent")
    private String workcontent;


    public Date getBookStartTime() {
        return bookStartTime;
    }

    public void setBookStartTime(Date bookStartTime) {
        this.bookStartTime = bookStartTime;
    }

    @Column(name = "bookStartTime")
    private Date bookStartTime;


    public Long getContinuedTime() {
        return continuedTime;
    }

    public void setContinuedTime(Long continuedTime) {
        this.continuedTime = continuedTime;
    }

    @Column(name ="continuedTime")
    private Long continuedTime;
    /**
     * 创建时间
     */
    @Column(name = "createTime")
    private Date createtime;

    /**
     * 创建者
     */
    @Column(name = "createUser")
    private String createuser;

    /**
     * 更新时间
     */
    @Column(name = "updateTime")
    private Date updatetime;

    /**
     * 更新者
     */
    @Column(name = "updateUser")
    private String updateuser;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取日期
     *
     * @return date - 日期
     */
    public Date getDate() {
        return date;
    }

    /**
     * 设置日期
     *
     * @param date 日期
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * 获取分厂
     *
     * @return factory - 分厂
     */
    public String getFactory() {
        return factory;
    }

    /**
     * 设置分厂
     *
     * @param factory 分厂
     */
    public void setFactory(String factory) {
        this.factory = factory == null ? null : factory.trim();
    }

    /**
     * 获取科室ID
     *
     * @return deptid - 科室ID
     */
    public Long getDeptid() {
        return deptid;
    }

    /**
     * 设置科室ID
     *
     * @param deptid 科室ID
     */
    public void setDeptid(Long deptid) {
        this.deptid = deptid;
    }

    /**
     * 获取区域
     *
     * @return area - 区域
     */
    public String getArea() {
        return area;
    }

    /**
     * 设置区域
     *
     * @param area 区域
     */
    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    /**
     * 获取白班工位数
     *
     * @return dayNumber - 白班工位数
     */
    public Long getDaynumber() {
        return daynumber;
    }

    /**
     * 设置白班工位数
     *
     * @param daynumber 白班工位数
     */
    public void setDaynumber(Long daynumber) {
        this.daynumber = daynumber;
    }

    /**
     * 获取夜班工位数
     *
     * @return nightNumber - 夜班工位数
     */
    public Long getNightnumber() {
        return nightnumber;
    }

    /**
     * 设置夜班工位数
     *
     * @param nightnumber 夜班工位数
     */
    public void setNightnumber(Long nightnumber) {
        this.nightnumber = nightnumber;
    }

    /**
     * 获取已预约白班工位数
     *
     * @return bookedDayNumber - 已预约白班工位数
     */
    public Long getBookeddaynumber() {
        return bookeddaynumber;
    }

    /**
     * 设置已预约白班工位数
     *
     * @param bookeddaynumber 已预约白班工位数
     */
    public void setBookeddaynumber(Long bookeddaynumber) {
        this.bookeddaynumber = bookeddaynumber;
    }

    /**
     * 获取已预约夜班工位数
     *
     * @return bookedNightNumber - 已预约夜班工位数
     */
    public Long getBookednightnumber() {
        return bookednightnumber;
    }

    /**
     * 设置已预约夜班工位数
     *
     * @param bookednightnumber 已预约夜班工位数
     */
    public void setBookednightnumber(Long bookednightnumber) {
        this.bookednightnumber = bookednightnumber;
    }

    /**
     * 获取工作内容及注意事项
     *
     * @return workContent - 工作内容及注意事项
     */
    public String getWorkcontent() {
        return workcontent;
    }

    /**
     * 设置工作内容及注意事项
     *
     * @param workcontent 工作内容及注意事项
     */
    public void setWorkcontent(String workcontent) {
        this.workcontent = workcontent == null ? null : workcontent.trim();
    }

    /**
     * 获取创建时间
     *
     * @return createTime - 创建时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置创建时间
     *
     * @param createtime 创建时间
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 获取创建者
     *
     * @return createUser - 创建者
     */
    public String getCreateuser() {
        return createuser;
    }

    /**
     * 设置创建者
     *
     * @param createuser 创建者
     */
    public void setCreateuser(String createuser) {
        this.createuser = createuser == null ? null : createuser.trim();
    }

    /**
     * 获取更新时间
     *
     * @return updateTime - 更新时间
     */
    public Date getUpdatetime() {
        return updatetime;
    }

    /**
     * 设置更新时间
     *
     * @param updatetime 更新时间
     */
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    /**
     * 获取更新者
     *
     * @return updateUser - 更新者
     */
    public String getUpdateuser() {
        return updateuser;
    }

    /**
     * 设置更新者
     *
     * @param updateuser 更新者
     */
    public void setUpdateuser(String updateuser) {
        this.updateuser = updateuser == null ? null : updateuser.trim();
    }
}