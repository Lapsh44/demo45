package spring.demo.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import spring.demo.demo.model.entity.Membertracking;
import spring.demo.demo.model.repository.MembertrackingRepository;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;

@Service
public class MembertrackingService {
    @Autowired
    MembertrackingRepository membertrackingRepository ;
    @Autowired
    MembertrackingService membertrackingService;




        public static String getToken() throws Exception {
            //   String Refresh_Token;
            String url = "https://login.eveonline.com/oauth/token";
            // String token = "1|CfDJ8O+5Z0aH+aBNj61BXVSPWfjz1m+KX0MgQESfCA9vQhVYMm6UMNG7cjqPRQFsVedzAtxxj3NqSoFhtykyEmo9heQEqdkMgDyUXeE3UBbttxcxCEvFMm7Pavd77G58wzwzx34QynvS3ScRn4DhFpInVycC3ptICJDIzwneKRCz/Y1Z";
            //String url = String.join("=", url1,token );
            //      System.out.println(url);

            HttpsURLConnection httpClient = (HttpsURLConnection) new URL(url).openConnection();

            //add reqest header
            httpClient.setRequestMethod("POST");
            httpClient.setRequestProperty("accept", "application/json");
            httpClient.setRequestProperty("Accept-Language", "en-us");
            httpClient.setRequestProperty("Content-Type", "application/json");
            httpClient.setRequestProperty("Authorization", "Basic MjBlMGUwZGE1Zjg3NGMzMDlmMTBmMTk2MDE1NTJmZjQ6VFZDTDJBOXp3aGtJalpPWkJTYTFWUlJrVzR2SkJ1WjI5RmNoQ3hMbg==");
            String urlParameters ="{\"grant_type\":\"refresh_token\", \"refresh_token\":\"kW_yLGZplJ2X8lWWJrNqs-CdeWtIxSb9Mzw9sSRRMzxE0mIWfOQpo_Aktt9VmqU-hv3U2MxVvA5GO4zyGvOiOUzEHX0PH6ws0Yf1eQ382AXzih5yxbP9miG-Nkn_piHgUZmqV9ygVomrSxWFvd7mWZO_MmZ0XQul2-xc4_OTE7wcWizPSRLSPNYcUNYhy_2MXSlagixCsSAfuFjrpGIMcnUmOG1dlDQ15Yv6RawlButOLVqmFoYJWG7DWgxJrWZsPGDINvl77Wqg8O66vj9lrtyRVU-Hm68l2z0wKAjhSQFmaZ3RmMBh19Pyk2P4Uka3p8YJAG_D3sMA7Y1okO3CLCkfLA6JR-KSO7bDV5bZIf1f7cQ6bIfwOyedPJJYwa9XTiMigQq5oANIlys6qVSBOQLXS7TJuDCYSc_9pFgyQiY\"}";

            // Send post request
            httpClient.setDoOutput(true);
            try (DataOutputStream wr = new DataOutputStream(httpClient.getOutputStream())) {
                wr.writeBytes(urlParameters);
                wr.flush();
            }


            int responseCode = httpClient.getResponseCode();
            //     System.out.println("Response Code : " + responseCode);

            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(httpClient.getInputStream()))) {

                String line;
                StringBuilder response = new StringBuilder();

                while ((line = in.readLine()) != null) {
                    response.append(line);
                }
                String A =response.toString();
                //  System.out.println(A);
                String token = A.substring(17,195);
                //   String Refresh_Token = A.substring(254,297);
                //print result
                System.out.println("token recived \n" + token);
                //    System.out.println("Refresh Token=" + Refresh_Token);
                return token;
            }
        }





    public static String getInfo() throws Exception {
        final String uri = "https://esi.evetech.net/latest/corporations/98399497/membertracking/?datasource=tranquility&token=" +
                getToken() +
                "";
//        final String uri = "https://esi.evetech.net/latest/corporations/98399497/membertracking/?datasource=tranquility&token=" +
//                "1%7CCfDJ8Oa41dYvIKRLuTM55Eo9S3fcOk74KkFOhxJqjNAMMnS%2BvDQ%2BVSLntdsdfNYmYxF0HyhYeGOC4NjRyqNPlq2rdApk1iJzX%2FXfFKUSQZv9p39oD9bZ%2FGkoJXs%2FNOVylnaKa0HYo2gEfU80VRgfJPZQFIdWa0lBUx1tD5jnaqQoJhZq" +
//                "";
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
