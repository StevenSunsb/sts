package com.example.server.service;

import com.example.server.core.universal.Service;
import com.example.server.model.RockOpmanage;

public interface RockOpmanagerService extends Service<RockOpmanage>{
    RockOpmanage selectByDeptId(String deptid);
}
