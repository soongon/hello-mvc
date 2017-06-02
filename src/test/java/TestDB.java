import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.re.kitri.hello.vo.ArticleVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestDB {
	
	@Autowired
	DataSource ds;
	
	@Autowired
	SqlSessionFactoryBean factory;
	
	@Autowired
	SqlSessionTemplate sqlSession;
	
	@Test
	public void testSelectAll() {
		List<ArticleVO> list = this.sqlSession.selectList("article.selectAll");
		System.out.println(list);
		Assert.assertTrue(list.size() > 0);
	}
	
	
//	private ApplicationContext ctx;
//	
//	@Before
//	public void setup() {
//		ctx = new ClassPathXmlApplicationContext(
//				"classpath:applicationContext.xml");
//	}
	
	@Test
	public void testSqlSession() {
		ArticleVO vo = sqlSession.selectOne("article.selectById", "2");
		System.out.println(vo);
		Assert.assertTrue(vo.getAuthor().equals("lee"));
	}
	
	@Test
	@Ignore
	public void testSqlSessionFactory() {
//		SqlSessionFactoryBean factory = 
//				ctx.getBean("sqlSessionFactory", SqlSessionFactoryBean.class);
		Assert.assertNotNull(factory);
	}
	
	@Test
	@Ignore
	public void testDatasource() {
		//DataSource ds = ctx.getBean("dataSource", DataSource.class);
		try {
			Connection conn = (Connection)ds.getConnection();
			Assert.assertNotNull(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
