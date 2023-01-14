package be.heh.laborne.model;

import be.heh.laborne.adaptater.out.CategoryJpaEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

//Get et Set d'un poste
@RequiredArgsConstructor
public class Posts {
    @Getter
    @Setter
    public final String title;
    @Getter
    @Setter
    public final String picture;
    @Getter
    @Setter
    public final String description;
    @Getter
    @Setter
    public final LocalDateTime createdAt;
    @Getter
    @Setter
    public final CategoryJpaEntity category;
    @Getter
    public final Long id;
}
