package com.lechatong.beakhub.services;

import com.lechatong.beakhub.models.BhJob;
import com.lechatong.beakhub.repositories.BhJobRepository;
import com.lechatong.beakhub.utils.APIResponse;
import com.lechatong.beakhub.utils.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BhJobService {

    @Autowired
    private BhJobRepository repo;

    private APIResponse resp;

    public APIResponse create_job(BhJob bhJob){
        resp = new APIResponse();
        BhJob job = new BhJob();
        try{
            bhJob.setCreatedAt(new Date());
            bhJob.setUpdatdedAt(new Date());
            job = repo.save(bhJob);
            if(repo.existsById(job.getId())){
                resp.setData(job);
                resp.setMessage("Job save with success !");
                resp.setStatus(ResponseCode.SUCCESS);
            }else{
                resp.setData(job);
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

    public APIResponse update_job(BhJob bhJob){
        resp = new APIResponse();
        BhJob job = new BhJob();
        try{
            bhJob.setUpdatdedAt(new Date());
            job = repo.save(bhJob);
            if(repo.existsById(job.getId())){
                resp.setData(job);
                resp.setMessage("Job update with success !");
                resp.setStatus(ResponseCode.SUCCESS);
            }else{
                resp.setData(job);
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

    public APIResponse delete_job(Integer id){
        resp = new APIResponse();
        try{
            if(repo.existsById(id)){
                repo.deleteById(id);
                resp.setData(null);
                resp.setMessage("Job delete with success !");
                resp.setStatus(ResponseCode.SERVER_ERROR);
            }else{
                resp.setData(null);
                resp.setMessage("Job not found !");
                resp.setStatus(ResponseCode.NOT_FOUND);
            }
        }catch(Exception e){
            resp.setData(null);
            resp.setMessage(e.getMessage());
            resp.setStatus(ResponseCode.SERVER_ERROR);
        }
        return resp;
    }

    public APIResponse list_job() {
        resp = new APIResponse();
        List<BhJob> jobs = new ArrayList<BhJob>();

        try{
            jobs = repo.findAll();
            if(!jobs.isEmpty()){
                resp.setData(jobs);
                resp.setStatus(ResponseCode.SUCCESS);
            }else{
                resp.setData(jobs);
                resp.setStatus(ResponseCode.NOT_FOUND);
            }
        }catch(Exception e){
            resp.setData(null);
            resp.setMessage(e.getMessage());
            resp.setStatus(ResponseCode.SERVER_ERROR);
        }
        return resp;
    }

    public APIResponse job_by_id(Integer id) {
        resp = new APIResponse();
        Optional<BhJob> job;

        try{
            job = repo.findById(id);
            if(job != null ){
                resp.setData(job);
                resp.setStatus(ResponseCode.SUCCESS);
            }else{
                resp.setData(job);
                resp.setStatus(ResponseCode.NOT_FOUND);
            }
        }catch(Exception e){
            resp.setData(null);
            resp.setMessage(e.getMessage());
            resp.setStatus(ResponseCode.SERVER_ERROR);
        }
        return resp;
    }

    public APIResponse list_job_by_user_id(Integer user_id) {
        resp = new APIResponse();
        List<BhJob> jobs = new ArrayList<BhJob>();

        try{
            jobs = repo.getBhJobByIdUser(user_id);
            if(!jobs.isEmpty()){
                resp.setData(jobs);
                resp.setStatus(ResponseCode.SUCCESS);
            }else{
                resp.setData(jobs);
                resp.setStatus(ResponseCode.NOT_FOUND);
            }
        }catch(Exception e){
            resp.setData(null);
            resp.setMessage(e.getMessage());
            resp.setStatus(ResponseCode.SERVER_ERROR);
        }
        return resp;
    }

    public APIResponse list_job_by_category_id(Integer category_id) {
        resp = new APIResponse();
        List<BhJob> jobs = new ArrayList<BhJob>();

        try{
            jobs = repo.getBhJobByIdCategory(category_id);
            if(!jobs.isEmpty()){
                resp.setData(jobs);
                resp.setStatus(ResponseCode.SUCCESS);
            }else{
                resp.setData(jobs);
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
