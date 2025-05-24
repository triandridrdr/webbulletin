package com.example.webbulletin.controllers;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.webbulletin.dto.PostData;
import com.example.webbulletin.dto.SearchData;
import com.example.webbulletin.models.Author;
import com.example.webbulletin.models.Post;
import com.example.webbulletin.repositories.AuthorRepository;
import com.example.webbulletin.repositories.PostRepository;
import com.example.webbulletin.services.PostService;

import jakarta.validation.Valid;

@Controller
public class PostController {
	
	@Autowired
    private PostService postService;
	
	@Autowired
	private AuthorRepository authorRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
    @RequestMapping("/")
    public String tampil(Model model) {	
    	List<Post> posts = postService.findByStatusDelete("no");
    	model.addAttribute("searchForm", new SearchData());
        model.addAttribute("posts", posts);
        return "lihatListBulletin";
    }
	   
    @RequestMapping("/updatePost/{postNumber}")
    public ModelAndView showById(@PathVariable(name = "postNumber") int postNumber) {
        ModelAndView mav = new ModelAndView("updateBulletin");
        Post pst = postService.getById(postNumber);
        mav.addObject("authors", authorRepository.findAll());
        mav.addObject("post", pst);
        return mav;
    }
    
    @GetMapping("/newPost")
    public String add(@ModelAttribute("post") Post pst, Model model) {
    	model.addAttribute("authors", authorRepository.findAll());
        model.addAttribute("Post", new Post());
        return "new";
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@Valid @ModelAttribute("post") PostData pstData, BindingResult bindingResult, Model model) {
    	boolean thereAreErrors = bindingResult.hasErrors();
    	if(thereAreErrors) {
    		model.addAttribute("post", pstData);
    		return "new";
    	}
    	long millis = System.currentTimeMillis();
    	java.sql.Date date = new java.sql.Date (millis);
    	pstData.setCreated(date);
    	pstData.setViewers(0);
    	pstData.setStatusDelete("no");
    	
    	//Coba mapping
    	System.out.println("Sebelum mapping");
    	Post post = modelMapper.map(pstData, Post.class);
    	
    	postService.save(post);
        return "redirect:/deletePost";
    }
    
    @RequestMapping(value = "/saveUpdate", method = RequestMethod.POST)
    public String saveUpdate(@ModelAttribute("post") PostData pstData) {
    	long millis = System.currentTimeMillis();
    	int viewer = 0;
    	java.sql.Date date = new java.sql.Date (millis);
    	
    	//Coba mapping
    	System.out.println("Sebelum mapping untuk update 2");
    	Post post = modelMapper.map(pstData, Post.class);
    	
    	post.setModifyDate(date);
    	Post pstGetDB = postService.getById(post.getPostNumber());
    	viewer = pstGetDB.getViewers();
    	post.setCreated(pstGetDB.getCreated());
    	post.setViewers(viewer);
    	post.setStatusDelete("no");
    	Author authorFromDb = authorRepository.findById(post.getAuthor().getId()).orElse(null);
    	post.setAuthor(authorFromDb);
    	postService.save(post);
    	return "redirect:/deletePost";
    }
    
    @RequestMapping("/updatePostFinish")
    public String updatePostFinish(@ModelAttribute("post") PostData pstData) {
    	
    	//Coba mapping
    	System.out.println("Sebelum mapping untuk update");
    	Post post = modelMapper.map(pstData, Post.class);
    	
    	postService.save(post);
        return "redirect:/";
    }
    
    
    @RequestMapping("/viewDetail/{postNumber}")
    public String findById(@PathVariable Integer postNumber, Model model) {
    	
    	List<Post> posts = postService.findByPostNumber(postNumber);
    	Integer viewersUpdate = posts.get(0).getViewers()+1;
    	posts.get(0).setViewers(viewersUpdate);
    	postService.saveAll(posts);
    	model.addAttribute("posts", posts);
    	return "lihatDetailPost";
        
    }
    
    @RequestMapping("/deletePost")
    public String deletePost(Model model) {
        //List<Post> posts = postRepository.findAll();
    	List<Post> posts = postService.findByStatusDelete("no");
        model.addAttribute("posts", posts);
        return "deletePost";
    }
    
    @RequestMapping("/deletePostFinish/{postNumber}")
    public String deletePostFinish(@PathVariable Integer postNumber, Model model) {
    	//postRepository.deleteById(postNumber);
    	Post pst = postService.getById(postNumber);
    	pst.setStatusDelete("yes");
    	postService.save(pst);
        return "redirect:../deletePost";
    }
    
    
    @PostMapping("/search")
    public String searchKey(Model model, SearchData searchData){
    	List<Post> posts = postService.findByPostTitleContains(searchData.getKeyWord());
    	model.addAttribute("searchForm", searchData);
        model.addAttribute("posts", posts);
        return "lihatListBulletin";
    }
    
    

}
