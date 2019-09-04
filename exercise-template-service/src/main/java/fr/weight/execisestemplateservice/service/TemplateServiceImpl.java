package fr.weight.execisestemplateservice.service;

import fr.weight.execisestemplateservice.dto.ExerciceTemplateModel;
import fr.weight.execisestemplateservice.dao.TemplateDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemplateServiceImpl implements TemplateService {
    @Autowired
    private TemplateDao templateDao;
    
    @Override
    public ExerciceTemplateModel save(ExerciceTemplateModel se) {
    	return templateDao.save(se);
    }

    @Override
    public List<ExerciceTemplateModel> list() {
        return (List<ExerciceTemplateModel>) templateDao.findAll();
    }

    @Override
    public ExerciceTemplateModel find(Integer id) throws Exception{
        return templateDao.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
    }
}