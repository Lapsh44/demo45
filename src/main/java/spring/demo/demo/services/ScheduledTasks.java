package spring.demo.demo.services;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
@Slf4j
@Component
public class ScheduledTasks {
@Autowired
NotificationService notificationService;
    Long start = System.currentTimeMillis();
    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("HH:mm:ss");

    // https://www.freeformatter.com/cron-expression-generator-quartz.html
 //   @Scheduled(fixedRate = 5000)
    @Scheduled(cron = "0 0 19 * * ?")
    public void reportCurrentTime() throws Exception {
notificationService.test2();
notificationService.test1();
notificationService.test12();
notificationService.test3();
log.debug("all time {}min", (System.currentTimeMillis() - start)/60000);
LOGGER.info("Fixed Rate Task :: Execution Time - {}", dateFormat.format(LocalDateTime.now()));

    }
}