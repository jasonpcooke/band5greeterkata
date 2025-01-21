package com.band5.greeter.kata;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class GreeterTest {
  @Test
  void greetReturnsHelloAndName() {
    var greeter = new Greeter();
    String name = "John Smith";
    assertEquals("Hello John Smith", greeter.greet(name));
  }

  @Test
  void greetTrimsName() {
    var greeter = new Greeter();
    String name = "  John Smith  ";
    assertEquals("Hello John Smith", greeter.greet(name));
  }

  @Test
  void greetCapitalisesFirstLetterOfName() {
    var greeter = new Greeter();
    String name = "john";
    assertEquals("Hello John", greeter.greet(name));
  }

  @Test
  void greetReturnsGoodMorningWhenTimeBetween0600and1200() {
    var greeter = new Greeter();
    LocalTime morning = LocalTime.of(6, 0);
    String name = "John";
    assertEquals("Good Morning John", greeter.greet(name, morning));
  }
}