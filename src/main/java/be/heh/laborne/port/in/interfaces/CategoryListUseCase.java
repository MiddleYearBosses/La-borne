package be.heh.laborne.port.in.interfaces;
import be.heh.laborne.model.Category;

import java.util.List;

public interface CategoryListUseCase {

    //méthode pour lister les catégories à l'accueil du site
    List<Category> getCategoryList();
}
