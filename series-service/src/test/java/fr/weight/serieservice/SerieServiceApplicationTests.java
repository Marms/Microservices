package fr.weight.serieservice;

import fr.weight.serieservice.bo.Serie;
import fr.weight.serieservice.dao.SerieDao;
import fr.weight.serieservice.dto.SerieModel;
import fr.weight.serieservice.service.SerieService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SerieServiceApplicationTests {

    @Autowired
    private SerieDao dao;

    @Autowired
    SerieService service;

    SerieModel s, s2;
    /** Test de proprieter ? */
    @Before
    public void init() {
         s = new SerieModel();
        s.setNbRepeat(10);
        s.setLeste(1.9);
        s.setSeanceId(1);
        s.setExoTemplateId("TEST");
        s.setVersion(1);
        s.setNumero(1);

        s2 = new SerieModel();
        s2.setNbRepeat(10);
        s2.setLeste(1.9);
        s2.setSeanceId(1);
        s2.setExoTemplateId("TEST");
        s2.setVersion(2);
        s2.setNumero(1);

        dao.save(s);
        dao.save(s2);

    }

    @Test
    public void contextLoads() {
    }

    @Test
    public void testFindAll() {
        System.out.println(dao.findAllBySeanceIdAndExoTemplateIdOrderByVersionDesc(1, "TEST"));
    }

    @Test
    public void testService() {
        System.out.println(service.listFromSeanceIdExoTemplateId(1, "TEST"));
    }

}
