package be.heh.laborne.adaptater.out.posts;

import be.heh.laborne.model.Posts;
import be.heh.laborne.port.in.interfaces.PostsUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RequiredArgsConstructor
public class PostsPersistanceAdapter implements PostsUseCase {


    @Autowired
    private final PostsRepository postsRepository;
    private List<Posts> posts;

    //Appel du mapper
    private final PostsMapper postsMapper;

    //On décrit ce que la méthode va réaliser : une liste des postes contenu dans le site
    @Override
    public List<Posts> getPostsList() {
        List<PostsJpaEntity> postsEntity = postsRepository.findAll();
        return postsMapper.mapToDomainEntity(postsEntity);
    }

    @Override
    public void deletePosts(Long postId) {

    }

    @Override
    public void modifyPosts(Long postId) {
    }

    @Override
    public void addPosts(Posts post) {
        PostsJpaEntity postEntity = new PostsJpaEntity();
        postEntity.setTitle(post.getTitle());
        postEntity.setPicture(post.getPicture());
        postEntity.setDescription(post.getDescription());
        postEntity.setCategory(post.getCategory());
        postsRepository.save(postEntity);
    }

}

