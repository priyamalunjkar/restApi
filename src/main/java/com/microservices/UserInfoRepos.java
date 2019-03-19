package com.microservices;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepos extends JpaRepository<User, Integer> {

}
