package com.example.server.model;

import javax.persistence.*;

@Table(name = "rock_opcapacityinfo")
public class RockOpcapacityinfo {
    @Id
    private Long id;

    private String date;

    @Column(name = "empName")
    private String empname;

    @Column(name = "empId")
    private String empid;

    private String deptid;

    @Column(name = "shiftFlag")
    private Integer shiftflag;

    private String area;

    private Float daycapacity;



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
     * @return date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date
     */
    public void setDate(String date) {
        this.date = date == null ? null : date.trim();
    }

    /**
     * @return empName
     */
    public String getEmpname() {
        return empname;
    }

    /**
     * @param empname
     */
    public void setEmpname(String empname) {
        this.empname = empname == null ? null : empname.trim();
    }

    /**
     * @return empId
     */
    public String getEmpid() {
        return empid;
    }

    /**
     * @param empid
     */
    public void setEmpid(String empid) {
        this.empid = empid == null ? null : empid.trim();
    }

    /**
     * @return deptid
     */
    public String getDeptid() {
        return deptid;
    }

    /**
     * @param deptid
     */
    public void setDeptid(String deptid) {
        this.deptid = deptid == null ? null : deptid.trim();
    }

    /**
     * @return shiftFlag
     */
    public Integer getShiftflag() {
        return shiftflag;
    }

    /**
     * @param shiftflag
     */
    public void setShiftflag(Integer shiftflag) {
        this.shiftflag = shiftflag;
    }

    /**
     * @return area
     */
    public String getArea() {
        return area;
    }

    /**
     * @param area
     */
    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    /**
     * @return daycapacity
     */
    public Float getDaycapacity() {
        return daycapacity;
    }

    /**
     * @param daycapacity
     */
    public void setDaycapacity(Float daycapacity) {
        this.daycapacity = daycapacity;
    }

    /**
     * @return maxcapacity
     */
}