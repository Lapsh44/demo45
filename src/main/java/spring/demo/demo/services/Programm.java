package spring.demo.demo.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;

@Service
@Slf4j
public class Programm {
    int count = 0;

    @Scheduled(fixedDelay = 1000)
    public void start() {
        count++;

       // System.out.println("OK");

    }

    public int test() {
        return count;
    }
}
