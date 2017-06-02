package kr.re.kitri.hello.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.re.kitri.hello.vo.ArticleVO;

@Repository
public class ArticleDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public ArticleVO selectById(String id) {
		
		System.out.println("log");
		
		return this.sqlSession.selectOne("article.selectById", id);
	}

	public void insertArticle(ArticleVO vo) {
		this.sqlSession.insert("article.insert", vo);
	}

}


