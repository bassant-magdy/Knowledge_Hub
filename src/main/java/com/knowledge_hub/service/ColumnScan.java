package com.knowledge_hub.service;


import com.knowledge_hub.entity.Problem;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class ColumnScan {

    public static ArrayList<String> MissingElements = new ArrayList<>() ;

    @Autowired
    public static Problem ScanEntities(Problem Body){
        MissingElements.clear();

        if (Body.getUs().getUser_id()==null) {
            //Body.setUsername("Default_UserName");
            MissingElements.add("User_ID");
        }
        if (Body.getTitle() == null) {
            //Body.setTitle("Default_Title");
            MissingElements.add("Title");
        }
        if (Body.getProblem() == null) {
            //Body.setProblem("Default_Problem");
            MissingElements.add("Problem");
        }
        if (Body.getCategory() == null) {
            //Body.setCategory("Default_Category");
            MissingElements.add("Category");
        }
        if (Body.getDepartment() == null) {
            //Body.setDepartment("Default_Department");
            MissingElements.add("Department");
        }
        if (Body.getStatus() == null) {
           // Body.setStatus("Default_Status");
            MissingElements.add("Status");
        }
        if (Body.getSolution() == null) {
            //Body.setSolution("Default_Solution");
            MissingElements.add("Solution");
        }
        if (Body.getSub_category() == null) {
            //Body.setSub_category("Default_Department");
            MissingElements.add("Sub_Category");
        }
            return Body;
    }
}