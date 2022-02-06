//package spring.demo.demo.services;
//
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.*;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.HttpClientErrorException;
//import org.springframework.web.client.HttpServerErrorException;
//import org.springframework.web.client.RestTemplate;
//
//import pl.allegro.finance.tradukisto.ValueConverters;
//import spring.demo.demo.model.entity.*;
//import spring.demo.demo.model.repository.CharactersRepository;
//import spring.demo.demo.model.repository.NotificationRepository;
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Date;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//@JsonIgnoreProperties
//@SpringBootTest
//@Slf4j
//class NotificationServiceTest {
//
//    @Autowired
//    NotificationService notificationService;
//    @Autowired
//    NotificationRepository notificationRepository;
//    @Autowired
//    CharactersRepository charactersRepository;
//
//    @Test
//    String idFromName(String name) throws IOException {
//        //  String name = "Legionnaire Paulus";
//        //  System.out.println(notificationService.id(name));
//
//        return notificationService.id(name);
//    }
//
//    //  @Scheduled(cron =  "0 0 */2 * * ?")
//    @Test
//    void idFromName2() throws IOException {
//        String name = "\uFEFFAchatur Gandganyan".replace("\uFEFF", "");
//        System.out.println(notificationService.id(name));
//
////"\uFEFFAchatur Gandganyan"
//        // return  "{\"characters\":[{\"id\":1057512100,\"name\":\"Legionnaire Paulus\"}]}";
//        //  return  "[{\"id\":1057512100,\"name\":\"Legionnaire Paulus\"}]";
//    }
//
//    //@Scheduled(fixedDelay = 60000)
//    @Test
//    void fromNpcFile() throws IOException {
//        List<String> all = new ArrayList<>();
//        try {
//            String path = "E:\\npc.txt";
//            BufferedReader br = new BufferedReader(new FileReader(path));
//            String sCurrentLine;
//            while ((sCurrentLine = br.readLine()) != null) {
//                all.add(sCurrentLine);
//                //  all.add("\n");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        List<String> distinctInts = all.stream().distinct().collect(Collectors.toList());
//
//        for (String name : distinctInts) {
//            try {
//
//
//                ObjectMapper objectMapper = new ObjectMapper();
//                String makeobject = idFromName(name.replace("\uFEFF", ""));
//                CharactersDTO characters = objectMapper.readValue(makeobject, CharactersDTO.class);
//
//                List<CharactersPOJO> list = characters.getCharacters();
//                log.debug("ошибка {} {}", name, makeobject);
//                for (CharactersPOJO n : list) {
//
//                    charactersRepository.save(n);
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            } catch (NullPointerException e) {
//                System.out.print("NullPointerException caught");
//            }
//        }
//        // String message;
////    JSONArray messages = new JSONArray();
////    for (String name : all)
////    {
////        messages.add(name);
////    }
//
//
//        // List<String> myArrayList = new ArrayList<>(Arrays.asList(all.split("\n")));
//
////    String jsonAsString1 = "";
////for (String name : all)
////{
////    jsonAsString1 += "\""+name+"\""+","+"\n";
////}
////    String  jsonAsString2 = jsonAsString1.substring(0,jsonAsString1.length()-2);
////  String  jsonAsString = "["+"\n"+jsonAsString2+"\n"+"]";
//
//        //  String jsonAsString =  idFromName2();
//        //String json =  jsonAsString.replace("\"characters\":","");
////    jsonAsString.replace("\n" +
////            "  ]\n" +
////            "}","");
//
////  ObjectMapper objectMapper = new ObjectMapper();
////   CharactersDTO characters = objectMapper.readValue( idFromName(messages.toString()), CharactersDTO .class);
////
////            List<CharactersPOJO>  list = characters.getCharacters();
////            for(CharactersPOJO  n : list )
////            {
////
////                charactersRepository.save(n);
////       }
//
////    Characters[] characters = objectMapper.readValue(jsonAsString, Characters[].class);
////    for (Characters n : characters) {
////        System.out.println(n.getId());
////charactersRepository.save(n);
//        //   }
//
//
//    }
//
//    @Test
//    void dateToString() throws IOException {
//        int day = 22;
//        int month = 11;
//        int year = 2019;
//        ValueConverters converter = ValueConverters.RUSSIAN_INTEGER;
//        String dayAsWords = converter.asWords(new Integer(day));
//        String monthAsWords = converter.asWords(new Integer(month));
//        String yearAsWords = converter.asWords(new Integer(year));
//
//        System.out.println(dayAsWords + " " + monthAsWords + " " + yearAsWords);
//        //двадцать два одиннадцать две тысячи девятнадцать
//    }
//
//    @Test
//    String test3(String string) {
//
////            final String string = "applicationText: \"\\u0425\\u043E\\u0447\\u0443 \\u0432\\u0441\\u0442\\u0443\\u043F\\u0438\\u0442\\u044C,\n"
////                    + "  \\u044F \\u043D\\u043E\\u0432\\u044B\\u0439 \\u0438\\u0433\\u0440\\u043E\\u043A\"\n"
////                    + "charID: 2119333139\n"
////                    + "corpID: 98399497\n";
//
//        return string.substring(16, string.indexOf("\"", string.indexOf("\"") + 1));
//
//
//    }
//    @Test
//    void test2() throws IOException, InterruptedException {
//        List<Notification> players = notificationRepository.findAllMain05();
////        System.out.println(players);
//log.debug("nitification {}",players);
//    }
//
//    @Test
//    void start() throws Exception {
//
////        updatBaseLast(update30()); // обновляет по тем у кого менялся секурети статус с последнего раза
//
//
////  updateFromH2all(); // обнавляет всх в базе
////   updatBaseLast(getNotification());
//      presendmail(2);
//      presendmail(1);
//
//   presendmail(3);
////     presendmail(4);
//    }
//
//    @Test
//    void presendmail(int choise) throws IOException {
//        List<Notification> players;
//        switch (choise) {
//            case 1:
//                players = notificationRepository.findAllMain01();
//                break;
//            case 2:
//                players = notificationRepository.findAllMain02();
//                break;
//            case 3:
//                players = notificationRepository.findAllMain03();
//                break;
//            case 4:
//                players = notificationRepository.findAllMain04();
//                break;
//            default:
//                throw new IllegalStateException("Unexpected value: " + choise);
//        }
//
//        //     List<Notification> players = notificationRepository.findAllMain01();
//        //   List<Notification> players = notificationRepository.findAllMain02();
//
//        List<String> stringList = new ArrayList<>();
//        for (Notification n : players) {
//            stringList.add(n.getName());
//            log.debug("players {} ", n.getName());
//        }
//
//        List<String> distinctInts = stringList.stream().distinct().collect(Collectors.toList());
//
//        for (String name : distinctInts) {
//            try {
//                ObjectMapper objectMapper = new ObjectMapper();
//                String makeobject = idFromName(name.replace("\uFEFF", ""));
//                CharactersDTO characters = objectMapper.readValue(makeobject, CharactersDTO.class);
//                List<CharactersPOJO> list = characters.getCharacters();
//                log.debug("отправка {} {}", name, makeobject);
//                for (CharactersPOJO n : list) {
//
//                    //          List<Notification> corpAppNewMsg = notificationRepository.findAll();
//                    //          NotificationService.sendMail2(Long.toString(n.getId()));
//                    //     List<Notification> corpAppNewMsg = notificationRepository.findAllBySenderId( n.getId());
//
//                    //    for (Notification m : corpAppNewMsg) {
//                    switch (choise) {
//                        case 1:
//
//                            List<Notification> сorpAppNewMsg = notificationRepository.findAllBySenderIdAndType(n.getId(), "CorpAppNewMsg");
//                            try {
//                                Thread.sleep(15000);
//                                notificationService.sendMail22(n.getId(), n.getName(), сorpAppNewMsg.get(0).getTimestamp(), сorpAppNewMsg.get(0).getText(), 1);
//                            } catch (HttpException520 e) {
//
//                                System.out.println("520 ошибка");
//                                List<Notification> сorpAppNewMsg11 = notificationRepository.findAllBySenderId(n.getId());
//                                for (Notification m : сorpAppNewMsg11) {
//                                    m.setIsRead("BLOCK");
//                                    notificationRepository.save(m);
//
//                                }
//                            }
//                            catch (IOException e) {
//                                Thread.sleep(10000);
//                                System.out.println("403 ошибка");
//
//                            }
//
//                            List<Notification> сorpAppNewMsg1 = notificationRepository.findAllBySenderId(n.getId());
//                            for (Notification m : сorpAppNewMsg1) {
//                                m.setMail1("+");
//
//                                notificationRepository.save(m);
//
//                            }
//
//                            break;
//                        case 2:
//                            List<Notification> charAppWithdrawMsg = notificationRepository.findAllBySenderIdAndType(n.getId(), "CharAppWithdrawMsg");
//                            try {
//                                Thread.sleep(15000);
//                                notificationService.sendMail22(n.getId(), n.getName(), charAppWithdrawMsg.get(0).getTimestamp(), charAppWithdrawMsg.get(0).getText(), 2);
//                            } catch (HttpException520 e) {
//                                Thread.sleep(10000);
//                                System.out.println("520 ошибка");
//                            }catch (IndexOutOfBoundsException e) {
//
//                                System.out.println("IndexOutOfBoundsException ошибка");
//                            }
//
//
//                            List<Notification> charAppWithdrawMsg2 = notificationRepository.findAllBySenderId(n.getId());
//                            for (Notification m : charAppWithdrawMsg2) {
//                                m.setMail2("+");
//                                m.setMail1("+");
//                                notificationRepository.save(m);
//                            }
//                            break;
//                        case 3:
//                            List<Notification> CharAppAcceptMsg3 = notificationRepository.findAllBySenderId(n.getId());
//                            try {
//                                Thread.sleep(15000);
//                                notificationService.sendMail22(n.getId(), n.getName(), CharAppAcceptMsg3.get(0).getTimestamp(), CharAppAcceptMsg3.get(0).getText(), 3);
//                            } catch (HttpException520 e) {
//                                Thread.sleep(10000);
//                                System.out.println("520 ошибка");
//                            }catch (IndexOutOfBoundsException e) {
//
//                                System.out.println("IndexOutOfBoundsException ошибка");
//                            }
//
//
//                            List<Notification> CharAppAcceptMsg33 = notificationRepository.findAllBySenderId(n.getId());
//                            for (Notification m : CharAppAcceptMsg33) {
//                                m.setMail3("+");
//
//                                notificationRepository.save(m);
//                            }
//                            break;
//                        case 4:
//                            List<Notification> CharAppAcceptMsg4 = notificationRepository.findAllBySenderId(n.getId());
//                            try {
//                                Thread.sleep(15000);
//                                notificationService.sendMail22(n.getId(), n.getName(), CharAppAcceptMsg4.get(0).getTimestamp(), CharAppAcceptMsg4.get(0).getText(), 4);
//                            } catch (HttpException520 e) {
//
//                                System.out.println("520 ошибка");
//                            }catch (IndexOutOfBoundsException e) {
//                                Thread.sleep(10000);
//                                System.out.println("IndexOutOfBoundsException ошибка");
//                            }
//
//
//                            List<Notification> CharAppAcceptMsg44 = notificationRepository.findAllBySenderId(n.getId());
//                            for (Notification m : CharAppAcceptMsg44) {
//                                m.setMail4("+");
//
//                                notificationRepository.save(m);
//                            }
//                            break;
//
//                    }
//
////                        notificationRepository.save(m);
////
////                    }
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            } catch (NullPointerException e) {
//                System.out.print("NullPointerException caught");
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    @Test
//    CharacterDTO getCharInfo(long charid) throws IOException, InterruptedException {
//        String jsonAsString = NotificationService.getCharInfoService(charid);
//        ObjectMapper objectMapper = new ObjectMapper();
//        CharacterDTO characterDTO = objectMapper.readValue(jsonAsString, CharacterDTO.class);
//
//        return characterDTO;
//
//    }
//
//    @Test
//    public static String getinfo() throws IOException {
////    String PATCH = "E:\\514674064.txt";
////
////    String path = "E:\\514674064.txt";
////    BufferedReader br = new BufferedReader(new FileReader(path));
////    String sCurrentLine = br.readLine();
////    String token = "";
////    token = sCurrentLine;
////
////    System.out.println(token);
//        final String uri = "https://esi.evetech.net/latest/characters/1057512100/?datasource=tranquility";
//
//        System.out.println(uri);
//        //   final String uri = "https://esi.evetech.net/latest/alliances/?datasource=tranquility";
//        RestTemplate restTemplate = new RestTemplate();
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//        headers.set("Cache-Control", "no-cache");
//        headers.set("accept", "application/json");
//
//        HttpEntity<String> entity = new HttpEntity<String>(headers);
//
//        ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
//        return response.getBody();
//
//    }
//
//    @Test
//    String unitext(String str1) throws IOException {
////
////        String str1  = "\\u0425\\u043E\\u0447\\u0443 \\u0432\\u0441\\u0442\\u0443\\u043F\\u0438\\u0442\\u044C,\n" +
////                "  \\u044F \\u043D\\u043E\\u0432\\u044B\\u0439 \\u0438\\u0433\\u0440\\u043E\\u043A\"\n";
////       ;
//        return org.apache.commons.text.StringEscapeUtils.unescapeJava(str1);
//    }
//
//
//    @Test
//    List<String> findNpcWhoSendMail1() throws IOException {
//
//        List<Notification> corpAppNewMsg = notificationRepository.findAllMain01();
//        List<String> stringList = new ArrayList<>();
//        for (Notification n : corpAppNewMsg) {
//            stringList.add(n.getName());
//            log.debug("NPC {} ", n.getName());
//        }
//        List<String> stringList2 = stringList.stream().distinct().collect(Collectors.toList());
//
//        return stringList2;
//
//    }
//
//    @Test
//    List<Notification> getNotification() throws Exception {
//
//        String json3 = NotificationService.getNotificationBody();
//
//        ObjectMapper objectMapper = new ObjectMapper();
//
//        Notification[] notifications = objectMapper.readValue(json3, Notification[].class);
//        long max = 0;
//        ///////////////////////////
//        List<Notification> corpAppNewMsg = notificationRepository.findAllMain();
//
//
//        for (Notification n : corpAppNewMsg) {
//            if (n.getNotificationId() > max) max = n.getNotificationId();
//
//        }
/////////////////////////////////////
//        List<Notification> toUpdate = new ArrayList<>();
//        for (Notification n : notifications) {
//
//            if (n.getNotificationId() > max) {
//                log.debug("notificationsSaved_ID {} ", n.getNotificationId());
//
//                if (n.getText().toString().length() > 255) {
//                    n.setText(n.getText().substring(0, 254));
//                }
//                notificationRepository.save(n);
//                toUpdate.add(n);
//
//
//            } else log.debug("notifications_ID {} ", n.getNotificationId());
//
//            //   log.debug("notifications {} ", n.getSenderId());
//        }
//        // notificationService.save(notifications);
//
////        List<Notification> all = notificationRepository.findAll();
////        log.debug("all {} ", all);
//        log.debug("notifications {} ", notifications);
//
//        return toUpdate;
//
//    }
//
//    @Test
//    String date(String date) throws IOException {
//
//        String date2 = date.replace("-", ".").substring(0, 10);
//        Date date1 = new Date();
//        SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
//        String date11 = format.format(date1);
//        // String date1  = n.getBirt();
////    String date1 = date;
////    String date2 = date0.toString();
//
//        // SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy");
//        SimpleDateFormat format2 = new SimpleDateFormat("yyyy.MM.dd");
//
//        Date dateOne = null;
//        Date dateTwo = null;
//
//        try {
//            dateOne = format2.parse(date11);
//            dateTwo = format2.parse(date2);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        // Количество дней между датами в миллисекундах
//        long difference = dateOne.getTime() - dateTwo.getTime();
//        // Перевод количества дней между датами из миллисекунд в дни
//        int days = (int) (difference / (24 * 60 * 60 * 1000));
//
//        return String.valueOf(days);
//    }
//
//    @Test
//    void secStatusChange() throws IOException, InterruptedException {
//        List<Notification> notificationsFromH2 = notificationRepository.findAllByType("CorpAppNewMsg");
////        String json3 = NotificationService.getNotification();
////        ObjectMapper objectMapper = new ObjectMapper();
////         Notification[] notificationsFromApi = objectMapper.readValue(json3, Notification[].class);
//////////////////////////////////
//        //  if (h2.getSenderId()== api.getSenderId() && h2.getSec()!= api.getSec())
//        for (Notification h2 : notificationsFromH2) {
//            Thread.sleep(1000);
//            CharacterDTO charInfo = getCharInfo(h2.getSenderId());
//
//
//            if (h2.getSec() != charInfo.getSecurityStatus()) {
//
//                System.out.println(h2.getName() + " было" + h2.getSec() + " стало " + charInfo.getSecurityStatus() + " разница " + ((charInfo.getSecurityStatus() / h2.getSec()) * 100 - 100) + " %");
//            }
//
//        }
//    }
//
//    List<Notification> update30() throws IOException, InterruptedException {
//        List<Notification> notificationsFromH2 = notificationRepository.findAllMain30();
//
//        List<Notification> notificationsToUpdate = new ArrayList<>();
//        for (Notification h2 : notificationsFromH2) {
//            Thread.sleep(1000);
//            CharacterDTO charInfo = getCharInfo(h2.getSenderId());
//
//
//            if (h2.getSec() != charInfo.getSecurityStatus()) {
//
//                notificationsToUpdate.add(h2);
//
//                // System.out.println(h2.getName() + " было" + h2.getSec() + " стало " + charInfo.getSecurityStatus() + " разница " + ((charInfo.getSecurityStatus() / h2.getSec()) * 100 - 100) + " %");
//            }
//
//        }
//        System.out.println(notificationsToUpdate);
//        return notificationsToUpdate;
//    }
//
//    @Test
//    void updatBaseLast(List<Notification> notification) throws IOException, InterruptedException {
//
//        // int max = 0;
//        ///////////////////////////
//        //  List<Notification> corpAppNewMsg = notificationRepository.findAllMain();
//
//
////
////        for (Notification n : corpAppNewMsg) {
////            if (n.getNotificationId() > max) max = n.getNotificationId();
////
////        }
/////////////////////////////////////
//
//
//        for (Notification n : notification) {
//
////          if (n.getNotificationId()>1516463941) {
//            //     if (n.getSenderId() == 2116620298) {
//
//
////            String text = unitext(n.getText());
////            String text2 = text.replace("applicationText: ", "");
////            String text3 = "";
////            if (text2.length() < 254) {
////                text3 = text2;
////            } else text3 = text2.substring(1, 255);
////            n.setApp(text3);
//
//
//            //String bday = getCharInfo(n.getSenderId());
//            CharacterDTO charInfo = getCharInfo(n.getSenderId());
//            // дата создания
//            String bday = charInfo.getBirthday();
//            n.setBirt(bday);
//
//            // возраст в днях
//            n.setApp(date(bday));
//            // name
//            String name = charInfo.getName();
//            n.setName(name);
//            // сек статус
//            float sec = charInfo.getSecurityStatus();
//            n.setSec(sec);
//
//            int corp = charInfo.getCorporationId();
//            Integer[] alphabet = new Integer[]{1000001,
//                    1000002,
//                    1000003,
//                    1000004,
//                    1000005,
//                    1000006,
//                    1000007,
//                    1000008,
//                    1000009,
//                    1000010,
//                    1000011,
//                    1000012,
//                    1000013,
//                    1000014,
//                    1000015,
//                    1000016,
//                    1000017,
//                    1000018,
//                    1000019,
//                    1000020,
//                    1000021,
//                    1000022,
//                    1000023,
//                    1000024,
//                    1000025,
//                    1000026,
//                    1000027,
//                    1000028,
//                    1000029,
//                    1000030,
//                    1000031,
//                    1000032,
//                    1000033,
//                    1000034,
//                    1000035,
//                    1000036,
//                    1000037,
//                    1000038,
//                    1000039,
//                    1000040,
//                    1000041,
//                    1000042,
//                    1000043,
//                    1000044,
//                    1000045,
//                    1000046,
//                    1000047,
//                    1000048,
//                    1000049,
//                    1000050,
//                    1000051,
//                    1000052,
//                    1000053,
//                    1000054,
//                    1000055,
//                    1000056,
//                    1000057,
//                    1000058,
//                    1000059,
//                    1000060,
//                    1000061,
//                    1000062,
//                    1000063,
//                    1000064,
//                    1000065,
//                    1000066,
//                    1000067,
//                    1000068,
//                    1000069,
//                    1000070,
//                    1000071,
//                    1000072,
//                    1000073,
//                    1000074,
//                    1000075,
//                    1000076,
//                    1000077,
//                    1000078,
//                    1000079,
//                    1000080,
//                    1000081,
//                    1000082,
//                    1000083,
//                    1000084,
//                    1000085,
//                    1000086,
//                    1000087,
//                    1000088,
//                    1000089,
//                    1000090,
//                    1000091,
//                    1000092,
//                    1000093,
//                    1000094,
//                    1000095,
//                    1000096,
//                    1000097,
//                    1000098,
//                    1000099,
//                    1000100,
//                    1000101,
//                    1000102,
//                    1000103,
//                    1000104,
//                    1000105,
//                    1000106,
//                    1000107,
//                    1000108,
//                    1000109,
//                    1000110,
//                    1000111,
//                    1000112,
//                    1000113,
//                    1000114,
//                    1000115,
//                    1000116,
//                    1000117,
//                    1000118,
//                    1000119,
//                    1000120,
//                    1000121,
//                    1000122,
//                    1000123,
//                    1000124,
//                    1000125,
//                    1000126,
//                    1000127,
//                    1000128,
//                    1000129,
//                    1000130,
//                    1000131,
//                    1000132,
//                    1000133,
//                    1000134,
//                    1000135,
//                    1000136,
//                    1000137,
//                    1000138,
//                    1000139,
//                    1000140,
//                    1000141,
//                    1000142,
//                    1000143,
//                    1000144,
//                    1000145,
//                    1000146,
//                    1000147,
//                    1000148,
//                    1000149,
//                    1000150,
//                    1000151,
//                    1000152,
//                    1000153,
//                    1000154,
//                    1000155,
//                    1000156,
//                    1000157,
//                    1000158,
//                    1000159,
//                    1000160,
//                    1000161,
//                    1000162,
//                    1000163,
//                    1000164,
//                    1000165,
//                    1000166,
//                    1000167,
//                    1000168,
//                    1000169,
//                    1000170,
//                    1000171,
//                    1000172,
//                    1000173,
//                    1000174,
//                    1000175,
//                    1000176,
//                    1000177,
//                    1000178,
//                    1000179,
//                    1000180,
//                    1000181,
//                    1000182,
//                    1000193,
//                    1000197,
//                    1000198,
//                    1000205,
//                    1000206,
//                    1000207,
//                    1000208,
//                    1000213,
//                    1000214,
//                    1000215,
//                    1000216,
//                    1000217,
//                    1000218,
//                    1000219,
//                    1000220,
//                    1000222,
//                    1000223,
//                    1000224,
//                    1000225,
//                    1000226,
//                    1000227,
//                    1000228,
//                    1000229,
//                    1000230,
//                    1000231,
//                    1000232,
//                    1000233,
//                    1000234,
//                    1000235,
//                    1000236,
//                    1000237,
//                    1000238,
//                    1000239,
//                    1000240,
//                    1000243,
//                    1000244,
//                    1000245,
//                    1000246,
//                    1000247,
//                    1000248,
//                    1000249,
//                    1000250,
//                    1000251,
//                    1000252,
//                    1000253,
//                    1000254,
//                    1000255,
//                    1000256,
//                    1000257,
//                    1000258,
//                    1000259,
//                    1000261,
//                    1000262,
//                    1000263,
//                    1000270,
//                    1000271,
//                    1000274,
//                    1000276,
//                    1000277,
//                    1000279,
//                    1000280,
//                    1000281,
//                    1000282,
//                    1000283,
//                    1000284,
//                    1000285,
//                    1000286,
//                    1000287,
//                    1000288,
//                    1000289,
//                    1000290,
//                    1000291,
//                    1000292,
//                    1000293,
//                    1000294,
//                    1000297,
//                    1000298,
//                    1000299};
//            List<Integer> list = Arrays.asList(alphabet);
//            String charcorp = "";
//            if (list.contains(corp)) {
//                charcorp = "NPC";
//            } else {
//                List<Integer> bacadem = Arrays.asList(98399497, 98631060);
//                List<Integer> rusac = Arrays.asList(98575483, 98593411);
//                if (bacadem.contains(corp)) {
//                    charcorp = "academ";
//                } else if (rusac.contains(corp)) {
//                    charcorp = "rusac";
//                } else charcorp = "notNPC";
//            }
//
//            n.setNpc(charcorp);
//
//            notificationRepository.save(n);
//
//            log.debug("birthday {} ", bday);
//            //       }
//        }
//    }
//
//    @Test
//    void updateFromH2all() throws IOException, InterruptedException {
//
//        // int max = 0;
//        ///////////////////////////
//        List<Notification> corpAppNewMsg = notificationRepository.findAllMain();
//
//
////
////        for (Notification n : corpAppNewMsg) {
////            if (n.getNotificationId() > max) max = n.getNotificationId();
////
////        }
/////////////////////////////////////
//
//
//        for (Notification n : corpAppNewMsg) {
//
//            try {
//
//                CharacterDTO charInfo = getCharInfo(n.getSenderId());
//                // дата создания
//                String bday = charInfo.getBirthday();
//                //  n.setBirt(bday);
//
//                // возраст в днях
//                n.setApp(date(bday));
//                // name
////                String name = charInfo.getName();
////                n.setName(name);
//                // сек статус
//                float sec = charInfo.getSecurityStatus();
//                n.setSec(sec);
//
//                int corp = charInfo.getCorporationId();
//                Integer[] alphabet = new Integer[]{1000001,
//                        1000002,
//                        1000003,
//                        1000004,
//                        1000005,
//                        1000006,
//                        1000007,
//                        1000008,
//                        1000009,
//                        1000010,
//                        1000011,
//                        1000012,
//                        1000013,
//                        1000014,
//                        1000015,
//                        1000016,
//                        1000017,
//                        1000018,
//                        1000019,
//                        1000020,
//                        1000021,
//                        1000022,
//                        1000023,
//                        1000024,
//                        1000025,
//                        1000026,
//                        1000027,
//                        1000028,
//                        1000029,
//                        1000030,
//                        1000031,
//                        1000032,
//                        1000033,
//                        1000034,
//                        1000035,
//                        1000036,
//                        1000037,
//                        1000038,
//                        1000039,
//                        1000040,
//                        1000041,
//                        1000042,
//                        1000043,
//                        1000044,
//                        1000045,
//                        1000046,
//                        1000047,
//                        1000048,
//                        1000049,
//                        1000050,
//                        1000051,
//                        1000052,
//                        1000053,
//                        1000054,
//                        1000055,
//                        1000056,
//                        1000057,
//                        1000058,
//                        1000059,
//                        1000060,
//                        1000061,
//                        1000062,
//                        1000063,
//                        1000064,
//                        1000065,
//                        1000066,
//                        1000067,
//                        1000068,
//                        1000069,
//                        1000070,
//                        1000071,
//                        1000072,
//                        1000073,
//                        1000074,
//                        1000075,
//                        1000076,
//                        1000077,
//                        1000078,
//                        1000079,
//                        1000080,
//                        1000081,
//                        1000082,
//                        1000083,
//                        1000084,
//                        1000085,
//                        1000086,
//                        1000087,
//                        1000088,
//                        1000089,
//                        1000090,
//                        1000091,
//                        1000092,
//                        1000093,
//                        1000094,
//                        1000095,
//                        1000096,
//                        1000097,
//                        1000098,
//                        1000099,
//                        1000100,
//                        1000101,
//                        1000102,
//                        1000103,
//                        1000104,
//                        1000105,
//                        1000106,
//                        1000107,
//                        1000108,
//                        1000109,
//                        1000110,
//                        1000111,
//                        1000112,
//                        1000113,
//                        1000114,
//                        1000115,
//                        1000116,
//                        1000117,
//                        1000118,
//                        1000119,
//                        1000120,
//                        1000121,
//                        1000122,
//                        1000123,
//                        1000124,
//                        1000125,
//                        1000126,
//                        1000127,
//                        1000128,
//                        1000129,
//                        1000130,
//                        1000131,
//                        1000132,
//                        1000133,
//                        1000134,
//                        1000135,
//                        1000136,
//                        1000137,
//                        1000138,
//                        1000139,
//                        1000140,
//                        1000141,
//                        1000142,
//                        1000143,
//                        1000144,
//                        1000145,
//                        1000146,
//                        1000147,
//                        1000148,
//                        1000149,
//                        1000150,
//                        1000151,
//                        1000152,
//                        1000153,
//                        1000154,
//                        1000155,
//                        1000156,
//                        1000157,
//                        1000158,
//                        1000159,
//                        1000160,
//                        1000161,
//                        1000162,
//                        1000163,
//                        1000164,
//                        1000165,
//                        1000166,
//                        1000167,
//                        1000168,
//                        1000169,
//                        1000170,
//                        1000171,
//                        1000172,
//                        1000173,
//                        1000174,
//                        1000175,
//                        1000176,
//                        1000177,
//                        1000178,
//                        1000179,
//                        1000180,
//                        1000181,
//                        1000182,
//                        1000193,
//                        1000197,
//                        1000198,
//                        1000205,
//                        1000206,
//                        1000207,
//                        1000208,
//                        1000213,
//                        1000214,
//                        1000215,
//                        1000216,
//                        1000217,
//                        1000218,
//                        1000219,
//                        1000220,
//                        1000222,
//                        1000223,
//                        1000224,
//                        1000225,
//                        1000226,
//                        1000227,
//                        1000228,
//                        1000229,
//                        1000230,
//                        1000231,
//                        1000232,
//                        1000233,
//                        1000234,
//                        1000235,
//                        1000236,
//                        1000237,
//                        1000238,
//                        1000239,
//                        1000240,
//                        1000243,
//                        1000244,
//                        1000245,
//                        1000246,
//                        1000247,
//                        1000248,
//                        1000249,
//                        1000250,
//                        1000251,
//                        1000252,
//                        1000253,
//                        1000254,
//                        1000255,
//                        1000256,
//                        1000257,
//                        1000258,
//                        1000259,
//                        1000261,
//                        1000262,
//                        1000263,
//                        1000270,
//                        1000271,
//                        1000274,
//                        1000276,
//                        1000277,
//                        1000279,
//                        1000280,
//                        1000281,
//                        1000282,
//                        1000283,
//                        1000284,
//                        1000285,
//                        1000286,
//                        1000287,
//                        1000288,
//                        1000289,
//                        1000290,
//                        1000291,
//                        1000292,
//                        1000293,
//                        1000294,
//                        1000297,
//                        1000298,
//                        1000299};
//                List<Integer> list = Arrays.asList(alphabet);
//                String charcorp = "";
//                if (list.contains(corp)) {
//                    charcorp = "NPC";
//                } else {
//                    List<Integer> bacadem = Arrays.asList(98399497, 98631060);
//                    List<Integer> rusac = Arrays.asList(98575483, 98593411);
//                    if (bacadem.contains(corp)) {
//                        charcorp = "academ";
//                    } else if (rusac.contains(corp)) {
//                        charcorp = "rusac";
//                    } else charcorp = "notNPC";
//                }
//
//                n.setNpc(charcorp);
//
//
//            } catch (HttpClientErrorException ex) {
//                if (ex.getRawStatusCode() == 404)
//                //        if (ex.getStatusCode() != HttpStatus.NOT_FOUND)
//
//                {
//                    // throw ex;
//                    System.out.println("ошибка HttpClientErrorException 404");
//                    Thread.sleep(10000);
//                } else if (ex.getRawStatusCode() == 504) {
//                    System.out.println("ошибка HttpClientErrorException 504");
//                    Thread.sleep(10000);
//                } else if (ex.getRawStatusCode() == 502) {
//                    System.out.println("ошибка HttpClientErrorException 502");
//
//                    Thread.sleep(10000);
//                }
//            } catch (HttpServerErrorException ex2) {
//
//                if (ex2.getRawStatusCode() == 504)
//                        {
//
//                    System.out.println("ошибка HttpServerErrorException 504");
//                    Thread.sleep(10000);
//                }
//            }
//
//
//            notificationRepository.save(n);
//
//            log.debug("notification updated {} ", n);
//        }
//
//    }
//
//    @Test
//    void frombase2() throws IOException {
//        // List<Notification> corpAppNewMsg = notificationRepository.findAllByType("CorpAppNewMsg");
//        List<Notification> corpAppNewMsg = notificationRepository.findAllByTypeAndIsRead
//                ("CharAppAcceptMsg", null);
//        //   log.debug("notifications {} ", corpAppNewMsg);
//        for (Notification n : corpAppNewMsg) {
//
//            log.debug("notifications {} ", n.getSenderId());
////            n.setOk("ok");
////            notificationRepository.save(n);
//        }
//
//    }
//
//    @Test
//    void ok() throws IOException {
//        // List<Notification> corpAppNewMsg = notificationRepository.findAllByType("CorpAppNewMsg");
//        List<Notification> corpAppNewMsg = notificationRepository.findAllByTypeAndOk
//                ("CharAppAcceptMsg", "ok");
//        //   log.debug("notifications {} ", corpAppNewMsg);
//        for (Notification n : corpAppNewMsg) {
//
//            log.debug("notifications {} ", n.getSenderId());
//            n.setIsRead("true");
//            notificationRepository.save(n);
//        }
//
//    }
//
//    @Test
//    void ok2(String type, String massage) throws IOException {
//        // List<Notification> corpAppNewMsg = notificationRepository.findAllByType("CorpAppNewMsg");
//        List<Notification> corpAppNewMsg = notificationRepository.findAllByType
//                (type);
//
//        for (Notification n : corpAppNewMsg) {
//
//            if (n.getOk() == massage) {
//                log.debug("Sender_id nothing {} ", n.getSenderId());
//            }
//            //     System.out.println(n.getOk());
//
//
//            else {
//                log.debug("Sender_id do true {} ", n.getSenderId());
//                n.setIsRead("true");
//                notificationRepository.save(n);
//            }
//        }
//
//
//    }
//
//    @Test
//    void test() throws IOException {
//        // List<Notification> corpAppNewMsg = notificationRepository.findAllByType("CorpAppNewMsg");
//        List<Notification> corpAppNewMsg = notificationRepository.findAllByType
//                ("test");
//        //   log.debug("notifications {} ", corpAppNewMsg);
//        for (Notification n : corpAppNewMsg) {
//
//            log.debug("notifications {} ", n.getSenderId());
//
//            n.setOk("sent");
//            //   notificationService.sendMail2(n.getSenderId());
//            notificationRepository.save(n);
//        }
//
//    }
//
//    @Test
//    void test2(String type, String massage) throws IOException {
//        // List<Notification> corpAppNewMsg = notificationRepository.findAllByType("CorpAppNewMsg");
//        List<Notification> corpAppNewMsg = notificationRepository.findAllByType
//                (type);
//        //   log.debug("notifications {} ", corpAppNewMsg);
//        for (Notification n : corpAppNewMsg) {
//
//            log.debug("notifications {} ", n.getSenderId());
//
//            n.setOk(massage);
//            //    notificationService.sendMail2(n.getSender_id());
//            notificationRepository.save(n);
//        }
//
//    }
//
//    @Test
//    void sendmail() throws IOException {
//
//        //    notificationService.sendMail2();
//
//
//        log.debug("notifications {} ", log);
//
//    }
////    @Test
////    void frombase3() throws IOException {
////        // List<Notification> corpAppNewMsg = notificationRepository.findAllByType("CorpAppNewMsg");
////        List<Notification> CharAppAcceptMsg = notificationRepository.findAllByTypeAndIsRead
////                ("CharAppAcceptMsg", "true");
////        List<Notification> corpAppNewMsg = notificationRepository.findAllByType("CorpAppNewMsg");
////        //   log.debug("notifications {} ", corpAppNewMsg);
////        for (Notification n : corpAppNewMsg) {
////
////            log.debug("notifications {} ", n.getSender_id());
////            n.setIsRead("true");
////            notificationRepository.save(n);
////        }
//
////    }
//}