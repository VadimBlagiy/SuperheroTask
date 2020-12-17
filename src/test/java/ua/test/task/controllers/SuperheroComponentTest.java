package ua.test.task.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import ua.test.task.repository.SuperheroRepository;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringJUnit4ClassRunner.class)
public class SuperheroComponentTest {

    @Autowired
    MockMvc mockMvc;
    @Mock
    SuperheroRepository repositoryMock;

    @Test
    public void friendPresentAfterAdding() throws Exception {
        String heroId = "1";
        String friendsIds = "[2,3,4,5]";
        String expectedResponse = "{" +
                "\"id\":1," +
                "\"name\":\"hjhkjhk\"," +
                "\"firstName\":\"sdnjdsndfj\"," +
                "\"lastName\":\"jnjnjnj\"," +
                "\"age\":78," +
                "\"super_power\":\"hhhhdd\"," +
                "\"friends\":[2,3,4,5]," +
                "\"enemies\":[]" +
                "}";

        mockMvc.perform(createPutRequest(heroId, friendsIds))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedResponse));
    }

    private MockHttpServletRequestBuilder createPutRequest(String heroId, String friendsIds) {
        return put("/superhero/" + heroId + "/friends")
                .contentType(MediaType.APPLICATION_JSON)
                .content(friendsIds);
    }

}
