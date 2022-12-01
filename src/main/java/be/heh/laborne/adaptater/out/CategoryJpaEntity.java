package be.heh.laborne.adaptater.out;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Data
@Table(name = "category")
public class CategoryJpaEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id_category")
    private Long idCategory;

    @Column(name = "name_category")
    private String nameCategory;

    @Column(name = "link")
    private String link;

}