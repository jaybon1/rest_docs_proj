package com.example.rest_docs_proj;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "TODO")
@EqualsAndHashCode(of = "idx", callSuper = false)
public class TodoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx")
    private Integer idx;

    @Column(name="content")
    private String content;

    @Enumerated(value = EnumType.STRING)
    @Column(name="done_yn")
    private YNEnum doneYn;

    @Enumerated(value = EnumType.STRING)
    @Column(name="delete_yn")
    private YNEnum deleteYn;

    @Column(name="create_date")
    private LocalDateTime createDate;

    @Column(name="update_date")
    private LocalDateTime updateDate;

    @Column(name="delete_date")
    private LocalDateTime deleteDate;

    public TodoDTO.Response toTodoDTOResponse(){
        return TodoDTO.Response
                .builder()
                .content(content)
                .doneYn(doneYn.toString())
                .deleteYn(deleteYn.toString())
                .build();
    }

}
