package in.dev.gmsk.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Data
@AllArgsConstructor
@Setter
@Getter
public class Address {

    private String addressLine1;

    private String addressLine2;

    private String city;

    private String state;

    private String country;

    private String zipCode;
}
