package be.heh.laborne.adaptater.in;

import be.heh.laborne.model.Posts;
import be.heh.laborne.port.in.interfaces.PostsUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class PostsController {

    private final PostsUseCase postsUseCase;
    private List<Posts> posts;

    @GetMapping("/stylistes")
    public String postListStylist(Model model){
        posts = postsUseCase.getPostsList().stream().filter(post -> post.getCategory().getIdCategory()==1).collect(Collectors.toList());
        model.addAttribute("posts",posts);
        return "StylistsList";
    }

    @GetMapping("/vetements")
    public String postListClothes(Model model){
        posts = postsUseCase.getPostsList().stream().filter(post -> post.getCategory().getIdCategory()==2).collect(Collectors.toList());
        model.addAttribute("posts",posts);
        return "ClothesList";
    }

    @GetMapping("/divers")
    public String postListDivers(Model model){
        posts = postsUseCase.getPostsList().stream().filter(post -> post.getCategory().getIdCategory()==3).collect(Collectors.toList());
        model.addAttribute("posts",posts);
        return "DiversList";
    }

    @GetMapping("/qr")
    public String postListQR(Model model){
        posts = postsUseCase.getPostsList().stream().filter(post -> post.getCategory().getIdCategory()==4).collect(Collectors.toList());
        model.addAttribute("posts",posts);
        return "QRList";
    }
}