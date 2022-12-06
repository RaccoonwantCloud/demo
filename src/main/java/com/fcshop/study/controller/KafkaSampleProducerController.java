package com.fcshop.study.controller;

import com.fcshop.study.service.KafkaSampleProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaSampleProducerController {

    @Autowired
    private KafkaSampleProducerService kafkaSampleProducerService;

    @PostMapping("/postMessage")
    public void postMessage(String message){
        System.out.println(message);
        kafkaSampleProducerService.sendMessage(message);
    }

}
