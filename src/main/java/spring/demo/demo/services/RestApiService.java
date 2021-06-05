package spring.demo.demo.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import spring.demo.demo.dao.Alliance;

@Slf4j
@Service
public class RestApiService {


    public Integer[] getData() {
        RestTemplate restTemplate = new RestTemplateBuilder()
//                .defaultHeader("sssss", "sssss")
                .build();


        String url = "https://esi.evetech.net/latest/alliances/?datasource=tranquility";
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Auuuu", "wwww");
//        HttpEntity<String> entity = new HttpEntity<String>(headers);
        ResponseEntity<Integer[]> forEntity = restTemplate.getForEntity(url, Integer[].class);
//        ResponseEntity<Integer[]> forEntity = restTemplate.getForEntity(url, Integer[].class, entity);

//        ResponseEntity<Alliance> forEntity1 = restTemplate.getForEntity(url, Alliance.class);
//        Alliance body = forEntity1.getBody();

        return forEntity.getBody();
    }
}
