package fr.weight.serieservice.service;

import fr.weight.serieservice.dto.SerieModel;

import java.util.List;

/**
 * @author Florent
 */
public interface SerieService {

    SerieModel save(SerieModel se) ;
    List<SerieModel> list();
    SerieModel find (Integer id) throws Exception;
    List<SerieModel> listFromExoId(Integer exoId);
    List<SerieModel> listFromSeanceIdExoTemplateId(Integer seanceId, String exoTemplateId);
}
