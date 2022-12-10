package be.heh.laborne.adaptater.in;

import be.heh.laborne.model.Posts;
import be.heh.laborne.port.in.interfaces.PostsUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PostsController {

    private final PostsUseCase postsUseCase;
    private List<Posts> posts;

    @GetMapping("/test")
    public String postList(Model model){
        posts = postsUseCase.getPostsList();
        model.addAttribute("posts",posts);
        return "postsList";
    }
}