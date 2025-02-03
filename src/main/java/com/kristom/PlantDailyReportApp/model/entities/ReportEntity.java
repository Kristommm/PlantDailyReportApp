package com.kristom.PlantDailyReportApp.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "reports_table")
public class ReportEntity {

    @Id
    @GeneratedValue(generator = "report_id_seq" , strategy = GenerationType.SEQUENCE )
    private Long id;
    private String message;
    private LocalDateTime dateTime;

    @ManyToOne
    @JoinColumn(name = "owner")
    private UserEntity user;

}
