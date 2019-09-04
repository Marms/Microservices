package fr.weight.serieservice.service;

import fr.weight.serieservice.bo.Serie;
import fr.weight.serieservice.dto.SerieModel;
import fr.weight.serieservice.dao.SerieDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class SerieServiceImpl implements SerieService {
    @Autowired
    private SerieDao serieDao;
    
    @Override
    public SerieModel save(SerieModel se) {
    	return serieDao.save(se);
    }

    @Override
    public List<SerieModel> list() {
        return (List<SerieModel>) serieDao.findAll();
    }

    @Deprecated
    @Override
    public SerieModel find(Integer id) throws Exception{
        return serieDao.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    /**
     * Retourne la derniere version de chaque serie - numéro
     * @param seanceId
     * @param exoTemplateId
     * @return
     */
    @Override
    public List<SerieModel> listFromSeanceIdExoTemplateId(Integer seanceId, String exoTemplateId) {
        List<SerieModel> result = serieDao.findAllBySeanceIdAndExoTemplateIdOrderByVersionDesc(seanceId, exoTemplateId);
        // cas ou exoTemplateId absent : Map<exoTemplateId, Map<numéro, serieModel>>
        Map<Integer, List<SerieModel>> temp = result.stream().collect(Collectors.groupingBy(SerieModel::getNumero));
        return filterMaxVersion(temp);
    }

    private List<SerieModel> filterMaxVersion(Map<Integer, List<SerieModel>> temp) {
        List<SerieModel> result;
        result = new ArrayList();
        for(Integer num : temp.keySet()) {  // possibilité de faire ca en stream
            List<SerieModel> m = temp.get(num);
            SerieModel t = m.stream().max(Comparator.comparing(s -> s.getVersion()))
                    .orElseThrow(NoSuchElementException::new);
            result.add(t);
        }
        return result;
    }

    public List<SerieModel> listFromExoId(Integer exoId) {
        return serieDao.findAllByExoId(exoId);
    }
}