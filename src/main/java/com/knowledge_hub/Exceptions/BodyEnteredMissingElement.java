package com.knowledge_hub.Exceptions;

import java.util.List;

public class BodyEnteredMissingElement extends RuntimeException{
    public BodyEnteredMissingElement(List<String> Elements) {
        super(String.format("The body you entered is missing the" +" "
                + Elements +" " + "elements, it will be assigned as Default"));
    }
}
