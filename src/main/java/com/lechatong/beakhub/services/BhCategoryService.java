package com.lechatong.beakhub.services;

import com.lechatong.beakhub.models.BhCategory;
import com.lechatong.beakhub.repositories.BhCategoryRepository;
import com.lechatong.beakhub.utils.APIResponse;
import com.lechatong.beakhub.utils.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BhCategoryService {

    @Autowired
    private BhCategoryRepository repo;

    private APIResponse resp;
    private BhCategory category;
    private List<BhCategory> categories;

    public APIResponse create_category(BhCategory bhCategory){
        resp = new APIResponse();
        category = new BhCategory();
        try{
            category = repo.save(bhCategory);
            if(repo.existsById(category.getId())){
                resp.setData(category);
                resp.setMessage("Category save with success !");
                resp.setStatus(ResponseCode.SUCCESS);
            }else{
                resp.setData(category);
                resp.setMessage("Error Encoured !");
                resp.setStatus(ResponseCode.NOT_FOUND);
            }
        }catch(Exception e){
            resp.setData(null);
            resp.setMessage(e.getMessage());
            resp.setStatus(ResponseCode.SERVER_ERROR);
        }
        return resp;
    }

    public APIResponse update_category(BhCategory bhCategory){
        resp = new APIResponse();
        category = new BhCategory();
        try{
            category = repo.save(bhCategory);
            if(repo.existsById(category.getId())){
                resp.setData(category);
                resp.setMessage("Category update with success !");
                resp.setStatus(ResponseCode.SUCCESS);
            }else{
                resp.setData(category);
                resp.setMessage("Error Encoured !");
                resp.setStatus(ResponseCode.NOT_FOUND);
            }
        }catch(Exception e){
            resp.setData(null);
            resp.setMessage(e.getMessage());
            resp.setStatus(ResponseCode.SERVER_ERROR);
        }
        return resp;
    }

    public APIResponse delete_category(Integer id){
        resp = new APIResponse();
        try{
            if(repo.existsById(id)){
                repo.deleteById(id);
                resp.setData(null);
                resp.setMessage("Category delete with success !");
                resp.setStatus(ResponseCode.SERVER_ERROR);
            }else{
                resp.setData(null);
                resp.setMessage("Category not found !");
                resp.setStatus(ResponseCode.NOT_FOUND);
            }
        }catch(Exception e){
            resp.setData(null);
            resp.setMessage(e.getMessage());
            resp.setStatus(ResponseCode.SERVER_ERROR);
        }
        return resp;
    }

    public APIResponse list_category() {
        resp = new APIResponse();

        categories = new ArrayList<>();

        try{
            categories = repo.findAll(Sort.by(Sort.Direction.ASC, "title"));
            if(!categories.isEmpty()){
                resp.setData(categories);
                resp.setStatus(ResponseCode.SUCCESS);
            }else{
                resp.setData(categories);
                resp.setStatus(ResponseCode.NOT_FOUND);
            }
        }catch(Exception e){
            resp.setData(null);
            resp.setMessage(e.getMessage());
            resp.setStatus(ResponseCode.SERVER_ERROR);
        }
        return resp;
    }

    public APIResponse category_by_id(Integer id) {
        resp = new APIResponse();

        Optional<BhCategory> category;

        try{
            category = repo.findById(id);
            if(category.isPresent()){
                resp.setData(category);
                resp.setStatus(ResponseCode.SUCCESS);
            }else{
                resp.setData(category);
                resp.setStatus(ResponseCode.NOT_FOUND);
            }
        }catch(Exception e){
            resp.setData(null);
            resp.setMessage(e.getMessage());
            resp.setStatus(ResponseCode.SERVER_ERROR);
        }
        return resp;
    }
}
