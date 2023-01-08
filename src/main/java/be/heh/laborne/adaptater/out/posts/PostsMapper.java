package be.heh.laborne.adaptater.out.posts;
import be.heh.laborne.adaptater.out.CategoryJpaEntity;
import be.heh.laborne.model.Posts;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//On map les données JPA et la liste des postes : mise en relation
public class PostsMapper {

    List<Posts> mapToDomainEntity(List<PostsJpaEntity> posts){
        List<Posts> postsList = new ArrayList<>();

        for (PostsJpaEntity postsJpaEntity : posts) {
            postsList.add(new Posts(postsJpaEntity.getTitle(), postsJpaEntity.getPicture(), postsJpaEntity.getDescription(), LocalDateTime.now(), postsJpaEntity.getCategory()));
        }
        return postsList;
    }

}


