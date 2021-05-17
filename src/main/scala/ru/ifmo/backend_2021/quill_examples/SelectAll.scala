package ru.ifmo.backend_2021.quill_examples

object SelectAll extends App {
  val ctx = CreateCtx()

  import ctx._

  println(translate(query[City]))
  val cities = ctx.run(query[City])
  pprint.log(cities.take(5))


  println(translate(query[Country]))
  val countries = ctx.run(query[Country])
  pprint.log(countries.take(5))


  println(translate(query[CountryLanguage]))
  val languages = ctx.run(query[CountryLanguage])
  pprint.log(languages.take(5))


}
