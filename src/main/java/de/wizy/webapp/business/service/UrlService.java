package de.wizy.webapp.business.service;

import de.wizy.webapp.business.dto.HtmlParserAnalysisDTO;
import de.wizy.webapp.business.dto.HtmlParserStatusDTO;

public interface UrlService {

	HtmlParserAnalysisDTO analyse(String url);

	HtmlParserStatusDTO getStatus(String url);
}
