package com.knowledge_hub.service;
import com.knowledge_hub.Exceptions.*;
import com.knowledge_hub.Repo.ProblemRepo;
import com.knowledge_hub.Repo.UserRepo;
import com.knowledge_hub.entity.Problem;
import com.knowledge_hub.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProblemService {

    @Autowired
    ProblemRepo r;
    @Autowired
    UserRepo u;

    // get all Problems
    public List<Problem> getAllProblems() {

        List<Problem> Result = r.findAll();

        if (Result.isEmpty()) {
            throw new EmptyDataBase();
        }
        System.out.println("Here are all existing entries:");
        return Result;
    }

    //add Problem data to database
    public Problem addProblem(Problem pr) {
        Optional<User> user = u.findById(pr.getUs().getUser_id());
        if (user.isPresent()) {
            pr.setUs(user.get());
            Problem ReturnedProblem = ColumnScan.ScanEntities(pr);
            ArrayList<String> missingList = ColumnScan.MissingElements;
            if (!missingList.isEmpty()) {
                r.save(ReturnedProblem);
                throw new BodyEnteredMissingElement(missingList);
            }
            return r.save(pr);
        }
        else {
            throw new UserNotFoundException(pr.getUs().getUser_id());
        }
    }

    public Problem getProblemById(Integer id) {

        Problem pr = r.getById(id);

        //	if there is not a Problem who has the id, throw the error.
        if (pr == null) {
            throw new RuntimeException("Problem not found");
        }
        return pr;
    }

    //	delete Problem by id
    public Optional<Problem> deleteProblemById(Integer id) {
        Optional<Problem> Result =r.findById(id);
        if (Result.isEmpty()) {
            throw new ProblemNotFoundException(id);
        }
        r.deleteById(id);
        return Result;
    }

    public Problem saveProblem(Problem savedProblem) {
        Optional<User> user = u.findById(savedProblem.getUs().getUser_id());
        Problem pro = r.findProblemById(savedProblem.getId());

        // If the user ID not found in the database
        if (user.isEmpty()) {

            throw new UserNotFoundException(savedProblem.getUs().getUser_id());

        } else {

            if (pro == null) {
                Problem NewProblem = savedProblem;
                r.save(NewProblem);
                throw new ProblemNotFoundException(savedProblem.getId());
            }
            else {
                pro.setId(savedProblem.getId());
                pro.setCategory(savedProblem.getCategory());
                pro.setSub_category(savedProblem.getSub_category());
                pro.setProblem(savedProblem.getProblem());
                pro.setStatus(savedProblem.getStatus());
                pro.setSolution(savedProblem.getSolution());
                pro.setTitle(savedProblem.getTitle());
                pro.setDepartment(savedProblem.getDepartment());
                pro.setCreationTime(savedProblem.getCreationTime());
                pro.setCreationDate(savedProblem.getCreationDate());
                return r.save(pro);
            }
        }

    }

}

//    public User addUser(User u) {
//        Optional<User> user = u.findById(pr.getUs().getUser_id());
//        if (user.isPresent()) {
//            pr.setUs(user.get());
//            Problem ReturnedProblem = ColumnScan.ScanEntities(pr);
//            ArrayList<String> missingList = ColumnScan.MissingElements;
//            if (!missingList.isEmpty()) {
//                r.save(ReturnedProblem);
//                throw new BodyEnteredMissingElement(missingList);
//            }
//            return r.save(pr);
//        }
//        else {
//            throw new UserNotFoundException(pr.getUs().getUser_id());
//        }
//        return ;
//    }


