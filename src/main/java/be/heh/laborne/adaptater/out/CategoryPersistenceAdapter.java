package be.heh.laborne.adaptater.out;

import be.heh.laborne.model.Category;
import be.heh.laborne.port.in.interfaces.CategoryListUseCase;
import lombok.RequiredArgsConstructor;

import java.util.List;
@RequiredArgsConstructor
public class CategoryPersistenceAdapter implements CategoryListUseCase {

    private final CategoryRepository categoryRepository;
    private List<Category> categories;

    private final CategoryMapper categoryMapper;

    @Override
    public List<Category> getCategoryList() {
        List<CategoryJpaEntity> categoriesEntity = categoryRepository.findAll();
        return categoryMapper.mapToDomainEntity(categoriesEntity);
    }
}
