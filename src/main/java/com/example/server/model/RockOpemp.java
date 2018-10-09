package com.example.server.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "rock_opemp")
public class RockOpemp {
    @Id
    private Integer id;

    /**
     * 分厂
     */
    private String factory;

    /**
     * 科室ID
     */
    private Long deptid;

    /**
     * 区域名
     */
    private String area;

    /**
     * 工号
     */
    @Column(name = "empId")
    private String empid;

    /**
     * 姓名
     */
    @Column(name = "empName")
    private String empname;

    /**
     * 密码
     */
    private String password;

    /**
     * 1：一般人员、2：师傅、3：学徒
     */
    @Column(name = "roleFlag")
    private Integer roleflag;

    /**
     * 学徒工号
     */
    @Column(name = "stuId")
    private String stuid;

    /**
     * 学徒开始时间（入职时间）
     */
    @Column(name = "stuStartTime")
    private Date stustarttime;

    /**
     * 学徒结束时间
     */
    @Column(name = "stuEndTime")
    private Date stuendtime;

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
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
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
     * 获取区域名
     *
     * @return area - 区域名
     */
    public String getArea() {
        return area;
    }

    /**
     * 设置区域名
     *
     * @param area 区域名
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
     * 获取姓名
     *
     * @return empName - 姓名
     */
    public String getEmpname() {
        return empname;
    }

    /**
     * 设置姓名
     *
     * @param empname 姓名
     */
    public void setEmpname(String empname) {
        this.empname = empname == null ? null : empname.trim();
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 获取1：一般人员、2：师傅、3：学徒
     *
     * @return roleFlag - 1：一般人员、2：师傅、3：学徒
     */
    public Integer getRoleflag() {
        return roleflag;
    }

    /**
     * 设置1：一般人员、2：师傅、3：学徒
     *
     * @param roleflag 1：一般人员、2：师傅、3：学徒
     */
    public void setRoleflag(Integer roleflag) {
        this.roleflag = roleflag;
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
     * 获取学徒开始时间（入职时间）
     *
     * @return stuStartTime - 学徒开始时间（入职时间）
     */
    public Date getStustarttime() {
        return stustarttime;
    }

    /**
     * 设置学徒开始时间（入职时间）
     *
     * @param stustarttime 学徒开始时间（入职时间）
     */
    public void setStustarttime(Date stustarttime) {
        this.stustarttime = stustarttime;
    }

    /**
     * 获取学徒结束时间
     *
     * @return stuEndTime - 学徒结束时间
     */
    public Date getStuendtime() {
        return stuendtime;
    }

    /**
     * 设置学徒结束时间
     *
     * @param stuendtime 学徒结束时间
     */
    public void setStuendtime(Date stuendtime) {
        this.stuendtime = stuendtime;
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
    
    @Column(name = "birthday")
    private Date birthday;

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
}