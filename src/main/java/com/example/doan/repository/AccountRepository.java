/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.doan.repository;

import com.example.doan.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ADMIN
 */
public interface AccountRepository extends JpaRepository<Account, String> {
    boolean existsByIdOrAdminId(String id, String adminId);
}
