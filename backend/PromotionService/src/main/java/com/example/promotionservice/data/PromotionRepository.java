package com.example.promotionservice.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface PromotionRepository extends JpaRepository<Promotion, String> {
    @Query(value = "select promotion_id from promotion where code = :code", nativeQuery = true)
    public String getIdByCode(String code);

    @Query(value = "select * from promotion where promotion_id = :id", nativeQuery = true)
    public Promotion getById(String id);


}
