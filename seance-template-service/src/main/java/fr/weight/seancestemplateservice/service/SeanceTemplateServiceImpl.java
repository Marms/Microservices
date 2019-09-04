package fr.weight.seancestemplateservice.service;

import fr.weight.seancestemplateservice.dto.SeanceModel;
import fr.weight.seancestemplateservice.dao.ExerciceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeanceTemplateServiceImpl implements SeanceTemplateService {
    @Autowired
    private ExerciceDao templateDao;
    
    @Override
    public SeanceModel save(SeanceModel se) {
    	return templateDao.save(se);
    }

    @Override
    public List<SeanceModel> list() {
        return (List<SeanceModel>) templateDao.findAll();
    }

    @Override
    public SeanceModel find(Integer id) throws Exception{
        return templateDao.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
    }
}