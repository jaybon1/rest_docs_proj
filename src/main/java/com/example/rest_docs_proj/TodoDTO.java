package com.example.rest_docs_proj;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class TodoDTO {

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    static class Post {
        @Length(max = 255)
        @NotBlank
        private String content;

//        @EnumValid(enumClass = YNEnum.class)
//        private String doneYn;
//
//        @EnumValid(enumClass = YNEnum.class)
//        private String deleteYn;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    static class Response {

        private String content;

        private String doneYn;

        private String deleteYn;

    }

}

