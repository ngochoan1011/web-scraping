package de.wizy.webapp.business.service.impl;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import de.wizy.webapp.business.dto.HtmlParserAnalysisDTO;
import de.wizy.webapp.business.dto.StatusDTO;
import de.wizy.webapp.business.enums.ErrorCodes;
import de.wizy.webapp.business.service.UrlService;
import de.wizy.webapp.rest.exception.BadRequestException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UrlServiceTest {

	@Autowired
	private UrlService urlService;

	private final String unreachableUrl = "http://www.qwertytesturl.com";
	private final String analysisUrl = "https://www.w3schools.com/";
	private final String urlWithLoginForm = "https://www.facebook.com/";
	private final String urlNoLoginForm = "https://vnexpress.net/";
	private final String blankUrl = "";

	@Test
	public void checkDependencyInjection() {
		assertThat(urlService, instanceOf(UrlService.class));
	}

	@Test
	public void shouldThrowExceptionWhenInputUrlIsInvalidWhileAnalyse() {
		try {
			urlService.analyse(blankUrl);
			fail();
		} catch (BadRequestException e) {
			StatusDTO inputURLInvalid = new StatusDTO(ErrorCodes.INPUT_URL_INVALID);
			assertEquals(e.getStatusDTO().getCode(), inputURLInvalid.getCode());
		}
	}

	@Test
	public void shouldThrowExceptionWhenInputUrlIsInvalidWhileGetStatus() {
		try {
			urlService.getStatus(blankUrl);
			fail();
		} catch (BadRequestException e) {
			StatusDTO inputURLInvalid = new StatusDTO(ErrorCodes.INPUT_URL_INVALID);
			assertEquals(e.getStatusDTO().getCode(), inputURLInvalid.getCode());
		}
	}

	@Test
	public void shouldThrowExceptionWhenInputUrlIsUnreachableWhileAnalyse() {
		try {
			urlService.analyse(unreachableUrl);
			fail();
		} catch (BadRequestException e) {
			StatusDTO jsoupParsingError = new StatusDTO(ErrorCodes.JSOUP_PARSING_ERROR);
			assertEquals(e.getStatusDTO().getCode(), jsoupParsingError.getCode());
		}
	}

	@Test
	public void shouldThrowExceptionWhenInputUrlIsUnreachableWhileGetStatus() {
		try {
			urlService.getStatus(unreachableUrl);
			fail();
		} catch (BadRequestException e) {
			StatusDTO jsoupParsingError = new StatusDTO(ErrorCodes.JSOUP_PARSING_ERROR);
			assertEquals(e.getStatusDTO().getCode(), jsoupParsingError.getCode());
		}
	}

	@Test
	public void shouldCheckDocumentTitleAndHTMLVersion() {
		try {
			HtmlParserAnalysisDTO analysisResult = urlService.analyse(analysisUrl);
			assertEquals(analysisResult.getPageTitle(), "W3Schools Online Web Tutorials");
			assertEquals(analysisResult.getHtmlVersion(), "HTML 5");
		} catch (BadRequestException e) {
			throw e;
		}
	}

	@Test
	public void showReturnIsLoginFormIsTrueWithTheURLContainLoginForm() {
		try {
			HtmlParserAnalysisDTO analysisResult = urlService.analyse(urlWithLoginForm);
			assertEquals(analysisResult.getLoginForm(), true);
		} catch (BadRequestException e) {
			throw e;
		}
	}

	@Test
	public void showReturnIsLoginFormIsFalseWithTheURLNotContainLoginForm() {
		try {
			HtmlParserAnalysisDTO analysisResult = urlService.analyse(urlNoLoginForm);
			assertEquals(analysisResult.getLoginForm(), false);
		} catch (BadRequestException e) {
			throw e;
		}
	}
}
