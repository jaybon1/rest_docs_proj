package com.example.rest_docs_proj;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.restdocs.request.RequestDocumentation.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// given

// when

// then

// docs

public class TodoControllerTest extends BaseTest {

    @Test
    public void 리스트() throws Exception {

        // when
        ResultActions resultActions = mockMvc.perform(get("/todoList"));

        // then
        resultActions
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(0));

        // docs
        resultActions
                .andDo(
                        document(
                                "리스트",
                                preprocessResponse(prettyPrint())
                        )
                );

    }


    @Test
    public void 저장() throws Exception {

        // given

        TodoDTO.Post todoDTOPost = TodoDTO.Post.builder()
                .content("테스트하기")
                .build();

        Gson gson = new Gson();

        String todoDTOPostJson = gson.toJson(todoDTOPost);

        // when
        ResultActions resultActions = mockMvc.perform(post("/todoList")
                .content(todoDTOPostJson)
                .contentType(MediaType.APPLICATION_JSON));

        // then
        resultActions
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(0));

        // docs
        resultActions
                .andDo(document(
                                "저장",
                                preprocessRequest(prettyPrint()),
                                preprocessResponse(prettyPrint()),
                                requestFields(
                                        fieldWithPath("content").type(JsonFieldType.STRING).description("할일 내용")
                                )
                        )
                );

    }

    @Test
    public void 수정() throws Exception {

        // given
        Integer givenIdx = 2;

        // when
        ResultActions resultActions = mockMvc.perform(put("/todoList/{idx}", givenIdx));

        // then
        resultActions
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(0));

        // docs
        resultActions
                .andDo(document(
                                "수정",
                                preprocessResponse(prettyPrint()),
                                pathParameters(
                                        parameterWithName("idx").description("할 일 고유번호")
                                )
                        )
                );

        resultActions.andReturn();

    }

    @Test
    public void 삭제() throws Exception {

        // given
        Integer givenIdx = 1;

        // when
        ResultActions resultActions = mockMvc.perform(delete("/todoList?idx=" + givenIdx));

        // then
        resultActions
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(0));

        // docs
        resultActions
                .andDo(document(
                                "삭제",
                                preprocessResponse(prettyPrint()),
                                requestParameters(
                                        parameterWithName("idx").description("할 일 고유번호")
                                )
                        )
                );

    }

}
