package com.example.server.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "rock_bookdetail")
public class RockBookdetail {
    @Id
    @Column(name = "ID")
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
     * 工号
     */
    @Column(name = "empId")
    private String empid;

    public String getEmpName() {
        return empname;
    }

    public void setEmpName(String empname) {
        this.empname = empname;
    }

    /**
     * 姓名
     */
    @Column(name = "empname")
    private String empname;

    /**
     * 学徒工号
     */
    @Column(name = "stuId")
    private String stuid;

    /**
     * 1：白班、2：夜班
     */
    @Column(name = "shiftFlag")
    private Long shiftflag;

    /**
     * 1：上班、2：未上班（默认）
     */
    @Column(name = "workConfirm")
    private Long workconfirm;

    /**
     * 取消原因
     */
    @Column(name = "reasonForCancel")
    private String reasonforcancel;

    /**
     * 取消申请者
     */
    private String applicant;

    /**
     * 1：取消、2：未取消
     */
    @Column(name = "cancelFlag")
    private Long cancelflag;

    /**
     * 确认者
     */
    @Column(name = "confirmPerson")
    private String confirmperson;

    @Column(name = "createUser")
    private String createuser;

    @Column(name = "createTime")
    private Date createtime;

    @Column(name = "updateUser")
    private String updateuser;

    @Column(name = "updateTime")
    private Date updatetime;

    public String getEmpidReplace() {
        return empidReplace;
    }

    public void setEmpidReplace(String empidReplace) {
        this.empidReplace = empidReplace;
    }

    @Column(name = "empidReplace")
    private String empidReplace;

    public int getMonthTotal() {
        return monthTotal;
    }

    public void setMonthTotal(int monthTotal) {
        this.monthTotal = monthTotal;
    }

    private int monthTotal;

    public int getMonthTotalBai() {
        return monthTotalBai;
    }

    public void setMonthTotalBai(int monthTotalBai) {
        this.monthTotalBai = monthTotalBai;
    }

    private int monthTotalBai;

    public int getMonthTotalYe() {
        return monthTotalYe;
    }

    public void setMonthTotalYe(int monthTotalYe) {
        this.monthTotalYe = monthTotalYe;
    }

    private int monthTotalYe;
    /**
     * @return ID
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
     * 获取工号
     *
     * @return empId - 工号
     */
    public String getEmpid() {
        return empid;
    }

    /**
     * 设置工号
     *
     * @param empid 工号
     */
    public void setEmpid(String empid) {
        this.empid = empid == null ? null : empid.trim();
    }

    /**
     * 获取学徒工号
     *
     * @return stuId - 学徒工号
     */
    public String getStuid() {
        return stuid;
    }

    /**
     * 设置学徒工号
     *
     * @param stuid 学徒工号
     */
    public void setStuid(String stuid) {
        this.stuid = stuid == null ? null : stuid.trim();
    }

    /**
     * 获取1：白班、2：夜班
     *
     * @return shiftFlag - 1：白班、2：夜班
     */
    public Long getShiftflag() {
        return shiftflag;
    }

    /**
     * 设置1：白班、2：夜班
     *
     * @param shiftflag 1：白班、2：夜班
     */
    public void setShiftflag(Long shiftflag) {
        this.shiftflag = shiftflag;
    }

    /**
     * 获取1：上班、2：未上班（默认）
     *
     * @return workConfirm - 1：上班、2：未上班（默认）
     */
    public Long getWorkconfirm() {
        return workconfirm;
    }

    /**
     * 设置1：上班、2：未上班（默认）
     *
     * @param workconfirm 1：上班、2：未上班（默认）
     */
    public void setWorkconfirm(Long workconfirm) {
        this.workconfirm = workconfirm;
    }

    /**
     * 获取取消原因
     *
     * @return reasonForCancel - 取消原因
     */
    public String getReasonforcancel() {
        return reasonforcancel;
    }

    /**
     * 设置取消原因
     *
     * @param reasonforcancel 取消原因
     */
    public void setReasonforcancel(String reasonforcancel) {
        this.reasonforcancel = reasonforcancel == null ? null : reasonforcancel.trim();
    }

    /**
     * 获取取消申请者
     *
     * @return applicant - 取消申请者
     */
    public String getApplicant() {
        return applicant;
    }

    /**
     * 设置取消申请者
     *
     * @param applicant 取消申请者
     */
    public void setApplicant(String applicant) {
        this.applicant = applicant == null ? null : applicant.trim();
    }

    /**
     * 获取1：取消、2：未取消
     *
     * @return cancelFlag - 1：取消、2：未取消
     */
    public Long getCancelflag() {
        return cancelflag;
    }

    /**
     * 设置1：取消、2：未取消
     *
     * @param cancelflag 1：取消、2：未取消
     */
    public void setCancelflag(Long cancelflag) {
        this.cancelflag = cancelflag;
    }

    /**
     * 获取确认者
     *
     * @return confirmPerson - 确认者
     */
    public String getConfirmperson() {
        return confirmperson;
    }

    /**
     * 设置确认者
     *
     * @param confirmperson 确认者
     */
    public void setConfirmperson(String confirmperson) {
        this.confirmperson = confirmperson == null ? null : confirmperson.trim();
    }

    /**
     * @return createUser
     */
    public String getCreateuser() {
        return createuser;
    }

    /**
     * @param createuser
     */
    public void setCreateuser(String createuser) {
        this.createuser = createuser == null ? null : createuser.trim();
    }

    /**
     * @return createTime
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * @param createtime
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * @return updateUser
     */
    public String getUpdateuser() {
        return updateuser;
    }

    /**
     * @param updateuser
     */
    public void setUpdateuser(String updateuser) {
        this.updateuser = updateuser == null ? null : updateuser.trim();
    }

    /**
     * @return updateTime
     */
    public Date getUpdatetime() {
        return updatetime;
    }

    /**
     * @param updatetime
     */
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}