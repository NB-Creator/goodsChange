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
		// Ĭ����֤����ת·��
		String targetUrl = "/mainPage";

		// �����¼ǰ������Ϊ����ҳ�棬����֤����ת����ҳ��
		if (savedRequest != null) {
			targetUrl = savedRequest.getRedirectUrl();
		}

		// ��ת����֤�ɹ����������
		response.sendRedirect("/loginSuccess?url=" + targetUrl);

	}

	@Override
	public void afterPropertiesSet() throws Exception {
	}

}
