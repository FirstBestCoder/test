package com.liuzm.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SalaryTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入员工人数");
        int m = scanner.nextInt();
        System.out.println("请输入提问次数");
        int n =  scanner.nextInt();
        Map<Integer,   Integer>map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            System.out.println("请输入每个员工工资");
            int salary = scanner.nextInt();
            map.put(salary,map.getOrDefault(salary,0)+1);
        }
        for (int i = 0; i < n; i++) {
            System.out.println("请输入你要查询人数的工资");
            int query = scanner.nextInt();
            int result = map.containsKey(query)? map.get(query):0;
            System.out.println("查询的结果为："+result);

        }
    }
}
