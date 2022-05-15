package com.css533.curbthecoins.PurchaseService.filter;


import com.css533.curbthecoins.PurchaseService.Constants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.stream.Collectors;

public class AuthFilter extends GenericFilterBean {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {


        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;

        if ("OPTIONS".equals(httpRequest.getMethod())) {
            httpResponse.setStatus(HttpServletResponse.SC_OK);
            httpResponse.setHeader("Access-Control-Allow-Origin", "*");
            System.out.println("Inside OPTIONS.");
            return ;
        }

        Iterator<String> it = httpRequest.getHeaderNames().asIterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("Inside do filter.");
        System.out.println("Request method " + httpRequest.getMethod());

        String headers =
                Collections.list(httpRequest.getHeaderNames()).stream()
                        .map(headerName -> headerName + " : " + Collections.list(httpRequest.getHeaders(headerName)) )
                        .collect(Collectors.joining(", "));
        System.out.println(headers);
        it = httpRequest.getHeaders("access-control-request-headers").asIterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }


        String authHeader = httpRequest.getHeader("Authorization");
        if(authHeader != null){
            System.out.println("Inside do filter. Authheader not null");
            String[] authHeaderArray = authHeader.split("Bearer");
            if( authHeaderArray.length > 1 && authHeaderArray[1] != null){
                String token = authHeaderArray[1];
                try{
                    System.out.println("Inside do filter. Inside try.");
                    Claims claims = Jwts.parser().setSigningKey(Constants.API_SECRET_KEY).parseClaimsJws(token).getBody();
                    httpRequest.setAttribute("UserId" , Integer.parseInt(claims.get("UserId").toString()));
                    httpRequest.setAttribute("Partner" , Integer.parseInt(claims.get("Partner").toString()));
                    System.out.println(" Integer.parseInt(claims.get(\"UserId\").toString())" +  claims.get("UserId").toString());
                }catch( Exception e){
                    httpResponse.sendError(HttpStatus.FORBIDDEN.value(), "invalid/ expired token  *************" + e.getMessage() +"************************************");
                    return;
                }
            }else{
                httpResponse.sendError(HttpStatus.FORBIDDEN.value(), "Authorization token must be Bearer [token]");
                return;
            }
        }else{
            System.out.println("Inside do filter. Authheader IS NULL");
            httpResponse.sendError(HttpStatus.FORBIDDEN.value(), "Authorization token must be provided");
            return;
        }
        System.out.println("returning from do filter");
        filterChain.doFilter(servletRequest,servletResponse);
    }
}

