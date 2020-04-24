package br.com.juli0mendes.codeblog.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.juli0mendes.codeblog.models.Post;
import br.com.juli0mendes.codeblog.repositories.CodeblogRepository;
import br.com.juli0mendes.codeblog.services.CodeblogService;

@Service
public class CodeblogServiceImpl implements CodeblogService {
	
	private final CodeblogRepository codeblogRepository;
	
	@Autowired
	public CodeblogServiceImpl(CodeblogRepository codeblogRepository) {
		this.codeblogRepository = codeblogRepository;
	}

	@Override
	public List<Post> findAll() {
		return this.codeblogRepository.findAll();
	}

	@Override
	public Post findById(Long id) {
		return this.codeblogRepository.findById(id).get();
	}

	@Override
	public Post save(Post post) {
		return this.codeblogRepository.save(post);
	}
}