package com.yogi.firstjobapp.company;
import java.util.*;
public interface CompanyService {
   List<Company>getAllCompanies();
   boolean updateCompany(Company company,Long id);
   void addCompany(Company company);
   Company getCompanyById(Long id);
   boolean deleteCompanyById(Long id);
}
