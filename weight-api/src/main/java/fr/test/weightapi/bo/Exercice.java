package fr.test.weightapi.bo;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;


@Data
public class Exercice {

    private Integer id;
    private ExoPredef exoPredef;
    private List<Serie> series = new ArrayList<>();
    private Date date;
    private int numero;
    private int repos;

}
