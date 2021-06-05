package spring.demo.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import spring.demo.demo.model.entity.Character;
import spring.demo.demo.model.entity.Membertracking;
import spring.demo.demo.model.repository.MembertrackingRepository;

import java.util.Arrays;

@Service
public class MembertrackingService {
    @Autowired
    MembertrackingRepository membertrackingRepository ;
    @Autowired
    MembertrackingService membertrackingService;

    public static String getInfo()
    {
        final String uri = "https://esi.evetech.net/latest/corporations/98399497/membertracking/?datasource=tranquility&token=1%7CCfDJ8Oa41dYvIKRLuTM55Eo9S3fcOk74KkFOhxJqjNAMMnS%2BvDQ%2BVSLntdsdfNYmYxF0HyhYeGOC4NjRyqNPlq2rdApk1iJzX%2FXfFKUSQZv9p39oD9bZ%2FGkoJXs%2FNOVylnaKa0HYo2gEfU80VRgfJPZQFIdWa0lBUx1tD5jnaqQoJhZq";
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set("Accept-Language", "en-us");
        headers.set("Content-Type", "application/json");

        HttpEntity<String> entity = new HttpEntity<String>(headers);

        ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
        return response.getBody();

    }

    public void save(Membertracking membertracking) {


        membertrackingRepository.save(membertracking);

//Character test = characterRepository.findById("Петров").get();
    }

}
