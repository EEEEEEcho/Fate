package com.thinkInJava.chapter14;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Part{
    public String toString(){
        return getClass().getSimpleName();
    }
    static List<Factory<? extends Part>> partFactories = new ArrayList<Factory<? extends Part>>();
    static {
        partFactories.add(new FuelFilter.Factory());
        partFactories.add(new AirFilter.Factory());
        partFactories.add(new CarBinAirFilter.Factory());
        partFactories.add(new OilFilter.Factory());
        partFactories.add(new FanBelt.Factory());
        partFactories.add(new PowerSteeringBelt.Factory());
        partFactories.add(new GeneratorBelt.Factory());
    }
    private static Random random = new Random(47);
    public static Part createRandom(){
        int n = random.nextInt(partFactories.size());
        return partFactories.get(n).create();
    }
}
public class RegisteredFactories {
    public static void main(String[] args) {
        for(int i=0;i < 10;i ++){
            System.out.println(Part.createRandom());
        }
    }
}
class Filter extends Part{

}
class FuelFilter extends Filter{
    //静态内部类，该内部类是一个工厂，该工厂实现了定义的工厂基类，
    //工厂中定义了一个方法，该方法返回外部类的一个对象


    public static class Factory implements com.thinkInJava.chapter14.Factory<FuelFilter>{
        public FuelFilter create(){
            return new FuelFilter();
        }
    }
}
class AirFilter extends Filter{
    public static class Factory implements com.thinkInJava.chapter14.Factory<AirFilter>{
        public AirFilter create(){
            return new AirFilter();
        }
    }
}
class CarBinAirFilter extends Filter{
    public static class Factory implements com.thinkInJava.chapter14.Factory<CarBinAirFilter>{
        public CarBinAirFilter create(){
            return new CarBinAirFilter();
        }
    }
}
class OilFilter extends Filter{
    public static class Factory implements com.thinkInJava.chapter14.Factory<OilFilter>{
        public OilFilter create(){
            return new OilFilter();
        }
    }
}
class Belt extends Part{

}
class FanBelt extends Belt{
    public static class Factory implements com.thinkInJava.chapter14.Factory<FanBelt>{
        public FanBelt create(){
            return new FanBelt();
        }
    }
}

class GeneratorBelt extends Belt{
    public static class Factory implements com.thinkInJava.chapter14.Factory<GeneratorBelt>{
        public GeneratorBelt create(){
            return new GeneratorBelt();
        }
    }
}
class PowerSteeringBelt extends Belt{
    public static class Factory implements com.thinkInJava.chapter14.Factory<PowerSteeringBelt>{
        public PowerSteeringBelt create(){
            return new PowerSteeringBelt();
        }
    }
}