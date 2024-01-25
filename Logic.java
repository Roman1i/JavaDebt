import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Logic {
    private static HashMap<Integer, HashMap<String, String>> storage = new HashMap<>();

    public static void addNewItem(String manufacturer, String model, String color, String os, int hddSize, int ram) {
        HashMap<String, String> map = new HashMap<>();
        map.put("model", manufacturer + " " + model);
        map.put("color", color);
        map.put("os", os);
        map.put("hdd size", Integer.toString(hddSize));
        map.put("ram", Integer.toString(ram));

        storage.put(storage.size(), map);
    }

    public static void startProgram() {
        boolean toggle = true;
        while(toggle) {
            try {
                System.out.println("Выберите действие:\n1. Просмотреть содержимое\n2. Фильтр поиска\n3. Выход");
                Scanner sc = new Scanner(System.in);
                int in = sc.nextInt();
                switch (in) {
                    case 1:
                        showStore();
                        break;
                    case 2:
                    filter();
                        break;
                    case 3:
                        sc.close();
                        toggle = false;
                        break;
                    default:
                        System.out.println("Выбранный пункт не найден!");
                        break;
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Введите номер пункта!");
            }
        }
    }

    public static void showStore() {
        storage.forEach((id, info) -> {
            System.out.printf("id: %d Information: %s\n", id, info);
        });
    }

    public static void filter() {
        System.out.println("Выберите параметр для фильтра:\n1. model\n2. color\n3. os\n4. hdd size\n5. ram");
        Scanner sc = new Scanner(System.in);
        int property = sc.nextInt();
        switch (property) {
            case 1:
                System.out.println("Введите интересующую модель:");
                showFiltered("model", false);
                break;
            case 2:
                System.out.println("Введите интересующий цвет:");
                showFiltered("color", false);
                break;
            case 3:
                System.out.println("Введите интересующую ос:");
                showFiltered("os", false);
                break;
            case 4:
                System.out.println("Введите минимальный объём hdd:");
                showFiltered("hdd size", true);
            break;
            case 5:
                System.out.println("Введите минимальный объём озу:");
                showFiltered("ram", true);
                break;
            default:
                break;
        }
    }


    public static void showFiltered(String type, boolean isInt) {
        Scanner scan = new Scanner(System.in);
        String value = scan.nextLine();
        for (int id = 0; id < storage.size(); id++) {
            HashMap<String, String> map = storage.get(id);
            if (!isInt) {
                if (map.get(type).compareTo(value) == 0){
                    System.out.printf("id: %d Information: %s\n", id, map);
                }
            } else {
                if (Integer.valueOf(map.get(type)) >= Integer.valueOf(value)) {
                    System.out.printf("id: %d Information: %s\n", id, map);
                }
            }
        }
    }
}
