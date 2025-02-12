package com.luv2code.springboot.cruddemo.rest;

import com.luv2code.springboot.cruddemo.entity.Media;
import com.luv2code.springboot.cruddemo.service.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult; // Captures validation results of request body
import org.springframework.web.bind.annotation.*;

import com.luv2code.springboot.cruddemo.ErrorResponse; // Custom error response class

import javax.validation.Valid; // Ensures the request body is valid based on constraints
import java.util.List;

@RestController // Marks class as REST controller to HTTP requests
@RequestMapping("/api") // Defines the base URL for the controller as "/api"
public class MediaRestController {

    // Service used for handling media operations
    private MediaService mediaService;

    // Constructor injection of MediaService
    @Autowired
    public MediaRestController(MediaService theMediaService) {
        mediaService = theMediaService;
    }

    // expose "/media" and return a list of media
    @GetMapping("/media")
    // Calls service to get all media and returns the list
    public List<Media> findAll() {
        return mediaService.findAll();
    }

    // add mapping to get media by Id
    @GetMapping("/media/{mediaId}")
    public ResponseEntity<Object> getMedia(@PathVariable int mediaId) {
        // Fetch media by ID from the service
        Media theMedia = mediaService.findById(mediaId);

        // If media not found, return a custom error response
        if (theMedia == null) {
            // Return a custom error response when media is not found
            ErrorResponse errorResponse = new ErrorResponse("Media id not found - " + mediaId, HttpStatus.NOT_FOUND.value(), System.currentTimeMillis());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }

        // Return the Media if found
        return ResponseEntity.ok(theMedia);
    }



    // add mapping for POST /media - add new media
    @PostMapping("/media")
    public ResponseEntity<Object> addMedia(@RequestBody @Valid Media theMedia, BindingResult bindingResult) {

        // Handle validation errors
        if (bindingResult.hasErrors()) {
            StringBuilder errorMessages = new StringBuilder();
            bindingResult.getAllErrors().forEach(error -> {
                // Append each validation error message
                errorMessages.append(error.getDefaultMessage()).append("; ");
            });
            // Return a BAD_REQUEST response with the validation error messages
            ErrorResponse errorResponse = new ErrorResponse("Validation failed: " + errorMessages.toString(), HttpStatus.BAD_REQUEST.value(), System.currentTimeMillis());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }

        //set mediaId to 0 to indicate new entity
        theMedia.setMediaId(0);

        // Save the new media using the service and return the created media
        Media savedMedia = mediaService.save(theMedia);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMedia);
    }

    // add mapping to update existing media
    @PutMapping("/media")
    public ResponseEntity<Object> updateMedia(@RequestBody @Valid Media theMedia, BindingResult bindingResult) {

        // Handle validation errors
        if (bindingResult.hasErrors()) {
            StringBuilder errorMessages = new StringBuilder();
            bindingResult.getAllErrors().forEach(error -> {
                // Append each validation error message
                errorMessages.append(error.getDefaultMessage()).append("; ");
            });
            // Return a BAD_REQUEST response with the validation error messages
            ErrorResponse errorResponse = new ErrorResponse("Validation failed: " + errorMessages.toString(), HttpStatus.BAD_REQUEST.value(), System.currentTimeMillis());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }

        // Check if mediaId exists
        if (theMedia.getMediaId() == 0 || mediaService.findById(theMedia.getMediaId()) == null) {
            // If media does not exist, return a NOT_FOUND error response
            ErrorResponse errorResponse = new ErrorResponse("Media not found with ID: " + theMedia.getMediaId(), HttpStatus.NOT_FOUND.value(), System.currentTimeMillis());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }

        // Proceed with the update and save media
        Media updatedMedia = mediaService.save(theMedia);

        // Return the updated media with OK status
        return ResponseEntity.status(HttpStatus.OK).body(updatedMedia);
    }

    // add mapping to delete media
    @DeleteMapping("/media/{mediaId}")
    public ResponseEntity<Object> deleteMedia(@PathVariable int mediaId) {

        //find media by Id
        Media tempMedia = mediaService.findById(mediaId);

        // throw exception if null
        if (tempMedia == null) {
            throw new RuntimeException("Media id not found - " + mediaId);
        }

        //delete media
        mediaService.deleteById(mediaId);

        // Return a success message
        return ResponseEntity.status(HttpStatus.OK).body("Deleted media id - " + mediaId);
    }

}