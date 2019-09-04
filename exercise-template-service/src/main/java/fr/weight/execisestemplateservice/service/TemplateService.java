package fr.weight.execisestemplateservice.service;

import fr.weight.execisestemplateservice.dto.ExerciceTemplateModel;

import java.util.List;

/**
 * @author Florent
 */
public interface TemplateService {

    ExerciceTemplateModel save(ExerciceTemplateModel se) ;
    List<ExerciceTemplateModel> list();
    ExerciceTemplateModel find (Integer id) throws Exception;
}
