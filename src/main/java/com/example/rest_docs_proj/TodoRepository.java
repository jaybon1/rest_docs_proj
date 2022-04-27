package com.example.rest_docs_proj;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<TodoEntity,Integer> {
    List<TodoEntity> findAllByDeleteYn(YNEnum deleteYn);
    TodoEntity findByIdxAndDeleteYn(Integer idx, YNEnum deleteYn);
}