package fr.weight.seancestemplateservice.dto;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class SeanceModel {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private Integer templateId;
    private Date date;
    private int numero;
    /** temps de repos en secondes */
    private Integer repos;

    //    @ElementCollection
//    @CollectionTable(name="SERIES", joinColumns=@JoinColumn(name="Owner_id"))
    @ElementCollection(targetClass=Integer.class)
    private List<Integer> exerciceTemplates = new ArrayList<>();
}