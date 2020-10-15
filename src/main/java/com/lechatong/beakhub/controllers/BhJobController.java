package com.lechatong.beakhub.controllers;

import com.lechatong.beakhub.models.BhJob;
import com.lechatong.beakhub.services.BhJobService;
import com.lechatong.beakhub.utils.APIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/job")
public class BhJobController {

    @Autowired
    private BhJobService service;

    @PostMapping("/save")
    public APIResponse saveJob(@RequestBody BhJob bhJob){ return service.create_job(bhJob);}

    @PutMapping("/update")
    public APIResponse updateJob(@RequestBody BhJob bhJob){ return service.update_job(bhJob);}

    @DeleteMapping("/delete")
    public APIResponse deleteJob(@PathVariable Integer id){ return service.delete_job(id);}

    @GetMapping("/{id}")
    public APIResponse getOneJob(@PathVariable Integer id){ return service.job_by_id(id);}

    @GetMapping("/list")
    public APIResponse getAllJob(){ return service.list_job();}

    @GetMapping("/user/{user_id}")
    public APIResponse getAllJobByUserId(@PathVariable Integer user_id){ return service.list_job_by_user_id(user_id);}

    @GetMapping("/category/{category_id}")
    public  APIResponse getAllJobByCategoryId(@PathVariable Integer category_id){ return service.list_job_by_category_id(category_id);}
}
