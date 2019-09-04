package fr.test.weightapi.bo;

import java.util.List;


import lombok.Data;

/** Evolution possible : créer un Type d'exercice et des variante  */

@Data
public class ExoPredef {

    private String id;
    private String name;
    private String comment;
    private String image;
    private List<TypeExo> type;
}
