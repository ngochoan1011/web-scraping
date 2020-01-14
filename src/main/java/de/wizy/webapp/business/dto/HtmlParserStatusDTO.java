package de.wizy.webapp.business.dto;


public class HtmlParserStatusDTO {

    private String url;
    private StatusDTO statusDTO;

    public HtmlParserStatusDTO(String url) {
        this.url = url;
    }

    public HtmlParserStatusDTO(String url, StatusDTO statusDTO) {
        this.url = url;
        this.statusDTO = statusDTO;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public StatusDTO getStatusDTO() {
        return statusDTO;
    }

    public void setStatusDTO(StatusDTO statusDTO) {
        this.statusDTO = statusDTO;
    }
}
