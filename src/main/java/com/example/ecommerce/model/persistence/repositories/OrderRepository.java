package com.example.ecommerce.model.persistence.repositories;

import java.util.List;

import com.example.ecommerce.model.persistence.User;
import com.example.ecommerce.model.persistence.UserOrder;
import org.springframework.data.jpa.repository.JpaRepository;



public interface OrderRepository extends JpaRepository<UserOrder, Long> {
	List<UserOrder> findByUser(User user);
}
