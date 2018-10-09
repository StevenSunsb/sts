package com.example.server.dao;

import com.example.server.core.universal.Mapper;
import com.example.server.model.RockOpemp;
import org.apache.ibatis.annotations.Param;

public interface RockOpempMapper extends Mapper<RockOpemp> {
    RockOpemp selectByEmpId(@Param("empid") String empid);
}