package br.com.juli0mendes.codeblog.controllers;

import static java.time.LocalDate.now;
import static org.slf4j.LoggerFactory.getLogger;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.juli0mendes.codeblog.models.Post;
import br.com.juli0mendes.codeblog.services.CodeblogService;

@Controller
public class CodeblogController {

private static final Logger log = getLogger(CodeblogController.class);
	
	private final CodeblogService codeblogService;
	
	@Autowired
	public CodeblogController(CodeblogService codeblogService) {
		this.codeblogService = codeblogService;
	}
	
	@RequestMapping(value = "/posts", method = GET)
	public ModelAndView getPosts() {
		ModelAndView mv = new ModelAndView("posts");
		
		List<Post> posts = this.codeblogService.findAll();
		
		log.debug("Quantity posts: [{}]", posts.size());
		
		mv.addObject("posts", posts);
		
		return mv;
	}
	
	@RequestMapping(value = "/posts/{id}", method = GET)
	public ModelAndView getPostDetails(@PathVariable("id") Long id) {
		log.info("getting id [{}]", id);
		
		ModelAndView mv = new ModelAndView("postDetails");
		
		Post post = this.codeblogService.findById(id);
		
		log.info("entity exists: [{}]", post.toString());
		
		mv.addObject("post", post);
		
		return mv;
	}
	

	@RequestMapping(value = "/newpost", method = GET)
	public String getPostForm() {
		return "postForm";
	}
	
	@RequestMapping(value = "/newpost", method = POST)
	public String savePost(@Valid Post post, BindingResult result, RedirectAttributes attributes) {
		
		if (result.hasErrors()) {
			attributes.addFlashAttribute("message", "Verify required fields!");			
			return "redirect:newpost";
		}
		
		post.setCreationDate(now());
		
		Post postSaved = this.codeblogService.save(post);
		
		log.info("post saved [{}]", postSaved.toString());
		
		return "redirect:/posts";
	}

}
