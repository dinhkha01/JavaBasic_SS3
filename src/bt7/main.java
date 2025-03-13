package bt7;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("CHƯƠNG TRÌNH KIỂM TRA VÀ PHÂN LOẠI TAM GIÁC");
        System.out.println("============================================");

        // Nhập độ dài 3 cạnh tam giác
        System.out.print("Nhập độ dài cạnh 1: ");
        double side1 = 0;
        do {
            while (!scanner.hasNextDouble()) {
                System.out.println("Lỗi: Vui lòng nhập một số dương!");
                scanner.next(); // Loại bỏ đầu vào không hợp lệ
            }
            side1 = scanner.nextDouble();
            if (side1 <= 0) {
                System.out.println("Lỗi: Vui lòng nhập một số dương!");
            }
        } while (side1 <= 0);

        System.out.print("Nhập độ dài cạnh 2: ");
        double side2 = 0;
        do {
            while (!scanner.hasNextDouble()) {
                System.out.println("Lỗi: Vui lòng nhập một số dương!");
                scanner.next(); // Loại bỏ đầu vào không hợp lệ
            }
            side2 = scanner.nextDouble();
            if (side2 <= 0) {
                System.out.println("Lỗi: Vui lòng nhập một số dương!");
            }
        } while (side2 <= 0);

        System.out.print("Nhập độ dài cạnh 3: ");
        double side3 = 0;
        do {
            while (!scanner.hasNextDouble()) {
                System.out.println("Lỗi: Vui lòng nhập một số dương!");
                scanner.next(); // Loại bỏ đầu vào không hợp lệ
            }
            side3 = scanner.nextDouble();
            if (side3 <= 0) {
                System.out.println("Lỗi: Vui lòng nhập một số dương!");
            }
        } while (side3 <= 0);

        // Kiểm tra có phải là tam giác hợp lệ
        boolean isValidTriangle = (side1 + side2 > side3) && (side1 + side3 > side2) && (side2 + side3 > side1);

        if (isValidTriangle) {
            System.out.println("Ba cạnh " + side1 + ", " + side2 + ", " + side3 + " tạo thành một tam giác hợp lệ.");

            // Phân loại tam giác
            // Kiểm tra tam giác đều
            if (side1 == side2 && side2 == side3) {
                System.out.println("Đây là tam giác đều.");
            }
            // Kiểm tra tam giác cân
            else if (side1 == side2 || side2 == side3 || side1 == side3) {
                System.out.println("Đây là tam giác cân.");
            }

            // Kiểm tra tam giác vuông (sử dụng định lý Pythagoras)
            // So sánh với sai số nhỏ để xử lý lỗi làm tròn khi tính toán số thực
            double epsilon = 1e-10;
            boolean isRightTriangle = false;

            if (Math.abs(side1*side1 + side2*side2 - side3*side3) < epsilon ||
                    Math.abs(side1*side1 + side3*side3 - side2*side2) < epsilon ||
                    Math.abs(side2*side2 + side3*side3 - side1*side1) < epsilon) {
                System.out.println("Đây là tam giác vuông.");
                isRightTriangle = true;
            }

            // Tam giác thường (không phải tam giác đều, cân, vuông)
            if (side1 != side2 && side2 != side3 && side1 != side3 && !isRightTriangle) {
                System.out.println("Đây là tam giác thường.");
            }
        } else {
            System.out.println("Ba cạnh " + side1 + ", " + side2 + ", " + side3 + " không tạo thành tam giác.");
        }

        scanner.close();

    }
}
