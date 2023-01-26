package com.example.reservservice.order.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdercourseRepository extends JpaRepository<Ordercourse,String> {
}
