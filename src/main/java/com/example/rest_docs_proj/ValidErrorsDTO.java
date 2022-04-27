package com.example.rest_docs_proj;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ValidErrorsDTO {
    String objectName;
    String field;
    String code;
    String message;
}
