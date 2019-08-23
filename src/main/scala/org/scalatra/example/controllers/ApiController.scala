package org.scalatra.example.controllers

import org.scalatra.example.authentication.AuthenticationSupport
import org.scalatra.swagger.{Swagger, SwaggerSupport}

class ApiController(implicit val swagger: Swagger) extends BaseController
  with AuthenticationSupport
  with SwaggerSupport {

  val getTheTruth =
    (apiOperation[Boolean]("getTheTruth")
      summary "Show the Truth"
      parameter queryParam[Option[String]]("name").description("A name to search for")
      )

  get("/", operation(getTheTruth)) {
    if (request.getParameter("name") != null && request.getParameter("name") == "Kaffee") {
      false // Lt. Daniel Kaffee can't handle the truth
    } else {
      true // Other people can handle the truth
    }
  }

  override protected def applicationDescription: String = "The Truth Deliverer"

}
