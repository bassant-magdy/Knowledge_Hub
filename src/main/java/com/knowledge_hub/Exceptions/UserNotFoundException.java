package com.knowledge_hub.Exceptions;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException (Integer id){

        super(String.format("User with Id : %d not found", id));

    }


}
