package com.knowledge_hub.Exceptions;

public class ProblemNotFoundException extends RuntimeException{

    public ProblemNotFoundException (Integer id){
        super(String.format("Problem with Id : %d not found", id));

    }


}
