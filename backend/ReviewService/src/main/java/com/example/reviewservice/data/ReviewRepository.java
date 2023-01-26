package com.example.reviewservice.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, String>
{
    @Query(value = "select * from review where rest_id = :restId", nativeQuery = true)
    public List<Review> readByRestId(String restId);

    @Query(value = "select avg(rating) from review where rest_id = :restId", nativeQuery = true)
    public Double readAllRating(String restId);

}
