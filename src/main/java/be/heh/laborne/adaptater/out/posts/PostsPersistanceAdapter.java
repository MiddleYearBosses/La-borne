package be.heh.laborne.adaptater.out.posts;


import be.heh.laborne.adaptater.out.CategoryJpaEntity;
import be.heh.laborne.model.Category;
import be.heh.laborne.model.Posts;
import be.heh.laborne.port.in.interfaces.PostsUseCase;
import lombok.RequiredArgsConstructor;

import java.util.List;
@RequiredArgsConstructor
public class PostsPersistanceAdapter implements PostsUseCase {

    private final PostsRepository postsRepository;
    private List<Posts> posts;

    private final PostsMapper postsMapper;

    @Override
    public List<Posts> getPostsList() {
        List<PostsJpaEntity> postsEntity = postsRepository.findAll();
        return postsMapper.mapToDomainEntity(postsEntity);
    }

}

