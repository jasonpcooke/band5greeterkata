package com.band5.greeter.kata;

import java.time.LocalTime;

public class Greeter {
  public String greet(String name, LocalTime timeOfDay){
    name = name.trim();
    return getGreeting(timeOfDay) + " " + name.substring(0,1).toUpperCase() + name.substring(1);
  }

  private String getGreeting(LocalTime timeOfDay) {
    if(timeOfDay.isAfter(LocalTime.of(5,59)) && timeOfDay.isBefore(LocalTime.of(12, 1))){
      return "Good morning";
    }
    else if (timeOfDay.isAfter(LocalTime.of(17,59)) && timeOfDay.isBefore(LocalTime.of(22,1))){
      return "Good evening";
    }
    return "Hello";
  }
}
