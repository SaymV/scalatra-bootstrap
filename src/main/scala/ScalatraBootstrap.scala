import javax.servlet.ServletContext
import org.scalatra._
import org.scalatra.example.controllers._
import org.scalatra.example.persistence.PostgresConnection
import org.scalatra.swagger.ApiKey

class ScalatraBootstrap extends LifeCycle with PostgresConnection {

  implicit val swagger: SwaggerController = new SwaggerController()
  swagger.addAuthorization(ApiKey("Authorization"))

  override def init(context: ServletContext) {
    openDatabaseConnection()
    context.mount(new ApiController, "/api", "api")
    context.mount(new CompanyController, "/api/company")
    context.mount (new ResourcesApp, "/api-docs")
  }

  override def destroy(context: ServletContext): Unit = {
    closeDatabaseConnection()
  }
}
