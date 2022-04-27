package com.example.rest_docs_proj;

import org.junit.jupiter.api.Disabled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureRestDocs(uriPort = 8070)
@Disabled // 이 클래스의 테스트 실행 안함
@ActiveProfiles("test") // application-test.yml 프로필로 작동
public class BaseTest {

    @Autowired
    public MockMvc mockMvc;

}
