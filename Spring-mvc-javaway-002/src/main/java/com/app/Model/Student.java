package com.app.Model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Student {
    private int StudentId;
    private String StudentName;
    private String StudentCity;
    private int StudentPhone;
}
