package com.example.ecommerce.controllers;


import com.example.ecommerce.exception.ItemNotFoundException;
import com.example.ecommerce.exception.UsernameNotFoundException;
import com.example.ecommerce.model.persistence.Cart;
import com.example.ecommerce.model.persistence.Item;
import com.example.ecommerce.model.persistence.User;
import com.example.ecommerce.model.persistence.repositories.CartRepository;
import com.example.ecommerce.model.persistence.repositories.ItemRepository;
import com.example.ecommerce.model.persistence.repositories.UserRepository;
import com.example.ecommerce.model.requests.ModifyCartRequest;
import com.example.ecommerce.util.LogMF;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/api/cart")
public class CartController {

	private static final Logger log = LoggerFactory.getLogger(CartController.class);

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@PostMapping("/addToCart")
	public ResponseEntity<Cart> addToCart(@RequestBody ModifyCartRequest request) {
		log.debug(LogMF.format("addToCart", "Adding item(s) to cart.", request));
		User user = userRepository.findByUsername(request.getUsername());
		if(user == null) {
			log.debug(LogMF.format("addToCart", "Invalid user id.", request));
			throw new UsernameNotFoundException("User '" + request.getUsername()+ "' does not exist.");
		}
		Optional<Item> item = itemRepository.findById(request.getItemId());
		if(!item.isPresent()) {
			log.debug(LogMF.format("addToCart", "Invalid item id.", request));
			throw new ItemNotFoundException("Item id '" + request.getItemId() +"' does not exist.");
		}
		Cart cart = user.getCart();
		IntStream.range(0, request.getQuantity())
			.forEach(i -> cart.addItem(item.get()));
		cartRepository.save(cart);
		log.debug(LogMF.format("addToCart", "Success: item(s) added.", item.get()));
		return ResponseEntity.ok(cart);
	}
	
	@PostMapping("/removeFromCart")
	public ResponseEntity<Cart> removeFromCart(@RequestBody ModifyCartRequest request) {
		log.debug(LogMF.format("removeFromCart", "Removing item(s) to cart.", request));
		User user = userRepository.findByUsername(request.getUsername());
		if(user == null) {
			log.debug(LogMF.format("removeFromCart", "Invalid user id.", request));
			throw new UsernameNotFoundException("User '" + request.getUsername()+ "' does not exist.");
		}
		Optional<Item> item = itemRepository.findById(request.getItemId());
		if(!item.isPresent()) {
			log.debug(LogMF.format("removeFromCart", "Invalid item id.", request));
			throw new ItemNotFoundException("Item id '" + request.getItemId() +"' does not exist.");
		}
		Cart cart = user.getCart();
		// don't remove more items than are in the cart.
		int qty = (request.getQuantity() <= cart.getItems().size()) ? request.getQuantity() : cart.getItems().size();
		IntStream.range(0, qty)
			.forEach(i -> cart.removeItem(item.get()));
		cartRepository.save(cart);
		log.debug(LogMF.format("removeFromCart", "Success: item(s) removed.", item.get()));
		return ResponseEntity.ok(cart);
	}
		
}
