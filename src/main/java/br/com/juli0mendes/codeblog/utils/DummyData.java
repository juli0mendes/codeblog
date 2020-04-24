package br.com.juli0mendes.codeblog.utils;

import static org.slf4j.LoggerFactory.getLogger;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.juli0mendes.codeblog.models.Post;
import br.com.juli0mendes.codeblog.models.builders.PostBuilder;
import br.com.juli0mendes.codeblog.repositories.CodeblogRepository;

@Component
public class DummyData {
	
    private static final Logger log = getLogger(DummyData.class);
	
	private final CodeblogRepository codeblogRepository;
	
	@Autowired
	public DummyData(CodeblogRepository codeblogRepository) {
		this.codeblogRepository = codeblogRepository;
	}
	
//	@PostConstruct
	public void savePosts() {
	
		List<Post> posts = Arrays.asList(
				new PostBuilder().any1().build(), 
				new PostBuilder().any2().build(),
				new PostBuilder().any3().build());
		
		posts.stream().forEach(post -> {
			Post postSaved = this.codeblogRepository.save(post);
			log.info("Id post saved - {}", postSaved.getId());
		});
	}

}
