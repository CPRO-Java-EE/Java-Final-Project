package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.entity.Media;
import java.util.List;

// Defines the service layer for Media operations
public interface MediaService {

    //Retrieves all media records
    List<Media> findAll();

    //Retrieve media by Id
    Media findById(int theId);

    //Save/Update media record
    Media save(Media theMedia);

    //Delete media by Id
    void deleteById(int theId);

}