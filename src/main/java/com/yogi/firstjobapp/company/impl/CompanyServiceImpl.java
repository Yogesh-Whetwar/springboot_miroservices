package com.yogi.firstjobapp.company.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yogi.firstjobapp.company.Company;
import com.yogi.firstjobapp.company.CompanyRepo;
import com.yogi.firstjobapp.company.CompanyService;

@Service
public class CompanyServiceImpl  implements CompanyService{
       @Autowired
       CompanyRepo companyRepo;

    @Override
    public List<Company> getAllCompanies() {
         return companyRepo.findAll();
    }

    @Override
    public boolean updateCompany(Company company,Long id) { 
         Optional<Company>c=companyRepo.findById(id);
        if(c.isPresent()){
            Company toUpdate=c.get();
            toUpdate.setDescription(company.getDescription());
            toUpdate.setName(company.getName());
            toUpdate.setJobs(company.getJobs());
            companyRepo.save(toUpdate);
            return true;
        }
        return false;
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'updateCompany'");
    }

    @Override
    public void addCompany(Company company) { 
        companyRepo.save(company);
        
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'addCompany'");
    }

    @Override
    public Company getCompanyById(Long id) {
        Optional<Company>c=companyRepo.findById(id);
        if(c.isPresent()){
            Company toUpdate=c.get();
            return toUpdate;
        }
        return null;
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'getCompanyById'");
    }

    @Override
    public boolean deleteCompanyById(Long id) { 
        Optional<Company>c=companyRepo.findById(id);
        if(c.isPresent()){
            Company toUpdate=c.get();
            companyRepo.delete(toUpdate);
            return true;
        }
        return false;
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'deleteCompanyById'");
    }
    
}
