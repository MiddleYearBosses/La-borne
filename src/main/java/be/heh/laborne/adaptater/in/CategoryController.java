package be.heh.laborne.adaptater.in;

import be.heh.laborne.model.Category;
import be.heh.laborne.port.in.interfaces.CategoryListUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryListUseCase categoryListUseCase;
    private List<Category> categories;

    //On lie l'id d'une catégorie à un texte qui servira pour notre url
    private Map<Long,String> routes = Map.of(
            1L,"/stylistes",
            2L,"/vetements",
            3L,"/divers",
            4L, "/qr"
    );

    //Accès aux catégories sur le site
    @GetMapping("/")
    public String categoryList(Model model) {
        categories = categoryListUseCase.getCategoryList();
        model.addAttribute("categories", categories);
        model.addAttribute("routes", routes);
        return "CategoryList";

    }
}