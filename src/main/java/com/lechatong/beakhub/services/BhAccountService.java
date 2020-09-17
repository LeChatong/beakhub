package com.lechatong.beakhub.services;

import com.lechatong.beakhub.models.BhAccount;
import com.lechatong.beakhub.repositories.BhAccountRepository;
import com.lechatong.beakhub.utils.APIResponse;
import com.lechatong.beakhub.utils.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BhAccountService {

    @Autowired
    private BhAccountRepository repo;

    APIResponse resp;

    public APIResponse create_account(BhAccount bhAccount){
        resp = new APIResponse();
        BhAccount account = new BhAccount();
        try{
            account = repo.save(bhAccount);
            if(repo.existsById(account.getId())){
                resp.setData(account);
                resp.setMessage("Account save with success !");
                resp.setStatus(ResponseCode.SUCCESS);
            }else{
                resp.setData(account);
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

    public APIResponse update_account(BhAccount bhAccount){
        resp = new APIResponse();
        BhAccount account = new BhAccount();
        try{
            account = repo.save(bhAccount);
            if(repo.existsById(account.getId())){
                resp.setData(account);
                resp.setMessage("Account update with success !");
                resp.setStatus(ResponseCode.SUCCESS);
            }else{
                resp.setData(account);
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

    public APIResponse delete_account(Integer id){
        resp = new APIResponse();
        try{
            if(repo.existsById(id)){
                repo.deleteById(id);
                resp.setData(null);
                resp.setMessage("Account delete with success !");
                resp.setStatus(ResponseCode.SERVER_ERROR);
            }else{
                resp.setData(null);
                resp.setMessage("Account not found !");
                resp.setStatus(ResponseCode.NOT_FOUND);
            }
        }catch(Exception e){
            resp.setData(null);
            resp.setMessage(e.getMessage());
            resp.setStatus(ResponseCode.SERVER_ERROR);
        }
        return resp;
    }

    public APIResponse account_by_id(Integer id) {
        resp = new APIResponse();
        Optional<BhAccount> account;
        try{
            account = repo.findById(id);
            if(account != null ){
                resp.setData(account);
                resp.setStatus(ResponseCode.SUCCESS);
            }else{
                resp.setData(account);
                resp.setStatus(ResponseCode.NOT_FOUND);
            }
        }catch(Exception e){
            resp.setData(null);
            resp.setMessage(e.getMessage());
            resp.setStatus(ResponseCode.SERVER_ERROR);
        }
        return resp;
    }

    public APIResponse list_account(){
        resp = new APIResponse();
        List<BhAccount> accounts = new ArrayList<BhAccount>();
        try{
            accounts = repo.findAll();
            if(!accounts.isEmpty()){
                resp.setData(accounts);
                resp.setStatus(ResponseCode.SUCCESS);
            }else{
                resp.setData(accounts);
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
