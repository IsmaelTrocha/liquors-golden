package com.liquorsgolden.lq.application.cart;

import com.liquorsgolden.lq.application.customer.FindCustomerByIdApplication;
import com.liquorsgolden.lq.domain.entities.Cart;
import com.liquorsgolden.lq.domain.entities.Customer;
import com.liquorsgolden.lq.domain.services.cart.AddShoppingCartService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AddShoppingCartApplication {

  private final AddShoppingCartService addShoppingCartService;
  private final FindCustomerByIdApplication findCustomerByIdApplication;

  public Cart addShoppingCart(Cart cart) {
    Customer customer = findCustomerByIdApplication.exists(cart.getCustomer().getId());
    cart.setCustomer(customer);
    return addShoppingCartService.addCart(cart);
  }

}
