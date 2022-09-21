package com.reader.entity;


public class Book {

	private int bookId;
	private String title;
	private String category;
	private String image;
	private int price;
	private String publisher;
	private boolean active;
	private String authorName;
	private String authorEmail;
	private boolean readable;
	
	
	public boolean isReadable() {
		return readable;
	}
	public void setReadable(boolean readable) {
		this.readable = readable;
	}
	public Book(int bookId, String title, String category, String image, int price, String publisher, boolean active,
			String authorName, String authorEmail, boolean readable) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.category = category;
		this.image = image;
		this.price = price;
		this.publisher = publisher;
		this.active = active;
		this.authorName = authorName;
		this.authorEmail = authorEmail;
		this.readable = readable;
	}
	public String getAuthorEmail() {
		return authorEmail;
	}
	public void setAuthorEmail(String authorEmail) {
		this.authorEmail = authorEmail;
	}
	public Book() {
		super();
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	
	

}