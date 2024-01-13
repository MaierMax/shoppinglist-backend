package htwberlin.webtech.controller;

import htwberlin.webtech.shoppingList.ListController;
import htwberlin.webtech.shoppingList.ListService;
import htwberlin.webtech.shoppingList.ShoppingList;
import htwberlin.webtech.shoppingListItem.ItemService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ListControllerTest {

    @InjectMocks
    private ListController listController;

    @Mock
    private ListService listService;

    @Mock
    private ItemService itemService;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(listController).build();
    }

    @Test
    void testCreateList() throws Exception {
        when(listService.save(any(ShoppingList.class))).thenReturn(new ShoppingList("Supermarkt"));

        mockMvc.perform(MockMvcRequestBuilders.post("/saveList")
                        .content("{\"listName\": \"Supermarkt\"}")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.listName").value("Supermarkt"));
    }

    @Test
    void testGetList() throws Exception {
        when(listService.get(1L)).thenReturn(new ShoppingList("Supermarkt"));

        mockMvc.perform(MockMvcRequestBuilders.get("/getList/1"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.listName").value("Supermarkt"));
    }

    @Test
    void testGetAllLists() throws Exception {
        List<ShoppingList> shoppingLists = Arrays.asList(
                new ShoppingList("Supermarkt"),
                new ShoppingList("Baumarkt"),
                new ShoppingList("Kleidung")
        );

        when(listService.getAll()).thenReturn(shoppingLists);

        mockMvc.perform(MockMvcRequestBuilders.get("/home"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].listName").value("Supermarkt"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[1].listName").value("Baumarkt"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[2].listName").value("Kleidung"));
    }

    @Test
    void testUpdateList() throws Exception {
        when(listService.rename(any(String.class), any(Long.class))).thenReturn(new ShoppingList("Kaufland"));

        mockMvc.perform(MockMvcRequestBuilders.put("/updateList/1")
                        .content("{\"newName\": \"Kaufland\"}")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.listName").value("Kaufland"));
    }

    @Test
    void testDeleteList() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/deleteList/1"))
                .andExpect(status().isOk());
    }

}
