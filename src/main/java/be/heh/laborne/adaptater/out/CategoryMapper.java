package be.heh.laborne.adaptater.out;

import be.heh.laborne.model.Category;

import java.util.ArrayList;
import java.util.List;

//On map les données JPA et la liste des catégorie : mise en relation
public class CategoryMapper {

    List<Category> mapToDomainEntity(List<CategoryJpaEntity> categories){
        List<Category> categoriesList = new ArrayList<>();

        for (CategoryJpaEntity categoryJpaEntity : categories) {
            categoriesList.add(new Category(categoryJpaEntity.getNameCategory(), categoryJpaEntity.getLink(), categoryJpaEntity.getIdCategory()));
        }
        return categoriesList;
    }
}
