package com.smartphoneshop.services;

import com.smartphoneshop.entity.Cart;
import com.smartphoneshop.filters.AddCartParams;

public interface ICartService {
    Cart getCartByUserId(Integer id);

    void addCartItemToCart(AddCartParams params);

    void buyCartItem(Integer userId , Integer cartItemId);

    void buyListCartItems(Integer userId);



}
