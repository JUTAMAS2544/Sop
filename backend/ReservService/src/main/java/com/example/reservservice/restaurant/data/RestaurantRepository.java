package com.example.reservservice.restaurant.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, String> {
    @Query(value = "select * from restaurant where rest_id = :restId", nativeQuery = true)
    public Restaurant readByRestId(String restId);
}
