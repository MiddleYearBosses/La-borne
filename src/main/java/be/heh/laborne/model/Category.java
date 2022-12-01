package be.heh.laborne.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class Category {

    @Getter
    private final String name;
    @Getter
    private final String link;

}
