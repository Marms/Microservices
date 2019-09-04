package fr.weight.seancesservice.dao;

import fr.weight.seancesservice.dto.SeanceModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface SeanceDao extends CrudRepository<SeanceModel, Integer> {

    List<SeanceModel> findBySeanceTemplateId(Integer templateId);
    List<SeanceModel> findByIdAndSeanceTemplateIdOrderByVersionDesc(Integer id, Integer templateId);

}
