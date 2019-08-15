package org.scalatra.example

import com.typesafe.config.ConfigFactory

class Settings() {

  private val config = ConfigFactory.load()
  config.checkValid(ConfigFactory.defaultReference()) // validate vs. reference.conf

  // non-lazy fields, we want all exceptions at construct time
  val baseUrl = config.getString("base_url")

  val oktaConfig = OktaConfig(
    config.getString("okta.domain"),
    config.getString("okta.audience"),
    config.getInt("okta.timeout")
  )


}

case class OktaConfig(domain: String, audience: String, timeout: Int)
