package be.heh.laborne.adaptater.out;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "category")
public class CategoryJpaEntity {
    //Base de donnée faite à partir de JPA (ou comment réaliser une base de donnée en s'aidant de Java)
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id_category")
    private Long idCategory;

    @Column(name = "name_category",nullable = false,unique = true)
    private String nameCategory;

    @Column(name = "link",nullable = false,unique = true)
    private String link;

}