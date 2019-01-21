package com.example.demo.controller;



import com.example.demo.mapper.DepartmentMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
public class DeptController {

    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    RestTemplate restTemplate;

    Logger log = LoggerFactory.getLogger(getClass());

    @GetMapping("/dept/{id}")
    public Map<?, ?> getDepartment(@PathVariable("id") Integer id){
        log.info("id:[{}]",id);
        return departmentMapper.getDeptById(id);
    }
    @GetMapping("/")
    public String index(){
        return "account/pc/real_next";
    }
    @PostMapping("/dept/sety")
    public String getTest(Integer id){
        System.out.println(id);
        //System.out.println(ip);
        return "";
    }
    @GetMapping("/dept/test")
    public ResponseEntity getwseTest(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        MultiValueMap<String, Object> map= new LinkedMultiValueMap<String, Object>();
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("ip","kjlllkl");
        map.add("id", "156");
        map.add("ip",objectObjectHashMap);
        HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<MultiValueMap<String, Object>>(map, headers);
        ResponseEntity<Object> responseEntity = restTemplate.postForEntity("http://localhost:8080/dept/sety", request, Object.class);
        return responseEntity;
    }

}
