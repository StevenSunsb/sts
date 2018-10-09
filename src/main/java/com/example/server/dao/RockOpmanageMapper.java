package com.example.server.dao;

import com.example.server.core.universal.Mapper;
import com.example.server.model.RockOpmanage;
import org.apache.ibatis.annotations.Param;

public interface RockOpmanageMapper extends Mapper<RockOpmanage> {
    RockOpmanage selectByDeptId(@Param("deptid") String deptid);
}