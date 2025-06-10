/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.doan.service;

import br.com.thiaguten.umbrella.support.security.BCryptPasswordEncoder;
import com.example.doan.dto.RegisterRequest;
import com.example.doan.entity.Account;
import com.example.doan.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ADMIN
 */
@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;
    
    public String registerAdmin(RegisterRequest request){
        if(accountRepository.existsByIdOrAdminId(request.getId(), request.getAdminId())){
            return "duplicate";
        }
        Account account = new Account();
        account.setId(request.getId());
        account.setUsername(request.getUsername());
        account.setPassword(new BCryptPasswordEncoder().encode(request.getPassword()));
        account.setRole(1); // admin
        account.setAdminId(request.getAdminId());
        account.setStudentId(null);
        account.setTeacherId(null);

        accountRepository.save(account);
        return "success";
    }
}
