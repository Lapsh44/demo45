package spring.demo.demo.services;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class RestApiServiceTest {
    @Autowired
    RestApiService restApiService;

    @Test
    void getData() {
        Integer[] data = restApiService.getData();
        log.debug("data {} ", data.length);
        log.debug("data {} ", data[0]);
        log.debug("data {} ", data[2]);

    }
}