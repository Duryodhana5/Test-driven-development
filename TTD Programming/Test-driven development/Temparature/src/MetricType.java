package temperature;


import static temperature.MetricType.Type.TEMPERATURE;

public class MetricType {
    public enum Type{
        LENGTH, TEMPERATURE , VOLUME
    }
    private final String name;
    private final Type type;
    private final double numberOfBaseUnits;
    private final double offset;

    public MetricType(String name ,Type type, double numberOfBaseUnits, double offset){
        this.name = name;
        this.type = type;
        this.numberOfBaseUnits = numberOfBaseUnits;
        this.offset = offset;
    }
    public void validate(double value) {
        if(TEMPERATURE.equals(type)) return;
        if(value < 0)
            throw new IllegalArgumentException("Negative values are not allowed");
    }

    public double inBaseUnits(double value) {
        return (value - offset) * numberOfBaseUnits;
    }

    public double amountFrom(double baseUnit, MetricType original) {
        if(!type.equals(original.type))
            throw new RuntimeException(type + " cannot be converted to " + original.type);

        return baseUnit / numberOfBaseUnits  + offset;
    }
    @Override
    public String toString(){
        return name;
    }

}