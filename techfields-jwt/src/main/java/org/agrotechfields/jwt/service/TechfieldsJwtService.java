package org.agrotechfields.jwt.service;

import io.smallrye.jwt.build.Jwt;
import javax.inject.Singleton;

@Singleton
public class TechfieldsJwtService {

  public String generateJwt() {

    return Jwt.issuer("techfields-jwt")
        .subject("island-report")
        .groups("admin")
        .expiresAt(System.currentTimeMillis() + 6600)
        .sign();
  }

}
