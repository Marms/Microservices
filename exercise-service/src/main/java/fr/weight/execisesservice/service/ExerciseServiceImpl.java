package fr.weight.execisesservice.service;

import fr.weight.execisesservice.dto.ExerciceModel;
import fr.weight.execisesservice.dao.TemplateDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ExerciseServiceImpl implements ExerciseService {
    @Autowired
    private TemplateDao templateDao;
    
    @Override
    public ExerciceModel save(ExerciceModel se) {
    	return templateDao.save(se);
    }

    @Override
    public List<ExerciceModel> list() {
        return (List<ExerciceModel>) templateDao.findAll();
    }

    @Override
    public ExerciceModel find(Integer id) throws Exception{
        return templateDao.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
    }
    @Override
    public List<ExerciceModel> listByTemplateId(Integer id) {
        return templateDao.findAllByTemplateId(id);
    }

    @Override
    public List<ExerciceModel> listBySeanceIdAndTemplateId(Integer scId, Integer templateId) {
        List<ExerciceModel> list = templateDao.findAllBySeanceIdAndTemplateId(scId,templateId);
        Map<Integer, List<ExerciceModel>> map = list.stream().collect(Collectors.groupingBy(ExerciceModel::getVersion));
        return filterMaxVersion(map);
    }

    private List<ExerciceModel> filterMaxVersion(Map<Integer, List<ExerciceModel>> temp) {
        List<ExerciceModel> result;
        result = new ArrayList<>();
        for(Integer num : temp.keySet()) {  // possibilité de faire ca en stream
            List<ExerciceModel> m = temp.get(num);
            ExerciceModel t = m.stream().max(Comparator.comparing(s -> s.getVersion()))
                    .orElseThrow(NoSuchElementException::new);
            result.add(t);
        }
        return result;
    }
}