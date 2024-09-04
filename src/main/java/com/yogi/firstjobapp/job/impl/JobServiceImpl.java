package com.yogi.firstjobapp.job.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yogi.firstjobapp.job.Job;
import com.yogi.firstjobapp.job.JobRepo;
import com.yogi.firstjobapp.job.JobService;

@Service
public class JobServiceImpl implements JobService {
    // private List<Job> jobs = new ArrayList<>();

    @Autowired
    private JobRepo jobRepo;

    @Override
    public List<Job> findAll() {
        // TODO Auto-generated method stub
        return jobRepo.findAll();
        // throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public void createJob(Job job) {
        // TODO Auto-generated method stub
        jobRepo.save(job);
        // throw new UnsupportedOperationException("Unimplemented method 'createJob'");
    }

    @Override
    public Job getJobById(Long id) {
        Optional<Job> jb = jobRepo.findById(id);
        if (jb.isPresent()) {
            return jb.get();
        }
        return null;
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'getJobById'");
    }

    @Override
    public boolean deleteJobById(Long id) {

        Optional<Job> jb = jobRepo.findById(id);
        if (jb.isPresent()) {
            Job myJob = jb.get();
            jobRepo.delete(myJob);
            return true;
        }
        return false;
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method
        // 'deleteJobById'");
    }

    @Override
    public boolean updateJob(Long id, Job jb) {
        Optional<Job> jb2 = jobRepo.findById(id);
        if (jb2.isPresent()) {
            Job j = jb2.get();
            j.setTitle(jb.getTitle());
            j.setDescription(jb.getDescription());
            j.setMaxSalary(jb.getMaxSalary());
            j.setMinSalary(jb.getMinSalary());
            j.setLocation(jb.getLocation());
            jobRepo.save(j);
            return true;
        }
        return false;
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'updateJob'");
    }

}
