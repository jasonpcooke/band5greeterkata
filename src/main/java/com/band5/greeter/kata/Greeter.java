package com.band5.greeter.kata;

import java.time.LocalTime;

public class Greeter {
  public String greet(String name, LocalTime timeOfDay){
    name = name.trim();
    String greeting = getGreeting(timeOfDay) + " " + name.substring(0,1).toUpperCase() + name.substring(1);
    System.out.println(greeting);
    return greeting ;
  }

  private String getGreeting(LocalTime timeOfDay) {
    if(timeOfDay.isAfter(LocalTime.of(5,59)) && timeOfDay.isBefore(LocalTime.of(12, 0))){
      return "Good morning";
    }
    else if (timeOfDay.isAfter(LocalTime.of(17,59)) && timeOfDay.isBefore(LocalTime.of(22,0))){
      return "Good evening";
    }
    else if (timeOfDay.isAfter(LocalTime.of(21,59)) || timeOfDay.isBefore(LocalTime.of(6,0))){
      return "Good night";
    }
    return "Hello";
  }
}
