package kr.re.kitri.hello.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
//	@Autowired
//	private BbsService bbsService;

	@RequestMapping("/article")
	public String article(
			@RequestParam("title") String title, 
			@RequestParam("content") String content) {
		
		System.out.println(title + "  , " + content);
		
		return "index";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String write() {
		return "write";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String doWrite() {
		return "write_ok";
	}
	
	@RequestMapping("/article/{articleId}")
	public ModelAndView articleDetail(@PathVariable String articleId) {
		
		//ArticleVO vo = bbsService.viewArticleDetail(articleId);
		
		System.out.println(articleId);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("detail");
		//mav.addObject("detail", vo);
		return mav;
	}
	
	@RequestMapping("/")
	public String home() {
		return "index";
	}
	
	@RequestMapping("/bbs/write") //.. /test .. /test.do  .. /test/
	public String test() {

//		bbsService.writeArticle();
		
		return "test";
	}
}
