package fr.weight.seancestemplateservice.dao;

import fr.weight.seancestemplateservice.dto.SeanceModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface ExerciceDao extends CrudRepository<SeanceModel, Integer> {

    List<SeanceModel> findByTemplateId(Integer templateId);

}
