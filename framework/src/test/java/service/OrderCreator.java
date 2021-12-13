package service;

import model.Order;

public class OrderCreator {
    public static String COMPUTE_ENGINE = "testdata.common.category";
    public static String NUMBER = "testdata.common.number";
    public static int OPERATING_SYSTEM = 0;
    public static int VM_CLASS = 0;
    public static int SERIES = 0;
    public static int INSTANCE_TYPE = 3;
    public static boolean ADD_GPU = true;
    public static int NUMBER_GPU = 1;
    public static int GPU_TYPE = 3;
    public static int SSD = 2;
    public static int LOCATION = 9;
    public static int COMMITED_USAGE = 1;

    public static Order getTestOrder() {
        return new Order(TestDataReader.getTestData(COMPUTE_ENGINE),
                TestDataReader.getTestData(NUMBER),
                OPERATING_SYSTEM, VM_CLASS, SERIES, INSTANCE_TYPE, ADD_GPU,
                NUMBER_GPU, GPU_TYPE, SSD, LOCATION, COMMITED_USAGE);
    }

}
