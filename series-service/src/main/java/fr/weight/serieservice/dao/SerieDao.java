package fr.weight.serieservice.dao;

import fr.weight.serieservice.bo.Serie;
import fr.weight.serieservice.dto.SerieModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SerieDao extends CrudRepository<SerieModel, Integer> {

    List<SerieModel> findAllByExoId(Integer exoId);
    List<SerieModel> findAllBySeanceIdAndExoTemplateIdOrderByVersionDesc(Integer seanceId, String exoTemplateId);
}
