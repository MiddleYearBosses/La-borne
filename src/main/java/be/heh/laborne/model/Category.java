package be.heh.laborne.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

//Get et Set d'une catégorie
@RequiredArgsConstructor
public class Category {

    @Getter
    private final String name;
    @Getter
    private final String link;
    @Getter
    private final long id;

}
