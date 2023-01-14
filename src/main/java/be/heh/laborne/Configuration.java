package be.heh.laborne;

import be.heh.laborne.adaptater.out.CategoryMapper;
import be.heh.laborne.adaptater.out.CategoryPersistenceAdapter;
import be.heh.laborne.adaptater.out.CategoryRepository;
import be.heh.laborne.adaptater.out.posts.PostsMapper;
import be.heh.laborne.adaptater.out.posts.PostsPersistanceAdapter;
import be.heh.laborne.adaptater.out.posts.PostsRepository;
import be.heh.laborne.port.in.interfaces.CategoryListUseCase;
import be.heh.laborne.port.in.interfaces.PostsUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@org.springframework.context.annotation.Configuration
@EnableJpaRepositories
public class Configuration {
        @Autowired
        private CategoryRepository categoryRepository;
        @Autowired
        private PostsRepository postsRepository;

        private CategoryMapper categoryMapper = new CategoryMapper();
        private PostsMapper postsMapper = new PostsMapper();

        @Bean
        CategoryListUseCase getCategoryListUseCase(){

            return new CategoryPersistenceAdapter(categoryRepository, categoryMapper);
        }
        @Bean
        PostsUseCase getPostListUsecase(){

                return new PostsPersistanceAdapter(postsRepository, postsMapper);
        }

}
