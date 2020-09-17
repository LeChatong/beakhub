package com.lechatong.beakhub.services;

import com.lechatong.beakhub.models.BhAccount;
import com.lechatong.beakhub.models.BhUser;
import com.lechatong.beakhub.repositories.BhUserRepository;
import com.lechatong.beakhub.utils.APIResponse;
import com.lechatong.beakhub.utils.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BhUserService {

    @Autowired
    private BhUserRepository repo;

    APIResponse resp;

    public APIResponse create_user(BhUser bhUser){

        resp = new APIResponse();

        BhUser user = new BhUser();
        try{
            bhUser.setCreatedAt(new Date());
            bhUser.setUpdatdedAt(new Date());
            user = repo.save(bhUser);
            if(repo.existsById(user.getId())){
                resp.setData(user);
                resp.setMessage("User save with success !");
                resp.setStatus(ResponseCode.SUCCESS);
            }else{
                resp.setData(user);
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

    public APIResponse update_user(BhUser bhUser){
        resp = new APIResponse();
        BhUser user = new BhUser();
        try{
            bhUser.setUpdatdedAt(new Date());
            user = repo.save(bhUser);
            if(repo.existsById(user.getId())){
                resp.setData(user);
                resp.setMessage("User update with success !");
                resp.setStatus(ResponseCode.SUCCESS);
            }else{
                resp.setData(user);
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

    public APIResponse delete_user(Integer id){
        resp = new APIResponse();
        try{
            if(repo.existsById(id)){
                repo.deleteById(id);
                resp.setData(null);
                resp.setMessage("User delete with success !");
                resp.setStatus(ResponseCode.SERVER_ERROR);
            }else{
                resp.setData(null);
                resp.setMessage("User not found !");
                resp.setStatus(ResponseCode.NOT_FOUND);
            }
        }catch(Exception e){
            resp.setData(null);
            resp.setMessage(e.getMessage());
            resp.setStatus(ResponseCode.SERVER_ERROR);
        }
        return resp;
    }

    public APIResponse user_by_id(Integer id) {
        resp = new APIResponse();
        Optional<BhUser> user;
        try{
            user = repo.findById(id);
            if(user.isPresent() ){
                resp.setData(user);
                resp.setStatus(ResponseCode.SUCCESS);
            }else{
                resp.setData(user);
                resp.setStatus(ResponseCode.NOT_FOUND);
            }
        }catch(Exception e){
            resp.setData(null);
            resp.setMessage(e.getMessage());
            resp.setStatus(ResponseCode.SERVER_ERROR);
        }
        return resp;
    }

    public APIResponse list_user(){
        resp = new APIResponse();
        List<BhUser> users = new ArrayList<BhUser>();
        try{
            users = repo.findAll();
            if(!users.isEmpty()){
                resp.setData(users);
                resp.setStatus(ResponseCode.SUCCESS);
            }else{
                resp.setData(users);
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
