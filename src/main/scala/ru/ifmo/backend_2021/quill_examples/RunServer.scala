package ru.ifmo.backend_2021.quill_examples

import com.opentable.db.postgres.embedded.EmbeddedPostgres

object RunServer extends App {
  val server = EmbeddedPostgres.builder().setPort(5432).start()
  while (true) {
    Thread.sleep(10000)
  }
}
