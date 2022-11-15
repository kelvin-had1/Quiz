package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.domain.Entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    Object findByemail(String email);

    List<Object> findBypassword(String password);
        


}
