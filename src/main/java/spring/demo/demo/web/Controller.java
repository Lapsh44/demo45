package spring.demo.demo.web;

import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import spring.demo.demo.model.entity.Character;
import spring.demo.demo.model.repository.CharacterRepository;
import spring.demo.demo.services.CharacterService;
import spring.demo.demo.services.Evewho;
import spring.demo.demo.services.NotificationService;
import spring.demo.demo.services.Programm;

import java.io.IOException;

@RestController
public class Controller {
    @Autowired
    Programm programm;
    @Autowired
    CharacterService characterService;
    @Autowired
    NotificationService notificationService;

    @GetMapping("/hels")
    public String hels() {

        return "OK" + programm.test();

    }

    @GetMapping("/update")
    public String update() throws Exception {
       // notificationService.test1();
        return "updated"  + notificationService.test1();
    }

    @GetMapping("/updateall")
    public String updateall() throws Exception {
        notificationService.test2();
        return "AllUpdated";
    }

    @GetMapping("/send12")
    public String send12() throws Exception {
        notificationService.test12();
        return "sended12";
    }
    @GetMapping("/send3")
    public String send3() throws Exception {
        notificationService.test3();
        return "sended3";
    }

    @GetMapping("/note0")
    public String note0() {

        // return  "OK" + NotificationService.getNotification();
        return "OK" + CharacterService.getInfo();

    }

    @GetMapping("/note")
    public String note() throws Exception {

        return NotificationService.getNotificationBody();
        //  return  "OK" + CharacterService.getInfo();


    }

    @GetMapping("/note2")
    public String note2() throws IOException {

        // return  "OK" + NotificationService.getNotification();
        return "OK" + Evewho.getInfo();

    }

    @GetMapping("/note3")
    @Scheduled(cron = "0 0 */2 * * ?")
    public String note3() throws IOException {

        // return  "OK" + NotificationService.getNotification();

        return "OK";    // notificationService.testing();

    }

//    @GetMapping
//    public String main ()
//    {
//       return  "OK "+ (double)programm.test()/3600*60;
//    }

//    @GetMapping
//    public String main ()
//    {
//
//        return  CharacterService.getInfo();
//    }

    @Autowired
    CharacterRepository CharacterRepository;

    @GetMapping
    public Character getCharacter() {
        var character = new Character();
        character.setName("Сигизмунд");
        character.setDescription("Петров");
        character.setCorporation_id(23);
        CharacterRepository.save(character);
        return character;
    }
}
