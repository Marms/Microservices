package fr.test.weightapi.bo;

import lombok.Data;

import java.util.List;

@Data
public class Salle {

    private Long id;
    private String name;
    private List<ExoPredef> exoTemplates;
    private List<SeancePredef> seanceTemplates;
}
