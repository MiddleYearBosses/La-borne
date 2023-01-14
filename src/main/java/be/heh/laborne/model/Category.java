package be.heh.laborne.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

//Get et Set d'une catégorie
@RequiredArgsConstructor
public class Category {

    @Getter
    public final String name;
    @Getter
    public final String link;
    @Getter
    public final long id;

}
