package ecommercecode;

import java.util.Arrays;

public class SearchFunction {
    
    public static int linearSearch(Product[] items, String target) {
        for (int i = 0; i < items.length; i++) {
            if (items[i].name.equalsIgnoreCase(target)) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(Product[] items, String target) {
        int low = 0;
        int high = items.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = items[mid].name.compareToIgnoreCase(target);

            if (cmp == 0) return mid;
            if (cmp < 0) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Product[] items = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Mobile", "Electronics"),
            new Product(103, "Shoes", "Footwear"),
            new Product(104, "Watch", "Accessories"),
            new Product(105, "Shirt", "Clothing")
        };

        int index1 = linearSearch(items, "Mobile");
        if (index1 != -1) {
            System.out.println("Found using Linear Search: " + items[index1].name);
        } else {
            System.out.println("Not found using Linear Search");
        }

        Arrays.sort(items, (a, b) -> a.name.compareToIgnoreCase(b.name));
        int index2 = binarySearch(items, "Mobile");
        if (index2 != -1) {
            System.out.println("Found using Binary Search: " + items[index2].name);
        } else {
            System.out.println("Not found using Binary Search");
        }
    }
}

