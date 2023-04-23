package com.amanda.fsms.controller;

import com.amanda.fsms.dao.mapper.CPFollowerDetailMapper;
import com.amanda.fsms.data.CPFollowerDetailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private CPFollowerDetailMapper cpFollowerDetailMapper;
    @GetMapping("/hello")
    public String test(){
        CPFollowerDetailDTO cpFollowerDetailDTO = new CPFollowerDetailDTO();
        cpFollowerDetailDTO.setFollower("123");
        cpFollowerDetailDTO.setCP(1);
        cpFollowerDetailDTO.setArea("123");
        cpFollowerDetailDTO.setId(2);
        cpFollowerDetailDTO.setProblemId("12123");
        cpFollowerDetailDTO.setRiskLevel(1);
        final int i = cpFollowerDetailMapper.insertProblemDetail(cpFollowerDetailDTO);
        return "123";
    }
}
