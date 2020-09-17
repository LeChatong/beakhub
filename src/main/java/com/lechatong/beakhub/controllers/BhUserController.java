package com.lechatong.beakhub.controllers;

import com.lechatong.beakhub.models.BhUser;
import com.lechatong.beakhub.services.BhUserService;
import com.lechatong.beakhub.utils.APIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class BhUserController {

    @Autowired
    private BhUserService service;

    @PostMapping("/save")
    public APIResponse saveUser(@RequestBody BhUser bhUser){ return service.create_user(bhUser); }

    @PutMapping("/update")
    public APIResponse updateUser(@RequestBody BhUser bhUser){ return service.update_user(bhUser); }

    @DeleteMapping("/delete/{id}")
    public APIResponse deleteUSer(@PathVariable Integer id){ return service.delete_user(id); }

    @GetMapping("/{id}")
    public APIResponse getOneUser(@PathVariable Integer id){ return service.user_by_id(id); }

    @GetMapping("/list")
    public APIResponse getAllUser(){
        return service.list_user();
    }
}
