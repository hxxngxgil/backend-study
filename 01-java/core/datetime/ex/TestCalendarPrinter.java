package time.ex;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

public class TestCalendarPrinter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("년도를 입력하세요: ");
        int year = scanner.nextInt();

        System.out.print("월을 입력하세요: ");
        int month = scanner.nextInt();

        LocalDate firstDay = LocalDate.ofYearDay(year, month);
        LocalDate dayNextMonth = firstDay.plusMonths(1);

        //월요일=1(1%7=1) ... 일요일7(7%7=0)
        int offsetWeekDays = firstDay.getDayOfWeek().getValue() % 7;

        System.out.println("Su Mo Tu We Th Fr Sa");
        for (int i = 0; i < offsetWeekDays; i++) {
            System.out.print("   ");
        }

        LocalDate dayIterator = firstDay;
        while (dayIterator.isBefore(dayNextMonth)) {
            System.out.printf("%2d ", dayIterator.getDayOfMonth());
            if (dayIterator.getDayOfWeek() == DayOfWeek.SATURDAY) {
                System.out.println();
            }
            dayIterator = dayIterator.plusDays(1);
        }
    }
}
