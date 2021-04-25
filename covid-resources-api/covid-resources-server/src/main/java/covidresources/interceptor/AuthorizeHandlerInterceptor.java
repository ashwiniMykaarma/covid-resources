package covidresources.interceptor;

import java.lang.annotation.Annotation;
import java.util.Calendar;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import covidresources.services.ApiAuthenticationAndAuthorizationService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service ("authorizeHandlerInterceptor")
public class AuthorizeHandlerInterceptor implements HandlerInterceptor {
	
	public static final String XREQUESTID = "x-request-id";
	@Autowired
	private ApiAuthenticationAndAuthorizationService apiAuthenticationAndAuthorizationService;
	
	@Override
	public boolean preHandle(HttpServletRequest request,
    						HttpServletResponse response,
    						Object handler) throws Exception {
		
		log.info("pre handle");
//		if(request.getAttribute(XREQUESTID) ==null) {
//			request.setAttribute(XREQUESTID,UUID.randomUUID().toString()) ;
//		}
//		String appRequestId = (String)request.getAttribute(XREQUESTID) ;
//		response.setHeader(XREQUESTID, appRequestId);
//		request.setAttribute("start-time",Calendar.getInstance().getTimeInMillis());		
//
//		if (handler instanceof HandlerMethod) {
//			HandlerMethod handlerMethod = (HandlerMethod) handler;
//			Annotation[] annotations = handlerMethod.getMethod().getAnnotations();
//			return apiAuthenticationAndAuthorizationService.checkForAuthenticationAndAuthorization(request, annotations);
//		}
		
		return true;
	}
	

	@Override
	public void postHandle(
			HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView){
		request.setAttribute(XREQUESTID,UUID.randomUUID().toString()) ;
		String appRequestId = (String)request.getAttribute(XREQUESTID) ;
		Long startTime = (Long)request.getAttribute("start-time");
		if(startTime == null ){
			startTime = Calendar.getInstance().getTimeInMillis() ;
		}
		response.setHeader(XREQUESTID, appRequestId);
		log.info(" time_taken: " +  (Calendar.getInstance().getTimeInMillis() - startTime)
		 + " for sending response response_status: " +  response.getStatus()
		 + " x-app-request-id:" + appRequestId);
	}
 
}


