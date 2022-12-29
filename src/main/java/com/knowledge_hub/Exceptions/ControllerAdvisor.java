package com.knowledge_hub.Exceptions;

import com.knowledge_hub.service.ColumnScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor {
    @ExceptionHandler(value = ProblemNotFoundException.class)
    public ResponseEntity<Object> exception(ProblemNotFoundException exception){
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("Request Time: ", LocalDateTime.now());
        body.put("Status: ", "No problem found with this ID, we add it to the Database.");
        exception.printStackTrace();
        return new ResponseEntity<>(body, HttpStatus.CONFLICT);
    }
    @ExceptionHandler(value = BodyEnteredMissingElement.class)
    public ResponseEntity<Object> Exception(BodyEnteredMissingElement exception){
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("You didn't enter these elements",ColumnScan.MissingElements);
        body.put("Status: ","Saved with Missing Elements as Null");
        exception.printStackTrace();
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = EmptyDataBase.class)
    public ResponseEntity<String> Exception (EmptyDataBase exception){
        exception.printStackTrace();
     return new ResponseEntity<>("There Are no Entries yet!",HttpStatus.OK);
    }

    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<Object> exception(UserNotFoundException exception) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("Request Time: ", LocalDateTime.now());
        body.put("Status: ", "No user found");
        exception.printStackTrace();
        return new ResponseEntity<>(body, HttpStatus.CONFLICT);

    }

}
