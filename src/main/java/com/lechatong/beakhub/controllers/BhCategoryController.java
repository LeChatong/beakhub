package com.lechatong.beakhub.controllers;

import com.lechatong.beakhub.models.BhCategory;
import com.lechatong.beakhub.services.BhCategoryService;
import com.lechatong.beakhub.utils.APIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class BhCategoryController {

    @Autowired
    private BhCategoryService service;

    @PostMapping("/save")
    public APIResponse saveCategory(@RequestBody BhCategory bhCategory){ return service.create_category(bhCategory);}

    @PutMapping("/update")
    public APIResponse updateCategory(@RequestBody BhCategory bhCategory){ return service.update_category(bhCategory);}

    @DeleteMapping("/delete")
    public APIResponse deleteCategory(@PathVariable Integer id){ return service.delete_category(id);}

    @GetMapping("/{id}")
    public APIResponse getOneCategory(@PathVariable Integer id){ return service.category_by_id(id);}

    @GetMapping("/list")
    public APIResponse getAllCategory(){ return service.list_category();}
}
