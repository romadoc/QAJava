package model;

import java.util.Objects;

public class Order {
    private String computeEngine;
    private String number;
    private int operatingSystem;
    private int vmClass;
    private int series;
    private int instanceType;
    private boolean addGpu;
    private int numberGpu;
    private int gpuType;
    private int ssd;
    private int location;
    private int commitedUsage;


    public Order(String computeEngine, String number, int operatingSystem, int vmClass,
                 int series, int instanceType, boolean addGpu, int numberGpu, int gpuType,
                 int ssd, int location, int commitedUsage) {
        this.computeEngine = computeEngine;
        this.number = number;
        this.operatingSystem = operatingSystem;
        this.vmClass = vmClass;
        this.series = series;
        this.instanceType = instanceType;
        this.addGpu = addGpu;
        this.numberGpu = numberGpu;
        this.gpuType = gpuType;
        this.ssd = ssd;
        this.location = location;
        this.commitedUsage = commitedUsage;

    }

    public String getComputeEngine() {
        return computeEngine;
    }

    public void setComputeEngine(String computeEngine) {
        this.computeEngine = computeEngine;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(int operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public int getVmClass() {
        return vmClass;
    }

    public void setVmClass(int vmClass) {
        this.vmClass = vmClass;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public int getInstanceType() {
        return instanceType;
    }

    public void setInstanceType(int instanceType) {
        this.instanceType = instanceType;
    }

    public boolean isAddGpu() {
        return addGpu;
    }

    public void setAddGpu(boolean addGpu) {
        this.addGpu = addGpu;
    }

    public int getNumberGpu() {
        return numberGpu;
    }

    public void setNumberGpu(int numberGpu) {
        this.numberGpu = numberGpu;
    }

    public int getGpuType() {
        return gpuType;
    }

    public void setGpuType(int gpuType) {
        this.gpuType = gpuType;
    }

    public int getSsd() {
        return ssd;
    }

    public void setSsd(int ssd) {
        this.ssd = ssd;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public int getCommitedUsage() {
        return commitedUsage;
    }

    public void setCommitedUsage(int commitedUsage) {
        this.commitedUsage = commitedUsage;
    }

    @Override
    public String toString() {
        return "Order{" +
                "computeEngine='" + computeEngine + '\'' +
                ", number='" + number + '\'' +
                ", operatingSystem=" + operatingSystem +
                ", vmClass=" + vmClass +
                ", series=" + series +
                ", instanceType=" + instanceType +
                ", addGpu=" + addGpu +
                ", numberGpu=" + numberGpu +
                ", gpuType=" + gpuType +
                ", ssd=" + ssd +
                ", location=" + location +
                ", commitedUsage=" + commitedUsage +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return getOperatingSystem() == order.getOperatingSystem() && getVmClass() == order.getVmClass()
                && getSeries() == order.getSeries() && getInstanceType() == order.getInstanceType()
                && isAddGpu() == order.isAddGpu() && getNumberGpu() == order.getNumberGpu()
                && getGpuType() == order.getGpuType() && getSsd() == order.getSsd()
                && getLocation() == order.getLocation() && getCommitedUsage() == order.getCommitedUsage()
                && Objects.equals(getComputeEngine(), order.getComputeEngine())
                && Objects.equals(getNumber(), order.getNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getComputeEngine(), getNumber(), getOperatingSystem(), getVmClass(),
                getSeries(), getInstanceType(), isAddGpu(), getNumberGpu(), getGpuType(), getSsd(),
                getLocation(), getCommitedUsage());
    }
}
