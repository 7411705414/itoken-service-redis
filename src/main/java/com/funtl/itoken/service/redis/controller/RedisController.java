package com.funtl.itoken.service.redis.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.funtl.itoken.service.redis.service.RedisService;

@RestController
public class RedisController {


    @Autowired
    private RedisService redisService ;



    @RequestMapping(value = "put", method = RequestMethod.POST)
    public String put(String key, String value, long seconds){
        redisService.put(key, value, seconds) ;
        return "ok" ;
    }

    @RequestMapping(value = "get", method = RequestMethod.GET)
    public String get(String key){
        Object o = redisService.get(key);

        if (o != null){
            String json = String.valueOf(o) ;
            return json ;
        }
        return null ;
    }


}
