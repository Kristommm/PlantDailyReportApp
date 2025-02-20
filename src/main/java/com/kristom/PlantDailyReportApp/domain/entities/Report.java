package com.kristom.PlantDailyReportApp.domain.entities;

import com.kristom.PlantDailyReportApp.domain.Department;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "reports_table")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reports_id_seq")
    private Long id;

    @Column(nullable = false)
//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private String author;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private LocalDateTime localDateTime;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Department department;

}
