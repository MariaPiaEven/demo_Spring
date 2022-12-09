package com.mpeven.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
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
public class Pays {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(VueUtilisateur.class)
    private Integer id;

    @JsonView(VueUtilisateur.class)
    private String nom;

    //Mettre la propriete de Many to One
    @OneToMany(mappedBy = "pays")
    @JsonIgnore
    private Set<Utilisateur> utilisateurs = new HashSet<>();

}
