package br.com.caelum.livraria.controller;

import javax.annotation.PostConstruct;

import org.scribe.builder.ServiceBuilder;
import org.scribe.extractors.AccessTokenExtractor;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.caelum.oauth.GithubApi;

@Controller
@RequestMapping("/oauth")
public class OAuthController {

	private OAuthService service;
	
	@PostConstruct
	public void prepareOAuthService() {
		this.service = new ServiceBuilder()
			.provider(GithubApi.class)
			.apiKey("cb1e2e4a590857e713a9")
			.apiSecret("5f94fbe95d9b73bf6887464fc1d503b0c1aa02c5")
			.callback("http://localhost:8088/fj36-livraria/oauth/callback")
			.build();
	}

	@RequestMapping("/github-login")
	public String redirectToGithub() {
		final Token EMPTY_TOKEN = null;
		return "redirect:" + service.getAuthorizationUrl(EMPTY_TOKEN);
	}

	@RequestMapping("/callback")
	public String callback(@RequestParam("code") String authToken, Model model) {
		Verifier verifier = new Verifier(authToken);
		Token accessToken = service.getAccessToken(null, verifier);

		model.addAttribute("accessToken", accessToken.getToken());
		model.addAttribute("authToken", authToken);
		
		return "github-logado";
	}

	@RequestMapping("/github-emails")
	public String githubRequest(@RequestParam("accessToken") String token, RedirectAttributes redirectAttributes) {
		OAuthRequest request = new OAuthRequest(Verb.GET, "https://api.github.com/user/emails");
		request.addBodyParameter("access_token", token.trim());

		service.signRequest(new Token(token, ""), request);
		Response response = request.send();
		
		redirectAttributes.addFlashAttribute("responseBody", response.getBody());
		
		return "redirect:github-logado";
	}

	@RequestMapping("/github-logado")
	public String logado() {
		return "github-logado";
		
	}
}
