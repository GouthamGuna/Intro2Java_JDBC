package in.dev.gmsk.model;

import lombok.*;

import javax.persistence.Embeddable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Embeddable
public class User {

    private int id;
    private String name;
    private String password;
    private String email;
}
