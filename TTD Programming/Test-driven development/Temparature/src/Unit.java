package temperature;

public class Unit {
    public final double value;
    private final MetricType metricType ;
    private final double baseUnit;
    public Unit(double value, MetricType metricType){
        metricType.validate(value);
        baseUnit = metricType.inBaseUnits(value);
        this.value = value;
        this.metricType = metricType;
    }
    public Unit in(MetricType toType){
        return new Unit(toType.amountFrom(baseUnit,metricType),toType);
    }

    public boolean equals(Unit other){
        return value == other.value && metricType.equals(other.metricType);
    }

    @Override
    public String toString(){
        return value + " " + metricType;
    }
}