package kr.re.kitri.hello.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.re.kitri.hello.vo.ArticleVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestArticleDao {
	
	@Autowired
	ArticleDao articleDao;

	@Test
	public void testSelectById() {
		ArticleVO vo = articleDao.selectById("1");
		System.out.println(vo);
		Assert.assertNotNull(vo);
	}
}
