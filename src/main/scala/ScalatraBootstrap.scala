
import org.scalatra.example.controllers._
import javax.servlet.ServletContext
import org.scalatra._
import org.scalatra.swagger.ApiKey

class ScalatraBootstrap extends LifeCycle {

  implicit val swagger = new SwaggerController()
  swagger.addAuthorization(ApiKey("Authorization"))

  override def init(context: ServletContext) {
    context.mount(new ApiController, "/api", "api")
    context.mount (new ResourcesApp, "/api-docs")
  }
}
