package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.dao.MediaRepository;
import com.luv2code.springboot.cruddemo.entity.Media;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Service class implementation that handles media operations
@Service
public class MediaServiceImpl implements MediaService {

    // Repository to interact with the database
    private MediaRepository mediaRepository;

    // Constructor-based dependency injection of MediaRepository
    @Autowired
    public MediaServiceImpl(MediaRepository theMediaRepository) {
        mediaRepository = theMediaRepository;
    }

    // Method to retrieve all media records from the database
    @Override
    public List<Media> findAll() {
        return mediaRepository.findAll();
    }

    // Method to find a media record by its ID
    @Override
    public Media findById(int theId) {
        // Fetches an Optional Media entity from the repository
        Optional<Media> result = mediaRepository.findById(theId);

        Media theMedia = null;

        // If the media record exists, get it from the Optional container
        if (result.isPresent()) {
            theMedia = result.get();
        }
        else {
            // If media with the given ID is not found, throw an exception
            throw new RuntimeException("Did not find media id - " + theId);
        }

        // Return the found media record
        return theMedia;
    }

    // Method to save or update a media record in the repository
    @Override
    public Media save(Media theMedia) {
        return mediaRepository.save(theMedia);
    }

    // Method to delete a media record by its ID
    @Override
    public void deleteById(int theId) {
        mediaRepository.deleteById(theId);
    }
}






