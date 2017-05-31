package kr.re.kitri.hello.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice("kr.re.kitri.hello")
public class CommonExceptionHandler {

	@ExceptionHandler(RuntimeException.class)
	public String handleRuntimeException() {
		System.out.println("���ܰ� �߻��߽��ϴ�.");
		return "error/runtime";
	}
}
