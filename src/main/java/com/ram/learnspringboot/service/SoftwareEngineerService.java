package com.ram.learnspringboot.service;

import com.ram.learnspringboot.model.SoftwareEngineer;
import com.ram.learnspringboot.repository.SoftwareEngineerRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class SoftwareEngineerService {

    private final SoftwareEngineerRepository softwareEngineerRepository;

    public SoftwareEngineerService(SoftwareEngineerRepository softwareEngineerRepository) {
        this.softwareEngineerRepository = softwareEngineerRepository;
    }

    public List<SoftwareEngineer> getAllSoftwareEngineers() {
        return softwareEngineerRepository.findAll();
    }

    public SoftwareEngineer getSoftwareEngineerById(Integer id) {
        return softwareEngineerRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(id + " not found!"));
    }

    public void addSoftwareEngineer(SoftwareEngineer softwareEngineer) {
        softwareEngineerRepository.save(softwareEngineer);
    }

    public void deleteSoftwareEngineerById(Integer id) {
        softwareEngineerRepository.deleteById(id);
    }

    public void updateSoftwareEngineerById(Integer id, SoftwareEngineer updatedEngineer) {
        Optional<SoftwareEngineer> optionalEngineer = softwareEngineerRepository.findById(id);

        if (optionalEngineer.isPresent()) {
            SoftwareEngineer existingEngineer = optionalEngineer.get();

            existingEngineer.setName(updatedEngineer.getName());
            existingEngineer.setDesignation(updatedEngineer.getDesignation());
            existingEngineer.setEmail(updatedEngineer.getEmail());
            existingEngineer.setPhone(updatedEngineer.getPhone());
            existingEngineer.setAddress(updatedEngineer.getAddress());
            existingEngineer.setTechStack(updatedEngineer.getTechStack());

            softwareEngineerRepository.save(existingEngineer);
        } else {
            throw new IllegalArgumentException("Engineer not found with ID: " + id);
        }
    }

}
