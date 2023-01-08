package be.heh.laborne.adaptater.out.posts;
import be.heh.laborne.adaptater.out.CategoryJpaEntity;
import be.heh.laborne.adaptater.out.users.UsersJpaEntity;
import lombok.AllArgsConstructor;
import lombok.Data;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@Table(name = "posts")
public class PostsJpaEntity {
    //Base de donnée faite à partir de JPA (ou comment réaliser une base de donnée en s'aidant de Java)
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_post")
    private Long idPost;

    @ManyToMany(targetEntity = UsersJpaEntity.class)
    private Set Likes;

    @Column(name = "title",nullable = false)
    private String title;

    @Column(name = "picture",nullable = false,unique = true)
    private String picture;

    @Column(name = "description")
    private String description;

    @Column(name = "created_at",nullable = false)
    private LocalDateTime created_at = LocalDateTime.now();

    @ManyToOne
    private CategoryJpaEntity category;


}