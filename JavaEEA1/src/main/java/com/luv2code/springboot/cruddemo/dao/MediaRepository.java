package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Media;
import org.springframework.data.jpa.repository.JpaRepository;

//The Media entity is the object to be persisted and Integer is the type of its primary key.
public interface MediaRepository extends JpaRepository<Media, Integer> {
    // JpaRepository provides methods save, findById, findAll, deleteById, etc.
}
