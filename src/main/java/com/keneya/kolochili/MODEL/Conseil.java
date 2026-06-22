package com.keneya.kolochili.Model;

import com.keneya.kolochili.Enumeration.TagConseil;
import jakarta.persistence.*;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Conseils")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Conseil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idConseils")
    private int idConseils;

    @ManyToOne
    @JoinColumn(name = "idCategorieConseil", nullable = false)
    private CategorieConseil categorieConseil;

    @ManyToOne
    @JoinColumn(name = "idAgent", nullable = false)
    private Agent agent;

    @Column(nullable = false, length = 30)
    private String titre;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('CONSEILLER', 'RECOMENDATION')")
    private TagConseil tag;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String contenu;

    @Column(name = "dateConseil", nullable = false, updatable = false)
    private LocalDate dateConseil;

    @PrePersist
    protected void onCreate() {
        this.dateConseil = LocalDate.now();
    }
}