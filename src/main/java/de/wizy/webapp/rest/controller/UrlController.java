package de.wizy.webapp.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.wizy.webapp.business.dto.HtmlParserAnalysisDTO;
import de.wizy.webapp.business.dto.HtmlParserStatusDTO;
import de.wizy.webapp.business.service.UrlService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "url")
@RestController
@RequestMapping(value = "/api/v1/urls")
public class UrlController {

	@Autowired
	private UrlService urlService;

	@GetMapping("/analysis")
	@ApiOperation("Send detail information of linked html to the url")
	public HtmlParserAnalysisDTO analyse(@RequestParam("url") String url) {
		return urlService.analyse(url);
	}

	@GetMapping("/statuses")
	@ApiOperation("Validates the url and send status of url")
	public HtmlParserStatusDTO getStatus(@RequestParam("url") String url) {
		return urlService.getStatus(url);
	}

}