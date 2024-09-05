package com.yogi.firstjobapp.review.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yogi.firstjobapp.company.Company;
import com.yogi.firstjobapp.company.impl.CompanyServiceImpl;
import com.yogi.firstjobapp.review.Review;
import com.yogi.firstjobapp.review.ReviewRepo;
import com.yogi.firstjobapp.review.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {
  @Autowired
  private ReviewRepo reviewRepo;
 
  @Autowired
  private CompanyServiceImpl companyServiceImpl;
  

  @Override
  public List<Review> getAllReviews(Long id){
     List<Review>reviews=reviewRepo.findByCompanyId(id);
     return reviews;
  }

@Override
public boolean addReview(Long companyId, Review review) { 
    Company company=companyServiceImpl.getCompanyById(companyId);
    if(company!=null){
      review.setCompany(company);
      reviewRepo.save(review);
      return true;
    } 
    return false;
}

@Override
public Review getReview(Long companyId, Long reviewId) {  
  List<Review> reviews =reviewRepo.findByCompanyId(companyId);
  
  return reviews.stream().filter(review->review.getId().equals(reviewId)).findFirst().orElse(null);
  // TODO Auto-generated method stub
  // throw new UnsupportedOperationException("Unimplemented method 'getReview'");
}

@Override
public boolean updateReview(Long companyId, Long reviewId, Review review) {
  List<Review> reviews =reviewRepo.findByCompanyId(companyId);
  if(!reviews.isEmpty()){
    Review r2= reviews.stream().filter(r3->r3.getId().equals(reviewId)).findFirst().orElse(null);
    if(r2!=null){
        r2.setTitle(review.getTitle());
        r2.setDescription(review.getDescription());
        r2.setRating(review.getRating());
        reviewRepo.save(r2);
        return true;
    }
  }
  return false;
}

@Override
public boolean deleteReview(Long companyId, Long reviewId) {  
  List<Review> reviews =reviewRepo.findByCompanyId(companyId);
  if(!reviews.isEmpty()){
    Review r2= reviews.stream().filter(r3->r3.getId().equals(reviewId)).findFirst().orElse(null);
    if(r2!=null){
       
        reviewRepo.delete(r2);
        return true;
    }
  }
  return false;
  // TODO Auto-generated method stub
  // throw new UnsupportedOperationException("Unimplemented method 'deleteReview'");
}
}
