package Model;

import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Expense {
    private int ExpenseId;
    private String ExpenseRemark;
    private int ExpenseAmount;
    private String PaymentMode;
    private LocalDateTime Time;
}
