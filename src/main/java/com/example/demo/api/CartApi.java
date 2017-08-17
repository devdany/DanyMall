package com.example.demo.api;


import com.example.demo.model.Cart;
import com.example.demo.model.Item;
import com.example.demo.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartApi {


    @Autowired
    CartRepository cartRepository;

    public void addItemIntoCart(Cart cart, Item item){
        cart.addItem(item);
        cartRepository.save(cart);
    }

}
