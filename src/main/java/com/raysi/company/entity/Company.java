package com.raysi.company.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "company_seq"
    )
    @SequenceGenerator(
            name = "company_seq",
            sequenceName = "company_sequence",
            allocationSize = 116
    )
    private Long regNo;
    private String name;
    private Integer noOfEmployee;
    @Column(name = "establishment_date")
    private LocalDate estDate;
    private Long annualRevenue;
    private Long netProfit;
    private String domain;
}
