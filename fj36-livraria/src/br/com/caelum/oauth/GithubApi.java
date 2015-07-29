package br.com.caelum.oauth;

import org.scribe.builder.api.DefaultApi20;
import org.scribe.model.OAuthConfig;

public class GithubApi extends DefaultApi20 {

	@Override
	public String getAccessTokenEndpoint() {
		return "https://github.com/login/oauth/access_token";
	}

	@Override
	public String getAuthorizationUrl(OAuthConfig config) {
		return String.format("https://github.com/login/oauth/authorize?"
				+ "scope=user:email&client_id=%s", config.getApiKey());
	}

}
