package fr.weight.seancesservice.dto;

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
    private Integer seanceTemplateId;
    private String name;
    private Date date;
    private Integer version = 0;
    private Boolean deleted = false;

    public void increment() {
        this.version += 1;
    }

    public void delete() {
        this.deleted = true;
    }
}