package com.yogi.firstjobapp.review;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepo extends JpaRepository<Review,Long> {

    List<Review> findByCompanyId(Long id);
    
}
