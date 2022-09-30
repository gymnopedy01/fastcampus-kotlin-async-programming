package observerpattern

fun main() {
    EventPrinter().start()
    EventPrinter2().start() //익명객체
}

interface EventListener {
    fun onEvent(count: Int)
}

class Counter(val listener: EventListener) {

    fun count() {
        for (i in 1..100) {
            if (i % 5 == 0) listener.onEvent(i)
        }
    }
}

class EventPrinter : EventListener {
    override fun onEvent(count: Int) {
        print("${count}-")
    }

    fun start() {
        val counter = Counter(this)
        counter.count()
    }
}

class EventPrinter2 {
    fun start() {
        val counter = Counter(object : EventListener {
            override fun onEvent(count: Int) {
                print("${count}--")
            }
        })
        counter.count()
    }

}

