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
    private final String title;
    @Getter
    @Setter
    private final String picture;
    @Getter
    @Setter
    private final String description;
    @Getter
    @Setter
    private final LocalDateTime createdAt;
    @Getter
    @Setter
    private final CategoryJpaEntity category;
    @Getter
    private final Long id;
}
