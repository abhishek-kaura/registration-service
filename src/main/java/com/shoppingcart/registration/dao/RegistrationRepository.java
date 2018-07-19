package com.shoppingcart.registration.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingcart.registration.entity.Usr;

public interface RegistrationRepository extends JpaRepository<Usr, Long>{

}
