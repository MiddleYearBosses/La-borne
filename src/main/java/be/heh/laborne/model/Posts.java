package be.heh.laborne.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import java.util.Date;

@RequiredArgsConstructor
public class Posts {

    @Getter
    private final String title;
    @Getter
    private final String picture;
    @Getter
    private final String description;
    @Getter
    private final Date createdAt;

}
