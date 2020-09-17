package com.lechatong.beakhub.controllers;

import com.lechatong.beakhub.models.BhAddress;
import com.lechatong.beakhub.services.BhAddressService;
import com.lechatong.beakhub.utils.APIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
public class BhAddressController {

    @Autowired
    private BhAddressService service;

    @PostMapping("/save")
    public APIResponse saveAddress(@RequestBody BhAddress bhAddress){return service.create_address(bhAddress);}

    @PutMapping("/update")
    public APIResponse updateAddress(@RequestBody BhAddress bhAddress){ return service.update_address(bhAddress);}

    @DeleteMapping("/delete/{id}")
    public APIResponse deleteAddress(@PathVariable Integer id){ return service.delete_address_by_id(id);}

    @GetMapping("/{id}")
    public APIResponse getOneAddress(@PathVariable Integer id){ return service.address_by_id(id);}

    @GetMapping("/list")
    public APIResponse getAllAddress(){ return service.list_address();}

    @GetMapping("/job/{job_id}")
    public APIResponse getAllAddressByJobId(@PathVariable Integer job_id){ return service.list_address_by_job_id(job_id);}
}
