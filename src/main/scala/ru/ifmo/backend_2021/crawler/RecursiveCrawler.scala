package ru.ifmo.backend_2021.crawler

import ru.ifmo.backend_2021.crawler.FetchLinks.fetchLinks

import java.util.concurrent.Executors
import scala.concurrent.duration.Duration.Inf
import scala.concurrent.{Await, ExecutionContext, Future}

object RecursiveCrawler extends App {
  implicit val ec = ExecutionContext.fromExecutorService(Executors.newFixedThreadPool(8))
  def fetchAllLinksRec(startTitle: String, depth: Int): Set[String] = {
    def innerFetchAllLinks(current: Set[String], seen: Set[String], recDepth: Int): Set[String] = {
      if (recDepth >= depth) seen
      else {
        val futures = for (title <- current) yield Future {
          fetchLinks(title)
        }
        val nextTitles = futures.flatMap(Await.result(_, Inf))
        innerFetchAllLinks(nextTitles.filter(!seen.contains(_)), seen ++ nextTitles, recDepth + 1)
      }
    }

    innerFetchAllLinks(Set(startTitle), Set(startTitle), 0)
  }
  TimeColored {
    pprint.pprintln(fetchAllLinksRec("Albert Einstein", 2))
  }
  ec.shutdown()
}
