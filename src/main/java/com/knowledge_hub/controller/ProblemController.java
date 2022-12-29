package com.knowledge_hub.controller;

import com.knowledge_hub.entity.Problem;
import com.knowledge_hub.entity.User;
import com.knowledge_hub.service.ProblemService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/problems")
public class ProblemController {

    @Autowired
    private ProblemService service;

    @GetMapping(path = "/", produces = "application/json")

    public List<Problem> viewAllProblems()
    {

        return service.getAllProblems();
    }


    @PostMapping("/add")
    public ResponseEntity<Object> problemRegister(@RequestBody Problem e ) {
        System.out.println(e);
        Problem AddedProblem = service.addProblem(e);
        return new ResponseEntity<>("Entry is added successfully and as follows: \n"
                +AddedProblem,
                HttpStatus.OK);
    }

//    @PostMapping("/add")
//    public ResponseEntity<Object> UserRegister(@RequestBody User u ) {
//        System.out.println(u);
//        User AddedUser = service.addUser(u);
//        return new ResponseEntity<>("User is added successfully and as follows: \n" +
//                AddedUser,
//                HttpStatus.OK);
//    }
    @PostMapping("/update")
    public ResponseEntity<Object> updateProblem(@RequestBody Problem e) {
        System.out.println(e.toString());
        Problem UpdatedVersion =service.saveProblem(e);
        return new ResponseEntity<>("Entry " + UpdatedVersion.getId() + " is updated successfully and as follows \n "+
                UpdatedVersion,
                HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteProblem(@PathVariable int id) {
        Optional<Problem> DeletedProblem = service.deleteProblemById(id);

        return new ResponseEntity<>("Entry: " + id + "is deleted successfully and was: \n" +
                DeletedProblem,
                HttpStatus.OK);
    }

}
