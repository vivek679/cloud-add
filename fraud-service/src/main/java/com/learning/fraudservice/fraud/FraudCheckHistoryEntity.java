package com.learning.fraudservice.fraud;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Fraud_Check_History")
public class FraudCheckHistoryEntity {
    @Id
    @SequenceGenerator(name = "fraud_id_sequence",
            sequenceName = "fraud_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "fraud_id_sequence")
    private Integer fraudId;
    private String customerId;
    private Boolean isFraudster;
    private LocalDateTime createdAt;

}
