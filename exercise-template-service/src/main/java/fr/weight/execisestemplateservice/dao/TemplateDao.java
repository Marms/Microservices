package fr.weight.execisestemplateservice.dao;

import fr.weight.execisestemplateservice.dto.ExerciceTemplateModel;
import org.springframework.data.repository.CrudRepository;


public interface TemplateDao extends CrudRepository<ExerciceTemplateModel, Integer> {

}
