package ru.ifmo.backend_2021.crawler

import ru.ifmo.backend_2021.crawler.FetchLinks.fetchLinks

import java.util.concurrent.Executors
import scala.concurrent.duration.Duration.Inf
import scala.concurrent.{Await, ExecutionContext, Future}

object ParallelCrawler extends App {
  implicit val ec = ExecutionContext.fromExecutorService(Executors.newFixedThreadPool(8))
  def fetchAllLinksParallel(startTitle: String, depth: Int): Set[String] = {
    var seen = Set(startTitle)
    var current = Set(startTitle)
    for (i <- Range(0, depth)) {
      val futures = for (title <- current) yield Future {
        fetchLinks(title)
      }
      val nextTitleLists = futures.map(Await.result(_, Inf))
      current = nextTitleLists.flatten.filter(!seen.contains(_))
      seen = seen ++ current
    }
    seen
  }
  TimeColored {
    pprint.pprintln(fetchAllLinksParallel("Albert Einstein", 4))
  }
  ec.shutdown()
}
