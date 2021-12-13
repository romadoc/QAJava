package constants;

public class ResultConstants {
    private static final String VM_CLASS = "VM class: regular";
    private static final String REGION = "Region: Frankfurt";
    private static final String SSD = "Local SSD: 2x375 GiB\n" +
            "Committed Use Discount applied";
    private static final String TERM = "Commitment term: 1 Year";
    private static final String SUM = "Total Estimated Cost: USD 1,082.77 per 1 month";
    private static final String CPU = "Instance type: n1-standard-8\n" +
            "Committed Use Discount applied";

    public static String getVM_CLASS() {
        return VM_CLASS;
    }

    public static String getREGION() {
        return REGION;
    }

    public static String getSSD() {
        return SSD;
    }

    public static String getTERM() {
        return TERM;
    }

    public static String getSUM() {
        return SUM;
    }

    public static String getCPU() {
        return CPU;
    }
}
