package ru.ifmo.backend_2021.quill_examples

object Updates extends App {
  val ctx = CreateCtx()

  import ctx._

  pprint.pprintln(ctx.translate(query[City].filter(_.id == 10000).update(City(10000, "testham", "TST", "Test County", 0))))
  pprint.pprintln(ctx.run(
    query[City]
      .filter(_.id == 10000)
      .update(City(10000, "testham", "TST", "Test County", 0))
  )
  )

  pprint.pprintln(ctx.run(query[City].filter(_.id == 10000)))

  pprint.pprintln(ctx.translate(query[City].filter(_.id == 10000).update(_.name -> "testford")))
  pprint.pprintln(ctx.run(
    query[City]
      .filter(_.id == 10000)
      .update(_.name -> "testford")
  )
  )
  pprint.pprintln(ctx.run(query[City].filter(_.id == 10000)))

  pprint.pprintln(ctx.translate(query[City].filter(_.district == "Test County").update(_.district -> "Test Borough")))
  pprint.pprintln(ctx.run(
    query[City]
      .filter(_.district == "Test County")
      .update(_.district -> "Test Borough")
  )
  )
  pprint.pprintln(ctx.run(query[City].filter(_.population == 0)))
}
