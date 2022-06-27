package org.agrotechfields.jwt.service;

import io.smallrye.jwt.build.Jwt;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import javax.inject.Singleton;

@Singleton
public class TechfieldsJwtService {

  public String generateJwt() {
    Set<String> roles = new HashSet<>(Arrays.asList("admin", "drone"));

    return Jwt.issuer("techfields-jwt").subject("techfields-jwt")
        .groups(roles).sign();
  }

}
