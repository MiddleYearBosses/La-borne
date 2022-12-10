package be.heh.laborne.adaptater.out;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "category")
public class CategoryJpaEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id_category")
    private Long idCategory;

    @Column(name = "name_category",nullable = false,unique = true)
    private String nameCategory;

    @Column(name = "link",nullable = false,unique = true)
    private String link;

}