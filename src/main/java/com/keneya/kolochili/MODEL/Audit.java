package com.keneya.kolochili.Model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Audit")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Audit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAudit")
    private int idAudit;

    @ManyToOne
    @JoinColumn(name = "idAdmin", nullable = false)
    private Admin admin;

    @Column(nullable = false, length = 50)
    private String action;

    @Column(name = "entityid", nullable = false)
    private int entityId;

    @Column(nullable = false, length = 255)
    private String url;

    @Column(name = "dateAction", nullable = false, updatable = false)
    private LocalDateTime dateAction;

    @PrePersist
    protected void onCreate() {
        this.dateAction = LocalDateTime.now();
    }
}