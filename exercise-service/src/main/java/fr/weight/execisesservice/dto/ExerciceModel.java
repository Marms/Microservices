package fr.weight.execisesservice.dto;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class ExerciceModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer templateId;
    @ElementCollection(targetClass = Integer.class)
    private List<Integer> series = new ArrayList<>();

    private Integer seanceId;
    private Integer version = 0;
    private Boolean disabled;


    public void delete() {
        this.disabled = Boolean.TRUE;
    }

    public void incremente() {
        this.version += 1;
    }
}
