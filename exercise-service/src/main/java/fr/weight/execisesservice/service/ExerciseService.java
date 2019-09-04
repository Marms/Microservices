package fr.weight.execisesservice.service;

import fr.weight.execisesservice.dto.ExerciceModel;

import java.util.List;

/**
 * @author Florent
 */
public interface ExerciseService {

    ExerciceModel save(ExerciceModel se);

    List<ExerciceModel> list();

    List<ExerciceModel> listByTemplateId(Integer id);

    ExerciceModel find(Integer id) throws Exception;

    List<ExerciceModel> listBySeanceIdAndTemplateId(Integer scId, Integer templateId);
}