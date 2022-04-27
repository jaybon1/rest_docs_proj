//package com.example.rest_docs_proj;
//
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestController;
//
//@ControllerAdvice
//@RestController
//public class GlobalExceptionHandler {
//    @ExceptionHandler(RuntimeException.class)
//    public HttpEntity<?> exceptionResponse(RuntimeException e) {
//
////        System.out.println(e.getCause().toString());
//        System.out.println(e.getMessage());
//
//        return new ResponseEntity<>(
//                RespDTO.builder()
//                        .code(0)
//                        .message("예상치 못한 에러가 발생했습니다.")
//                        .build()
//                , HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//}
