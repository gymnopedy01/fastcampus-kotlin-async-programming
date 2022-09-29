package completablefuture

import future.sum
import java.util.concurrent.CompletableFuture

fun main() {
    val completableFuture = CompletableFuture.supplyAsync {
        Thread.sleep(2000)
        sum(100, 2000)
    }
    println("게산시작")
    completableFuture.thenApplyAsync(::println)

//    val result =  completableFuture.get()//블로킹으로 동작
//    println(result)

    while (!completableFuture.isDone) {
        Thread.sleep(500)
        println("계산 결과를 집계 중입니다.")
    }
    println("계산 종료")

}