package be.heh.laborne.adaptater.out.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostsRepository extends JpaRepository<PostsJpaEntity,Long>{

}
