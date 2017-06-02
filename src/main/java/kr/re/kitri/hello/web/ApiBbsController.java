package kr.re.kitri.hello.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 
 *  /bbs (GET)         : 전체 글보기
 *  /bbs (POST)        : 글 쓰기
 *  /bbs/{id} (GET)    : 글상세보기
 *  /bbs/{id} (PUT)    : 글 수정
 *  /bbs/{id} (DELETE) : 글 삭제
 *  
 *  /employees
 *  /employee/{id}
 * @author Administrator
 *
 */
@RestController // @Controller + @ResponseBody
@RequestMapping("/api/bbs")
public class ApiBbsController {
	
	
//	@RequestMapping(value="", method=RequestMethod.GET)
//	public List<Article> viewAll() {
//		
//		return new ArrayList<Article>();
//	}
//	

}
