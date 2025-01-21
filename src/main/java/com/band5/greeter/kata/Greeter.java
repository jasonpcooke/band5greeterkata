package com.band5.greeter.kata;

public class Greeter {
  public String greet(String name){
    name = name.trim();
    return "Hello " + name.substring(0,1).toUpperCase() + name.substring(1);
  }
}
