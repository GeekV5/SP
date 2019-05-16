package com.jnu.sp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/JNU/SP/Rest")
public class RESTfulController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @ResponseBody
    @RequestMapping("/ListAll")
    public List<Map<String,Object>> ListAll(){
        String ExcuteSQL = "select * from jnu_sp_point";
        List<Map<String,Object>> list = jdbcTemplate.queryForList(ExcuteSQL);
        for (Map<String,Object> map:list){
            Set<Map.Entry<String,Object>> entries = map.entrySet();
            if (entries != null){
                Iterator<Map.Entry<String,Object>> iterator = entries.iterator();
                while (iterator.hasNext()){
                    Map.Entry<String,Object> entry = (Map.Entry<String, Object>) iterator.next();
                    Object key = entry.getKey();
                    Object value = entry.getValue();
                    System.out.println(key+":"+value);
                }
            }
        }

        return list;
    }
}
