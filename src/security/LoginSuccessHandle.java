package security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;

public class LoginSuccessHandle implements AuthenticationSuccessHandler, InitializingBean {
	private RequestCache requestCache = new HttpSessionRequestCache();

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authen)
			throws IOException, ServletException {
		SavedRequest savedRequest = requestCache.getRequest(request, response);
		// 默认认证后跳转路径
		String targetUrl = "/mainPage";

		// 如果登录前有请求为拦截页面，则验证后跳转到该页面
		if (savedRequest != null) {
			targetUrl = savedRequest.getRedirectUrl();
		}

		// 跳转到认证成功处理控制器
		response.sendRedirect("/loginSuccess?url=" + targetUrl);

	}

	@Override
	public void afterPropertiesSet() throws Exception {
	}

}
