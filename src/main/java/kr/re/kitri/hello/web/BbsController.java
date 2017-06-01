package kr.re.kitri.hello.web;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.re.kitri.hello.service.BbsService;
import kr.re.kitri.hello.vo.ArticleVO;

/**
 *  /bbs : 전체 글보기
 *  /bbs/write (GET) : 글쓰기화면
 *  /bbs/write (POST) : 글쓰기(action)
 *  /bbs/{id} (GET) : 글 상세보기
 *  /bbs/modify/{id} (GET) : 글수정화면
 *  /bbs/modify/{id} (POST) : 글수정(action)
 *  /bbs/remove/{id} : 글삭제(action)
 *  
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/bbs")
public class BbsController {
	
	@Autowired
	private BbsService bbsService;
	
	@RequestMapping(value="/{id}")
	public ModelAndView detailView(@PathVariable("id") String id) {
		System.out.println(id);
		ArticleVO vo = this.bbsService.detailArticle(id);
		
		System.out.println(vo);
		
		return new ModelAndView("detail").addObject("article", vo);	
	}
	
	@RequestMapping(value="/writ")
	public String test() {
		return "forward:write";
	}
	
	@RequestMapping(value="/prim")
	public String testPrimitive(
			@RequestParam Map<String, String> map,
			HttpSession session) {
		
		int a = Integer.parseInt("a");
		
		session.setAttribute("session_key", "hello");
		
		System.out.println(map);
		
		return "index";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String viewWritePage(HttpSession session) {
		
		String sKey = (String)session.getAttribute("session_key");
		
		System.out.println("글쓰기화면 " + sKey);
		return "write";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public ModelAndView doWrite(@ModelAttribute("article") ArticleVO vo) {
		
		//서비스를 요청하여 사용자가 등록한 글을 DB에 insert
		this.bbsService.registArticle(vo);
		
		//등록된 글을 화면에 보여준다.
		return new ModelAndView("write_ok");
	}
	
	
	@RequestMapping("")
	public String viewAllArticles() {
		System.out.println("전체글보기");
		return "index";
	}
}
