package com.yogi.firstjobapp.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yogi.firstjobapp.company.impl.CompanyServiceImpl;

import java.util.*;

@RestController
@RequestMapping("/companies")
public class CompanyController {

 @Autowired
 private CompanyServiceImpl companyService;
    @GetMapping
    public ResponseEntity<List<Company>> getAllCompanies() {
        return new ResponseEntity<>(companyService.getAllCompanies(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable Long id,@RequestBody Company company) {
        boolean f = companyService.updateCompany(company, id);
        if (f) {
            return new ResponseEntity<>("Updated", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<String> addCompany(@RequestBody Company company) {
        companyService.addCompany(company);
        return new ResponseEntity<>("Company added", HttpStatus.OK);
    } 


    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long id){
          Company c=companyService.getCompanyById(id);
          if(c!=null){
            return new ResponseEntity<>(c, HttpStatus.OK);
          } 
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }  


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompanyById(@PathVariable Long id){
          boolean f=companyService.deleteCompanyById(id);
          if(f){
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
          } 
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }  
}
