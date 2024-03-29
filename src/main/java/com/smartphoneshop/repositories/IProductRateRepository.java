package com.smartphoneshop.repositories;

import com.smartphoneshop.entity.ProductRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface IProductRateRepository extends JpaRepository<ProductRate, Integer>, JpaSpecificationExecutor<ProductRate> {
    List<ProductRate> findByProductId(Integer productId);
}
