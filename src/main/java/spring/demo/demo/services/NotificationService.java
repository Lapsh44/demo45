package spring.demo.demo.services;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import spring.demo.demo.model.entity.CharacterDTO;
import spring.demo.demo.model.entity.CharactersDTO;
import spring.demo.demo.model.entity.CharactersPOJO;
import spring.demo.demo.model.entity.Notification;
import spring.demo.demo.model.repository.NotificationRepository;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;


@Service
@JsonIgnoreProperties(ignoreUnknown = true)
@Slf4j
public class NotificationService {
    @Autowired

    NotificationRepository notificationRepository;


    public static String getToken() throws Exception {

        String url = "https://login.eveonline.com/oauth/token";
        HttpsURLConnection httpClient = (HttpsURLConnection) new URL(url).openConnection();

        //add reqest header
        httpClient.setRequestMethod("POST");
        httpClient.setRequestProperty("accept", "application/json");
        httpClient.setRequestProperty("Accept-Language", "en-us");
        httpClient.setRequestProperty("Content-Type", "application/json");
        httpClient.setRequestProperty("Authorization", "Basic MjBlMGUwZGE1Zjg3NGMzMDlmMTBmMTk2MDE1NTJmZjQ6VFZDTDJBOXp3aGtJalpPWkJTYTFWUlJrVzR2SkJ1WjI5RmNoQ3hMbg==");
        String urlParameters = "{\"grant_type\":\"refresh_token\", \"refresh_token\":\"kW_yLGZplJ2X8lWWJrNqs-CdeWtIxSb9Mzw9sSRRMzxE0mIWfOQpo_Aktt9VmqU-hv3U2MxVvA5GO4zyGvOiOUzEHX0PH6ws0Yf1eQ382AXzih5yxbP9miG-Nkn_piHgUZmqV9ygVomrSxWFvd7mWZO_MmZ0XQul2-xc4_OTE7wcWizPSRLSPNYcUNYhy_2MXSlagixCsSAfuFjrpGIMcnUmOG1dlDQ15Yv6RawlButOLVqmFoYJWG7DWgxJrWZsPGDINvl77Wqg8O66vj9lrtyRVU-Hm68l2z0wKAjhSQFmaZ3RmMBh19Pyk2P4Uka3p8YJAG_D3sMA7Y1okO3CLCkfLA6JR-KSO7bDV5bZIf1f7cQ6bIfwOyedPJJYwa9XTiMigQq5oANIlys6qVSBOQLXS7TJuDCYSc_9pFgyQiY\"}";

        // Send post request
        httpClient.setDoOutput(true);
        try (DataOutputStream wr = new DataOutputStream(httpClient.getOutputStream())) {
            wr.writeBytes(urlParameters);
            wr.flush();
        }


        int responseCode = httpClient.getResponseCode();

        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(httpClient.getInputStream()))) {

            String line;
            StringBuilder response = new StringBuilder();

            while ((line = in.readLine()) != null) {
                response.append(line);
            }
            String A = response.toString();
            String token = A.substring(17, 195);

            System.out.println("token recived \n" + token);

            return token;
        }
    }

    CharacterDTO getCharInfo(long charid) throws IOException, InterruptedException {
        String jsonAsString = NotificationService.getCharInfoService(charid);
        ObjectMapper objectMapper = new ObjectMapper();
        CharacterDTO characterDTO = objectMapper.readValue(jsonAsString, CharacterDTO.class);

        return characterDTO;

    }

    String date(String date) throws IOException {

        String date2 = date.replace("-", ".").substring(0, 10);
        Date date1 = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
        String date11 = format.format(date1);

        SimpleDateFormat format2 = new SimpleDateFormat("yyyy.MM.dd");

        Date dateOne = null;
        Date dateTwo = null;

        try {
            dateOne = format2.parse(date11);
            dateTwo = format2.parse(date2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Количество дней между датами в миллисекундах
        long difference = dateOne.getTime() - dateTwo.getTime();
        // Перевод количества дней между датами из миллисекунд в дни
        int days = (int) (difference / (24 * 60 * 60 * 1000));

        return String.valueOf(days);
    }

    void updateFromH2all() throws IOException, InterruptedException {

        List<Notification> corpAppNewMsg = notificationRepository.findAllMain();

        for (Notification n : corpAppNewMsg) {

            try {

                CharacterDTO charInfo = getCharInfo(n.getSenderId());
                // дата создания
                String bday = charInfo.getBirthday();
                //  n.setBirt(bday);

                // возраст в днях
                n.setApp(date(bday));
                // name
//                String name = charInfo.getName();
//                n.setName(name);
                // сек статус
                float sec = charInfo.getSecurityStatus();
                n.setSec(sec);

                int corp = charInfo.getCorporationId();
                Integer[] alphabet = new Integer[]{1000001,
                        1000002,
                        1000003,
                        1000004,
                        1000005,
                        1000006,
                        1000007,
                        1000008,
                        1000009,
                        1000010,
                        1000011,
                        1000012,
                        1000013,
                        1000014,
                        1000015,
                        1000016,
                        1000017,
                        1000018,
                        1000019,
                        1000020,
                        1000021,
                        1000022,
                        1000023,
                        1000024,
                        1000025,
                        1000026,
                        1000027,
                        1000028,
                        1000029,
                        1000030,
                        1000031,
                        1000032,
                        1000033,
                        1000034,
                        1000035,
                        1000036,
                        1000037,
                        1000038,
                        1000039,
                        1000040,
                        1000041,
                        1000042,
                        1000043,
                        1000044,
                        1000045,
                        1000046,
                        1000047,
                        1000048,
                        1000049,
                        1000050,
                        1000051,
                        1000052,
                        1000053,
                        1000054,
                        1000055,
                        1000056,
                        1000057,
                        1000058,
                        1000059,
                        1000060,
                        1000061,
                        1000062,
                        1000063,
                        1000064,
                        1000065,
                        1000066,
                        1000067,
                        1000068,
                        1000069,
                        1000070,
                        1000071,
                        1000072,
                        1000073,
                        1000074,
                        1000075,
                        1000076,
                        1000077,
                        1000078,
                        1000079,
                        1000080,
                        1000081,
                        1000082,
                        1000083,
                        1000084,
                        1000085,
                        1000086,
                        1000087,
                        1000088,
                        1000089,
                        1000090,
                        1000091,
                        1000092,
                        1000093,
                        1000094,
                        1000095,
                        1000096,
                        1000097,
                        1000098,
                        1000099,
                        1000100,
                        1000101,
                        1000102,
                        1000103,
                        1000104,
                        1000105,
                        1000106,
                        1000107,
                        1000108,
                        1000109,
                        1000110,
                        1000111,
                        1000112,
                        1000113,
                        1000114,
                        1000115,
                        1000116,
                        1000117,
                        1000118,
                        1000119,
                        1000120,
                        1000121,
                        1000122,
                        1000123,
                        1000124,
                        1000125,
                        1000126,
                        1000127,
                        1000128,
                        1000129,
                        1000130,
                        1000131,
                        1000132,
                        1000133,
                        1000134,
                        1000135,
                        1000136,
                        1000137,
                        1000138,
                        1000139,
                        1000140,
                        1000141,
                        1000142,
                        1000143,
                        1000144,
                        1000145,
                        1000146,
                        1000147,
                        1000148,
                        1000149,
                        1000150,
                        1000151,
                        1000152,
                        1000153,
                        1000154,
                        1000155,
                        1000156,
                        1000157,
                        1000158,
                        1000159,
                        1000160,
                        1000161,
                        1000162,
                        1000163,
                        1000164,
                        1000165,
                        1000166,
                        1000167,
                        1000168,
                        1000169,
                        1000170,
                        1000171,
                        1000172,
                        1000173,
                        1000174,
                        1000175,
                        1000176,
                        1000177,
                        1000178,
                        1000179,
                        1000180,
                        1000181,
                        1000182,
                        1000193,
                        1000197,
                        1000198,
                        1000205,
                        1000206,
                        1000207,
                        1000208,
                        1000213,
                        1000214,
                        1000215,
                        1000216,
                        1000217,
                        1000218,
                        1000219,
                        1000220,
                        1000222,
                        1000223,
                        1000224,
                        1000225,
                        1000226,
                        1000227,
                        1000228,
                        1000229,
                        1000230,
                        1000231,
                        1000232,
                        1000233,
                        1000234,
                        1000235,
                        1000236,
                        1000237,
                        1000238,
                        1000239,
                        1000240,
                        1000243,
                        1000244,
                        1000245,
                        1000246,
                        1000247,
                        1000248,
                        1000249,
                        1000250,
                        1000251,
                        1000252,
                        1000253,
                        1000254,
                        1000255,
                        1000256,
                        1000257,
                        1000258,
                        1000259,
                        1000261,
                        1000262,
                        1000263,
                        1000270,
                        1000271,
                        1000274,
                        1000276,
                        1000277,
                        1000279,
                        1000280,
                        1000281,
                        1000282,
                        1000283,
                        1000284,
                        1000285,
                        1000286,
                        1000287,
                        1000288,
                        1000289,
                        1000290,
                        1000291,
                        1000292,
                        1000293,
                        1000294,
                        1000297,
                        1000298,
                        1000299};
                List<Integer> list = Arrays.asList(alphabet);
                String charcorp = "";
                if (list.contains(corp)) {
                    charcorp = "NPC";
                } else {
                    List<Integer> bacadem = Arrays.asList(98399497, 98631060);
                    List<Integer> rusac = Arrays.asList(98575483, 98593411);
                    if (bacadem.contains(corp)) {
                        charcorp = "academ";
                    } else if (rusac.contains(corp)) {
                        charcorp = "rusac";
                    } else charcorp = "notNPC";
                }

                n.setNpc(charcorp);


            } catch (HttpClientErrorException ex) {
                if (ex.getRawStatusCode() == 404)
                //        if (ex.getStatusCode() != HttpStatus.NOT_FOUND)

                {
                    // throw ex;
                    System.out.println("ошибка HttpClientErrorException 404");
                    Thread.sleep(10000);
                } else if (ex.getRawStatusCode() == 504) {
                    System.out.println("ошибка HttpClientErrorException 504");
                    Thread.sleep(10000);
                } else if (ex.getRawStatusCode() == 502) {
                    System.out.println("ошибка HttpClientErrorException 502");

                    Thread.sleep(10000);
                }
            } catch (HttpServerErrorException ex2) {

                if (ex2.getRawStatusCode() == 504) {

                    System.out.println("ошибка HttpServerErrorException 504");
                    Thread.sleep(10000);
                }
            }


            notificationRepository.save(n);

            log.debug("notification updated {} ", n);
        }

    }

    List<Notification> getNotification() throws Exception {

        String json3 = getNotificationBody();

        ObjectMapper objectMapper = new ObjectMapper();

        Notification[] notifications = objectMapper.readValue(json3, Notification[].class);
        long max = 0;
        ///////////////////////////
        List<Notification> corpAppNewMsg = notificationRepository.findAllMain();


        for (Notification n : corpAppNewMsg) {
            if (n.getNotificationId() > max) max = n.getNotificationId();

        }
///////////////////////////////////
        List<Notification> toUpdate = new ArrayList<>();
        for (Notification n : notifications) {

            if (n.getNotificationId() > max) {
                log.debug("notificationsSaved_ID {} ", n.getNotificationId());

                if (n.getText().toString().length() > 255) {
                    n.setText(n.getText().substring(0, 254));
                }
                notificationRepository.save(n);
                toUpdate.add(n);


            } else log.debug("notifications_ID {} ", n.getNotificationId());

            //   log.debug("notifications {} ", n.getSenderId());
        }
        // notificationService.save(notifications);

//        List<Notification> all = notificationRepository.findAll();
//        log.debug("all {} ", all);
        log.debug("notifications {} ", notifications);

        return toUpdate;

    }

    public static String getNotificationBody() throws Exception {


//        String path = "E:\\514674064.txt";
//        BufferedReader br = new BufferedReader(new FileReader(path));
//        String sCurrentLine = br.readLine();
//        String token = "";
//        token = sCurrentLine;
//
//        System.out.println(token);

        String token = "";
        token = getToken();

        System.out.println("getToken \n" + token);

        final String uri = "https://esi.evetech.net/latest/characters/514674064/notifications/?datasource=tranquility&token=" +
                token +
                "";

        System.out.println(uri);
        //   final String uri = "https://esi.evetech.net/latest/alliances/?datasource=tranquility";
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set("Cache-Control", "no-cache");
        headers.set("accept", "application/json");

        HttpEntity<String> entity = new HttpEntity<String>(headers);

        ResponseEntity<String> response = null;
        try {


            response = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
        } catch (RestClientException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();

        }

        if (response == null) {
            return "{\"birthday\":\"2021-01-01T00:00:00Z\",\"bloodline_id\":14,\"corporation_id\":98500220,\"description\":\"Pilots from the Republic Military School's Center for Combat Studies are known for their creative approach to battle tactics. \",\"gender\":\"male\",\"name\":\"ERROR2\",\"race_id\":2,\"security_status\":0.00000000000000000},[Date:\"Tue, 16 Nov 2021 08:06:07 GMT\", Content-Type:\"application/json; charset=UTF-8\", Content-Length:\"302\", Connection:\"keep-alive\", Access-Control-Allow-Credentials:\"true\", Access-Control-Allow-Headers:\"Content-Type,Authorization,If-None-Match,X-User-Agent\", Access-Control-Allow-Methods:\"GET,HEAD,OPTIONS\", Access-Control-Allow-Origin:\"*\", Access-Control-Expose-Headers:\"Content-Type,Warning,ETag,X-Pages,X-ESI-Error-Limit-Remain,X-ESI-Error-Limit-Reset\", Access-Control-Max-Age:\"600\", Allow:\"GET,HEAD,OPTIONS\", Cache-Control:\"public\", Etag:\"\"9dd18931453a2e51f940977e72fff63355670d182edefd2439d91313\"\", Expires:\"Tue, 16 Nov 2021 15:00:22 GMT\", Last-Modified:\"Mon, 15 Nov 2021 15:00:22 GMT\", Strict-Transport-Security:\"max-age=31536000\", X-Esi-Error-Limit-Remain:\"100\", X-Esi-Error-Limit-Reset:\"53\", X-Esi-Request-Id:\"8d03b80d-e21a-4697-be42-9175fbe73b14\"]";
        } else return response.getBody();

    }

    void updatBaseLast(List<Notification> notification) throws IOException, InterruptedException {

        // int max = 0;
        ///////////////////////////
        //  List<Notification> corpAppNewMsg = notificationRepository.findAllMain();


//
//        for (Notification n : corpAppNewMsg) {
//            if (n.getNotificationId() > max) max = n.getNotificationId();
//
//        }
///////////////////////////////////


        for (Notification n : notification) {

//          if (n.getNotificationId()>1516463941) {
            //     if (n.getSenderId() == 2116620298) {


//            String text = unitext(n.getText());
//            String text2 = text.replace("applicationText: ", "");
//            String text3 = "";
//            if (text2.length() < 254) {
//                text3 = text2;
//            } else text3 = text2.substring(1, 255);
//            n.setApp(text3);


            //String bday = getCharInfo(n.getSenderId());
            CharacterDTO charInfo = getCharInfo(n.getSenderId());
            // дата создания
            String bday = charInfo.getBirthday();
            n.setBirt(bday);

            // возраст в днях
            n.setApp(date(bday));
            // name
            String name = charInfo.getName();
            n.setName(name);
            // сек статус
            float sec = charInfo.getSecurityStatus();
            n.setSec(sec);

            int corp = charInfo.getCorporationId();
            Integer[] alphabet = new Integer[]{1000001,
                    1000002,
                    1000003,
                    1000004,
                    1000005,
                    1000006,
                    1000007,
                    1000008,
                    1000009,
                    1000010,
                    1000011,
                    1000012,
                    1000013,
                    1000014,
                    1000015,
                    1000016,
                    1000017,
                    1000018,
                    1000019,
                    1000020,
                    1000021,
                    1000022,
                    1000023,
                    1000024,
                    1000025,
                    1000026,
                    1000027,
                    1000028,
                    1000029,
                    1000030,
                    1000031,
                    1000032,
                    1000033,
                    1000034,
                    1000035,
                    1000036,
                    1000037,
                    1000038,
                    1000039,
                    1000040,
                    1000041,
                    1000042,
                    1000043,
                    1000044,
                    1000045,
                    1000046,
                    1000047,
                    1000048,
                    1000049,
                    1000050,
                    1000051,
                    1000052,
                    1000053,
                    1000054,
                    1000055,
                    1000056,
                    1000057,
                    1000058,
                    1000059,
                    1000060,
                    1000061,
                    1000062,
                    1000063,
                    1000064,
                    1000065,
                    1000066,
                    1000067,
                    1000068,
                    1000069,
                    1000070,
                    1000071,
                    1000072,
                    1000073,
                    1000074,
                    1000075,
                    1000076,
                    1000077,
                    1000078,
                    1000079,
                    1000080,
                    1000081,
                    1000082,
                    1000083,
                    1000084,
                    1000085,
                    1000086,
                    1000087,
                    1000088,
                    1000089,
                    1000090,
                    1000091,
                    1000092,
                    1000093,
                    1000094,
                    1000095,
                    1000096,
                    1000097,
                    1000098,
                    1000099,
                    1000100,
                    1000101,
                    1000102,
                    1000103,
                    1000104,
                    1000105,
                    1000106,
                    1000107,
                    1000108,
                    1000109,
                    1000110,
                    1000111,
                    1000112,
                    1000113,
                    1000114,
                    1000115,
                    1000116,
                    1000117,
                    1000118,
                    1000119,
                    1000120,
                    1000121,
                    1000122,
                    1000123,
                    1000124,
                    1000125,
                    1000126,
                    1000127,
                    1000128,
                    1000129,
                    1000130,
                    1000131,
                    1000132,
                    1000133,
                    1000134,
                    1000135,
                    1000136,
                    1000137,
                    1000138,
                    1000139,
                    1000140,
                    1000141,
                    1000142,
                    1000143,
                    1000144,
                    1000145,
                    1000146,
                    1000147,
                    1000148,
                    1000149,
                    1000150,
                    1000151,
                    1000152,
                    1000153,
                    1000154,
                    1000155,
                    1000156,
                    1000157,
                    1000158,
                    1000159,
                    1000160,
                    1000161,
                    1000162,
                    1000163,
                    1000164,
                    1000165,
                    1000166,
                    1000167,
                    1000168,
                    1000169,
                    1000170,
                    1000171,
                    1000172,
                    1000173,
                    1000174,
                    1000175,
                    1000176,
                    1000177,
                    1000178,
                    1000179,
                    1000180,
                    1000181,
                    1000182,
                    1000193,
                    1000197,
                    1000198,
                    1000205,
                    1000206,
                    1000207,
                    1000208,
                    1000213,
                    1000214,
                    1000215,
                    1000216,
                    1000217,
                    1000218,
                    1000219,
                    1000220,
                    1000222,
                    1000223,
                    1000224,
                    1000225,
                    1000226,
                    1000227,
                    1000228,
                    1000229,
                    1000230,
                    1000231,
                    1000232,
                    1000233,
                    1000234,
                    1000235,
                    1000236,
                    1000237,
                    1000238,
                    1000239,
                    1000240,
                    1000243,
                    1000244,
                    1000245,
                    1000246,
                    1000247,
                    1000248,
                    1000249,
                    1000250,
                    1000251,
                    1000252,
                    1000253,
                    1000254,
                    1000255,
                    1000256,
                    1000257,
                    1000258,
                    1000259,
                    1000261,
                    1000262,
                    1000263,
                    1000270,
                    1000271,
                    1000274,
                    1000276,
                    1000277,
                    1000279,
                    1000280,
                    1000281,
                    1000282,
                    1000283,
                    1000284,
                    1000285,
                    1000286,
                    1000287,
                    1000288,
                    1000289,
                    1000290,
                    1000291,
                    1000292,
                    1000293,
                    1000294,
                    1000297,
                    1000298,
                    1000299};
            List<Integer> list = Arrays.asList(alphabet);
            String charcorp = "";
            if (list.contains(corp)) {
                charcorp = "NPC";
            } else {
                List<Integer> bacadem = Arrays.asList(98399497, 98631060);
                List<Integer> rusac = Arrays.asList(98575483, 98593411);
                if (bacadem.contains(corp)) {
                    charcorp = "academ";
                } else if (rusac.contains(corp)) {
                    charcorp = "rusac";
                } else charcorp = "notNPC";
            }

            n.setNpc(charcorp);

            notificationRepository.save(n);

            log.debug("birthday {} ", bday);
            //       }
        }
    }

    String idFromName(String name) throws IOException {
        //  String name = "Legionnaire Paulus";
        //  System.out.println(notificationService.id(name));

        return id(name);
    }

    void presendmail(int choise) throws IOException {
        List<Notification> players;
        switch (choise) {
            case 1:
                players = notificationRepository.findAllMain01();
                break;
            case 2:
                players = notificationRepository.findAllMain02();
                break;
            case 3:
                players = notificationRepository.findAllMain03();
                break;
            case 4:
                players = notificationRepository.findAllMain04();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + choise);
        }

        //     List<Notification> players = notificationRepository.findAllMain01();
        //   List<Notification> players = notificationRepository.findAllMain02();

        List<String> stringList = new ArrayList<>();
        for (Notification n : players) {
            stringList.add(n.getName());
            log.debug("players {} ", n.getName());
        }

        List<String> distinctInts = stringList.stream().distinct().collect(Collectors.toList());

        for (String name : distinctInts) {
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                String makeobject = idFromName(name.replace("\uFEFF", ""));
                CharactersDTO characters = objectMapper.readValue(makeobject, CharactersDTO.class);
                List<CharactersPOJO> list = characters.getCharacters();
                log.debug("отправка {} {}", name, makeobject);
                for (CharactersPOJO n : list) {

                    //          List<Notification> corpAppNewMsg = notificationRepository.findAll();
                    //          NotificationService.sendMail2(Long.toString(n.getId()));
                    //     List<Notification> corpAppNewMsg = notificationRepository.findAllBySenderId( n.getId());

                    //    for (Notification m : corpAppNewMsg) {
                    switch (choise) {
                        case 1:

                            List<Notification> сorpAppNewMsg = notificationRepository.findAllBySenderIdAndType(n.getId(), "CorpAppNewMsg");
                            try {
                                Thread.sleep(15000);
                                sendMail22(n.getId(), n.getName(), сorpAppNewMsg.get(0).getTimestamp(), сorpAppNewMsg.get(0).getText(), 1);
                            } catch (HttpException520 e) {

                                System.out.println("520 ошибка");
                                List<Notification> сorpAppNewMsg11 = notificationRepository.findAllBySenderId(n.getId());
                                for (Notification m : сorpAppNewMsg11) {
                                    m.setIsRead("BLOCK");
                                    notificationRepository.save(m);

                                }
                            } catch (IOException e) {
                                Thread.sleep(10000);
                                System.out.println("403 ошибка");

                            }

                            List<Notification> сorpAppNewMsg1 = notificationRepository.findAllBySenderId(n.getId());
                            for (Notification m : сorpAppNewMsg1) {
                                m.setMail1("+");

                                notificationRepository.save(m);

                            }

                            break;
                        case 2:
                            List<Notification> charAppWithdrawMsg = notificationRepository.findAllBySenderIdAndType(n.getId(), "CharAppWithdrawMsg");
                            try {
                                Thread.sleep(15000);
                                sendMail22(n.getId(), n.getName(), charAppWithdrawMsg.get(0).getTimestamp(), charAppWithdrawMsg.get(0).getText(), 2);
                            } catch (HttpException520 e) {
                                Thread.sleep(10000);
                                System.out.println("520 ошибка");
                            } catch (IndexOutOfBoundsException e) {

                                System.out.println("IndexOutOfBoundsException ошибка");
                            }


                            List<Notification> charAppWithdrawMsg2 = notificationRepository.findAllBySenderId(n.getId());
                            for (Notification m : charAppWithdrawMsg2) {
                                m.setMail2("+");
                                m.setMail1("+");
                                notificationRepository.save(m);
                            }
                            break;
                        case 3:
                            List<Notification> CharAppAcceptMsg3 = notificationRepository.findAllBySenderId(n.getId());
                            try {
                                Thread.sleep(15000);
                                sendMail22(n.getId(), n.getName(), "", "", 3);
                            } catch (HttpException520 e) {
                                Thread.sleep(10000);
                                System.out.println("520 ошибка");
                            } catch (IndexOutOfBoundsException e) {

                                System.out.println("IndexOutOfBoundsException ошибка");
                            }


                            List<Notification> CharAppAcceptMsg33 = notificationRepository.findAllBySenderId(n.getId());
                            for (Notification m : CharAppAcceptMsg33) {
                                m.setMail3("+");

                                notificationRepository.save(m);
                            }
                            break;
                        case 4:
                            List<Notification> CharAppAcceptMsg4 = notificationRepository.findAllBySenderId(n.getId());
                            try {
                                Thread.sleep(15000);
                                sendMail22(n.getId(), n.getName(), CharAppAcceptMsg4.get(0).getTimestamp(), CharAppAcceptMsg4.get(0).getText(), 4);
                            } catch (HttpException520 e) {

                                System.out.println("520 ошибка");
                            } catch (IndexOutOfBoundsException e) {
                                Thread.sleep(10000);
                                System.out.println("IndexOutOfBoundsException ошибка");
                            }


                            List<Notification> CharAppAcceptMsg44 = notificationRepository.findAllBySenderId(n.getId());
                            for (Notification m : CharAppAcceptMsg44) {
                                m.setMail4("+");

                                notificationRepository.save(m);
                            }
                            break;

                    }

                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NullPointerException e) {
                System.out.print("NullPointerException caught");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public static void sendMail2() throws IOException {


        String path = "E:\\95422192.txt";
        BufferedReader br = new BufferedReader(new FileReader(path));
        String sCurrentLine = br.readLine();
        String token = "";
        token = sCurrentLine;


        String url1 = "https://esi.evetech.net/latest/characters/";
        int charIDOtpravitel = 95422192;
        String charID2 = String.valueOf(charIDOtpravitel);
        String url2 = "/mail/?datasource=tranquility&token=";

        String url = url1 + charID2 + url2 + token;

        HttpsURLConnection httpClient = (HttpsURLConnection) new URL(url).openConnection();

        //add reqest header
        httpClient.setRequestMethod("POST");
        httpClient.setRequestProperty("accept", "application/json");
        httpClient.setRequestProperty("Accept-Language", "en-us");
        httpClient.setRequestProperty("Content-Type", "application/json");

        String urlParameters = "{\n" +
                "  \"approved_cost\": 0,\n" +
                "  \"body\": \"body\",\n" +
                "  \"recipients\": [\n" +
                "    {\n" +
                "      \"recipient_id\": 583300221,\n" +
                "      \"recipient_type\": \"character\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"subject\": \"subject\"\n" +
                "}";
        httpClient.setDoOutput(true);

        OutputStream wr = httpClient.getOutputStream();
        try (BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(wr, StandardCharsets.UTF_8))) {
            //        new OutputStreamWriter(wr))) {
            writer.write(urlParameters);
            writer.flush();
            writer.close();
            wr.close();
        }

        int responseCode = httpClient.getResponseCode();


        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(httpClient.getInputStream()))) {

            String line;
            StringBuilder response = new StringBuilder();

            while ((line = in.readLine()) != null) {
                response.append(line);
            }

        }
    }


    public static void sendMail22(Long sender_id, String name, String timestamp1, String text1, int i) throws Exception {


        String text = "";
        String timestamp2 = timestamp1.replace('T', ' ');
        String timestamp = timestamp2.replace('Z', ' ');

        if (text1.length() < 60) {
            text = " ";
        } else if (text1.indexOf("\"") == -1) {
            text = " ";
        } else if (text1.length() < 254) {
            text = text1.substring(text1.indexOf("\""), text1.indexOf("\"", text1.indexOf("\"") + 1));
        } else if (text1.length() > 254) {
            text = text1.substring(text1.indexOf("\""), text1.indexOf("\"", 254));
        }

        //    String path = "E:\\95422192.txt";
//        String path = "E:\\514674064.txt";
////        BufferedReader br = new BufferedReader(new FileReader(path));
////        String sCurrentLine = br.readLine();
////        String token = "";
////        token = sCurrentLine;

        String token = "";
        token = getToken();

        String url1 = "https://esi.evetech.net/latest/characters/";
        int charIDOtpravitel = 514674064;
        String charID2 = String.valueOf(charIDOtpravitel);
        String url2 = "/mail/?datasource=tranquility&token=";
        //  String token = "1|CfDJ8Oa41dYvIKRLuTM55Eo9S3dodwAwDv+guvv4iCITYMm4AC5xONaMUeT51v3Ta7hWuvsNt2G1NCjmHK5g8YFgPe2Etazmk48hkwMHunT+HOWunZGs+J6/ZsgNIGr6LIBnyNfqBOXDIdk80p4aN8E6fvFtUetcATaYFIWIVGgmxbur";

        String url = url1 + charID2 + url2 + token;

        //    String url = String.join("=", url1,token );
        //      System.out.println(url);

        HttpsURLConnection httpClient = (HttpsURLConnection) new URL(url).openConnection();

        //add reqest header
        httpClient.setRequestMethod("POST");
        httpClient.setRequestProperty("accept", "application/json");
        httpClient.setRequestProperty("Accept-Language", "en-us");
        httpClient.setRequestProperty("Content-Type", "application/json");

        // String urlParameters = "{  \"approved_cost\": 0,  \"body\": \"test\",  \"recipients\": [    {      \"recipient_id\": 839982294,      \"recipient_type\": \"character\"    }  ],  \"subject\": \"string\"}";
        String subject;
        String body;
        switch (i) {
            case 1:
                subject = "Re: Получена заявка от персонажа " +
                        name +
                        "";
                body = "<font size=\\\"13\\\" color=\\\"#ff999999\\\"></font><font size=\\\"14\\\" color=\\\"#ffd98d00\\\"><loc><a href=\\\"showinfo:1385//" +
                        sender_id +
                        "\\\">" +
                        name +
                        "</a></loc></font><font size=\\\"14\\\" color=\\\"#ffffffff\\\"> , привет!<br>от тебя пришла заявка на вступление в корпорацию, но ты так до конца и не прошел процедуру.<br><br>Для вступленя тебе надо зайти во вкладку<br></font><font size=\\\"14\\\" color=\\\"#ff94ccff\\\"><a href=\\\"helpPointer:neocom.corporation\\\">Корпорация</a></font><font size=\\\"14\\\" color=\\\"#ffffffff\\\"> =&gt;</font><font size=\\\"14\\\" color=\\\"#ff999999\\\"> </font><font size=\\\"14\\\" color=\\\"#ff94ccff\\\"><a href=\\\"helpPointer:unique_UI_recruitementTab\\\">Вербовка</a></font><font size=\\\"14\\\" color=\\\"#ffffffff\\\"> =&gt; </font><font size=\\\"14\\\" color=\\\"#ff94ccff\\\"><a href=\\\"helpPointer:unique_UI_myApplications\\\">Мои заявки на вступление в корпорацию</a></font><font size=\\\"14\\\" color=\\\"#ffffffff\\\"> <br>и подтвердить вступление в корпорацию </font><font size=\\\"14\\\" color=\\\"#ffd98d00\\\"><a href=\\\"showinfo:2//98399497\\\">Red Cold Chili Banderlogs Academy</a></font><font size=\\\"14\\\" color=\\\"#ffffffff\\\"> <br><br>(если вдруг там нет твоей заявки нужно кликнуть на  </font><font size=\\\"14\\\" color=\\\"#ffd98d00\\\"><a href=\\\"showinfo:2//98399497\\\">Red Cold Chili Banderlogs Academy</a></font><font size=\\\"14\\\" color=\\\"#ffffffff\\\"> и снизу будет - \\\"Подать заявку на вступление\\\")<br><br>Все вопросы касающиеся игры можешь задавать в текстовом канале нашего <br></font><font size=\\\"14\\\" color=\\\"#ffffe400\\\"><a href=\\\"https://discord.gg/2zSaZhJ\\\">Дискорд</a></font><font size=\\\"14\\\" color=\\\"#ffffffff\\\"> сервера<br><br><br><u>Получена заявка от персонажа " +
                        name +
                        "</u><br>От: </font><font size=\\\"14\\\" color=\\\"#ffd98d00\\\"><loc><a href=\\\"showinfo:1385//" +
                        sender_id +
                        "\\\">" +
                        name +
                        "</a></loc><br></font><font size=\\\"14\\\" color=\\\"#ffffffff\\\">Отправлено: " +
                        timestamp +
                        "<br><br>" +
                        text +
                        "</font>";
                break;
            case 2:
                subject = "Re: Пилот " +
                        name +
                        " отозвал свою заявку";
                body = "<font size=\\\"13\\\" color=\\\"#ff999999\\\"></font><font size=\\\"14\\\" color=\\\"#ffd98d00\\\"><loc><a href=\\\"showinfo:1377//" +
                        sender_id +
                        "\\\">" +
                        name +
                        "</a></loc></font><font size=\\\"14\\\" color=\\\"#ffffffff\\\"> , привет!<br>ты хотел присоедениться к нашей корпорации, но отозвал свою заявку( и не прошел процедуру вступления в корпорацию до конца.<br><br>Eve online достаточно сложная игра для самостоятельного изучения;  игроки объединяются в группы(корпорации) и играют вместе. Наша корпорация специализируются на адаптации русскоязычных новичков, а также тех игроков, кто давно не играл и пробует вернуться в игру.<br><br>Для вступления в нашу корпорацию тебе надо кликнуть на  </font><font size=\\\"14\\\" color=\\\"#ffd98d00\\\"><a href=\\\"showinfo:2//98399497\\\">Red Cold Chili Banderlogs Academy</a></font><font size=\\\"14\\\" color=\\\"#ffffffff\\\"> и снизу будет - \\\"Подать заявку на вступление\\\"<br><br>Заявки обрабатываются обычно в течении часа, после утверждения тебе надо будет зайти во вкладку </font><font size=\\\"14\\\" color=\\\"#ff94ccff\\\"><a href=\\\"helpPointer:neocom.corporation\\\">Корпорация</a></font><font size=\\\"14\\\" color=\\\"#ffffffff\\\"> =&gt;</font><font size=\\\"14\\\" color=\\\"#ff999999\\\"> </font><font size=\\\"14\\\" color=\\\"#ff94ccff\\\"><a href=\\\"helpPointer:unique_UI_recruitementTab\\\">Вербовка</a></font><font size=\\\"14\\\" color=\\\"#ffffffff\\\"> =&gt; </font><font size=\\\"14\\\" color=\\\"#ff94ccff\\\"><a href=\\\"helpPointer:unique_UI_myApplications\\\">Мои заявки на вступление в корпорацию</a></font><font size=\\\"14\\\" color=\\\"#ffffffff\\\"> <br>и подтвердить вступление в корпорацию </font><font size=\\\"14\\\" color=\\\"#ffd98d00\\\"><a href=\\\"showinfo:2//98399497\\\">Red Cold Chili Banderlogs Academy</a></font><font size=\\\"14\\\" color=\\\"#ffffffff\\\"> <br> <br>Все вопросы касающиеся игры можешь задавать в текстовом канале нашего <br></font><font size=\\\"14\\\" color=\\\"#ffffe400\\\"><a href=\\\"https://discord.gg/2zSaZhJ\\\">Дискорд</a></font><font size=\\\"14\\\" color=\\\"#ffffffff\\\"> сервера<br><br><br><u>Пилот " +
                        name +
                        " отозвал свою заявку</u><br>От: </font><font size=\\\"14\\\" color=\\\"#ffd98d00\\\"><loc><a href=\\\"showinfo:1377//" +
                        sender_id +
                        "\\\">" +
                        name +
                        "</a></loc><br></font><font size=\\\"14\\\" color=\\\"#ffffffff\\\">Отправлено: " +
                        timestamp +
                        "<br><br><br>Пилот </font><font size=\\\"14\\\" color=\\\"#ffd98d00\\\"><loc><a href=\\\"showinfo:1377//" +
                        sender_id +
                        "\\\">" +
                        name +
                        "</a></loc></font><font size=\\\"14\\\" color=\\\"#ffffffff\\\"> отозвал свою заявку на вступление в ряды корпорации.</font>";

                break;
            case 3:
                subject = "Полезная информация для вновь вступивших";
//                body = "<font size=\\\"13\\\" color=\\\"#ff999999\\\"></font><font size=\\\"18\\\" color=\\\"#ffd98d00\\\"><a href=\\\"showinfo:1383//" +
//                        sender_id +
//                        "\\\">" +
//                        name +
//                        "</a></font><font size=\\\"18\\\" color=\\\"#ff999999\\\">, привет!<br>ты только вступил хочу порекомендовать ссылки на наши ресурсы, которые помогут тебе освоиться:<br><br>1) </font><font size=\\\"18\\\" color=\\\"#ffffe400\\\"><loc><a href=\\\"https://zen.yandex.ru/media/id/5e68e756f4235c367b77063d/putevoditel-po-eve-online-609d371cc6446324a36f0749\\\">Яндекс дзен путеводител</loc>ь</a></font><font size=\\\"18\\\" color=\\\"#ff999999\\\"> (кому не доступен Яндекс воспользуйтесь</font><font size=\\\"18\\\" color=\\\"#ffffe400\\\"><loc><a href=\\\"https://www.torproject.org/ru/download/\\\"> браузером Tor</a></loc></font><font size=\\\"18\\\" color=\\\"#ff999999\\\"> )<br>2) </font><font size=\\\"18\\\" color=\\\"#ffffe400\\\"><a href=\\\"http://wiki.banderlogs.ru/doku.php\\\">Wiki</a></font><font size=\\\"18\\\" color=\\\"#ff999999\\\"> <br>3) </font><font size=\\\"18\\\" color=\\\"#ffffe400\\\"><a href=\\\"https://www.youtube.com/channel/UCjevM1DrRB3Arq-2U2dHvRw\\\">Youtube</a></font><font size=\\\"18\\\" color=\\\"#ff999999\\\"> <br><br>Для общения мы используем голосовой чат  </font><font size=\\\"18\\\" color=\\\"#ffffe400\\\"><a href=\\\"https://discord.gg/QunNGesRYD\\\">Дискорд.</a></font><font size=\\\"18\\\" color=\\\"#ff999999\\\"> На первых порах можно не регистрироваться, но если ты решишь задержаться то надо пройти </font><font size=\\\"18\\\" color=\\\"#ffffe400\\\"><a href=\\\"https://zen.yandex.ru/media/id/5e68e756f4235c367b77063d/diskord-v-eve-online-5e906d1a5b52a25f8a85b903\\\">Авторизация</a></font><font size=\\\"18\\\" color=\\\"#ff999999\\\">, лучше сначала посмотреть  </font><font size=\\\"18\\\" color=\\\"#ffffe400\\\"><a href=\\\"https://youtu.be/8op1tc8dExc\\\">видео про регистрацию</a></font><font size=\\\"18\\\" color=\\\"#ff999999\\\"> <br><br>Для общения используется канал - <br></font><font size=\\\"18\\\" color=\\\"#ff00ffff\\\">fleet Academ voice</font><font size=\\\"18\\\" color=\\\"#ff999999\\\"> в нем обычно сидят новички и те кто им помогают, так что не стесняйся заходи и задавай интересующие вопросы. <br></font><font size=\\\"18\\\" color=\\\"#ffb2b2b2\\\">в канале</font><font size=\\\"18\\\" color=\\\"#ff00ffff\\\"> Информация рекрутинг</font><font size=\\\"18\\\" color=\\\"#ff999999\\\">   можно прослушать информацию о нас.<br><br><br>После прохождения регистрации у откроется дополнительный канал - \\\"</font><font size=\\\"18\\\" color=\\\"#ff00ffff\\\">имперская академия</font><font size=\\\"18\\\" color=\\\"#ff999999\\\">\\\" в котором можно задавать все интересующие вас вопросы связанные с игрой, и опытные игроки ответят на них.<br><br>Мы организуем учебные вылеты каждую неделю. Информация о вылетах можно узнать:<br>- в дискорде в канале - \\\"</font><font size=\\\"18\\\" color=\\\"#ff00ffff\\\">имперская академия</font><font size=\\\"18\\\" color=\\\"#ff999999\\\">\\\"<br>- во внутри игровой рассылке - </font><font size=\\\"18\\\" color=\\\"#ff00ffff\\\">xxxmail</font><font size=\\\"18\\\" color=\\\"#ff999999\\\"> (почтовый ящик - &gt; слева снизу Добавить почтовую рассылку -&gt; добавляем </font><font size=\\\"18\\\" color=\\\"#ff00ffff\\\">xxxmail</font><font size=\\\"18\\\" color=\\\"#ff999999\\\"> <br>- в корпоративной  </font><font size=\\\"18\\\" color=\\\"#ffffe400\\\"><a href=\\\"https://zen.yandex.ru/media/id/5e68e756f4235c367b77063d/ispolzovanie-pochty-v-eve-online-609c01c79be82c4728c1f87f\\\">Почте</a><br><br></font><font size=\\\"18\\\" color=\\\"#ff999999\\\">Участие в вылетах  - добровольное. а в случае потери корабля на боевом вылете,  его компенсируют. Желательно ознакомиться с </font><font size=\\\"18\\\" color=\\\"#ffffe400\\\"><loc><a href=\\\"http://wiki.banderlogs.ru/doku.php?id=pvp\\\">основами пвп</a></loc></font><font size=\\\"18\\\" color=\\\"#ff999999\\\">.<br>Если летшь первый раз лучше взять  </font><font size=\\\"18\\\" color=\\\"#ffd98d00\\\"><a href=\\\"fitting:585:5443;1:31716;1:8785;3:31752;1:31177;1:8433;1:5971;1:5403;1:2046;1:5599;1:21898;1200::\\\">Slasher</a></font><font size=\\\"18\\\" color=\\\"#ff999999\\\"> из канала  </font><font size=\\\"18\\\" color=\\\"#ff6868e1\\\"><a href=\\\"joinChannel:player_8f48fdde0f9511e9b4bb9abe94f5a43f//None//None\\\">RU_Trashformat</a></font><font size=\\\"18\\\" color=\\\"#ff999999\\\"> <br>А на последующие вылеты корабль который наносит урон  </font><font size=\\\"18\\\" color=\\\"#ffd98d00\\\"><a href=\\\"fitting:32876:9632;1:35658;1:11563;1:31598;1:6160;1:22291;1:3831;1:31608;1:8089;7:31358;1:29009;1:210;1000:29011;1:27361;1000::\\\">Corax</a></font><font size=\\\"18\\\" color=\\\"#ff999999\\\"> или </font><font size=\\\"18\\\" color=\\\"#ffd98d00\\\"><a href=\\\"fitting:621:35771;1:1541;1:31718;1:3496;1:2281;1:31790;2:8529;2:22291;2:5975;1:8027;5:2488;2:27361;1000:27371;1000:28668;50:27381;1000:27387;1095::\\\">Caracal</a></font><font size=\\\"18\\\" color=\\\"#ff999999\\\"> или логиста </font><font size=\\\"18\\\" color=\\\"#ffd98d00\\\"><a href=\\\"fitting:599:2048;1:31716;1:31752;1:2605;2:6001;1:5011;1:3831;1:8537;3:31358;1:2486;1:32006;21::\\\">Burst</a></font><font size=\\\"18\\\" color=\\\"#ff999999\\\"> или </font><font size=\\\"18\\\" color=\\\"#ffd98d00\\\"><a href=\\\"fitting:620:2048;1:8225;2:8579;3:3841;1:2281;2:31754;1:35660;1:31790;2:16495;2:9622;1:2486;4:6005_;1::\\\">Osprey</a><br></font><font size=\\\"18\\\" color=\\\"#ff999999\\\">Прокачка скилов занимает время, поэтому в случае если корабль качать долго есть смысл создать специально под конкретный вылет нового персонажа воспользовавшись  </font><font size=\\\"18\\\" color=\\\"#ffffe400\\\"><a href=\\\"https://zen.yandex.ru/media/id/5e68e756f4235c367b77063d/haliavnyi-liam-skilpointov-v-eve-online-5e9836a866bf881a32fa0ea1\\\">реферальной ссылкой</a></font><font size=\\\"18\\\" color=\\\"#ff999999\\\">, по которой дают 1млн. навыков, которые можно потратить на что угодно. <br><br>Обычно новички самостоятельно изучают игру (а параллельно участвуют в обучающих вылетах), а что не понятно - спрашивают в голосовых каналах в голосовом чате, можно, например, начать с :<br></font><font size=\\\"18\\\" color=\\\"#ffffe400\\\"><a href=\\\"https://zen.yandex.ru/media/id/5e68e756f4235c367b77063d/kadrovye-agenty-v-eve-online-5eab15898a622c20283bf3e2\\\">прохождение кадровых агентов</a><br><a href=\\\"https://zen.yandex.ru/media/id/5e68e756f4235c367b77063d/diskaveri-do-10mln-v-chas-v-eve-online-613195d5a502d2043671608c\\\">участие в проекте Дискавери</a><br><a href=\\\"https://zen.yandex.ru/media/id/5e68e756f4235c367b77063d/sisters-epic-arc-v-eve-online-5eab201a0ab5b766d085325b\\\">проходение систерскую арку</a><br><a href=\\\"https://zen.yandex.ru/media/id/5e68e756f4235c367b77063d/farm-beltov-v-louseke-na-algose-7kk-v-chas-v-eve-online-6148c6fc22cf4f2d6e0b44f9\\\">фарма астеройды в империи</a><br><a href=\\\"https://zen.yandex.ru/media/id/5e68e756f4235c367b77063d/missii-v-airaken-3kk-v-chas-na-missiiah-2-urovnia-na-tristane-bez-blica-v-eve-online-614f3bc68b1b9c2081aa54bb\\\">прохождения миссии агентов</a></font><font size=\\\"18\\\" color=\\\"#ff999999\\\"> используя </font><font size=\\\"18\\\" color=\\\"#ffffe400\\\"><a href=\\\"https://zen.yandex.ru/media/id/5e68e756f4235c367b77063d/gaid-prokachki-cherez-drony-v-eve-online-5e993d0253b3cf245c2b74fd\\\">о<loc>сновной гайд прокачки</a></loc><a href=\\\"https://zen.yandex.ru/media/id/5e68e756f4235c367b77063d/sisters-epic-arc-v-eve-online-5eab201a0ab5b766d085325b\\\"> </a><br><a href=\\\"https://zen.yandex.ru/media/id/5e68e756f4235c367b77063d/kopka-veldsparaskorditapiroksiresa-v-maurasi-riadom-s-jita-na-venture-27mln-v-chas-v-eve-online-613509440d368d33ec2f7917\\\">копки самостоятельно</a></font><font size=\\\"18\\\" color=\\\"#ff999999\\\">  и в составе флота  </font><font size=\\\"18\\\" color=\\\"#ff6868e1\\\"><a href=\\\"joinChannel:-86320118//None//None\\\">Mspace</a></font><font size=\\\"18\\\" color=\\\"#ff999999\\\"> <br></font><font size=\\\"18\\\" color=\\\"#ffffe400\\\"><loc><a href=\\\"http://wiki.banderlogs.ru/doku.php?id=pve\\\">проходят бездн</loc>ы</a><br></font><font size=\\\"18\\\" color=\\\"#ff999999\\\">и многим другим, ознакомиться можно на страничке </font><font size=\\\"18\\\" color=\\\"#ffffe400\\\"><loc><a href=\\\"http://wiki.banderlogs.ru/doku.php?id=kmb\\\">нашей википеди</loc>и</a><br><br></font><font size=\\\"18\\\" color=\\\"#ffffffff\\\">Основная причина почему мы набираем в игроков корпорацию и организуем обучающие вылеты это надежда на то что рекруты освоившись в империи будут переходить в нашу корпорацию базирующуюся в нульсек регионе - </font><font size=\\\"18\\\" color=\\\"#ffd98d00\\\"><a href=\\\"showinfo:3//10000023\\\">Pure Blind.</a></font><font size=\\\"18\\\" color=\\\"#ffffffff\\\"> <br>Обычно новым игрокам требуется около месяца на адаптацию, а переход добровольный</font>";
//
                body = "<font size=\\\"13\\\" color=\\\"#ff999999\\\"></font><font size=\\\"18\\\" color=\\\"#ffd98d00\\\"><a href=\\\"showinfo:1377//" +
                        sender_id +
                        "\\\">" +
                        name +
                        "</a></font><font size=\\\"18\\\" color=\\\"#ff999999\\\">, привет!<br>ты только вступил хочу порекомендовать ссылки на наши ресурсы, которые помогут тебе освоиться:<br><br>1) </font><font size=\\\"18\\\" color=\\\"#ffffe400\\\"><loc><a href=\\\"https://zen.yandex.ru/media/id/5e68e756f4235c367b77063d/putevoditel-po-eve-online-609d371cc6446324a36f0749\\\">Яндекс дзен путеводител</loc>ь</a></font><font size=\\\"18\\\" color=\\\"#ff999999\\\"> (кому не доступен Яндекс воспользуйтесь</font><font size=\\\"18\\\" color=\\\"#ffffe400\\\"><loc><a href=\\\"https://www.torproject.org/ru/download/\\\"> браузером Tor</a></loc></font><font size=\\\"18\\\" color=\\\"#ff999999\\\"> )<br>2) </font><font size=\\\"18\\\" color=\\\"#ffffe400\\\"><a href=\\\"http://wiki.banderlogs.ru/doku.php\\\">Wiki</a></font><font size=\\\"18\\\" color=\\\"#ff999999\\\"> <br>3) </font><font size=\\\"18\\\" color=\\\"#ffffe400\\\"><a href=\\\"https://www.youtube.com/channel/UCjevM1DrRB3Arq-2U2dHvRw\\\">Youtube</a></font><font size=\\\"18\\\" color=\\\"#ff999999\\\"> <br><br>Для общения мы используем голосовой чат  </font><font size=\\\"18\\\" color=\\\"#ffffe400\\\"><a href=\\\"https://discord.gg/QunNGesRYD\\\">Дискорд.</a></font><font size=\\\"18\\\" color=\\\"#ff999999\\\"> На первых порах можно не регистрироваться, но если ты решишь задержаться то надо пройти </font><font size=\\\"18\\\" color=\\\"#ffffe400\\\"><a href=\\\"https://zen.yandex.ru/media/id/5e68e756f4235c367b77063d/diskord-v-eve-online-5e906d1a5b52a25f8a85b903\\\">Авторизация</a></font><font size=\\\"18\\\" color=\\\"#ff999999\\\">, лучше сначала посмотреть  </font><font size=\\\"18\\\" color=\\\"#ffffe400\\\"><a href=\\\"https://youtu.be/8op1tc8dExc\\\">видео про регистрацию</a></font><font size=\\\"18\\\" color=\\\"#ff999999\\\"> <br><br>Для общения используется канал - <br></font><font size=\\\"18\\\" color=\\\"#ff00ffff\\\">fleet Academ voice</font><font size=\\\"18\\\" color=\\\"#ff999999\\\"> в нем обычно сидят новички и те кто им помогают, так что не стесняйся заходи и задавай интересующие вопросы. <br></font><font size=\\\"18\\\" color=\\\"#ffb2b2b2\\\">в каналах</font><font size=\\\"18\\\" color=\\\"#ff00ffff\\\"> fleet 1-5</font><font size=\\\"18\\\" color=\\\"#ff999999\\\"> проходят обучающие вылеты.<br><br><br>После прохождения регистрации у откроется дополнительный канал - \\\"</font><font size=\\\"18\\\" color=\\\"#ff00ffff\\\">имперская академия</font><font size=\\\"18\\\" color=\\\"#ff999999\\\">\\\" в котором можно задавать все интересующие вас вопросы связанные с игрой, и опытные игроки ответят на них.<br><br>Мы организуем учебные вылеты каждую неделю. Информация о вылетах можно узнать:<br>- в дискорде в канале - \\\"</font><font size=\\\"18\\\" color=\\\"#ff00ffff\\\">имперская академия</font><font size=\\\"18\\\" color=\\\"#ff999999\\\">\\\"<br>- во внутри игровой рассылке - </font><font size=\\\"18\\\" color=\\\"#ff00ffff\\\">xxxmail</font><font size=\\\"18\\\" color=\\\"#ff999999\\\"> (почтовый ящик - &gt; слева снизу Добавить почтовую рассылку -&gt; добавляем </font><font size=\\\"18\\\" color=\\\"#ff00ffff\\\">xxxmail</font><font size=\\\"18\\\" color=\\\"#ff999999\\\"> <br>- в корпоративной  </font><font size=\\\"18\\\" color=\\\"#ffffe400\\\"><a href=\\\"https://zen.yandex.ru/media/id/5e68e756f4235c367b77063d/ispolzovanie-pochty-v-eve-online-609c01c79be82c4728c1f87f\\\">Почте</a><br><br></font><font size=\\\"18\\\" color=\\\"#ff999999\\\">Участие в вылетах  - добровольное. а в случае потери корабля на боевом вылете,  его компенсируют. Желательно ознакомиться с </font><font size=\\\"18\\\" color=\\\"#ffffe400\\\"><loc><a href=\\\"http://wiki.banderlogs.ru/doku.php?id=pvp\\\">основами пвп</a></loc></font><font size=\\\"18\\\" color=\\\"#ff999999\\\">.<br>Если летшь первый раз лучше взять  </font><font size=\\\"18\\\" color=\\\"#ffd98d00\\\"><a href=\\\"fitting:585:5443;1:31716;1:8785;3:31752;1:31177;1:8433;1:5971;1:5403;1:2046;1:5599;1:21898;1200::\\\">Slasher</a></font><font size=\\\"18\\\" color=\\\"#ff999999\\\"> из канала  </font><font size=\\\"18\\\" color=\\\"#ff6868e1\\\"><a href=\\\"joinChannel:player_8f48fdde0f9511e9b4bb9abe94f5a43f//None//None\\\">RU_Trashformat</a></font><font size=\\\"18\\\" color=\\\"#ff999999\\\"> <br>А на последующие вылеты корабль который наносит урон  </font><font size=\\\"18\\\" color=\\\"#ffd98d00\\\"><a href=\\\"fitting:32876:9632;1:35658;1:11563;1:31598;1:6160;1:22291;1:3831;1:31608;1:8089;7:31358;1:29009;1:210;1000:29011;1:27361;1000::\\\">Corax</a></font><font size=\\\"18\\\" color=\\\"#ff999999\\\"> или </font><font size=\\\"18\\\" color=\\\"#ffd98d00\\\"><a href=\\\"fitting:621:35771;1:1541;1:31718;1:3496;1:2281;1:31790;2:8529;2:22291;2:5975;1:8027;5:2488;2:27361;1000:27371;1000:28668;50:27381;1000:27387;1095::\\\">Caracal</a></font><font size=\\\"18\\\" color=\\\"#ff999999\\\"> или логиста </font><font size=\\\"18\\\" color=\\\"#ffd98d00\\\"><a href=\\\"fitting:599:2048;1:31716;1:31752;1:2605;2:6001;1:5011;1:3831;1:8537;3:31358;1:2486;1:32006;21::\\\">Burst</a></font><font size=\\\"18\\\" color=\\\"#ff999999\\\"> или </font><font size=\\\"18\\\" color=\\\"#ffd98d00\\\"><a href=\\\"fitting:620:2048;1:8225;2:8579;3:3841;1:2281;2:31754;1:35660;1:31790;2:16495;2:9622;1:2486;4:6005_;1::\\\">Osprey</a><br></font><font size=\\\"18\\\" color=\\\"#ff999999\\\">Прокачка скилов занимает время, поэтому в случае если корабль качать долго есть смысл создать специально под конкретный вылет нового персонажа воспользовавшись  </font><font size=\\\"18\\\" color=\\\"#ffffe400\\\"><a href=\\\"https://zen.yandex.ru/media/id/5e68e756f4235c367b77063d/haliavnyi-liam-skilpointov-v-eve-online-5e9836a866bf881a32fa0ea1\\\">реферальной ссылкой</a></font><font size=\\\"18\\\" color=\\\"#ff999999\\\">, по которой дают 1млн. навыков, которые можно потратить на что угодно. <br><br>На начальном этапе придется много посмотреть-почитать об игре и поучаствовать в обучающих вылетах, а что не понятно - спрашивают в голосовых каналах в голосовом чате, можно, например, начать с :<br></font><font size=\\\"18\\\" color=\\\"#ffffe400\\\"><a href=\\\"https://zen.yandex.ru/media/id/5e68e756f4235c367b77063d/kadrovye-agenty-v-eve-online-5eab15898a622c20283bf3e2\\\">прохождение кадровых агентов</a><br><a href=\\\"https://zen.yandex.ru/media/id/5e68e756f4235c367b77063d/diskaveri-do-10mln-v-chas-v-eve-online-613195d5a502d2043671608c\\\">участие в проекте Дискавери</a><br><a href=\\\"https://zen.yandex.ru/media/id/5e68e756f4235c367b77063d/sisters-epic-arc-v-eve-online-5eab201a0ab5b766d085325b\\\">проходение систерскую арку</a><br><a href=\\\"https://zen.yandex.ru/media/id/5e68e756f4235c367b77063d/farm-beltov-v-louseke-na-algose-7kk-v-chas-v-eve-online-6148c6fc22cf4f2d6e0b44f9\\\">фарма астеройды в империи</a><br><a href=\\\"https://zen.yandex.ru/media/id/5e68e756f4235c367b77063d/missii-v-airaken-3kk-v-chas-na-missiiah-2-urovnia-na-tristane-bez-blica-v-eve-online-614f3bc68b1b9c2081aa54bb\\\">прохождения миссии агентов</a></font><font size=\\\"18\\\" color=\\\"#ff999999\\\"> используя </font><font size=\\\"18\\\" color=\\\"#ffffe400\\\"><a href=\\\"https://zen.yandex.ru/media/id/5e68e756f4235c367b77063d/gaid-prokachki-cherez-drony-v-eve-online-5e993d0253b3cf245c2b74fd\\\">о<loc>сновной гайд прокачки</a></loc><a href=\\\"https://zen.yandex.ru/media/id/5e68e756f4235c367b77063d/sisters-epic-arc-v-eve-online-5eab201a0ab5b766d085325b\\\"> </a><br><a href=\\\"https://zen.yandex.ru/media/id/5e68e756f4235c367b77063d/kopka-veldsparaskorditapiroksiresa-v-maurasi-riadom-s-jita-na-venture-27mln-v-chas-v-eve-online-613509440d368d33ec2f7917\\\">копки самостоятельно</a></font><font size=\\\"18\\\" color=\\\"#ff999999\\\">  и в составе флота  </font><font size=\\\"18\\\" color=\\\"#ff6868e1\\\"><a href=\\\"joinChannel:-86320118//None//None\\\">Mspace</a></font><font size=\\\"18\\\" color=\\\"#ff999999\\\"> <br></font><font size=\\\"18\\\" color=\\\"#ffffe400\\\"><loc><a href=\\\"http://wiki.banderlogs.ru/doku.php?id=pve\\\">проходят бездн</loc>ы</a><br></font><font size=\\\"18\\\" color=\\\"#ff999999\\\">и многим другим, ознакомиться можно на страничке </font><font size=\\\"18\\\" color=\\\"#ffffe400\\\"><loc><a href=\\\"http://wiki.banderlogs.ru/doku.php?id=kmb\\\">нашей википеди</loc>и</a><br><br></font><font size=\\\"18\\\" color=\\\"#ffffffff\\\">Основная причина почему мы набираем в игроков корпорацию и организуем обучающие вылеты это надежда на то что рекруты освоившись в империи будут переходить в нашу корпорацию базирующуюся в нульсек регионе - </font><font size=\\\"18\\\" color=\\\"#ffd98d00\\\"><a href=\\\"showinfo:3//10000023\\\">Pure Blind.</a></font><font size=\\\"18\\\" color=\\\"#ffffffff\\\"> <br></font>";


                break;

            case 4:
                subject = "Переход в нули как этап развития игроков академии";
                body = "<font size=\\\"13\\\" color=\\\"#ff999999\\\"></font><font size=\\\"18\\\" color=\\\"#ffd98d00\\\"><a href=\\\"showinfo:1383//" +
                        sender_id +
                        "\\\">" +
                        name +
                        "</a></font><font size=\\\"18\\\" color=\\\"#ff999999\\\">, привет!<br>Ты у нас уже около месяца, хочу тебе напомнить, что основная причина почему мы набираем в игроков корпорацию и организуем обучающие вылеты это надежда на то что рекруты освоившись в империи будут переходить в нашу корпорацию базирующуюся в нульсек регионе -  </font><font size=\\\"18\\\" color=\\\"#ffd98d00\\\"><a href=\\\"showinfo:3//10000023\\\">Pure Blind</a></font><font size=\\\"18\\\" color=\\\"#ff999999\\\">. Вылеты проходят с  </font><font size=\\\"18\\\" color=\\\"#ffd98d00\\\"><a href=\\\"showinfo:35833//1036238770247\\\">5ZXX-K - XPEHOB (OLIMP inc)</a></font><font size=\\\"18\\\" color=\\\"#ff999999\\\"> <br><br></font><font size=\\\"18\\\" color=\\\"#ff007fff\\\">Нас постоянно атакуют, и без сильного флота нам тяжело оборонять наши территории. <br><br></font><font size=\\\"18\\\" color=\\\"#ffffffff\\\">Для перехода в нулевую корпорацию</font><font size=\\\"18\\\" color=\\\"#ff999999\\\"> </font><font size=\\\"18\\\" color=\\\"#ffffffff\\\"><u>нам нужны пилоты(пилотессы) которые:</u><br>- интересна командная игра;<br>- пользуются голосовым чатом - </font><font size=\\\"18\\\" color=\\\"#ffffe400\\\"><a href=\\\"https://discord.gg/QunNGesRYD\\\">Дискордом</a></font><font size=\\\"18\\\" color=\\\"#ffffffff\\\"> ;<br>- участвуют в пвп и пве обучающих вылетах.<br><br><u>В обмен мы предлагаем </u><br>адекватный коллектив, различные виды нулевых заработков (как правило раза в 2-3 выше чем в империи), компенсацию потерянных кораблей на вылетах, обучени пилотированию на кораблях разных классов.<br> <br></font><font size=\\\"18\\\" color=\\\"#ff00ffff\\\"><u>Чтобы перейти в нулевую корпорацию надо :</u><br>- Изучить все корабли из канала -  </font><font size=\\\"18\\\" color=\\\"#ff6868e1\\\"><a href=\\\"joinChannel:player_8f48fdde0f9511e9b4bb9abe94f5a43f//None//None\\\">RU_Trashformat</a></font><font size=\\\"18\\\" color=\\\"#ff00ffff\\\"> <br>- Попробовать все доступные новичкам виды заработка в империи. (агенты, сканирование, копка, бездны, ) и заработать базовый капитал, который поможет продержаться первое время.<br>- Поучаствовать в 5-10 боевых и учебных вылетах; активность проверяем по </font><font size=\\\"18\\\" color=\\\"#ffffe400\\\"><loc><a href=\\\"https://zkillboard.com/character/514674064/\\\">Zkillboard</a></loc><br></font><font size=\\\"18\\\" color=\\\"#ff00ffff\\\">- Быть зарегистрированным в дискорде. </font><font size=\\\"18\\\" color=\\\"#ffffe400\\\"><a href=\\\"https://zen.yandex.ru/media/id/5e68e756f4235c367b77063d/diskord-v-eve-online-5e906d1a5b52a25f8a85b903\\\">пройти регистрацию</a></font><font size=\\\"18\\\" color=\\\"#ff00ffff\\\"> нужно в течении первого месяца игры<br><br><br></font><font size=\\\"18\\\" color=\\\"#ff00ff00\\\">Если все критерии выполнены  подавайте заявку в  </font><font size=\\\"18\\\" color=\\\"#ffd98d00\\\"><a href=\\\"showinfo:2//98520878\\\">Russian Space Community</a></font><font size=\\\"18\\\" color=\\\"#ff00ff00\\\">. Важно что после перехода в эту корпорацию у вас появится война и вас смогут стрелять в империи, поэтому перед тем как вступить свезите все ваше имущество на станцию - </font><font size=\\\"18\\\" color=\\\"#ffd98d00\\\"><a href=\\\"showinfo:52678//60003760\\\">Jita IV - Moon 4 - Caldari Navy Assembly Plant</a></font><font size=\\\"18\\\" color=\\\"#ff00ff00\\\"> с нее осуществляется доставка имущества в нули. <br><br>Ответственный за прием в - </font><font size=\\\"18\\\" color=\\\"#ffd98d00\\\"><a href=\\\"showinfo:1376//2116980676\\\">Dark kardinal</a></font><font size=\\\"18\\\" color=\\\"#ff00ff00\\\"> (ингейм) или в дискорде </font><font size=\\\"18\\\" color=\\\"#ffffffff\\\">DarK KardInaLL#8019</font><font size=\\\"18\\\" color=\\\"#ff00ff00\\\">  </font>";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + i);
        }

// <font size=\"13\" color=\"#ff999999\"></font><font size=\"18\" color=\"#ffd98d00\"><a href=\"showinfo:1383//514674064\">Lapsh Banderlog</a></font><font size=\"18\" color=\"#ff999999\">, привет!<br>ты только вступил хочу порекомендовать ссылки на наши ресурсы, которые помогут тебе освоиться:<br><br>1) </font><font size=\"18\" color=\"#ffffe400\"><loc><a href=\"https://zen.yandex.ru/media/id/5e68e756f4235c367b77063d/putevoditel-po-eve-online-609d371cc6446324a36f0749\">Яндекс дзен путеводител</loc>ь</a></font><font size=\"18\" color=\"#ff999999\"> (кому не доступен Яндекс воспользуйтесь</font><font size=\"18\" color=\"#ffffe400\"><loc><a href=\"https://www.torproject.org/ru/download/\"> браузером Tor</a></loc></font><font size=\"18\" color=\"#ff999999\"> )<br>2) </font><font size=\"18\" color=\"#ffffe400\"><a href=\"http://wiki.banderlogs.ru/doku.php\">Wiki</a></font><font size=\"18\" color=\"#ff999999\"> <br>3) </font><font size=\"18\" color=\"#ffffe400\"><a href=\"https://www.youtube.com/channel/UCjevM1DrRB3Arq-2U2dHvRw\">Youtube</a></font><font size=\"18\" color=\"#ff999999\"> <br><br>Для общения мы используем голосовой чат  </font><font size=\"18\" color=\"#ffffe400\"><a href=\"https://discord.gg/QunNGesRYD\">Дискорд.</a></font><font size=\"18\" color=\"#ff999999\"> На первых порах можно не регистрироваться, но если ты решишь задержаться то надо пройти </font><font size=\"18\" color=\"#ffffe400\"><a href=\"https://zen.yandex.ru/media/id/5e68e756f4235c367b77063d/diskord-v-eve-online-5e906d1a5b52a25f8a85b903\">Авторизация</a></font><font size=\"18\" color=\"#ff999999\">, лучше сначала посмотреть  </font><font size=\"18\" color=\"#ffffe400\"><a href=\"https://youtu.be/8op1tc8dExc\">видео про регистрацию</a></font><font size=\"18\" color=\"#ff999999\"> <br><br>Для общения используется канал - <br></font><font size=\"18\" color=\"#ff00ffff\">fleet Academ voice</font><font size=\"18\" color=\"#ff999999\"> в нем обычно сидят новички и те кто им помогают, так что не стесняйся заходи и задавай интересующие вопросы. <br></font><font size=\"18\" color=\"#ffb2b2b2\">в канале</font><font size=\"18\" color=\"#ff00ffff\"> Информация рекрутинг</font><font size=\"18\" color=\"#ff999999\">   можно прослушать информацию о нас.<br><br><br>После прохождения регистрации у откроется дополнительный канал - \"</font><font size=\"18\" color=\"#ff00ffff\">имперская академия</font><font size=\"18\" color=\"#ff999999\">\" в котором можно задавать все интересующие вас вопросы связанные с игрой, и опытные игроки ответят на них.<br><br>Мы организуем учебные вылеты каждую неделю. Информация о вылетах можно узнать:<br>- в дискорде в канале - \"</font><font size=\"18\" color=\"#ff00ffff\">имперская академия</font><font size=\"18\" color=\"#ff999999\">\"<br>- во внутри игровой рассылке - </font><font size=\"18\" color=\"#ff00ffff\">xxxmail</font><font size=\"18\" color=\"#ff999999\"> (почтовый ящик - &gt; слева снизу Добавить почтовую рассылку -&gt; добавляем </font><font size=\"18\" color=\"#ff00ffff\">xxxmail</font><font size=\"18\" color=\"#ff999999\"> <br>- в корпоративной  </font><font size=\"18\" color=\"#ffffe400\"><a href=\"https://zen.yandex.ru/media/id/5e68e756f4235c367b77063d/ispolzovanie-pochty-v-eve-online-609c01c79be82c4728c1f87f\">Почте</a><br><br></font><font size=\"18\" color=\"#ff999999\">Участие в вылетах  - добровольное. а в случае потери корабля на боевом вылете,  его компенсируют. Желательно ознакомиться с </font><font size=\"18\" color=\"#ffffe400\"><loc><a href=\"http://wiki.banderlogs.ru/doku.php?id=pvp\">основами пвп</a></loc></font><font size=\"18\" color=\"#ff999999\">.<br>Если летшь первый раз лучше взять  </font><font size=\"18\" color=\"#ffd98d00\"><a href=\"fitting:585:5443;1:31716;1:8785;3:31752;1:31177;1:8433;1:5971;1:5403;1:2046;1:5599;1:21898;1200::\">Slasher</a></font><font size=\"18\" color=\"#ff999999\"> из канала  </font><font size=\"18\" color=\"#ff6868e1\"><a href=\"joinChannel:player_8f48fdde0f9511e9b4bb9abe94f5a43f//None//None\">RU_Trashformat</a></font><font size=\"18\" color=\"#ff999999\"> <br>А на последующие вылеты корабль который наносит урон  </font><font size=\"18\" color=\"#ffd98d00\"><a href=\"fitting:32876:9632;1:35658;1:11563;1:31598;1:6160;1:22291;1:3831;1:31608;1:8089;7:31358;1:29009;1:210;1000:29011;1:27361;1000::\">Corax</a></font><font size=\"18\" color=\"#ff999999\"> или </font><font size=\"18\" color=\"#ffd98d00\"><a href=\"fitting:621:35771;1:1541;1:31718;1:3496;1:2281;1:31790;2:8529;2:22291;2:5975;1:8027;5:2488;2:27361;1000:27371;1000:28668;50:27381;1000:27387;1095::\">Caracal</a></font><font size=\"18\" color=\"#ff999999\"> или логиста </font><font size=\"18\" color=\"#ffd98d00\"><a href=\"fitting:599:2048;1:31716;1:31752;1:2605;2:6001;1:5011;1:3831;1:8537;3:31358;1:2486;1:32006;21::\">Burst</a></font><font size=\"18\" color=\"#ff999999\"> или </font><font size=\"18\" color=\"#ffd98d00\"><a href=\"fitting:620:2048;1:8225;2:8579;3:3841;1:2281;2:31754;1:35660;1:31790;2:16495;2:9622;1:2486;4:6005_;1::\">Osprey</a><br></font><font size=\"18\" color=\"#ff999999\">Прокачка скилов занимает время, поэтому в случае если корабль качать долго есть смысл создать специально под конкретный вылет нового персонажа воспользовавшись  </font><font size=\"18\" color=\"#ffffe400\"><a href=\"https://zen.yandex.ru/media/id/5e68e756f4235c367b77063d/haliavnyi-liam-skilpointov-v-eve-online-5e9836a866bf881a32fa0ea1\">реферальной ссылкой</a></font><font size=\"18\" color=\"#ff999999\">, по которой дают 1млн. навыков, которые можно потратить на что угодно. <br><br>Обычно новички самостоятельно изучают игру (а параллельно участвуют в обучающих вылетах), а что не понятно - спрашивают в голосовых каналах в голосовом чате, можно, например, начать с :<br></font><font size=\"18\" color=\"#ffffe400\"><a href=\"https://zen.yandex.ru/media/id/5e68e756f4235c367b77063d/kadrovye-agenty-v-eve-online-5eab15898a622c20283bf3e2\">прохождение кадровых агентов</a><br><a href=\"https://zen.yandex.ru/media/id/5e68e756f4235c367b77063d/diskaveri-do-10mln-v-chas-v-eve-online-613195d5a502d2043671608c\">участие в проекте Дискавери</a><br><a href=\"https://zen.yandex.ru/media/id/5e68e756f4235c367b77063d/sisters-epic-arc-v-eve-online-5eab201a0ab5b766d085325b\">проходение систерскую арку</a><br><a href=\"https://zen.yandex.ru/media/id/5e68e756f4235c367b77063d/farm-beltov-v-louseke-na-algose-7kk-v-chas-v-eve-online-6148c6fc22cf4f2d6e0b44f9\">фарма астеройды в империи</a><br><a href=\"https://zen.yandex.ru/media/id/5e68e756f4235c367b77063d/missii-v-airaken-3kk-v-chas-na-missiiah-2-urovnia-na-tristane-bez-blica-v-eve-online-614f3bc68b1b9c2081aa54bb\">прохождения миссии агентов</a></font><font size=\"18\" color=\"#ff999999\"> используя </font><font size=\"18\" color=\"#ffffe400\"><a href=\"https://zen.yandex.ru/media/id/5e68e756f4235c367b77063d/gaid-prokachki-cherez-drony-v-eve-online-5e993d0253b3cf245c2b74fd\">о<loc>сновной гайд прокачки</a></loc><a href=\"https://zen.yandex.ru/media/id/5e68e756f4235c367b77063d/sisters-epic-arc-v-eve-online-5eab201a0ab5b766d085325b\"> </a><br><a href=\"https://zen.yandex.ru/media/id/5e68e756f4235c367b77063d/kopka-veldsparaskorditapiroksiresa-v-maurasi-riadom-s-jita-na-venture-27mln-v-chas-v-eve-online-613509440d368d33ec2f7917\">копки самостоятельно</a></font><font size=\"18\" color=\"#ff999999\">  и в составе флота  </font><font size=\"18\" color=\"#ff6868e1\"><a href=\"joinChannel:-86320118//None//None\">Mspace</a></font><font size=\"18\" color=\"#ff999999\"> <br></font><font size=\"18\" color=\"#ffffe400\"><loc><a href=\"http://wiki.banderlogs.ru/doku.php?id=pve\">проходят бездн</loc>ы</a><br></font><font size=\"18\" color=\"#ff999999\">и многим другим, ознакомиться можно на страничке </font><font size=\"18\" color=\"#ffffe400\"><loc><a href=\"http://wiki.banderlogs.ru/doku.php?id=kmb\">нашей википеди</loc>и</a><br><br></font><font size=\"18\" color=\"#ffffffff\">Основная причина почему мы набираем в игроков корпорацию и организуем обучающие вылеты это надежда на то что рекруты освоившись в империи будут переходить в нашу корпорацию базирующуюся в нульсек регионе - </font><font size=\"18\" color=\"#ffd98d00\"><a href=\"showinfo:3//10000023\">Pure Blind.</a></font><font size=\"18\" color=\"#ffffffff\"> <br>Обычно новым игрокам требуется около месяца на адаптацию, а переход добровольный</font>
// <font size=\"13\" color=\"#ff999999\"></font><font size=\"18\" color=\"#ffd98d00\"><a href=\"showinfo:1383//514674064\">Lapsh Banderlog</a></font><font size=\"18\" color=\"#ff999999\">, привет!<br>Ты у нас уже около месяца, хочу тебе напомнить, что основная причина почему мы набираем в игроков корпорацию и организуем обучающие вылеты это надежда на то что рекруты освоившись в империи будут переходить в нашу корпорацию базирующуюся в нульсек регионе -  </font><font size=\"18\" color=\"#ffd98d00\"><a href=\"showinfo:3//10000023\">Pure Blind</a></font><font size=\"18\" color=\"#ff999999\">. Вылеты проходят с  </font><font size=\"18\" color=\"#ffd98d00\"><a href=\"showinfo:35833//1036238770247\">5ZXX-K - XPEHOB (OLIMP inc)</a></font><font size=\"18\" color=\"#ff999999\"> <br><br></font><font size=\"18\" color=\"#ff007fff\">Нас постоянно атакуют, и без сильного флота нам тяжело оборонять наши территории. <br><br></font><font size=\"18\" color=\"#ffffffff\">Для перехода в нулевую корпорацию</font><font size=\"18\" color=\"#ff999999\"> </font><font size=\"18\" color=\"#ffffffff\"><u>нам нужны пилоты(пилотессы) которые:</u><br>- интересна командная игра;<br>- пользуются голосовым чатом - </font><font size=\"18\" color=\"#ffffe400\"><a href=\"https://discord.gg/QunNGesRYD\">Дискордом</a></font><font size=\"18\" color=\"#ffffffff\"> ;<br>- участвуют в пвп и пве обучающих вылетах.<br><br><u>В обмен мы предлагаем </u><br>адекватный коллектив, различные виды нулевых заработков (как правило раза в 2-3 выше чем в империи), компенсацию потерянных кораблей на вылетах, обучени пилотированию на кораблях разных классов.<br> <br></font><font size=\"18\" color=\"#ff00ffff\"><u>Чтобы перейти в нулевую корпорацию надо :</u><br>- Изучить все корабли из канала -  </font><font size=\"18\" color=\"#ff6868e1\"><a href=\"joinChannel:player_8f48fdde0f9511e9b4bb9abe94f5a43f//None//None\">RU_Trashformat</a></font><font size=\"18\" color=\"#ff00ffff\"> <br>- Попробовать все доступные новичкам виды заработка в империи. (агенты, сканирование, копка, бездны, ) и заработать базовый капитал, который поможет продержаться первое время.<br>- Поучаствовать в 5-10 боевых и учебных вылетах; активность проверяем по </font><font size=\"18\" color=\"#ffffe400\"><loc><a href=\"https://zkillboard.com/character/514674064/\">Zkillboard</a></loc><br></font><font size=\"18\" color=\"#ff00ffff\">- Быть зарегистрированным в дискорде. </font><font size=\"18\" color=\"#ffffe400\"><a href=\"https://zen.yandex.ru/media/id/5e68e756f4235c367b77063d/diskord-v-eve-online-5e906d1a5b52a25f8a85b903\">пройти регистрацию</a></font><font size=\"18\" color=\"#ff00ffff\"> нужно в течении первого месяца игры<br><br><br></font><font size=\"18\" color=\"#ff00ff00\">Если все критерии выполнены  подавайте заявку в  </font><font size=\"18\" color=\"#ffd98d00\"><a href=\"showinfo:2//98520878\">Russian Space Community</a></font><font size=\"18\" color=\"#ff00ff00\">. Важно что после перехода в эту корпорацию у вас появится война и вас смогут стрелять в империи, поэтому перед тем как вступить свезите все ваше имущество на станцию - </font><font size=\"18\" color=\"#ffd98d00\"><a href=\"showinfo:52678//60003760\">Jita IV - Moon 4 - Caldari Navy Assembly Plant</a></font><font size=\"18\" color=\"#ff00ff00\"> с нее осуществляется доставка имущества в нули. <br><br>Ответственный за прием в - </font><font size=\"18\" color=\"#ffd98d00\"><a href=\"showinfo:1376//2116980676\">Dark kardinal</a></font><font size=\"18\" color=\"#ff00ff00\"> (ингейм) или в дискорде </font><font size=\"18\" color=\"#ffffffff\">DarK KardInaLL#8019</font><font size=\"18\" color=\"#ff00ff00\">  </font>

        String urlParameters = "{\n" +
                "  \"approved_cost\": 0,\n" +
                " \"body\": \" " +
                body +
                "\"," +

                "  \"recipients\": [\n" +
                "    {\n" +
                //    "      \"recipient_id\": 809294375,\n" +
                "      \"recipient_id\": " +
                sender_id +
                ",\n" +
                "      \"recipient_type\": \"" +
                "character" +
                "\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"subject\": \"" +
                "Subject: " + subject +
                "\"\n" +
                "}";

//        String urlParameters = "{\n" +
//                "  \"approved_cost\": 0,\n" +
//                " \"body\": \"" +
//                body +
//                "  \",  \"recipients\": [\n" +
//                "    {\n" +
//                "      \"recipient_id\": 1899497547,\n" +
//                "      \"recipient_type\": \"character\"\n" +
//                "    }\n" +
//                "  ],\n" +
//                "  \"subject\": \"Subject: Полезная информация для вновь вступивших\"\n" +
//                "}";

//
//            String urlParameters = "{\n" +
//                "  \"approved_cost\": 0,\n" +
//                "  \"body\": \"Информация по вступлению в корпорацию\",\n" +
//                "  \"recipients\": [\n" +
//                "    {\n" +
//                "      \"recipient_id\": " +
//                sender_id +
//                ",\n" +
//                "      \"recipient_type\": \"character\"\n" +
//                "    }\n" +
//                "  ],\n" +
//                "  \"subject\": \"Информация по вступлению в корпорацию\"\n" +
//                "}";

        httpClient.setDoOutput(true);

        OutputStream wr = httpClient.getOutputStream();
        try (BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(wr, "UTF-8"))) {
            //   new OutputStreamWriter(wr))) {
            writer.write(urlParameters);
            writer.flush();
            writer.close();
            wr.close();
        }

        int responseCode = httpClient.getResponseCode();
        System.out.println("Response Code : " + responseCode);

        if (responseCode == 520) {

            System.out.println("520 ошибка (блокировка отправляющего");
            throw new HttpException520();

        }

        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(httpClient.getInputStream()))) {

            String line;
            StringBuilder response = new StringBuilder();

            while ((line = in.readLine()) != null) {
                response.append(line);
            }

        }

    }


    public String id(String name) throws IOException {

//        String path = "E:\\514674064.txt";
//        BufferedReader br = new BufferedReader(new FileReader(path));
//        String sCurrentLine = br.readLine();
//        String token = "";
//        token = sCurrentLine;

        String url = "https://esi.evetech.net/latest/universe/ids/?datasource=tranquility&language=en";


        //    String url = String.join("=", url1,token );
        //      System.out.println(url);

        HttpsURLConnection httpClient = (HttpsURLConnection) new URL(url).openConnection();

        //add reqest header
        httpClient.setRequestMethod("POST");
        httpClient.setRequestProperty("accept", "application/json");
        httpClient.setRequestProperty("Accept-Language", "en-us");
        httpClient.setRequestProperty("Content-Type", "application/json");

        // String urlParameters = "{  \"approved_cost\": 0,  \"body\": \"test\",  \"recipients\": [    {      \"recipient_id\": 839982294,      \"recipient_type\": \"character\"    }  ],  \"subject\": \"string\"}";
        String urlParameters = "[\n" +
                "  \"" +
                name +
                "\"\n" +
                "]";
        //     String urlParameters = name;
        httpClient.setDoOutput(true);

        OutputStream wr = httpClient.getOutputStream();
        try (BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(wr, "UTF-8"))) {
            //   new OutputStreamWriter(wr))) {
            writer.write(urlParameters);
            writer.flush();
            writer.close();
            wr.close();
        }

        StringBuilder response = new StringBuilder();

        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(httpClient.getInputStream()))) {

            String line;


            while ((line = in.readLine()) != null) {
                response.append(line);
            }

        }
        return response.toString();
    }

    public void test99() throws Exception {
        getNotificationBody();
        List<Notification> corpAppNewMsg = notificationRepository.findAllMain1();

        for (Notification n : corpAppNewMsg) {


            log.debug("notifications_id {} ", n.getTimestamp());

        }


    }

    public String test1() throws Exception {

        updatBaseLast(getNotification());

        return "finish";
    }

    public void test2() throws Exception {

        updateFromH2all();
    }

    public void test12() throws Exception {

        presendmail(2);
        presendmail(1);
    }

    public void test3() throws Exception {

        presendmail(3);

    }

    public static String getCharInfoService(long charId) throws IOException, InterruptedException {
//        String PATCH = "E:\\514674064.txt";
//
//        String path = "E:\\514674064.txt";
//        BufferedReader br = new BufferedReader(new FileReader(path));
//        String sCurrentLine = br.readLine();
//        String token = "";
//        token = sCurrentLine;
//
//        System.out.println(token);
        final String uri = "https://esi.evetech.net/latest/characters/" +
                //  "1057512100" +
                charId +
                "/?datasource=tranquility";

        //   System.out.println(uri);
        //   final String uri = "https://esi.evetech.net/latest/alliances/?datasource=tranquility";
        RestTemplate restTemplate = new RestTemplate();
        //  restTemplate.setErrorHandler(new MyErrorHandler());
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set("Cache-Control", "no-cache");
        headers.set("accept", "application/json");

        HttpEntity<String> entity = new HttpEntity<String>(headers);
        //   log.debug("char id {}", charId);
        ResponseEntity<String> response = null;
        String body = "";
        try {
            response = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);

        } catch (HttpClientErrorException ex) {
            if (ex.getRawStatusCode() == 404)
            //        if (ex.getStatusCode() != HttpStatus.NOT_FOUND)

            {
                // throw ex;
                System.out.println("ошибка 404" + charId);
                Thread.sleep(10000);
            } else if (ex.getRawStatusCode() == 504) {
                System.out.println("ошибка 504" + charId);
                Thread.sleep(10000);
            } else if (ex.getRawStatusCode() == 502) {
                System.out.println("ошибка 502" + charId);

                Thread.sleep(10000);
            }
        }

        //if (response = "{\"error\":\"Character has been deleted!\"}") response = "";

        //    log.debug("char id {}", charId);
//        if(response.getStatusCode().value()> 206){
//        //    log.debug("char id error {}", charId);
//           // throw new ApplicationException();
//                 //   return response.getBody();
//                    body = "<200,{\"birthday\":\"2021-09-27T07:08:51Z\",\"bloodline_id\":14,\"corporation_id\":1000170,\"description\":\"Pilots from the Republic Military School's Center for Combat Studies are known for their creative approach to battle tactics. \",\"gender\":\"male\",\"name\":\"Weidj\",\"race_id\":2,\"security_status\":0.36714101800000004},[Date:\"Tue, 16 Nov 2021 08:06:07 GMT\", Content-Type:\"application/json; charset=UTF-8\", Content-Length:\"302\", Connection:\"keep-alive\", Access-Control-Allow-Credentials:\"true\", Access-Control-Allow-Headers:\"Content-Type,Authorization,If-None-Match,X-User-Agent\", Access-Control-Allow-Methods:\"GET,HEAD,OPTIONS\", Access-Control-Allow-Origin:\"*\", Access-Control-Expose-Headers:\"Content-Type,Warning,ETag,X-Pages,X-ESI-Error-Limit-Remain,X-ESI-Error-Limit-Reset\", Access-Control-Max-Age:\"600\", Allow:\"GET,HEAD,OPTIONS\", Cache-Control:\"public\", Etag:\"\"9dd18931453a2e51f940977e72fff63355670d182edefd2439d91313\"\", Expires:\"Tue, 16 Nov 2021 15:00:22 GMT\", Last-Modified:\"Mon, 15 Nov 2021 15:00:22 GMT\", Strict-Transport-Security:\"max-age=31536000\", X-Esi-Error-Limit-Remain:\"100\", X-Esi-Error-Limit-Reset:\"53\", X-Esi-Request-Id:\"8d03b80d-e21a-4697-be42-9175fbe73b14\"]>";
//        }
//        else body = response.getBody();
        if (response == null) {
            return "{\"birthday\":\"2021-01-01T00:00:00Z\",\"bloodline_id\":14,\"corporation_id\":98500220,\"description\":\"Pilots from the Republic Military School's Center for Combat Studies are known for their creative approach to battle tactics. \",\"gender\":\"male\",\"name\":\"ERROR\",\"race_id\":2,\"security_status\":0.00000000000000000},[Date:\"Tue, 16 Nov 2021 08:06:07 GMT\", Content-Type:\"application/json; charset=UTF-8\", Content-Length:\"302\", Connection:\"keep-alive\", Access-Control-Allow-Credentials:\"true\", Access-Control-Allow-Headers:\"Content-Type,Authorization,If-None-Match,X-User-Agent\", Access-Control-Allow-Methods:\"GET,HEAD,OPTIONS\", Access-Control-Allow-Origin:\"*\", Access-Control-Expose-Headers:\"Content-Type,Warning,ETag,X-Pages,X-ESI-Error-Limit-Remain,X-ESI-Error-Limit-Reset\", Access-Control-Max-Age:\"600\", Allow:\"GET,HEAD,OPTIONS\", Cache-Control:\"public\", Etag:\"\"9dd18931453a2e51f940977e72fff63355670d182edefd2439d91313\"\", Expires:\"Tue, 16 Nov 2021 15:00:22 GMT\", Last-Modified:\"Mon, 15 Nov 2021 15:00:22 GMT\", Strict-Transport-Security:\"max-age=31536000\", X-Esi-Error-Limit-Remain:\"100\", X-Esi-Error-Limit-Reset:\"53\", X-Esi-Request-Id:\"8d03b80d-e21a-4697-be42-9175fbe73b14\"]";
        } else return response.getBody();
        // return body;
    }

}