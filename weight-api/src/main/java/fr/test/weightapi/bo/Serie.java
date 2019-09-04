package fr.test.weightapi.bo;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.internal.util.Cloneable;

import lombok.Data;

/** object embarqué dans l'object Exercices **/
@Data
public class Serie extends Cloneable {

	private Integer id;
    private Integer numero;
    private double poids;
    private double nbRepeat;
    /** temps repos avant series en secondes */
    private int repos;
    
    /**
     * NORMAL, DEGRADER, PDC, TIME, TRACTION
     */
    private TypeNotation type;
    private Double minute;
    private Double seconde;
    private Double leste;
    private Boolean forcer;
    private Boolean neg;
    private String comment;
	private Character unilateral;
    private Serie serie;
}
