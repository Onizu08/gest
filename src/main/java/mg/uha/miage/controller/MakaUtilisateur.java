package mg.uha.miage.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.transaction.annotation.Transactional;

@Transactional

public class MakaUtilisateur {

	public String getUser(HttpServletRequest httpServletRequest) {
		HttpSession httpSession = httpServletRequest.getSession();
		SecurityContext securityContext = (SecurityContext) httpSession.getAttribute("SPRING_SECURITY_CONTEXT");
		String username = securityContext.getAuthentication().getName();
		return username;
	}

	public String upperCaseFirst(String value) {

		char[] array = value.toCharArray();
		array[0] = Character.toUpperCase(array[0]);
		return new String(array);

	}
	
	

}
