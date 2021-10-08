package com.vti.config.exception;

import javax.persistence.EntityNotFoundException;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
//	@Autowired
//	private MessageProperty messageProperty;	// dung khi co file properties cho message

	@ExceptionHandler({ Exception.class })
	public ResponseEntity<?> handleAll(Exception exception) {
		ApiErrorResponse error = new ApiErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR,
				"Đã có lỗi từ server,nếu cần hãy liên lạc với admin", exception.getMessage());
		return new ResponseEntity<>(error, error.getStatus());
	}

	@ExceptionHandler({ EntityNotFoundException.class })
	public ResponseEntity<?> handleEntityNotFound(Exception exception) {
		ApiErrorResponse error = new ApiErrorResponse(HttpStatus.NOT_FOUND,
				"Không tìm thấy tài nguyên bạn yêu cầu, hãy check lại params", exception.getMessage());
		return new ResponseEntity<>(error, error.getStatus());
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ApiErrorResponse error = new ApiErrorResponse(HttpStatus.BAD_REQUEST,
				"Lỗi không mapping parameters, hãy kiểm tra lại", exception.getMessage());
		return new ResponseEntity<>(error, error.getStatus());
	}

	@Override
	protected ResponseEntity<Object> handleServletRequestBindingException(ServletRequestBindingException exception,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ApiErrorResponse error = new ApiErrorResponse(HttpStatus.BAD_REQUEST,
				"Lỗi không mapping parameters, hãy kiểm tra lại", exception.getMessage());
		return new ResponseEntity<>(error, error.getStatus());
	}

	@ExceptionHandler(AccessDeniedException.class)
	public ResponseEntity<Object> AccessDeniedException(AccessDeniedException exception) {
		ApiErrorResponse error = new ApiErrorResponse(HttpStatus.FORBIDDEN,
				"Khong co quyen truy cap", exception.getMessage());
		return new ResponseEntity<>(error, error.getStatus());
	}
}
