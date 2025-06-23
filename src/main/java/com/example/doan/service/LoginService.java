/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.doan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.doan.dto.LoginResponse;
import com.example.doan.repository.LoginRepository;

import java.sql.Date;

/**
 *
 * @author ADMIN
 */
@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

    public LoginResponse checkUser(String username, String password) {
        Object result = loginRepository.findUserByUsernameAndPassword(username, password);
        if (result == null) {
            return null;
        }

        Object[] row = (Object[]) result;

        LoginResponse user = new LoginResponse();
        user.setVaitro(String.valueOf(row[0]));
        user.setHoten(String.valueOf(row[1]));
        user.setDiachi(String.valueOf(row[2]));
        user.setId(String.valueOf(row[3])); // đúng như bạn đã làm
        user.setNgaysinh(row[4] != null ? ((Date) row[4]).toLocalDate() : null);
        user.setEmail(String.valueOf(row[5]));
        user.setSdt(String.valueOf(row[6]));
        user.setGioitinh(String.valueOf(row[7]));

        return user;
    }

}
