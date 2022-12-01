package be.heh.laborne;

import be.heh.laborne.adaptater.out.CategoryMapper;
import be.heh.laborne.adaptater.out.CategoryPersistenceAdapter;
import be.heh.laborne.adaptater.out.CategoryRepository;
import be.heh.laborne.port.in.CategoryListUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@org.springframework.context.annotation.Configuration
@EnableJpaRepositories
public class Configuration {
        @Autowired
        private CategoryRepository categoryRepository;

        private CategoryMapper categoryMapper = new CategoryMapper();

        @Bean
        CategoryListUseCase getStudentListUseCase(){

            return new CategoryPersistenceAdapter(categoryRepository, categoryMapper);
        }

}
