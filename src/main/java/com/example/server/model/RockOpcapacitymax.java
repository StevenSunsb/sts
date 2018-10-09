package com.example.server.model;

import javax.persistence.*;

@Table(name = "rock_opcapacitymax")
public class RockOpcapacitymax {
    @Id
    private Long id;

    private String area;

    private Float maxcapacity;

    private Float mincapacity;

    @Column(name = "empId")
    private String empid;

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
     * @return maxcapacity
     */
    public Float getMaxcapacity() {
        return maxcapacity;
    }

    /**
     * @param maxcapacity
     */
    public void setMaxcapacity(Float maxcapacity) {
        this.maxcapacity = maxcapacity;
    }

    /**
     * @return mincapacity
     */
    public Float getMincapacity() {
        return mincapacity;
    }

    /**
     * @param mincapacity
     */
    public void setMincapacity(Float mincapacity) {
        this.mincapacity = mincapacity;
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
        this.empid = empid;
    }
}