package com.yakketyyak.error;

import java.time.LocalDateTime;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiErrorResponse {

	/** The timestamp. */
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
	private LocalDateTime timestamp;

	/** The status. */
	private int status;

	/** The message. */
	private String message;

	/** The debug message. */
	private String debugMessage;

	/** The path. */
	private String path;

	/** The errors. */
	Map<String, String> errors;

	/**
	 * Instantiates a new api error response.
	 */
	public ApiErrorResponse() {
		timestamp = LocalDateTime.now();
	}

	/**
	 * Instantiates a new api error response.
	 *
	 * @param status the status
	 */
	ApiErrorResponse(int status) {
		this();
		this.status = status;
	}

	/**
	 * Instantiates a new api error response.
	 *
	 * @param status the status
	 * @param ex     the ex
	 */
	ApiErrorResponse(int status, Throwable ex) {
		this();
		this.status = status;
		this.debugMessage = ex.getLocalizedMessage();
	}

	/**
	 * Instantiates a new api error response.
	 *
	 * @param status  the status
	 * @param message the message
	 * @param ex      the ex
	 */
	ApiErrorResponse(int status, String message, Throwable ex) {
		this();
		this.status = status;
		this.message = message;
		this.debugMessage = ex.getLocalizedMessage();
	}

}
