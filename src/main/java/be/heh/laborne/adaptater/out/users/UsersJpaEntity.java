package be.heh.laborne.adaptater.out.users;
import be.heh.laborne.adaptater.out.posts.PostsJpaEntity;
import lombok.Data;
import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "users")
public class UsersJpaEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id_fix")
    private Long idFix;

    @ManyToMany(targetEntity = PostsJpaEntity.class)
    private Set Likes;

    @Column(name = "pseudo",nullable = false,unique = true)
    private String pseudo;

    @Column(name = "name")
    private String name;

    @Column(name = "password",nullable = false)
    private String password;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "age",nullable = false)
    private int age;

    @Column(name = "creator_code",nullable = false,unique = true)
    private String creator_code;

    @Column(name = "admin",nullable = false)
    private boolean admin;
}

