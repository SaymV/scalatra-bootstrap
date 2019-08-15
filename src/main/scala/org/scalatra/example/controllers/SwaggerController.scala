package org.scalatra.example.controllers

import org.scalatra.ScalatraServlet
import org.scalatra.swagger._


class ResourcesApp(implicit val swagger: Swagger) extends ScalatraServlet with JacksonSwaggerBase

object SwaggerApiInfo extends ApiInfo(
  "The API",
  "Docs for the API",
  "http://scalatra.org",
  ContactInfo("", "", ""),
  LicenseInfo(
    name = "MIT",
    url = "http://opensource.org/licenses/MIT"))


class SwaggerController extends Swagger(Swagger.SpecVersion, "1.0.0", SwaggerApiInfo, "")  {}