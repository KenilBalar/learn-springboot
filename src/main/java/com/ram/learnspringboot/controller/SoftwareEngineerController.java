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

//        return List.of(
//                new SoftwareEngineer(1,
//                        "Kenil Balar",
//                        "Software Engineer",
//                        "kenil123@gmail.com",
//                        "+49134408425",
//                        "Berlin, Germany",
//                        List.of("Kotlin, Java, Android, Jetpack Compose, Spring-Boot, HTML5, CSS3, JavaScript, SQL, PostgreSQL, Firebase")),
//                new SoftwareEngineer(1,
//                        "Mohit Sukhadiya",
//                        "Front-end Developer",
//                        "mohit543@gmail.com",
//                        "+919573164864",
//                        "Surat, India",
//                        List.of("HTML5, CSS3, JavaScript, Tailwind CSS, React.js")),
//                new SoftwareEngineer(1,
//                        "Jay Patel",
//                        "Back-end Developer",
//                        "jay636@gmail.com",
//                        "+918593165241",
//                        "Delhi, India",
//                        List.of("Java, JavaScript, Spring-Boot, PostgreSQL, Git, Docker")),
//                new SoftwareEngineer(1,
//                        "Sagar Jariwala",
//                        "Android Developer",
//                        "Sagar0435@gmail.com",
//                        "+918866176834",
//                        "Ahmedabad, India",
//                        List.of("Kotlin, Java, Android, Jetpack Compose, Room Database, Firebase")),
//                new SoftwareEngineer(1,
//                        "Piyush Goswami",
//                        ".Net Developer",
//                        "kenil123@gmail.com",
//                        "+919768431846",
//                        "Pune, India",
//                        List.of("C#, C, SQL, Python, Django, AWS, Firebase"))
//        );

    }

    @GetMapping("getSoftwareEngineer/{id}")
    public SoftwareEngineer getSoftwareEngineerById(@PathVariable Integer id){
        return softwareEngineerService.getSoftwareEngineerById(id);
    }

}