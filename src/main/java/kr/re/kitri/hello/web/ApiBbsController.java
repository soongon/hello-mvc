package kr.re.kitri.hello.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 
 *  /bbs (GET)         : ��ü �ۺ���
 *  /bbs (POST)        : �� ����
 *  /bbs/{id} (GET)    : �ۻ󼼺���
 *  /bbs/{id} (PUT)    : �� ����
 *  /bbs/{id} (DELETE) : �� ����
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
