package be.heh.laborne.adaptater;

import be.heh.laborne.adaptater.out.CategoryMapper;
import be.heh.laborne.adaptater.out.CategoryPersistenceAdapter;
import be.heh.laborne.adaptater.out.CategoryRepository;
import be.heh.laborne.model.Category;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Testcontainers
@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class AdapterPersistenceTest extends AbstractIntegrationTest{

    @Autowired
    private CategoryRepository categoryRepository;
    private CategoryMapper categoryMapper;

    private CategoryPersistenceAdapter categoryPersistenceAdapter;

    @Test
    @Sql({"createStudentTable.sql","dataStudent.sql"})
    void getStudentsList(){
        categoryMapper = new CategoryMapper();
        categoryPersistenceAdapter = new CategoryPersistenceAdapter(categoryRepository, categoryMapper);

        List<Category> categories;

        categories = categoryPersistenceAdapter.getCategoryList();


        assertEquals("Vêtements",categories.get(1).getName());
        assertEquals("img/vetements.jpg",categories.get(1).getLink());
    }
}
