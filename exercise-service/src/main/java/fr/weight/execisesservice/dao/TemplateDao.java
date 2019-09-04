package fr.weight.execisesservice.dao;

import fr.weight.execisesservice.dto.ExerciceModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface TemplateDao extends CrudRepository<ExerciceModel, Integer> {

    List<ExerciceModel> findAllByTemplateId(Integer id);
    List<ExerciceModel> findAllBySeanceIdAndTemplateId(Integer seanceId, Integer templateId);
}
