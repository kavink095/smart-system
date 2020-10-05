package com.bolton.project.smartlib.repository;

import com.bolton.project.smartlib.entity.UserRBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRBookRepository extends JpaRepository<UserRBook, Integer> {

    @Query(value = "select mark from userbook where userid=:userid", nativeQuery = true)
    UserRBook findBookByUser(@Param("userid") String userid);

}
