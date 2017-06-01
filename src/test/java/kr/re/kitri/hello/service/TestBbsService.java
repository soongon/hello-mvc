package kr.re.kitri.hello.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import kr.re.kitri.hello.vo.ArticleVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestBbsService {
	
	@Autowired
	BbsService bbsService;
	
	@Test
	public void testDetailArticle() {
		ArticleVO vo = bbsService.detailArticle("1");
		System.out.println(vo);
		Assert.assertNotNull(vo);
	}

}
