package spring.demo.demo.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "user_paps")
public class Paps {
    @Id
    private String userId;
    private Integer paps;

}
