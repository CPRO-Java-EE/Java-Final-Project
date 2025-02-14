package com.luv2code.springboot.cruddemo.rest;

import com.luv2code.springboot.cruddemo.entity.Capsule;
import com.luv2code.springboot.cruddemo.service.CapsuleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/capsules")
public class CapsuleController {
    private final CapsuleService service;

    public CapsuleController(CapsuleService service) {
        this.service = service;
    }

    @GetMapping
    public List<Capsule> getAllCapsule(){
        return service.getAllCapsules();
    }

    @GetMapping ("/{id}")
    public Capsule getCapsuleById(@PathVariable int id){
        return service.getCapsuleById(id);
    }

    @PostMapping
    public Capsule createCapsule(@RequestBody Capsule capsule) {
        return service.createCapsule(capsule);
    }

    @PutMapping("/{id}")
    public Capsule updateCapsule(@PathVariable int id, @RequestBody Capsule capsule) {
        return service.updateCapsule(id, capsule);
    }

    @DeleteMapping("/{id}")
    public void deleteCapsule(@PathVariable int id) {
        service.deleteCapsule(id);
    }
}
