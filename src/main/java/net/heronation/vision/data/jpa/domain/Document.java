package net.heronation.vision.data.jpa.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Document implements Serializable  {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String title;

	@Column(nullable = false)
	private String content;
 
	public Document() {
		// TODO Auto-generated constructor stub
	}

	public Document(Long id, String title, String content) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Document(String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}

}
