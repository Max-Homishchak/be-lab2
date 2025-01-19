package com.khomishchak.belab2.repository;

import com.khomishchak.belab2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}