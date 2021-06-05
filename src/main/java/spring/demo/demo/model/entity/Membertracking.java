package spring.demo.demo.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "membertracking")
public class Membertracking {
    @Id
    int character_id;
    int location_id;
    String logoff_date;
    String logon_date;
    int ship_type_id;
    String start_date;

}
