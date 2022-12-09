package com.mpeven.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.mpeven.demo.view.VueCompetence;
import com.mpeven.demo.view.VueUtilisateur;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class Competence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({VueUtilisateur.class, VueCompetence.class})
    private Integer id;

    @JsonView({VueUtilisateur.class, VueCompetence.class})
    private String nom;

    @ManyToMany(mappedBy = "listeCompetence")
    @JsonView(VueCompetence.class)
    private Set<Utilisateur> utilisateurs = new HashSet<>();


}
