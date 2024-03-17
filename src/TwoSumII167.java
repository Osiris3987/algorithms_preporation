import java.util.Arrays;

public class TwoSumII167 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2,7,11,15}, 9)));
    }
    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while(numbers[left] + numbers[right] != target) {
            int curr = numbers[left] + numbers[right];
            if(curr > target) {
                right--;
            }
            if (curr < target) {
                left++;
            }
            if (curr == target) {
                break;
            }
        }

        return new int[]{left + 1, right + 1};
    }
}
/**
 * Реализовал 4 пет проекта. Есть опыт самостоятельного проектирования сервиса с нуля, включая security, API и миграции.
 *
 * Проекты:
 * "Список дел" - сервис для составления ежедневных задач и дел с дедлайнами,
 * Стек:
 * Java, Spring, Spring Security, Spring Data, Spring Mail, Postgresql, Liquibase, OpenAPI
 * Ссылка на репозиторий с проектом:
 * https://github.com/Osiris3987/daily_task_list
 *
 * "SneakerShop" - онлайн-магазин обуви.
 * Сервис проектировался с учетом дальнейшей интеграции с UI.
 */
