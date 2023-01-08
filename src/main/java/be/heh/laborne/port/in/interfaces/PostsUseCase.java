package be.heh.laborne.port.in.interfaces;
import be.heh.laborne.adaptater.out.posts.PostsJpaEntity;
import be.heh.laborne.model.Posts;

import java.util.List;

public interface PostsUseCase {

    //méthode pour lister les posts
    List<Posts> getPostsList();

    void deletePosts(Long postId);

    void modifyPosts(Long postId);

    void addPosts(Posts post);


}
