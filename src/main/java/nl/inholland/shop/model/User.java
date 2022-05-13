package nl.inholland.shop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue
    private long id;

    private String username;
    private String password;
}
