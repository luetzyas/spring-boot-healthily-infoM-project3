package ch.zhaw.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.zhaw.springboot.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
}
