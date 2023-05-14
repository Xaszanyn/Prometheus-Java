package com.bitirmetezi.prometheusjava.data.repository;

import com.bitirmetezi.prometheusjava.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
