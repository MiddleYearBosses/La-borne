package be.heh.laborne.adaptater.out.posts;
import be.heh.laborne.model.Posts;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//On map les données JPA et la liste des postes : mise en relation
public class PostsMapper {

    //Relier les classes objets aux entités
    List<Posts> mapToDomainEntity(List<PostsJpaEntity> posts){
        List<Posts> postsList = new ArrayList<>();

        for (PostsJpaEntity postsJpaEntity : posts) {
            postsList.add(new Posts(postsJpaEntity.getTitle(), postsJpaEntity.getPicture(), postsJpaEntity.getDescription(), LocalDateTime.now(), postsJpaEntity.getCategory(), postsJpaEntity.getIdPost()));
        }
        return postsList;
    }

    Posts mapToSingleEntity(PostsJpaEntity post){
        return new Posts(post.getTitle(), post.getPicture(), post.getDescription(), LocalDateTime.now(), post.getCategory(), post.getIdPost());
    }

}


