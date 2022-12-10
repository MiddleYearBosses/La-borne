package be.heh.laborne.port.in.interfaces;
import be.heh.laborne.model.Posts;

import java.util.List;

public interface PostsUseCase {

    List<Posts> getPostsList();
}
