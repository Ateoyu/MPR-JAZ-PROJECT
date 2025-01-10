package pl.edu.pjatk.frontend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Date {
    private Integer year;
    private Integer month;
    private Integer day;
} 