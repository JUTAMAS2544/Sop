package com.example.reservservice.table.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat, String> {

    @Query(value = "select * from seat where rest_id = :id order by table_no", nativeQuery = true)
    public List<Seat> readByRestId(String id);
}
