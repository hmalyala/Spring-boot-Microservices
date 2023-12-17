package com.org.fraud;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FraudCheckHistory {

    @Id
    @SequenceGenerator(
            name = "fraud-id_sequnce",
            sequenceName = "fraud-id_sequnce"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "fraud-id_sequnce"
    )
    private Integer id;
    private Integer customerId;
    private Boolean isFraudster;
    private LocalDate createdAt;

}
