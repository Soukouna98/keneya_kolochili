package com.keneya.kolochili.MODEL;

import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name="agents")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Agent extends Utilisateur {

    @Column(nullable=false)
    private String specialite;
    @OneToMany(mappedBy = "agent")
    private List<Conseil> conseils;
}
