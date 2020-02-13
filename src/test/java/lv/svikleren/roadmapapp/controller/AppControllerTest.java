package lv.svikleren.roadmapapp.controller;

import lv.svikleren.roadmapapp.mapper.PersonMapper;
import lv.svikleren.roadmapapp.service.PersonServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class AppControllerTest {

    private MockMvc mockMvc;

    @Mock
    private PersonServiceImpl personServiceImpl;

    private PersonMapper personMapper = new PersonMapper();

    @Mock
    Model model;

    @Before
    public void setUp() {

        initMocks(this);
        AppController controller = new AppController(personServiceImpl);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void getAllContacts() throws Exception {

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders
                .get("/");

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk());

        verify(personServiceImpl, times(1)).getAllContacts();
    }

    @Test
    public void showAddContactPage() throws Exception {

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders
                .get("/add");

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk());
    }

    @Test
    public void addContact() throws Exception {

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders
                .post("/addContact");

        mockMvc.perform(mockRequest)
                .andExpect(status().is3xxRedirection());

        verify(personServiceImpl, times(1)).addContact(any());
    }

    @Test
    public void showEditContactPage() throws Exception {

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders
                .get("/editContact/1")
                .param("id", "1");

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk());

        verify(personServiceImpl, times(1)).getItemById(any());
    }

    @Test
    public void updateContact() throws Exception {

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders
                .post("/updateContact/1")
                .param("id", "1");

        mockMvc.perform(mockRequest)
                .andExpect(status().is3xxRedirection());

        verify(personServiceImpl, times(1)).updateContact(any());
    }

    @Test
    public void deleteContact() throws Exception {

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders
                .get("/deleteContact/1")
                .param("id", "1");

        mockMvc.perform(mockRequest)
                .andExpect(status().is3xxRedirection());

        verify(personServiceImpl, times(1)).deleteContact(any());
    }
}