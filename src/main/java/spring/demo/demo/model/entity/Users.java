package spring.demo.demo.model.entity;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "users")
public class Users {
    @Id
    private String userName;
    private String userId;
    private String userSc;
    @Column(name = "user_corp")
    private String userCorp;

}
