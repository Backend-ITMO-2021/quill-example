package ru.ifmo.backend_2021.quill_examples

import scala.util.Try

object Transactions extends App {
  val ctx = CreateCtx()

  import ctx._

  pprint.pprintln(ctx.translate(query[City].filter(_.district == "Test Borough").update(_.district -> "Test County")))
  Try {
    pprint.pprintln(ctx.transaction {
      ctx.run(
        query[City].filter(_.district == "Test Borough").update(_.district -> "Test County")
      )
      pprint.pprintln(ctx.run(query[City].filter(_.population == 0)))
      throw new Exception()
    }
    )
  }.failed.foreach(println(_))

  pprint.pprintln(ctx.run(query[City].filter(_.population == 0)))
}
