package ua.test.task.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.test.task.controllers.SuperheroController;
import ua.test.task.models.Superhero;
import ua.test.task.service.SuperheroService;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
class SuperheroServiceTest {

    @Mock
    SuperheroService mockSuperheroService;
    @InjectMocks
    SuperheroController superheroController = new SuperheroController();

//    @Test
//    public void createSuperheroTest() throws Exception{
//        Superhero superhero = new Superhero();
//
//        superheroController.createSuperhero(superhero);
//
//        verify(mockSuperheroService, times(1)).createSuperhero(superhero);
//
//
//    }



//    @RequestMapping(value = "/superhero", method = RequestMethod.GET)
//    public Object allHero() {
//        Iterable<Superhero> best = superheroService.findAll();
//        return best;
//    }





//    @Test
//    public void findAllTest() {
//        // given
//        List<Superhero> superheroList = new ArrayList<>();
//        superheroList.add(new Superhero("Batman", "Dru", "Kilton",
//                                        45, "drink", superheroList, superheroList));
//        superheroList.add(new Superhero("SpiderMan", "Drum", "Kily",
//                25, "spin", superheroList, superheroList));
//        superheroList.add(new Superhero("Halk", "Tod", "Liof",
//                35, "drinks", superheroList, superheroList));
//
//        //when
//        when(superheroService.findAll()).thenReturn(superheroList);
//
//        // assert
//        List<Superhero> result = superheroService.findAll();
//        assertEquals(3, result.size());
//        assertThat(result.get(0).getFirstName()).isEqualTo("Firstname 1");
//        assertThat(result.get(1).getId()).isEqualTo(2);
    }


