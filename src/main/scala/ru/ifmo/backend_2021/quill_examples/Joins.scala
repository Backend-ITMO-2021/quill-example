package ru.ifmo.backend_2021.quill_examples

object Joins extends App {
  val ctx = CreateCtx()

  import ctx._

  pprint.pprintln(ctx.translate(query[City].join(query[Country]).on(_.countryCode == _.code).filter { case (city, country) => country.continent == "Asia" }.map { case (city, country) => city.name }))
  pprint.pprintln(ctx.run(
    query[City]
      .join(query[Country])
      .on(_.countryCode == _.code)
      .filter { case (city, country) => country.continent == "Asia" }
      .map { case (city, country) => city.name }
  )
  )
}
