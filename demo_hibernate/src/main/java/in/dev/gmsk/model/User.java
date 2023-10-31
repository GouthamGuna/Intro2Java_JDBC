package in.dev.gmsk.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Data
@Setter
@Getter
@Entity
public class User {

    private int id;
    private String name;
    private String password;
    private String email;
}
