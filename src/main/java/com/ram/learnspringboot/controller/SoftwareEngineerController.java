package com.ram.learnspringboot.controller;

import com.ram.learnspringboot.model.SoftwareEngineer;
import com.ram.learnspringboot.service.SoftwareEngineerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/software-engineers")
public class SoftwareEngineerController {

    private final SoftwareEngineerService softwareEngineerService;

    public SoftwareEngineerController(SoftwareEngineerService softwareEngineerService) {
        this.softwareEngineerService = softwareEngineerService;
    }

    @GetMapping("getAllSoftwareEngineers")
    public List<SoftwareEngineer> getSoftwareEngineers() {
        return softwareEngineerService.getAllSoftwareEngineers();
    }

    @GetMapping("getSoftwareEngineer/{id}")
    public SoftwareEngineer getSoftwareEngineer(@PathVariable Integer id){
        return softwareEngineerService.getSoftwareEngineerById(id);
    }

    @PostMapping("addSoftwareEngineer")
    public void addNewSoftwareEngineers(@RequestBody SoftwareEngineer softwareEngineer) {
        softwareEngineerService.addSoftwareEngineer(softwareEngineer);
    }

    @DeleteMapping("deleteSoftwareEngineer/{id}")
    public void deleteSoftwareEngineer(@PathVariable Integer id){
        softwareEngineerService.deleteSoftwareEngineerById(id);
    }

    @PutMapping("updateSoftwareEngineer/{id}")
    public void updateSoftwareEngineer(@PathVariable Integer id, @RequestBody SoftwareEngineer softwareEngineer){
        softwareEngineerService.updateSoftwareEngineerById(id,softwareEngineer);
    }

}