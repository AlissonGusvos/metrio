package com.metrio.Metrio.repository;

import com.metrio.Metrio.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
