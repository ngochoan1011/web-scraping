package de.wizy.webapp.rest.exception;

import de.wizy.webapp.business.dto.StatusDTO;

public class BadRequestException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private StatusDTO statusDTO;

	public BadRequestException(StatusDTO statusDTO) {
		super();
		this.setStatusDTO(statusDTO);
	}

	public StatusDTO getStatusDTO() {
		return statusDTO;
	}

	public void setStatusDTO(StatusDTO statusDTO) {
		this.statusDTO = statusDTO;
	}
}
