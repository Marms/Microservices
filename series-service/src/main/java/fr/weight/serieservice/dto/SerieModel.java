package fr.weight.serieservice.dto;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class SerieModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer exoId;
    private double poids;
    private double nbRepeat;

    // version seanceID, exoTemplateID, version -> id ? 
    private Integer numero;
    private Integer version = 0;
    private Integer seanceId;
    private String exoTemplateId;
    private Boolean disabled;

    /**
     * temps repos avant series en secondes
     */
    private int repos;
    @Enumerated(EnumType.STRING)
    private TypeNotation type;
    private Double minute;
    private Double seconde;
    private Double leste;
    private Boolean forcer;
    private Boolean neg;
    private String comment;
    private Character unilateral;

    public void incrementeVersion() {
        this.version +=1;
    }
    public void delete() {
        this.disabled = Boolean.TRUE;
    }
}
