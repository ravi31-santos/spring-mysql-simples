package com.ravi.projeto.Repository;

import com.ravi.projeto.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
