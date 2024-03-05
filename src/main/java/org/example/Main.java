package org.example;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order("Laptop", 1200.0),
                new Order("Smartphone", 800.0),
                new Order("Laptop", 1500.0),
                new Order("Tablet", 500.0),
                new Order("Smartphone", 900.0)
        );

        //Создайте список заказов с разными продуктами и их стоимостями.
        //List<Order> uniqueOrders = orders.stream().distinct().toList();
        //uniqueOrders.forEach(System.out::println);

        //Группируйте заказы по продуктам
        //Map<String, Set<Double>> mapOfOrderAndSetPrice = orders.stream()
        //        .collect(Collectors.groupingBy(Order::getProduct,
        //                Collectors.mapping(Order::getCost, Collectors.toSet())));
        //System.out.println(Collections.unmodifiableMap(mapOfOrderAndSetPrice));

        //Для каждого продукта найдите общую стоимость всех заказов.
        //Map<String, Double> mapOrderAndPriceAverage = orders.stream()
        //        .collect(Collectors.groupingBy(Order::getProduct,
        //                Collectors.averagingDouble(Order::getCost)));
        //System.out.println(Collections.unmodifiableMap(mapOrderAndPriceAverage));


        //Отсортируйте продукты по убыванию общей стоимости.
        //List<Order> sortedByPriceOrderList = orders.stream()
        //        .sorted(new OrderComparator()).toList();
        //System.out.println(sortedByPriceOrderList);

        //Выберите три самых дорогих продукта.
        //List<Order> threeMostExpensiveOrder  = orders.stream()
        //        .sorted(new OrderComparator()).limit(3).toList();
        //System.out.println(threeMostExpensiveOrder);

        //Выведите результат: список трех самых дорогих продуктов и их общая стоимость.
        //Map<List<Order>, Double> map = getThreeMostExpensiveOrderAndSum(orders);
        //System.out.println(map);
    }

    public static Map<List<Order>, Double> getThreeMostExpensiveOrderAndSum(List<Order> orders) {
        List<Order> threeMostExpensiveOrder = orders.stream()
                .sorted(new OrderComparator()).limit(3).toList();
        return Map.of(threeMostExpensiveOrder,
                threeMostExpensiveOrder.stream()
                        .mapToDouble(Order::getCost).sum());
    }
}