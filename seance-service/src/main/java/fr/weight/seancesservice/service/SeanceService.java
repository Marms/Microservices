package fr.weight.seancesservice.service;

import fr.weight.seancesservice.dto.SeanceModel;

import java.util.List;

/**
 * @author Florent
 */
public interface SeanceService {

    SeanceModel save(SeanceModel se) ;
    List<SeanceModel> lastVersionOfAllSeances();
    SeanceModel find (Integer id) throws Exception;
    List<SeanceModel> listByTemplateId(Integer templateId);
    List<SeanceModel> lastVersionOfSeance(Integer id, Integer templateId);
}
