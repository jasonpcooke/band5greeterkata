package com.band5.greeter.kata;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class GreeterTest {

  private final LocalTime midnight = LocalTime.of(0, 0);
  @Test
  void greetReturnsHelloAndName() {
    var greeter = new Greeter();
    String name = "John Smith";
    assertEquals("Hello John Smith", greeter.greet(name, midnight));
  }

  @Test
  void greetTrimsName() {
    var greeter = new Greeter();
    String name = "  John Smith  ";
    assertEquals("Hello John Smith", greeter.greet(name, midnight));
  }

  @Test
  void greetCapitalisesFirstLetterOfName() {
    var greeter = new Greeter();
    String name = "john";
    assertEquals("Hello John", greeter.greet(name, midnight));
  }

  @Test
  void greetReturnsGoodMorningWhenTime0600to1200() {
    var greeter = new Greeter();
    LocalTime morning = LocalTime.of(6, 0);
    String name = "John";
    assertEquals("Good morning John", greeter.greet(name, morning));
  }

  @Test
  void greetDoesNotReturnGoodMorningWhenTimeIsOutside0600to1200() {
    var greeter = new Greeter();
    LocalTime morning = LocalTime.of(5, 59);
    String name = "John";
    assertNotEquals("Good morning John", greeter.greet(name, morning));
  }

  @Test
  void greetReturnsGoodMorningWhenTime1800to2200() {
    var greeter = new Greeter();
    LocalTime morning = LocalTime.of(20, 0);
    String name = "John";
    assertEquals("Good evening John", greeter.greet(name, morning));
  }

  @Test
  void greetDoesNotReturnGoodMorningWhenTimeIsOutside1800to2200() {
    var greeter = new Greeter();
    LocalTime morning = LocalTime.of(17, 59);
    String name = "John";
    assertNotEquals("Good evening John", greeter.greet(name, morning));
  }
}