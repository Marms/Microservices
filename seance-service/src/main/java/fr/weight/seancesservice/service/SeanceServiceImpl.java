package fr.weight.seancesservice.service;

import fr.weight.seancesservice.dto.SeanceModel;
import fr.weight.seancesservice.dao.SeanceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class SeanceServiceImpl implements SeanceService {
    @Autowired
    private SeanceDao templateDao;
    
    @Override
    public SeanceModel save(SeanceModel se) {

        return templateDao.save(se);
    }

    @Override
    public List<SeanceModel> lastVersionOfAllSeances() {
        List<SeanceModel> l = (List<SeanceModel>) templateDao.findAll();
        Map<Integer, List<SeanceModel>> mapBySeanceId = l.stream()
                .collect(Collectors.groupingBy(SeanceModel::getId));
        return mapBySeanceId.values()
                .stream() // Stream<List<Seance>>
                .map(
                    listSeance -> listSeance.stream() // Stream<Seance>
                            .max(Comparator.comparing(SeanceModel::getVersion))
                            .orElseThrow(NoSuchElementException::new)// impossible
                ).
            collect(Collectors.toList());
    }

    @Override
    public SeanceModel find(Integer id) throws Exception{
        return templateDao.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    @Override
    public List<SeanceModel> listByTemplateId(Integer templateId) {
            return templateDao.findBySeanceTemplateId(templateId);
    }

    @Override
    public List<SeanceModel> lastVersionOfSeance(Integer id, Integer templateId) {

        List<SeanceModel> list = templateDao.findByIdAndSeanceTemplateIdOrderByVersionDesc(id, templateId);
        Map<Integer, List<SeanceModel>> map = list.stream().collect(Collectors.groupingBy(SeanceModel::getVersion));
        return this.filterMaxVersion(map);
    }

    private List<SeanceModel> filterMaxVersion(Map<Integer, List<SeanceModel>> temp) {
        List<SeanceModel> result;
        result = new ArrayList<>();
        for(Integer num : temp.keySet()) {  // possibilité de faire ca en stream
            List<SeanceModel> m = temp.get(num);
            SeanceModel t = m.stream().max(Comparator.comparing(s -> s.getVersion()))
                    .orElseThrow(NoSuchElementException::new); // impossible
            result.add(t);
        }
        return result;
    }

}