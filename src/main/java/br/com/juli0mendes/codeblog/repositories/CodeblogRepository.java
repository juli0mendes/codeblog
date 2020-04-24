package br.com.juli0mendes.codeblog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.juli0mendes.codeblog.models.Post;

public interface CodeblogRepository extends JpaRepository<Post, Long>{
}