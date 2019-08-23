package org.scalatra.example.authentication

import java.time.Duration

import com.okta.jwt.{JwtVerificationException, JwtVerifiers}
import com.typesafe.scalalogging.LazyLogging
import org.scalatra.ScalatraBase
import org.scalatra.example.Settings

trait AuthenticationSupport extends ScalatraBase with LazyLogging {

  val conf: Settings = new Settings()
  val oktaConfig = conf.oktaConfig


  val apiHeader = "Authorization";
  val jwtVerifier = JwtVerifiers.accessTokenVerifierBuilder()
    .setIssuer(s"https://${oktaConfig.domain}/oauth2/default")
    .setAudience(oktaConfig.audience)                            // defaults to 'api://default'
    .setConnectionTimeout(Duration.ofMillis(oktaConfig.timeout)) // defaults to 1000ms
    .setReadTimeout(Duration.ofMillis(oktaConfig.timeout))       // defaults to 1000ms
    .build

  def unauthorizedResponse(message: String = "401 Unauthorized.") =
    halt(status=401, body = <h1>{message}</h1>)

  /**
   * A simple interceptor that checks for the existence
   * of the correct headers
   */
  before() {
    // we check the host where the request is made
    val serverName = request.serverName
    val header = Option(request.getHeader(apiHeader))

    header match {
      case Some(x) => isValidRequest(serverName, x)
      case _ => unauthorizedResponse()
    }
  }

  /**
   * Check whether the host is valid. This is done by decoding the auth Token, and comparing the hostname to the
   * one that is configured.
   */
  private def isValidRequest(hostName: String, authHeader: String) = {
    try {
      if (hostName != conf.baseUrl) {
        unauthorizedResponse("Unauthorized Origin.")
      }

      val authToken = authHeader.replaceFirst("^Bearer ", "")
      val jwt = jwtVerifier.decode(authToken)

      // Perform extra validation on auth token contents (for example, expiration date > now ?)
      // jwt.getExpiresAt...

    } catch {
      case e: JwtVerificationException => {
        logger.info(e.getMessage)
        unauthorizedResponse(e.getMessage)
      }
    }
  }

}
