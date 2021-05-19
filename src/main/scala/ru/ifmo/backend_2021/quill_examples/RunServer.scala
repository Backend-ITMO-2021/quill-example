package ru.ifmo.backend_2021.quill_examples

import com.opentable.db.postgres.embedded.EmbeddedPostgres
import scala.io.StdIn.readLine

object RunServer extends App {
  val server = EmbeddedPostgres.builder().setPort(5432).start()
  readLine()
}
