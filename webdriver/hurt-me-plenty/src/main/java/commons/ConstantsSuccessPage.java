package commons;

public class ConstantsSuccessPage {

    private final String VN_CLASS = "VM class: regular";
    private final String INSTANCE_TYPE = "Compute Engine";
    private final String REGION = "Region: Frankfurt";
    private final String SSD = "Local SSD: 2x375 GiB\n" +
            "Committed Use Discount applied";
    private final String TERM = "Commitment term: 1 Year";
    private final String SUM = "Estimated Component Cost: USD 1,082.77 per 1 month";
    private final String CPU = "Instance type: n1-standard-8\n" +
            "Committed Use Discount applied";

    public String getVN_CLASS() {
        return VN_CLASS;
    }

    public String getINSTANCE_TYPE() {
        return INSTANCE_TYPE;
    }

    public String getREGION() {
        return REGION;
    }

    public String getSSD() {
        return SSD;
    }

    public String getTERM() {
        return TERM;
    }

    public String getSUM() {
        return SUM;
    }

    public String getCPU() {
        return CPU;
    }
}
