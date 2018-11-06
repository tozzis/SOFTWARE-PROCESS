package com.sit.SoftwareProcess.SoftwareProcess.Repository;

import com.sit.SoftwareProcess.SoftwareProcess.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public User getUserByUsername(String username);
}
