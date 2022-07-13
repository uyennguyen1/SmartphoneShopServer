package com.smartphoneshop.services.Impl;

import com.smartphoneshop.entity.ProductRates;
import com.smartphoneshop.repositories.IProductRateRepository;
import com.smartphoneshop.services.IProductRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductRateService implements IProductRateService {
    @Autowired
    private IProductRateRepository repository;

    @Override
    public List<ProductRates> getListProductRates(Integer productId) {
        return repository.findByProductId(productId);
    }
}
