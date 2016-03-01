package ii_collections

fun Shop.getCustomersWhoOrderedProduct(product: Product): Set<Customer> {
    return customers.filter { it.orderedProducts.contains(product) }.toSet()
}

fun Customer.getMostExpensiveDeliveredProduct(): Product? {
    return orders.filter { it.isDelivered }.flatMap { it.products }.maxBy { it.price }
}

fun Shop.getNumberOfTimesProductWasOrdered(product: Product): Int {
    return customers.flatMap { it.getOrderedProductsList() }.count { it == product }
}

fun Customer.getOrderedProductsList(): List<Product> {
    return orders.flatMap { it.products }
}
