package spring.demo.demo.services;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import spring.demo.demo.model.entity.Character;
import spring.demo.demo.model.repository.CharacterRepository;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;


@Service
@JsonIgnoreProperties(ignoreUnknown = true)
public class Evewho {
    public static void main(String[] args) throws IOException {
        System.out.println(getInfo());
    }
//    @Autowired
//    private CharacterRepository characterRepository;
//    @Autowired
//    CharacterRepository characteRepository;

    public static String getInfo() throws IOException {
        URL url = new URL("https://evewho.com/api/corplist/98605189/");
        HttpURLConnection http = (HttpURLConnection)url.openConnection();
        http.setRequestProperty("Accept", "application/json");
        http.setRequestProperty("User-Agent" , "Mozilla/5.0 (X11; U; Linux i686) Gecko/20071127 Firefox/2.0.0.11");

    //   System.out.println(http.getResponseCode() + " " + http.getResponseMessage());

    //    http.disconnect();
        return http.getResponseMessage();
    }

//
//    public void save(Character character) {
//
//
//        characterRepository.save(character);
//
////Character test = characterRepository.findById("Петров").get();
//    }



}