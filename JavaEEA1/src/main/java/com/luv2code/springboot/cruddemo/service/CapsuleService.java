package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.dao.CapsuleRepository;
import com.luv2code.springboot.cruddemo.entity.Capsule;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CapsuleService
{
    private final CapsuleRepository repository;

    public CapsuleService(CapsuleRepository repository){
        this.repository = repository;
    }

    public List<Capsule> getAllCapsules(){
        return repository.findAll();
    }

    public Capsule getCapsuleById(int id){
        return repository.findById(id).orElse(null);
    }

    public Capsule createCapsule(Capsule capsule){
        return repository.save(capsule);
    }

    public Capsule updateCapsule(int id, Capsule updatedCapsule){
        return repository.findById(id)
                .map(capsule -> {
                    capsule.setUserId(updatedCapsule.getUserId());
                    capsule.setTitle(updatedCapsule.getTitle());
                    capsule.setCreationDate(updatedCapsule.getCreationDate());
                    capsule.setLockDate(updatedCapsule.getLockDate());
                    capsule.setStatus(updatedCapsule.getStatus());
                    return repository.save(capsule);
                }).orElse(null);
    }

    public void deleteCapsule(int id){
        repository.deleteById(id);
    }
}
