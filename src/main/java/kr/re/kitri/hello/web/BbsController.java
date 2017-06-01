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
 *  /bbs : ��ü �ۺ���
 *  /bbs/write (GET) : �۾���ȭ��
 *  /bbs/write (POST) : �۾���(action)
 *  /bbs/{id} (GET) : �� �󼼺���
 *  /bbs/modify/{id} (GET) : �ۼ���ȭ��
 *  /bbs/modify/{id} (POST) : �ۼ���(action)
 *  /bbs/remove/{id} : �ۻ���(action)
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
		
		System.out.println("�۾���ȭ�� " + sKey);
		return "write";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public ModelAndView doWrite(@ModelAttribute("article") ArticleVO vo) {
		
		//���񽺸� ��û�Ͽ� ����ڰ� ����� ���� DB�� insert
		this.bbsService.registArticle(vo);
		
		//��ϵ� ���� ȭ�鿡 �����ش�.
		return new ModelAndView("write_ok");
	}
	
	
	@RequestMapping("")
	public String viewAllArticles() {
		System.out.println("��ü�ۺ���");
		return "index";
	}
}
