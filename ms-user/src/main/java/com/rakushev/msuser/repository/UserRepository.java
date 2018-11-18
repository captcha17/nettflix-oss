package com.rakushev.msuser.repository;

import com.rakushev.msuser.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}
