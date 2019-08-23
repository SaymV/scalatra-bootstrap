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

  val dbConfig = PostgresConfig(
    config.getString("postgres.url"),
    config.getString("postgres.port"),
    config.getString("postgres.database"),
    config.getString("postgres.user"),
    config.getString("postgres.password"),
  )


}

case class OktaConfig(domain: String, audience: String, timeout: Int)
case class PostgresConfig(url: String, port: String, database: String, user: String, password: String)
