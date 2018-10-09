package com.example.server.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "rock_opmanage")
public class RockOpmanage {
    /**
     * 科室ID
     */
    @Id
    private Long deptid;

    private Long id;

    /**
     * 分厂
     */
    private String factory;

    /**
     * 提前预约天数
     */
    @Column(name = "advanceBookingDays")
    private Long advancebookingdays;

    /**
     * 提前结束时间
     */
    @Column(name = "earlyStopTime")
    private Long earlystoptime;

    /**
     * 一周最少上班天数
     */
    @Column(name = "minDaysAWeek")
    private Long mindaysaweek;

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
     * 获取提前预约天数
     *
     * @return advanceBookingDays - 提前预约天数
     */
    public Long getAdvancebookingdays() {
        return advancebookingdays;
    }

    /**
     * 设置提前预约天数
     *
     * @param advancebookingdays 提前预约天数
     */
    public void setAdvancebookingdays(Long advancebookingdays) {
        this.advancebookingdays = advancebookingdays;
    }

    /**
     * 获取提前结束时间
     *
     * @return earlyStopTime - 提前结束时间
     */
    public Long getEarlystoptime() {
        return earlystoptime;
    }

    /**
     * 设置提前结束时间
     *
     * @param earlystoptime 提前结束时间
     */
    public void setEarlystoptime(Long earlystoptime) {
        this.earlystoptime = earlystoptime;
    }

    /**
     * 获取一周最少上班天数
     *
     * @return minDaysAWeek - 一周最少上班天数
     */
    public Long getMindaysaweek() {
        return mindaysaweek;
    }

    /**
     * 设置一周最少上班天数
     *
     * @param mindaysaweek 一周最少上班天数
     */
    public void setMindaysaweek(Long mindaysaweek) {
        this.mindaysaweek = mindaysaweek;
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