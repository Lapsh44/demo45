package spring.demo.demo.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;
import org.h2.util.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring.demo.demo.model.entity.Character;
import spring.demo.demo.model.entity.Users;
import spring.demo.demo.model.repository.CharacterRepository;

import java.lang.reflect.Type;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
class CharacterServiceTest {
    @Autowired
    CharacterRepository characterRepository ;
    @Autowired
    CharacterRepository characterService;
    @Test
    void getInfo() throws JsonProcessingException {

      String json = CharacterService.getInfo() ;
        ObjectMapper objectMapper = new ObjectMapper();
    //    String json = "{"alliance_id":99009268,"ancestry_id":31,"birthday":"2008-11-16T07:53:00Z","bloodline_id":11,"corporation_id":98399497,"description":"u'<font size=\"13\" color=\"#ff999999\"><\/font><font size=\"24\" color=\"#ffd98d00\"><a href=\"recruitmentAd:98399497\/\/110569\">Red Cold Chili Banderlogs Academy - \\u043d\\u0430\\u0431\\u0438\\u0440\\u0430\\u0435\\u043c \\u0430\\u0433\\u0435\\u043d\\u0442\\u0440\\u0430\\u043d\\u0435\\u0440\\u043e\\u0432 \\u0438 \\u043c\\u0430\\u0439\\u043d\\u0435\\u0440\\u043e\\u0432<\/a><\/font><font size=\"24\" color=\"#bfffffff\"> <br><br>I\\'m a fucking carebear!!<br>   (\\'\\'\\') \\u043e___\\u043e (\\'\\'\\')<br>   ..\\\\ \\'( \\u043e_\\u043e )\\' \/<br>   ....\\\\ \\\\_\\u0428_\/ \/<br>   ......l . . . . |<br>   .....\/ .\/\"U\"\\\\. \\\\<br>   ..(\\u201e\\u201e\\u201e)___(\\u201e\\u201e\\u201e)<br>** DoN\\'t SHoOT!! **<br><br>Make hay while the sun shines.<br> <\/font>'","gender":"male","name":"Lapsh Banderlog","race_id":1,"security_status":3.560062658}";
        Character character = objectMapper.readValue(json, Character.class);



        characterService.save(character);

        List<Character> all = characterRepository.findAll();
        //log.debug("all {} ", all);
        System.out.println(all);
    }
}