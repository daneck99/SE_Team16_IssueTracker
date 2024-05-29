package com.Software_Engineering.Software_Eng.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="component_table")
public class ComponentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String contents;

    @Column
    private String statement;



    @Column
    private LocalDateTime Date;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private ProjectEntity projectEntity;
}
