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
public class ContractEmployee extends Employee{
    @Column(name = "invoice_amount")
    private int InvoiceAmount;
}
