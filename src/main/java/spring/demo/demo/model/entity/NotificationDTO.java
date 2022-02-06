package spring.demo.demo.model.entity;

import lombok.Data;
import org.aspectj.weaver.ast.Not;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Data


public class NotificationDTO {



  int notification_id;
  int sender_id;
  String sender_type;
  String text;
  String timestamp;
  String type;
  String is_read;
}
