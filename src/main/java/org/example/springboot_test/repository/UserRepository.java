package org.example.springboot_test.repository;

import org.example.springboot_test.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    /*
    * JpaRepository에서 기본으로 제공하는 CRUD 메서드
    * Create: save()
    * Read: findById()
    * Update: save()
    * Delete: deleteById
    * */

    User findByUserIdAndUserPw(String userId, String userPw);
}
