package be.heh.laborne.adaptater.out;

import be.heh.laborne.model.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryMapper {

    List<Category> mapToDomainEntity(List<CategoryJpaEntity> categories){
        List<Category> categoriesList = new ArrayList<>();

        for (CategoryJpaEntity categoryJpaEntity : categories) {
            categoriesList.add(new Category(categoryJpaEntity.getNameCategory(), categoryJpaEntity.getLink()));
        }
        return categoriesList;
    }
}
