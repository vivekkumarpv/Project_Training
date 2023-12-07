package com.hypereon.projectservice.feingclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hypereon.projectservice.dto.AccountDto;

@FeignClient(name="AccountService")
public interface AccountService {
    @GetMapping("/api/account/get")
    public AccountDto getAccountById(@RequestParam Long accountId);
}
