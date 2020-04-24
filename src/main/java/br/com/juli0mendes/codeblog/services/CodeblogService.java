package br.com.juli0mendes.codeblog.services;

import java.util.List;

import br.com.juli0mendes.codeblog.models.Post;

public interface CodeblogService {
	
	List<Post> findAll();
	
	Post findById(Long id);
	
	Post save(Post post);
}
