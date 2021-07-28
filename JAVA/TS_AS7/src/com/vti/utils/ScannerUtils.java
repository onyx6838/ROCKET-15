package com.vti.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Scanner;

public class ScannerUtils {
    private static Scanner scanner = new Scanner(System.in);

    public static <T> Object inputPreventPositive(String errorMessage, Class<T> c) {
        while (true) {
            try {
                String input = scanner.nextLine().trim();
                if (c == Integer.class)
                    if (Integer.parseInt(input) < 0) System.out.println(errorMessage);
                    else return Integer.parseInt(input);
                if (c == String.class)
                    if (!input.isEmpty()) System.out.println(errorMessage);
                    else return input;
                if (c == Double.class)
                    if (Double.parseDouble(input) < 0) System.out.println(errorMessage);
                    else return Double.parseDouble(input);
                if (c == Float.class)
                    if (Float.parseFloat(input) < 0) System.out.println(errorMessage);
                    else return Float.parseFloat(input);
            } catch (Exception e) {
                System.out.println(errorMessage);
                //throw new Exception(e);
            }
        }
    }

    public static <T> Object input(String errorMessage, Class<T> c) {
        while (true) {
            try {
                String input = scanner.nextLine().trim();
                if (c == Integer.class) return Integer.parseInt(input);
                if (c == String.class) {
                    if (!input.isEmpty()) System.out.println(errorMessage);
                    else return input;
                }
                if (c == Double.class) return Double.parseDouble(input);
                if (c == Float.class) return Float.parseFloat(input);
            } catch (Exception e) {
                System.out.println(errorMessage);
                //throw new Exception(e);
            }
        }
    }

    public static int inputInt(String errorMessage) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (Exception e) {
                System.out.println(errorMessage);
            }
        }
    }

//    public static int inputInt(String errorMessage) {
//        while (true) {
//            try {
//                if (Integer.parseInt(scanner.nextLine().trim()) < 0)
//                    System.out.println(errorMessage);
//                else return Integer.parseInt(scanner.nextLine().trim());
//            } catch (Exception e) {
//                System.out.println(errorMessage);
//            }
//        }
//    }

    public static float inputFloat(String errorMessage) {
        while (true) {
            try {
                if (Float.parseFloat(scanner.nextLine().trim()) < 0)
                    System.out.println(errorMessage);
                else return Float.parseFloat(scanner.nextLine().trim());
            } catch (Exception e) {
                System.out.println(errorMessage);
            }
        }
    }

    public static double inputDouble(String errorMessage) {
        while (true) {
            try {
                if (Double.parseDouble(scanner.nextLine().trim()) < 0)
                    System.out.println(errorMessage);
                else return Double.parseDouble(scanner.nextLine().trim());
            } catch (Exception e) {
                System.out.println(errorMessage);
            }
        }
    }

    public static String inputString(String errorMessage) {
        while (true) {
            String string = scanner.nextLine().trim();
            if (!string.isEmpty()) {
                return string;
            } else {
                System.err.println(errorMessage);
            }
        }
    }

    public static LocalDate inputLocalDate(String errorMessage) {
        System.out.println("Nhập theo định dạng yyyy-MM-dd");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        while (true) {
            String localDate = scanner.nextLine().trim();
            try {
                if (format.parse(localDate) != null) return LocalDate.parse(localDate);
            } catch (Exception e) {
                System.err.println(errorMessage);
            }
        }
    }
}
