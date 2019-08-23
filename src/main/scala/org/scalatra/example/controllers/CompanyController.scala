package org.scalatra.example.controllers

import org.scalatra.example.persistence.Company
import scalikejdbc.async.AsyncDB

import scala.concurrent.Await
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

class CompanyController extends BaseController {

  post("/") {
    Company.create("Name", Some("google.com"))
  }

  get("/") {
    val companies = AsyncDB.localTx { implicit session =>
      Company.findAll()
    }
    Await.result[List[Company]](companies, 5 seconds)
  }

}
