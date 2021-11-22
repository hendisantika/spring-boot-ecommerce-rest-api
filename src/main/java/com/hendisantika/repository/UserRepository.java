package com.hendisantika.repository;

import com.hendisantika.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-ecommerce-rest-api
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 23/11/21
 * Time: 03.57
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Finds a User through the given username.
     *
     * @param username the username to look for
     * @return the User that was found (if any)
     */
    Optional<User> findByUsername(String username);
}
