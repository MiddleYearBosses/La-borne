package be.heh.laborne.adaptater.out.posts;
import be.heh.laborne.model.Posts;

import java.util.ArrayList;
import java.util.List;

public class PostsMapper {

    List<Posts> mapToDomainEntity(List<PostsJpaEntity> posts){
        List<Posts> postsList = new ArrayList<>();

        for (PostsJpaEntity postsJpaEntity : posts) {
            postsList.add(new Posts(postsJpaEntity.getTitle(), postsJpaEntity.getPicture(), postsJpaEntity.getDescription(), postsJpaEntity.getCreatedAt()));
        }
        return postsList;
    }
}


