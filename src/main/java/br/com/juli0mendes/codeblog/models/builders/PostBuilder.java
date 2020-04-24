package br.com.juli0mendes.codeblog.models.builders;

import static java.time.LocalDate.now;

import java.time.LocalDate;

import br.com.juli0mendes.codeblog.models.Post;

public class PostBuilder {

	private Post entity;
	
	public PostBuilder() {
		this.entity = new Post();
	}
	
	public PostBuilder any1() {
		this.entity.setAuthor("João");
		this.entity.setCreationDate(now());
		this.entity.setTitle("Titulo 1");
		this.entity.setText("Title single 1");
		
		return this;
	}
	
	public PostBuilder any2() {
		this.entity.setAuthor("Maria");
		this.entity.setCreationDate(now());
		this.entity.setTitle("Titulo 2");
		this.entity.setText("Title single 2");
		
		return this;
	}
	
	public PostBuilder any3() {
		this.entity.setAuthor("Antônia");
		this.entity.setCreationDate(now());
		this.entity.setTitle("Titulo 3");
		this.entity.setText("Title single 3");
		
		return this;
	}
	
	public PostBuilder withAuthor(String author) {
		this.entity.setAuthor(author);
		return this;
	}
	
	public PostBuilder withCreationDate(LocalDate creationDate) {
		this.entity.setCreationDate(creationDate);
		return this;
	}
	
	public PostBuilder withTitle(String title) {
		this.entity.setTitle(title);
		return this;
	}
	
	public PostBuilder withText(String text) {
		this.entity.setText(text);
		return this;
	}
	
	public Post build() {
		return this.entity;
	}
}
