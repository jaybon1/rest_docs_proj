package com.example.rest_docs_proj;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @GetMapping("todoList")
    public HttpEntity<?> select() {

        return new ResponseEntity<>(
                RespDTO.<List<TodoDTO.Response>>builder()
                        .code(0)
                        .message("리스트를 성공적으로 가져왔습니다.")
                        .data(todoService.findAll())
                        .build(),
                HttpStatus.OK);

    }

    @PostMapping("todoList")
    public HttpEntity<?> insert(@RequestBody @Valid TodoDTO.Post todoDTOPost, Errors errors) {

        if (errors.hasErrors()) {
            return new ResponseEntity<>(
                    RespDTO.builder()
                            .code(0)
                            .message("저장에 실패하였습니다.")
                            .data(errors)
                            .build()
                    , HttpStatus.BAD_REQUEST);
        }


        TodoDTO.Response todoDTOResponse = todoService.insert(todoDTOPost);

        RespDTO<TodoDTO.Response> respDTO = RespDTO.<TodoDTO.Response>builder()
                .code(0)
                .message("정상적으로 저장했습니다.")
                .data(todoDTOResponse)
                .build();

        return new ResponseEntity<>(respDTO, HttpStatus.OK);

    }

    @PutMapping("todoList/{idx}")
    public HttpEntity<?> update(@PathVariable Integer idx) {

        todoService.changeDone(idx);

        RespDTO<Object> respDTO = RespDTO.builder()
                .code(0)
                .message("정상적으로 수정했습니다.")
                .build();

        return new ResponseEntity<>(respDTO, HttpStatus.OK);

    }

    @DeleteMapping("todoList")
    public HttpEntity<?> delete(@RequestParam Integer idx) {

        todoService.delete(idx);

        RespDTO<Object> respDTO = RespDTO.builder()
                .code(0)
                .message("정상적으로 삭제했습니다.")
                .build();

        return new ResponseEntity<>(respDTO, HttpStatus.OK);

    }
}
