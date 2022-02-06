package spring.demo.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.demo.demo.model.entity.Paps;
import spring.demo.demo.model.entity.Users;
import spring.demo.demo.model.repository.PapsRepository;
import spring.demo.demo.model.repository.UsersRepository;

import java.util.Optional;

@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    PapsRepository papsRepository;



//    public void save(Users user) {
//        usersRepository.save(user);
//        Users test = usersRepository.findById("*").get();
//        //String userId = test.getUserId();
//       // Paps paps = papsRepository.findById(userId).get();
//
//    }

}
