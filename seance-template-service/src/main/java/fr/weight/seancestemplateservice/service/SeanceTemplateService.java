package fr.weight.seancestemplateservice.service;

import fr.weight.seancestemplateservice.dto.SeanceModel;

import java.util.List;

/**
 * @author Florent
 */
public interface SeanceTemplateService {

    SeanceModel save(SeanceModel se) ;
    List<SeanceModel> list();
    SeanceModel find (Integer id) throws Exception;
}
