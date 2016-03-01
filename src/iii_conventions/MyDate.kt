package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(otherDate : MyDate) = when {
        year != otherDate.year -> year - otherDate.year
        month != otherDate.month -> month - otherDate.month
        else -> dayOfMonth - otherDate.dayOfMonth
    }
    operator fun rangeTo(other: MyDate) = DateRange(this, other)
}

operator fun MyDate.rangeTo(other: MyDate): DateRange = todoTask27()

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

class DateRange(val start: MyDate, val end: MyDate): Iterable<MyDate>{
    override fun iterator(): Iterator<MyDate> = DateIterator(this)
    operator fun contains(d: MyDate) : Boolean = d >= start && d <= end
}

class DateIterator(val dateRange:DateRange) : Iterator<MyDate> {
    var current: MyDate = dateRange.start
    override fun next(): MyDate {
        val result = current
        current = current.nextDay()
        return result
    }
    override fun hasNext(): Boolean = current <= dateRange.end
}