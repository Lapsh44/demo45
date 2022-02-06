//package spring.demo.demo.services;
//
//import lombok.extern.slf4j.Slf4j;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import spring.demo.demo.model.entity.Users;
//import spring.demo.demo.model.repository.UsersRepository;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//@Slf4j
//class UsersServiceTest {
//    @Autowired
//    UsersService usersService;
//    @Autowired
//    UsersRepository usersRepository;
//
//    @Test
//    void save() {
//
//        Users users = new Users();
//        users.setUserName("test1");
//        users.setUserId("121111");
//        usersService.save(users);
//
//
//     List<Users> all = usersRepository.findAll();
//      log.debug("all {} ", all);
//    }
//}