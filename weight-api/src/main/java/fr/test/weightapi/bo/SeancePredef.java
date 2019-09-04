package fr.test.weightapi.bo;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class SeancePredef {


    private Integer id;
    private String name;
    private List<ExoPredef> list = new ArrayList<>();

}
