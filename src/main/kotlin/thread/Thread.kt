package thread


fun main() {
    for (i in 0..5) {
        val thread = Thread(Runnable {
            println("current-thread-name : ${Thread.currentThread().name}")
        })
        thread.start()
    }
    println("current-thread-name : ${Thread.currentThread().name}")
}

/**
 * 멀티 스레드를 사용하면 스케쥴링 알고리즘에 의해 스레드가 전환되면서 작업을 처리하는데 이를 컨텍스트 스위칭 이라 한다
 * 하나의 프로세스(process)에는 최소한 하나 이상의 스레드가 존재하고 프로세스 내의 스레드들은 동일한 메모리를 공유한다.
 * 스레드는 프로세스를 생성하는 것 보다 가볍다
 *
 * 하지만 스레드가 무한정 많아지면 메모리 사용량이 높아져서 OOME 가 발생할 수 있고 높은 동시 처리량을 요구하는 시스템에서는 스레드를 생성함녀서 발생하는 대기시간 때문에 응답 지연이 발생한다
 * 이런문제를 해결하기 위해선 스레드풀(ThreadPool)을 사용해야 한다. 스레드 풀을 사용하면 애플리케이션 내에서 사용할 총 스레드 수를 제한할 수 있고 기존에 생성된 스레드를 재사용 하므로 빠른 응답이 가능
 * 직접 만드는 것보다 검증된 라이브러리를 사용해야 한다 java.util.concurrent 패키지의 ExcutorServce 를 사용하면 쉽고 안전하게 스레드 풀을 사용할 수 있다.
 */
