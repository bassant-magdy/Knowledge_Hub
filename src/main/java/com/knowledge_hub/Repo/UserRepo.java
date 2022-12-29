package com.knowledge_hub.Repo;

import com.knowledge_hub.entity.Problem;
import com.knowledge_hub.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {


}