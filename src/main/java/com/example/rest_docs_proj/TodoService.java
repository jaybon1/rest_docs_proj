package com.example.rest_docs_proj;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TodoService {

    private final TodoRepository todoRepository;

    public List<TodoDTO.Response> findAll() {
        return todoRepository.findAllByDeleteYn(YNEnum.valueOf("N"))
                .stream()
                .map(TodoEntity::toTodoDTOResponse)
                .collect(Collectors.toList());
    }

    @Transactional
    public TodoDTO.Response insert(TodoDTO.Post todoDTOPost) {

        TodoEntity todoEntity = todoRepository.save(
                TodoEntity.builder()
                        .content(todoDTOPost.getContent())
                        .doneYn(YNEnum.N)
                        .deleteYn(YNEnum.N)
                        .createDate(LocalDateTime.now())
                        .build()
        );

        return todoEntity.toTodoDTOResponse();

    }

    @Transactional
    public void changeDone(Integer idx) {
        TodoEntity todoEntity = todoRepository.findByIdxAndDeleteYn(idx, YNEnum.N);
        todoEntity.setDoneYn(YNEnum.Y.equals(todoEntity.getDoneYn()) ? YNEnum.N : YNEnum.Y);
        todoEntity.setUpdateDate(LocalDateTime.now());
    }

    @Transactional
    public void delete(Integer idx) {
        TodoEntity todoEntity = todoRepository.findByIdxAndDeleteYn(idx, YNEnum.N);
        todoEntity.setDeleteYn(YNEnum.Y);
        todoEntity.setDeleteDate(LocalDateTime.now());
    }

}
