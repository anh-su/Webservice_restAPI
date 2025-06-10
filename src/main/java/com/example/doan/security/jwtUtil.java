/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.doan.security;

import com.example.doan.dto.LoginResponse;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;
import org.springframework.data.repository.query.QueryLookupStrategy.Key;
import org.springframework.stereotype.Component;
/**
 *
 * @author ADMIN
 */
@Component
public class jwtUtil {

    private final String SECRET_KEY;

    public jwtUtil() {
        // Đọc biến môi trường JWT_SECRET (bạn đã set ở hệ thống)
        SECRET_KEY = System.getenv("JWT_SECRET");
        if (SECRET_KEY == null || SECRET_KEY.isEmpty()) {
            throw new IllegalStateException("JWT_SECRET environment variable not set");
        }
        byte[] decodedKey = Base64.getDecoder().decode(SECRET_KEY);
SecretKey key = Keys.hmacShaKeyFor(decodedKey);
// hien thi key theo môi trường System.out.println("JWT_SECRET = [" + SECRET_KEY + "]");

    }

    public String generateToken(LoginResponse user) {
    Map<String, Object> claims = new HashMap<>();

    claims.put("vaitro", user.getVaitro());
    claims.put("hoten", user.getHoten());
    claims.put("diachi", user.getDiachi());
    claims.put("id", user.getId());
    claims.put("ngaysinh", user.getNgaysinh().toString()); // đổi thành String (ISO date)
    claims.put("email", user.getEmail());
    claims.put("sdt", user.getSdt());
    claims.put("gioitinh", user.getGioitinh());

    return Jwts.builder()
            .setClaims(claims)
            .setSubject(user.getId())  // hoặc username nếu bạn muốn
            .setIssuedAt(new Date(System.currentTimeMillis()))
            .setExpiration(new Date(System.currentTimeMillis() + 3600000)) // 1 giờ
            .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
            .compact();
}

}

