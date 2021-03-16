package com.example.demo.controller;

import com.example.demo.service.PostService;
import com.example.demo.service.UserService;
import com.example.demo.entity.Gender;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("users")
public class UserController {

    private final UserService userService;
    private final PostService postService;

    @Autowired
    public UserController(UserService userService, PostService postService) {
        this.userService = userService;
        this.postService = postService;
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("users", userService.index());
        return "user/index";
    }

    @GetMapping("/outterUsers")
    public String getOutterUsers()
    {
        try {
            userService.saveOuterUser();
            postService.saveOuterPost();

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return "redirect:/users";
    }



    @GetMapping("/{id}")
    public String show(@PathVariable("id") Integer id
                       ,@RequestParam(name = "title",required = false,defaultValue = "") String title
                       ,@RequestParam(name = "sort",required = false,defaultValue = "") String sort
            , Model model)
    {

        model.addAttribute("user", userService.show(id));
        if (title.isBlank())
        {model.addAttribute("posts", postService.findByUserId(id));}
        else
        {model.addAttribute("posts", postService.findPostTitleLike(id,title));}

        return "user/show";
    }
    @GetMapping("/{id}/post/{page}")
    public String show(@PathVariable("id") Integer id
                       ,@PathVariable("page") Integer page
            ,@RequestParam(name = "title",required = false,defaultValue = "") String title
            ,@RequestParam(name = "sort",required = false,defaultValue = "id") String sort
            , Model model)
    {
        Integer prevPage = page - 1 >= 0 ? page - 1 : 0;
        model.addAttribute("user", userService.show(id));
        model.addAttribute("nextPage",page + 1);
        model.addAttribute("previousPage",prevPage.toString());
        Pageable pageable = PageRequest.of(page,50,Sort.Direction.ASC,sort);
        if (title.isBlank())
        {model.addAttribute("posts", postService.findByUserId(id, pageable));
        }
        else
        {model.addAttribute("posts", postService.findPostTitleLike(id,title,pageable));}

        return "user/show";
    }

//    @GetMapping("/{id}")
//    public String show(@PathVariable("id") Integer id, Model model)
//    {
//        model.addAttribute("user", userService.show(id));
//        model.addAttribute("posts", postService.findByUserId(id));
//        return "user/show";
//    }

    @GetMapping("/new")
    public String newUser(Model model)
    {
        model.addAttribute("user", new User());
        model.addAttribute("genders", Gender.values());
        return "user/new";

    }
    @PostMapping()
    public String create(@ModelAttribute("user") User user,
                         BindingResult bindingResult)
    {
        if (bindingResult.hasErrors())
        {
            return "user/new";
        }
        userService.save(user);
        return "redirect:/users";

    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("user", userService.show(id));
        List<Gender> genders = Arrays.asList(Gender.values().clone());

        model.addAttribute("genders", genders);
        return "user/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user,
                         BindingResult bindingResult,
                         @PathVariable("id") int id)
    {
        if(bindingResult.hasErrors())
            return "user/edit";
        userService.save(user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){

        userService.delete(id);
        return "redirect:/users";
    }


}
