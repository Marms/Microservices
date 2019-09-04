package fr.weight.execisestemplateservice.dto;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class ExerciceTemplateModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String comment;
    private String image;

    @ElementCollection(targetClass=TypeExo.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name="typeExo")
    @Column(name="type") // Column name in person_interest
    private List<TypeExo> type;
}
