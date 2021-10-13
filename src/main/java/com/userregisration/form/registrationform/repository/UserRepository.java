package com.userregisration.form.registrationform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.userregisration.form.registrationform.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
