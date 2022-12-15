package be.heh.laborne.adaptater.in;

import be.heh.laborne.model.Category;
import be.heh.laborne.port.in.interfaces.CategoryListUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryListUseCase categoryListUseCase;
    private List<Category> categories;

    @GetMapping("/")
    public String categoryList(Model model) {
        categories = categoryListUseCase.getCategoryList();
        model.addAttribute("categories", categories);
        return "CategoryList";

    }
}