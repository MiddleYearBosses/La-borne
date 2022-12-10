package be.heh.laborne.adaptater;

import be.heh.laborne.adaptater.in.CategoryController;
import be.heh.laborne.model.Category;
import be.heh.laborne.port.in.interfaces.CategoryListUseCase;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasItemInArray;
import static org.hamcrest.Matchers.hasProperty;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//@SpringBootTest
//@RunWith(SpringRunner.class)
@WebMvcTest(CategoryController.class)
public class AdapaterWebTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CategoryListUseCase categoryListUseCase;

    private List<Category> categories = new ArrayList<>();

    @Test
    public void testStudentController() throws Exception {

        categories.add(new Category("Stylistes","img/createurs.jpg"));
        categories.add(new Category("Vêtements","img/vetements.jpg"));
        categories.add(new Category("Divers","img/divers.jpg"));
        categories.add(new Category("QR codes","img/QR.jpg"));

        //Stub
        Mockito.when(categoryListUseCase.getCategoryList()).thenReturn(categories);

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("categoryList"))
                .andExpect(model().attributeExists("categories"))
                .andExpect(model().attribute("categories",Matchers.hasSize(3)));
    }
}