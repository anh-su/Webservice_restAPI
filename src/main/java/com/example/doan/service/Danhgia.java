/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.doan.service;

import com.example.doan.repository.detairepository;
import com.example.doan.repository.detaisinhvienrepository;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ADMIN
 */
@Service
public class Danhgia {
    @Autowired
    private detairepository detaiRepository;

    @Autowired
    private detaisinhvienrepository detaiSinhVienRepository;

    public Map<String, Long> getTopicCounts() {
        List<String> topicNames = detaiRepository.findDistinctTendetai();
        Map<String, Long> topicCounts = new LinkedHashMap<>();

        for (String topic : topicNames) {
            long count = detaiSinhVienRepository.countByTendetai(topic);
            topicCounts.put(topic, count);
        }

        return topicCounts;
    }
}
