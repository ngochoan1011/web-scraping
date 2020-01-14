package de.wizy.webapp.business.dto;

import de.wizy.webapp.business.enums.ErrorCodes;

public class StatusDTO {

	private Integer code;
	private String message;

	public StatusDTO(ErrorCodes errorCodes) {
		this.code = errorCodes.getCode();
		this.message = errorCodes.getMessage();
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public StatusDTO(Integer code, String message) {
		this.code = code;
		this.message = message;
	}
}
