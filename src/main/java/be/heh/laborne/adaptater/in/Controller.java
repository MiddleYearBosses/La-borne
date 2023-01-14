package be.heh.laborne.adaptater.in;

import be.heh.laborne.model.Category;
import be.heh.laborne.model.Posts;
import be.heh.laborne.port.in.interfaces.CategoryListUseCase;
import be.heh.laborne.port.in.interfaces.PostsUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@org.springframework.stereotype.Controller
@RequiredArgsConstructor
public class Controller {

    private final CategoryListUseCase categoryListUseCase;
    private final PostsUseCase postsUseCase;

    private List<Category> categories;
    private List<Posts> posts;

    //On lie l'id d'une catégorie à un texte qui servira pour notre url
    private Map<Long,String> routes = Map.of(
            1L,"/stylistes",
            2L,"/vetements",
            3L,"/divers",
            4L, "/qr"
    );

    //Accès aux catégories sur le site
    @GetMapping("/")
    public String categoryList(Model model) {
        categories = categoryListUseCase.getCategoryList();
        model.addAttribute("categories", categories);
        model.addAttribute("routes", routes);
        return "CategoryList";

    }

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

    //Accès à la page d'ajout d'un poste, on créée une instance vide que l'on va remplir pour ensuite être redirigé vers l'accueil une fois cela fait
    @GetMapping("/ajouter")
    public String addPostVue(Model model){
        model.addAttribute("post",new Posts("", "", "", null,null, null ));
        return "AddPost";
    }
    @PostMapping("/ajouter")
    public String addPost(@ModelAttribute Posts post,Model model) {
        postsUseCase.addPosts(post);
        return "redirect:/";
    }

    //Modifier/Supprimer un poste en sélectionnant ce dernier par son id, redirection vers l'accueil une fois cela fait
    @RequestMapping(value="/post/{postId}", method = RequestMethod.GET)
    public String editPostVue(@PathVariable Long postId, Model model){
        Posts post = postsUseCase.getPost(postId);
        model.addAttribute("post", post);
        return "ModifyDeleteProduct";
    }

    @RequestMapping(value="/post/{postId}", method = RequestMethod.POST)
    public String editPost(@PathVariable Long postId,@ModelAttribute Posts post, Model model){
        postsUseCase.modifyPosts(postId, post);
        model.addAttribute("post", post);
        return "redirect:/";
    }

    @RequestMapping(value="/delete/{postId}", method = RequestMethod.GET)
    public String deletePost(@PathVariable long postId, Model model){
        postsUseCase.deletePosts(postId);
        return "redirect:/";
    }

    @GetMapping("/profil")
    public String home(Model model, @AuthenticationPrincipal OidcUser principal) {
        if (principal != null) {
            model.addAttribute("profile", principal.getClaims());
        }
        return "profils";
    }
}