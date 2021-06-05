package spring.demo.demo.dao;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Data;

@Data
public class Alliance {
    Integer id;
    @JsonProperty("is_read")
    Integer isRead;
}
