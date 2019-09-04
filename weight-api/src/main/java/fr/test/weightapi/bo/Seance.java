package fr.test.weightapi.bo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;

import lombok.Data;
import lombok.ToString;

@Data
public class Seance {

    private Integer id;
    private String name;
    private Date date;

    private SeancePredef seancePredef;
    private List<Exercice> exercices = new ArrayList<>();
    private List<Salle> salles;
}
