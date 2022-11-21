package com.css533.curbthecoins.PurchaseService.filter;


import com.css533.curbthecoins.PurchaseService.Constants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.http.HttpStatus;
import org.springframework.web.filter.GenericFilterBean;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.stream.Collectors;

public class AuthFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Inside doFilter method. Checking if token is valid");
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;

        if ("OPTIONS".equals(httpRequest.getMethod())) {
            System.out.println("Inside doFilter method. Allowing pre flight request");
            httpResponse.setStatus(HttpServletResponse.SC_OK);
            httpResponse.setHeader("Access-Control-Allow-Origin", "*");
            return ;
        }

        String headers =
                Collections.list(httpRequest.getHeaderNames()).stream()
                        .map(headerName -> headerName + " : " + Collections.list(httpRequest.getHeaders(headerName)) )
                        .collect(Collectors.joining(", "));

        String authHeader = httpRequest.getHeader("Authorization");
        if(authHeader != null){
            String[] authHeaderArray = authHeader.split("Bearer");
            if( authHeaderArray.length > 1 && authHeaderArray[1] != null){
                String token = authHeaderArray[1];
                try{
                    Claims claims = Jwts.parser().setSigningKey(Constants.API_SECRET_KEY).parseClaimsJws(token).getBody();
                    httpRequest.setAttribute("UserId" , Integer.parseInt(claims.get("UserId").toString()));
                    httpRequest.setAttribute("Partner" , Integer.parseInt(claims.get("Partner").toString()));
                }catch( Exception e){
                    httpResponse.sendError(HttpStatus.FORBIDDEN.value(), "invalid/ expired token");
                    return;
                }
            }else{
                httpResponse.sendError(HttpStatus.FORBIDDEN.value(), "Authorization token must be Bearer [token]");
                return;
            }
        }else{
            httpResponse.sendError(HttpStatus.FORBIDDEN.value(), "Authorization token must be provided");
            return;
        }

        System.out.println("Token is valid, returning from doFilter method");
        filterChain.doFilter(servletRequest,servletResponse);
    }
}

