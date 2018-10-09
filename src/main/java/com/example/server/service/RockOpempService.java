package com.example.server.service;

import com.example.server.core.universal.Service;
import com.example.server.model.RockOpemp;

public interface RockOpempService extends Service<RockOpemp>{
    //UserInfo selectById(Integer id);
    RockOpemp selectByEmpId(String empid);
}
