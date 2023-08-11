package com.test.app.repository;

import com.test.app.entity.MyObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyObjectRepo extends JpaRepository<MyObject, Long> {
}
