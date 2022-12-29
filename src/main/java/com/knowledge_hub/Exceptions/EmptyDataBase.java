package com.knowledge_hub.Exceptions;

public class EmptyDataBase extends RuntimeException {
    public EmptyDataBase (){
        super("there are no Entries in your Database");
    }
}
