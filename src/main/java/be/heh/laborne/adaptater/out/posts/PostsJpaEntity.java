package be.heh.laborne.adaptater.out.posts;
import be.heh.laborne.adaptater.out.CategoryJpaEntity;
import be.heh.laborne.adaptater.out.users.UsersJpaEntity;
import be.heh.laborne.model.Category;
import lombok.Data;


import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@Table(name = "posts")
public class PostsJpaEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
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
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @ManyToOne
    private CategoryJpaEntity category;

    /*@Column(name = "id_fix")
    private long idFix;*/


}