import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class MyThreadDemoClass {
    private static final int COUNT_PARKING_PLACES = 4;
    private static final int COUNT_CARS = 10;
    // Флаги мест cтоянки
    private static boolean[] CONTROL_PARKING_PLACES = null;
    // Семафор
    private static Semaphore SEMAPHORE = null;

    public static void main(String[] args) throws InterruptedException {
        List<Car> carList = new ArrayList<>();
        // Определяем количество мест парковки
        CONTROL_PARKING_PLACES = new boolean[COUNT_PARKING_PLACES];
        // Флаги мест парковки [true-свободно,false-занято]
        for (int i = 0; i < COUNT_PARKING_PLACES; i++)
            CONTROL_PARKING_PLACES[i] = true;
        /*
         *  Определяем семафор со следующими параметрами:
         *  - количество разрешений
         *  - флаг очередности fair=true (очередь
         *                             first_in-first_out)
         */
        SEMAPHORE = new Semaphore(CONTROL_PARKING_PLACES.length,
                true);

        for (int i = 1; i <= COUNT_CARS; i++) {
            Car car = new Car(i);
            new Thread(new Car(i)).start();
            carList.add(car);
            Thread.sleep(400);
        }
    }

    public static class Car implements Runnable {
        private final int carNumber;
        private final long startTime;
        private boolean isTimeOut = false;

        public Car(int carNumber) {
            this.carNumber = carNumber;
            this.startTime = System.currentTimeMillis();
        }

        @Override
        public void run() {
            System.out.printf(
                    "Car is trying %d to park\n",
                    carNumber);
            try {
                // Запрос разрешения
                SEMAPHORE.acquire();
                System.out.printf(
                        "\tcar-driver (car № %d ) looking for free parking place\n", carNumber);

                if ((System.currentTimeMillis() - startTime) > 2000) {
                    isTimeOut = true;
                    System.out.println("i am tired by this place!");
                    leaveThisPlace();

                }

                int controlNum = -1;
                // Ищем свободное место и под подъезжаем к нему
                synchronized (CONTROL_PARKING_PLACES) {
                    for (int i = 0;

                         i < COUNT_PARKING_PLACES; i++)
                        // Есть ли свободные места?
                        if (CONTROL_PARKING_PLACES[i]) {
                            // Занимаем место
                            CONTROL_PARKING_PLACES[i] = false;
                            boolean isParked = true;
                            controlNum = i;
                            System.out.printf(
                                    "\t\tcar %d is parked on %d parking place.\n",
                                    carNumber, i);
                            isParked = true;
                            break;

                        }

                }
                // Время парковки
                Thread.sleep((int)
                        (Math.random() * 10 + 1) * 1000);
                // Освобождение парковки
                synchronized (CONTROL_PARKING_PLACES) {
                    CONTROL_PARKING_PLACES[controlNum] = true;
                }
                // Освобождение ресурса (парковки)
                SEMAPHORE.release();
                System.out.printf(
                        "car %d has left car parking\n",
                        carNumber);
            } catch (InterruptedException e) {
            }
        }

        public void leaveThisPlace() {
            System.out.printf("car %d leave this place! By!\n", carNumber);
            Thread.currentThread().stop();
        }
    }
}
