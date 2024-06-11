package com.example.Blog_API.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

  @Autowired
  private AuthenticationManager authenticationManager;

  // @Autowired
  // private UserDetailsService userDetailsService;

  @PostMapping("/login")
  public String authenticateUser(@RequestBody LoginRequest loginRequest) {
    try {
      Authentication authentication = authenticationManager.authenticate(
          new UsernamePasswordAuthenticationToken(
              loginRequest.getUsername(),
              loginRequest.getPassword()));
      UserDetails userDetails = (UserDetails) authentication.getPrincipal();
      return JwtUtil.generateToken(userDetails.getUsername());
    } catch (AuthenticationException e) {
      throw new RuntimeException("Invalid credentials");
    }
  }
}
