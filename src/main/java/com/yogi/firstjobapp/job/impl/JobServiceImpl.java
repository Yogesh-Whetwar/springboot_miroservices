package com.yogi.firstjobapp.job.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.yogi.firstjobapp.job.Job;
import com.yogi.firstjobapp.job.JobService;

@Service
public class JobServiceImpl implements JobService {
    private List<Job> jobs = new ArrayList<>();

    @Override
    public List<Job> findAll() {
        // TODO Auto-generated method stub
        return jobs;
        // throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public void createJob(Job job) {
        // TODO Auto-generated method stub
        jobs.add(job);
        // throw new UnsupportedOperationException("Unimplemented method 'createJob'");
    }
    
    @Override
    public Job getJobById(Long id) {
         for(Job jb:jobs){
            if(jb.getId()==id){
                return jb;
            }
         }
         return null;
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'getJobById'");
    }

    @Override
    public boolean deleteJobById(Long id) {  
        boolean f=false;
        for(Job jb:jobs){
            if(jb.getId()==id){
                jobs.remove(jb);
                f=true;
                return f;
            }
         }
         return f;
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'deleteJobById'");
    }

    @Override
    public boolean updateJob(Long id, Job jb) {  
        boolean f=false;
        for(Job j:jobs){
            if(j.getId()==id){ 
                j.setTitle(jb.getTitle());
                j.setDescription(jb.getDescription());
                j.setMaxSalary(jb.getMaxSalary());
                j.setMinSalary(jb.getMinSalary());
                j.setLocation(jb.getLocation());
                f=true;
                return f;
            }
         }
         return f;
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'updateJob'");
    }
  
}
