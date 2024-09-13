package biz.craftline.server.utils.network


fun <T> Iterator<T>.toList(): List<T> {
    val list = ArrayList<T>()
    if (this.hasNext()) {
        list.add(this.next())
    }
    return list
}

fun <T> Iterator<T>.toSet(): Set<T> {
    val set = HashSet<T>()
    if (this.hasNext()) {
        set.add(this.next())
    }
    return set
}