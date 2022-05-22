package nl.inholland.shop.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtTokenFilter extends OncePerRequestFilter {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

        String token = jwtTokenProvider.resolveToken(httpServletRequest);           // retrieve the token from the request

        try {
            if (token != null && jwtTokenProvider.validateToken(token)) {           // check if the token is valid
                Authentication auth = jwtTokenProvider.getAuthentication(token);    // retrieve the user from database
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        } catch (ResponseStatusException exc) {
            SecurityContextHolder.clearContext();
            httpServletResponse.sendError(exc.getRawStatusCode(), exc.getMessage());
            return;
        }

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
