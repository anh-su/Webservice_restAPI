/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.doan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.doan.dto.LoginResponse;
import com.example.doan.dto.RegisterRequest;
import com.example.doan.entity.Quanlytk;
import com.example.doan.security.jwtUtil;
import com.example.doan.service.AccountService;
import com.example.doan.service.LoginService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private LoginService loginService;

    @Autowired
    private jwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Quanlytk loginRequest) {
        LoginResponse user = loginService.checkUser(loginRequest.getTendangnhap(), loginRequest.getMatkhau());

        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("message", "Tài khoản hoặc mật khẩu không đúng"));
            
        }

        String token = jwtUtil.generateToken(user);

        Map<String, Object> response = new HashMap<>();
         
        response.put("token", token);
       response.put("user", user);
    

        return ResponseEntity.ok(response);
    }
    
    
      @Autowired
    private AccountService accountService;

    @PostMapping("/register")
    public ResponseEntity<?> registerAdmin(@RequestBody RegisterRequest request) {
        String result = accountService.registerAdmin(request);
        if (result.equals("duplicate")) {
             Map<String, String> error = new HashMap<>();
            error.put("message", "ID_TK hoặc ID_Admin đã tồn tại.");
            return ResponseEntity.ok(error);
        }
       Map<String, String> response = new HashMap<>();
         
       
       response.put("message","Đăng ký thành công");
    

        return ResponseEntity.ok(response);
    }
}

