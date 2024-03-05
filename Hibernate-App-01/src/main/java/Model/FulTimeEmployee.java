package Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class FulTimeEmployee extends Employee {
    @Column(name = "salary")
    private int Salary;
}
