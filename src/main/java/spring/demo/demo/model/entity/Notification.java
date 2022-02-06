package spring.demo.demo.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "notification")

public class Notification {
    @Id
    @JsonProperty("notification_id")
    @Column(name = "notification_id")
    long notificationId;
    @JsonProperty("sender_id")
    @Column(name = "sender_id")
    long senderId;
    @JsonProperty("sender_type")
    @Column(name = "sender_type")
    String senderType;
    String text;
    String timestamp;
    String type;
    @JsonProperty("is_read")
    @Column(name = "is_read")
    String isRead;
    String ok;
     String app;
    String name;
    String birt;
    String npc;
    String mail1;
    String mail2;
    String mail3;
    String mail4;
    float sec;



//    @Id
//    int notification_id;
//    int sender_id;
//    String sender_type;
//    String text;
//    String timestamp;
//    String type;
//    @JsonProperty("is_read")
//    @Column(name = "is_read")
//    String isRead;
//    String ok;


}
