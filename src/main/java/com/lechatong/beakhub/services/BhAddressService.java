package com.lechatong.beakhub.services;

import com.lechatong.beakhub.models.BhAddress;
import com.lechatong.beakhub.repositories.BhAddressRepository;
import com.lechatong.beakhub.utils.APIResponse;
import com.lechatong.beakhub.utils.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BhAddressService {

    @Autowired
    private BhAddressRepository repo;

    private APIResponse resp;

    private BhAddress address;

    public APIResponse create_address(BhAddress bhAddress){
        resp = new APIResponse();
        address = new BhAddress();
        try{
            bhAddress.setCreatedAt(new Date());
            bhAddress.setUpdatdedAt(new Date());
            address = repo.save(bhAddress);
            if(repo.existsById(address.getId())){
                resp.setData(address);
                resp.setMessage("Address save with success !");
                resp.setStatus(ResponseCode.SUCCESS);
            }else{
                resp.setData(address);
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

    public APIResponse update_address(BhAddress bhAddress){
        resp = new APIResponse();
        address = new BhAddress();
        try{
            bhAddress.setUpdatdedAt(new Date());
            address = repo.save(bhAddress);
            if(repo.existsById(address.getId())){
                resp.setData(address);
                resp.setMessage("Address update with success !");
                resp.setStatus(ResponseCode.SUCCESS);
            }else{
                resp.setData(address);
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

    public APIResponse delete_address_by_id(Integer id){
        resp = new APIResponse();
        try{
            if(repo.existsById(id)){
                repo.deleteById(id);
                resp.setData(null);
                resp.setMessage("Address delete with success !");
                resp.setStatus(ResponseCode.SERVER_ERROR);
            }else{
                resp.setData(null);
                resp.setMessage("Address not found !");
                resp.setStatus(ResponseCode.NOT_FOUND);
            }
        }catch(Exception e){
            resp.setData(null);
            resp.setMessage(e.getMessage());
            resp.setStatus(ResponseCode.SERVER_ERROR);
        }
        return resp;
    }

    public APIResponse address_by_id(Integer id){
        resp = new APIResponse();
        Optional<BhAddress> address;
        try{
            address = repo.findById(id);
            if(address.isPresent() ){
                resp.setData(address);
                resp.setStatus(ResponseCode.SUCCESS);
            }else{
                resp.setData(address);
                resp.setStatus(ResponseCode.NOT_FOUND);
            }
        }catch(Exception e){
            resp.setData(null);
            resp.setMessage(e.getMessage());
            resp.setStatus(ResponseCode.SERVER_ERROR);
        }
        return resp;
    }

    public APIResponse list_address(){
        resp = new APIResponse();
        List<BhAddress> addresses = new ArrayList<BhAddress>();
        try{
            addresses = repo.findAll();
            if(!addresses.isEmpty()){
                resp.setData(addresses);
                resp.setStatus(ResponseCode.SUCCESS);
            }else{
                resp.setData(addresses);
                resp.setStatus(ResponseCode.NOT_FOUND);
            }
        }catch(Exception e){
            resp.setData(null);
            resp.setMessage(e.getMessage());
            resp.setStatus(ResponseCode.SERVER_ERROR);
        }
        return resp;
    }

    public APIResponse list_address_by_job_id(Integer job_id){
        resp = new APIResponse();
        List<BhAddress> addresses = new ArrayList<BhAddress>();
        try{
            addresses = repo.findAllAdressByJobId(job_id);
            if(!addresses.isEmpty()){
                resp.setData(addresses);
                resp.setStatus(ResponseCode.SUCCESS);
            }else{
                resp.setData(addresses);
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
