package com.reader.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.reader.entity.Book;
import com.reader.entity.BookSearchRequest;
import com.reader.exception.ResourceNotFoundException;


@RestController
@RequestMapping("/reader")

@CrossOrigin(origins= "http://localhost:4200")
public class ReaderController {

	@Autowired
	private RestTemplate restTemplate;

	@PostMapping("/searchBook/book")
	
	public List<Book> searchBook(@RequestBody BookSearchRequest bookSearchRequest) {

		@SuppressWarnings("unchecked")
		List<Book> searchBook = this.restTemplate.postForObject("http://author-service/book/searchBook",
				bookSearchRequest, List.class);
	
		System.out.println(searchBook);
		return searchBook;
		
	}
	
	@GetMapping("/searchAllBooks")
	public List<Book>searchAllBook(){
	
		@SuppressWarnings("unchecked")
		List<Book>showAllBook=this.restTemplate.getForObject("http://author-service/book/allbooks", List.class);
		return showAllBook;
	}
	
	@GetMapping("/searchBookById/{bookId}")
	public Object searchBookById(@PathVariable("bookId") int bookId) {
		try {
			Book getBookById=this.restTemplate.getForObject("http://author-service/book/getBook/"+bookId,  Book.class);
			return getBookById;
		}catch(Exception e) {
			
			e.printStackTrace();
			throw new ResourceNotFoundException("Book", "id", bookId);
		}
	}
}
