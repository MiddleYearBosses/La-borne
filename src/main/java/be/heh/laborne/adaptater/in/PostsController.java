package be.heh.laborne.adaptater.in;

import be.heh.laborne.adaptater.out.posts.PostsJpaEntity;
import be.heh.laborne.adaptater.out.posts.PostsPersistanceAdapter;
import be.heh.laborne.model.Posts;
import be.heh.laborne.port.in.interfaces.PostsUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class PostsController {

    @Autowired
    private final PostsUseCase postsUseCase;
    private List<Posts> posts;
    //Accès au contenu des catégories du site + Tri des postes à ajouter dans les catégories en fonction de l'id_category qui y sont lié (voir BDD)
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

    @GetMapping("/ajouter")
    public String addPostVue(Model model){
        model.addAttribute("posts",posts);
        long millis = System.currentTimeMillis();
        model.addAttribute("post",new Posts("", "", "", null,null ));
        return "AddPost";
    }
    @PostMapping("/ajouter")
    public String addPost(@ModelAttribute Posts post,Model model) {
        postsUseCase.addPosts(post);
        return "redirect:/";
    }

}