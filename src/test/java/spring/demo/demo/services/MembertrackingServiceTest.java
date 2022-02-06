package spring.demo.demo.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring.demo.demo.model.entity.Character;
import spring.demo.demo.model.entity.Membertracking;
import spring.demo.demo.model.repository.CharacterRepository;
import spring.demo.demo.model.repository.MembertrackingRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
class MembertrackingServiceTest {
    @Autowired
    MembertrackingRepository membertrackingRepository ;
    @Autowired
    MembertrackingRepository membertracking2Repository ;
    @Autowired
    MembertrackingService membertrackingService;
    @Test
    void getInfo() throws Exception {

        String json = MembertrackingService.getInfo() ;
        ObjectMapper objectMapper = new ObjectMapper();
        //    String json = "{"alliance_id":99009268,"ancestry_id":31,"birthday":"2008-11-16T07:53:00Z","bloodline_id":11,"corporation_id":98399497,"description":"u'<font size=\"13\" color=\"#ff999999\"><\/font><font size=\"24\" color=\"#ffd98d00\"><a href=\"recruitmentAd:98399497\/\/110569\">Red Cold Chili Banderlogs Academy - \\u043d\\u0430\\u0431\\u0438\\u0440\\u0430\\u0435\\u043c \\u0430\\u0433\\u0435\\u043d\\u0442\\u0440\\u0430\\u043d\\u0435\\u0440\\u043e\\u0432 \\u0438 \\u043c\\u0430\\u0439\\u043d\\u0435\\u0440\\u043e\\u0432<\/a><\/font><font size=\"24\" color=\"#bfffffff\"> <br><br>I\\'m a fucking carebear!!<br>   (\\'\\'\\') \\u043e___\\u043e (\\'\\'\\')<br>   ..\\\\ \\'( \\u043e_\\u043e )\\' \/<br>   ....\\\\ \\\\_\\u0428_\/ \/<br>   ......l . . . . |<br>   .....\/ .\/\"U\"\\\\. \\\\<br>   ..(\\u201e\\u201e\\u201e)___(\\u201e\\u201e\\u201e)<br>** DoN\\'t SHoOT!! **<br><br>Make hay while the sun shines.<br> <\/font>'","gender":"male","name":"Lapsh Banderlog","race_id":1,"security_status":3.560062658}";
        Membertracking[] membertracking = objectMapper.readValue(json, Membertracking[].class);

 for (Membertracking x: membertracking) {
     log.debug("info  {} ", x);
     if (x.getCharacterId()== 514674064)
     {
         membertrackingRepository.save(x);
     }

 }

      //  membertrackingService.save(membertracking);

        List<Membertracking> all = membertrackingRepository.findAll();
    //    log.debug("all {} ", all);

    }
    @Test
    void getInfo2() throws Exception {

        String json = MembertrackingService.getInfo();
        ObjectMapper objectMapper = new ObjectMapper();
        //    String json = "{"alliance_id":99009268,"ancestry_id":31,"birthday":"2008-11-16T07:53:00Z","bloodline_id":11,"corporation_id":98399497,"description":"u'<font size=\"13\" color=\"#ff999999\"><\/font><font size=\"24\" color=\"#ffd98d00\"><a href=\"recruitmentAd:98399497\/\/110569\">Red Cold Chili Banderlogs Academy - \\u043d\\u0430\\u0431\\u0438\\u0440\\u0430\\u0435\\u043c \\u0430\\u0433\\u0435\\u043d\\u0442\\u0440\\u0430\\u043d\\u0435\\u0440\\u043e\\u0432 \\u0438 \\u043c\\u0430\\u0439\\u043d\\u0435\\u0440\\u043e\\u0432<\/a><\/font><font size=\"24\" color=\"#bfffffff\"> <br><br>I\\'m a fucking carebear!!<br>   (\\'\\'\\') \\u043e___\\u043e (\\'\\'\\')<br>   ..\\\\ \\'( \\u043e_\\u043e )\\' \/<br>   ....\\\\ \\\\_\\u0428_\/ \/<br>   ......l . . . . |<br>   .....\/ .\/\"U\"\\\\. \\\\<br>   ..(\\u201e\\u201e\\u201e)___(\\u201e\\u201e\\u201e)<br>** DoN\\'t SHoOT!! **<br><br>Make hay while the sun shines.<br> <\/font>'","gender":"male","name":"Lapsh Banderlog","race_id":1,"security_status":3.560062658}";
        Membertracking[] membertracking = objectMapper.readValue(json, Membertracking[].class);

        for (Membertracking x : membertracking) {
            log.debug("info  {} ", x);
            if (x.getShipTypeId() == 28606) {
               membertracking2Repository.delete(x);
             //   membertracking2Repository.save(x);
            }
            //


        }

    }
}