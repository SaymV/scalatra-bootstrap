package org.scalatra.example.persistence

import org.scalatra.example.Settings
import scalikejdbc.ConnectionPool
import scalikejdbc.async.{AsyncConnectionPool, AsyncConnectionPoolSettings, AsyncConnectionSettings}

trait PostgresConnection {

  def openDatabaseConnection() = {

    val conf = new Settings().dbConfig
    // set up connection pool (that's all you need to do)
    AsyncConnectionPool.singleton(
      s"jdbc:${conf.url}:${conf.port}/${conf.database}",
      conf.user,
      conf.password,
      AsyncConnectionPoolSettings(
        maxPoolSize = 8,
        maxQueueSize = 1000,
        maxIdleMillis = 1000L)
    )
  }

  def closeDatabaseConnection() = {
    AsyncConnectionPool.closeAll()
  }
}
