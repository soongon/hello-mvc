package kr.re.kitri.hello.vo;

public class ArticleVO {
	
	private int id;
	private String title;
	private String author;
	private String content;
	
	public ArticleVO() {}
	
	public ArticleVO(int id, String title, String author, String content) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.content = content;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		System.out.println("setId callback");
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "ArticleVO [id=" + id + ", title=" + title + ", author=" + author + ", content=" + content + "]";
	}
}
