package kr.re.kitri.hello.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice("kr.re.kitri.hello")
public class CommonExceptionHandler {

	@ExceptionHandler(RuntimeException.class)
	public String handleRuntimeException() {
		System.out.println("예외가 발생했습니다.");
		return "error/runtime";
	}
}
