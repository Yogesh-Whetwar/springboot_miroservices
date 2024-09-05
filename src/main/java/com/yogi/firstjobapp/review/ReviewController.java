package com.yogi.firstjobapp.review;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yogi.firstjobapp.review.impl.ReviewServiceImpl;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {
   
@Autowired
private ReviewServiceImpl reviewService;

@GetMapping("/reviews")
public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long companyId){
    return new ResponseEntity<>(reviewService.getAllReviews(companyId),HttpStatus.OK);
}

@PostMapping("/reviews")
public ResponseEntity<String> addReview(@PathVariable Long companyId, @RequestBody Review review){
  boolean isReviewsaved =  reviewService.addReview(companyId, review);
  if(isReviewsaved){
      return new ResponseEntity<>("Review Added Successfully",HttpStatus.OK);
    }else{
      return new ResponseEntity<>("Review Not saved Successfully",HttpStatus.NOT_FOUND);

  }
}  

@GetMapping("/reviews/{reviewId}")
public ResponseEntity<Review> getReview(@PathVariable Long companyId,@PathVariable Long reviewId){
  
    return new ResponseEntity<> (reviewService.getReview(companyId, reviewId),HttpStatus.OK);
}   

@PutMapping("/reviews/{reviewId}")
public ResponseEntity<String> updateReview(@PathVariable Long companyId,@PathVariable Long reviewId,@RequestBody Review review){
   boolean updation=reviewService.updateReview(companyId, reviewId, review);
   if(updation){
    return new ResponseEntity<>("Review Updated Successfully",HttpStatus.OK);
}
return new ResponseEntity<>("Review doesnt Updated",HttpStatus.NOT_FOUND);
}  

@DeleteMapping("/reviews/{reviewId}")
public ResponseEntity<String> deleteReview(@PathVariable Long companyId,@PathVariable Long reviewId){
     boolean deletetion=reviewService.deleteReview(companyId, reviewId);
     if(deletetion){
        return new ResponseEntity<>("Review Deleted Successfully",HttpStatus.OK);
     }
     return new ResponseEntity<>("Review cant be deleted",HttpStatus.NOT_FOUND);
}
}

