package com.lechatong.beakhub.controllers;

import com.lechatong.beakhub.models.BhAccount;
import com.lechatong.beakhub.services.BhAccountService;
import com.lechatong.beakhub.utils.APIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class BhAccountController {

    @Autowired
    private BhAccountService service;

    @PostMapping("/save")
    public APIResponse saveAccount(@RequestBody BhAccount bhAccount){
        return service.create_account(bhAccount);
    }

    @GetMapping("/list")
    public APIResponse getAllAccount(){
        return service.list_account();
    }

    @PutMapping("/update")
    public APIResponse updateAccount(@RequestBody BhAccount bhAccount) { return service.update_account(bhAccount); }

    @DeleteMapping("/delete/{id}")
    public APIResponse deleteAccount(@PathVariable Integer id) { return service.delete_account(id); }

    @GetMapping("/{id}")
    public APIResponse getOneAccount(@PathVariable Integer id) { return service.account_by_id(id); }
}
