/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.doan.controller;

import com.example.doan.service.Danhgia;
import java.util.Map;
import static org.aspectj.bridge.MessageUtil.error;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author ADMIN
 */
//xem thống kê
@RestController
@RequestMapping("/api/danhgia")
public class DanhgiaController {
     @Autowired
    private Danhgia Danhgia;

    @GetMapping("/topics")
    public ResponseEntity<Map<String, Long>> getTopicData() {
        Map<String, Long> result = Danhgia.getTopicCounts();
        // return ResponseEntity.status(HttpStatus.MULTIPLE_CHOICES).body(result);
         
        return ResponseEntity.ok(result);
    }
}
