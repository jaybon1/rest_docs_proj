package com.example.rest_docs_proj;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RespDTO<T> {
    Integer code;
    String message;
    T data;
}
