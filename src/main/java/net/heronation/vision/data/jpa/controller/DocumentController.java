package net.heronation.vision.data.jpa.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.heronation.vision.data.jpa.domain.Document;
import net.heronation.vision.data.jpa.service.DocumentRepository;

@RestController
@RequestMapping("/api/documents")
public class DocumentController {
	
	@Autowired
	DocumentRepository documentRepository;
	
	//All List
	@RequestMapping(method = RequestMethod.GET, value="")
	public ResponseEntity<List<Document>> list(){
		List<Document> documents = documentRepository.findAll();
		System.out.println("--------------------------getList--------------------------");
		return new ResponseEntity<List<Document>>(documents, HttpStatus.OK);
	}
	
	//read
	@RequestMapping(method = RequestMethod.GET, value="/{id}")
	public ResponseEntity<Document> read(@PathVariable(value="id") long id){
		Document document = documentRepository.findOne(id);
		System.out.println("--------------------------read--------------------------");
		return new ResponseEntity<Document>(document, HttpStatus.OK);
	}
	
	//insert
	@RequestMapping(method = RequestMethod.POST, value="")
	public ResponseEntity<Document> insert(Document document) {
		System.out.println("--------------------------insert--------------------------");
		document=documentRepository.save(document);
		return new ResponseEntity<Document>(document, HttpStatus.OK);
	}

	//update
	@RequestMapping(method = RequestMethod.PUT, value="/{id}")
	public ResponseEntity<Document> update(Document document, @PathVariable(value="id") long id) {
		System.out.println("--------------------------update--------------------------");
		System.out.println(document.getTitle());
		System.out.println(document.getContent());
		Document r = documentRepository.findOne(id);
		
		r.setTitle(document.getTitle());
		r.setContent(document.getContent());
		documentRepository.save(r);
		return new ResponseEntity<Document>(r, HttpStatus.OK);
	}

	//delete
	@RequestMapping(method = RequestMethod.DELETE, value="/{id}")
	public String delete(@PathVariable(value="id") long id){
		System.out.println("--------------------------delete--------------------------");
		documentRepository.delete(id);
		System.out.println("delete success");
		return "delete success";
	}
	
}
