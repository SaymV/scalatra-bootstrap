# Scalatra API With Okta Authentication #
This is a starter application for anyone who wants to write an API layer using [Scalatra](http://scalatra.org/). Why start here?
If you're serious about API development, you'll have configs to load, JSON will be necessary, and security will be paramount.
Instead of using the [Scalatra project generator](http://scalatra.org/getting-started/first-project.html),
clone this repository for a head start.
This app demonstrates how to return JSON, verify the origin and authorization Token.

## Application Features
Instead of the vanilla scalatra project generator, use this project to gain the following functionality out of the box:
* Logging
* Typesafe Config
* Jackson JSON
* [Swagger Support](http://scalatra.org//guides/2.6/swagger.html)
* [Okta Authentication](https://developer.okta.com/quickstart/#/angular/java/generic)

## Configuration
In the `src/main/resources` folder, there is a `resource.conf` file that looks like this:
```hocon
base_url = "localhost"

okta {
    domain: "yourOktaDomain"
    audience: "api://default"
    timeout: 1000
}
```
 Copy the contents of that file, name it `application.conf`, and replace your Okta domain.

## Build & Run ##

```shell script
$ cd back-end
$ sbt
> jetty:start
> browse
```
If `browse` doesn't launch your browser, manually open [http://localhost:8080/](http://localhost:8080/) in your browser.

If actively developing, use to have sbt watch for changes.
```sbt
~;jetty:stop;jetty:start
```

### Additional Notes
Okta has great tutorials around Spring and generic java. I thought it might be useful to have a scala based example.


### Contributing
Feel free to make a pull request if you add basic functionality that would help a fledgling API
on its way to being production ready.

:)

