package spring.demo.demo.model.repository;

import org.aspectj.weaver.ast.Not;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import spring.demo.demo.model.entity.Notification;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Integer> {

//    @Query("SELECT * FROM NOTIFICATION WHERE parsedatetime(TIMESTAMP, 'yyyy-MM-dd''T''hh:mm:ss''Z''') > DATEADD('HOUR',-12, CURRENT_DATE)")
//    List<Notification> queryAllByType(String type);

    // List<Notification>  findAllByType(String type);
    List<Notification> findAllByType(String type);
//    @Query("SELECT u FROM Notification u WHERE u.senderId = 2119246976")
//     @Query("SELECT u FROM Notification u")

 //    List<Notification> findAllMain();
 @Query("SELECT u FROM Notification u WHERE u.senderType <> 'corporation' and u.type <> 'NPCStandingsLost'")
 List<Notification> findAllMain();

    @Query("SELECT u FROM Notification u WHERE parsedatetime(u.timestamp, 'yyyy-MM-dd''T''hh:mm:ss''Z''') > DATEADD('HOUR',-24, CURRENT_DATE)")
    List<Notification> findAllMain1();

    @Query("SELECT u FROM Notification u WHERE u.type = 'CorpAppNewMsg' and parsedatetime(u.timestamp, 'yyyy-MM-dd''T''hh:mm:ss''Z''') > DATEADD('HOUR',-720, CURRENT_DATE)")
    List<Notification> findAllMain30();

   // @Query("SELECT u FROM Notification u WHERE u.type = 'CorpAppNewMsg' and (u.mail1 is null or u.mail1 <> '+') and u.npc = 'NPC'and parsedatetime(u.timestamp, 'yyyy-MM-dd''T''hh:mm:ss''Z''') > DATEADD('HOUR',-168, CURRENT_DATE)")
    @Query("SELECT u FROM Notification u WHERE u.type = 'CorpAppNewMsg' and (u.mail1 is null or u.mail1 <> '+') and u.npc = 'NPC' and (parsedatetime(u.timestamp, 'yyyy-MM-dd''T''hh:mm:ss''Z''') BETWEEN  DATEADD('HOUR',-720, CURRENT_DATE) AND DATEADD('HOUR',-12, CURRENT_DATE))")
        List<Notification> findAllMain01();

    @Query("SELECT u FROM Notification u WHERE u.type = 'CharAppWithdrawMsg' and (u.mail2 is null or u.mail2 <> '+') and u.npc = 'NPC' and (parsedatetime(u.timestamp, 'yyyy-MM-dd''T''hh:mm:ss''Z''') BETWEEN  DATEADD('HOUR',-720, CURRENT_DATE) AND DATEADD('HOUR',-12, CURRENT_DATE))")
    List<Notification> findAllMain02();

    @Query("SELECT u FROM Notification u WHERE u.type = 'CharAppAcceptMsg' and (u.mail3 is null or u.mail3 <> '+') and u.npc = 'academ' and (parsedatetime(u.timestamp, 'yyyy-MM-dd''T''hh:mm:ss''Z''') BETWEEN  DATEADD('HOUR',-60, CURRENT_DATE) AND DATEADD('HOUR',-12, CURRENT_DATE))")
    List<Notification> findAllMain03();

  //  @Query("SELECT u FROM Notification u WHERE u.npc = 'academm' and u.mail3 <> '+' and u.type = 'CharAppAcceptMsg' and parsedatetime(u.timestamp, 'yyyy-MM-dd''T''hh:mm:ss''Z''') > DATEADD('HOUR',-680, CURRENT_DATE)")
   // @Query("SELECT u FROM Notification u WHERE (u.mail3 is null or u.mail3 <> null) and u.npc = 'academm' and u.mail3 <> '+' and parsedatetime(u.timestamp, 'yyyy-MM-dd''T''hh:mm:ss''Z''') > DATEADD('HOUR',-680, CURRENT_DATE)")
  @Query("SELECT u FROM Notification u WHERE u.type = 'CharAppAcceptMsg' and (u.mail4 is null or u.mail4 <> '+') and u.npc = 'academ' and (parsedatetime(u.timestamp, 'yyyy-MM-dd''T''hh:mm:ss''Z''') BETWEEN  DATEADD('HOUR',-720, CURRENT_DATE) AND DATEADD('HOUR',-672, CURRENT_DATE))")
    List<Notification> findAllMain04();

    @Query("SELECT u FROM Notification u WHERE u.type = 'CorpAppNewMsg' and (u.mail2 is null or u.mail2 <> '+') and u.npc = 'NPC' and (parsedatetime(u.timestamp, 'yyyy-MM-dd''T''hh:mm:ss''Z''') BETWEEN  DATEADD('HOUR',-720, CURRENT_DATE) AND DATEADD('HOUR',-672, CURRENT_DATE)) ")
    List<Notification> findAllMain05();

    List<Notification> findAllByNotificationId(int notificationId);

    List<Notification> findAllByTypeAndIsRead(String type, String isRead);

    List<Notification> findAllByTypeAndOk(String type, String ok);

    List<Notification> findAllBySenderId(long id);

    List<Notification> findAllBySenderIdAndType(long id,String type );

 //   List<Notification> findAllBySenderIdAndType(long id,String type);
//STRING DATA Jpa
}
