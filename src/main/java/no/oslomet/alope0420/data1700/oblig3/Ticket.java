package no.oslomet.alope0420.data1700.oblig3;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity
@Data
public class Ticket {

    @Id
    @GeneratedValue
    private Integer id;

    @NotBlank
    private String movie;

    @Min(value = 1)
    @Max(value = 100)
    private Integer count;

    @NotBlank
    private String firstname;

    @NotBlank
    private String lastname;

    @Pattern(regexp = "^[2-9]\\d{7}|(?:\\+|00)\\d{6,}$")
    private String tel;

    /*
    * Validation pattern for e-mail addresses, adapted for case-insensitivity.
    * Source: How to Find or Validate an Email Address. (n.d.).
    * Retrieved February 11, 2024, from https://www.regular-expressions.info/email.html
    */
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")
    private String email;
}
