package kr.re.kitri.hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.re.kitri.hello.dao.ArticleDao;
import kr.re.kitri.hello.vo.ArticleVO;

@Service
public class BbsService {
	
	@Autowired
	private ArticleDao dao;
	
	public ArticleVO detailArticle(String id) {
		
		return dao.selectById(id);
	}

	public void registArticle(ArticleVO vo) {
		dao.insertArticle(vo);
		
	}

}
