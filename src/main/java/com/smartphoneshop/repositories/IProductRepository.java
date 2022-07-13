package com.smartphoneshop.repositories;

import com.smartphoneshop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IProductRepository extends JpaRepository<Product , Integer> , JpaSpecificationExecutor<Product> {

    Product findProductById(Integer id);

    Product findProductByTitle(String title);

    boolean existsProductByTitle(String title);
}
