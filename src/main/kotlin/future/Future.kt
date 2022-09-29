package future

import java.util.concurrent.Callable
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit


fun sum(a: Int, b: Int) = a+ b

fun main() {
    val pool = Executors.newSingleThreadExecutor()
    val future = pool.submit(Callable {
        sum(100, 200)
    })

    println("계산 시작")
    val futureResult = future.get(1000L, TimeUnit.MILLISECONDS) //비동기 작업의 결과를 기다린다.
    //val futureResult = future.get() //비동기 작업의 결과를 기다린다.
    println(futureResult)
    println("계산 종료")
    
    //퓨처를 사용해서 한개이상의 작업을 조합한다던지 비동기작업에대한 처리를 완료,정지 하지 않아 단점이 있음
}