package spring.demo.demo.services;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import spring.demo.demo.model.entity.Character;
import spring.demo.demo.model.entity.Users;
import spring.demo.demo.model.repository.CharacterRepository;

import java.util.Arrays;


@Service
@JsonIgnoreProperties(ignoreUnknown = true)
public class CharacterService {
    @Autowired
    private CharacterRepository characterRepository;
    @Autowired
    CharacterRepository characteRepository;

    public static String getInfo()
    {
        final String uri = "https://esi.evetech.net/latest/characters/514674064/?datasource=tranquility";
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set("Accept-Language", "en-us");
        headers.set("Content-Type", "application/json");

        HttpEntity<String> entity = new HttpEntity<String>(headers);

        ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
        return response.getBody();

    }


    public void save(Character character) {


        characterRepository.save(character);

//Character test = characterRepository.findById("Петров").get();
    }



}