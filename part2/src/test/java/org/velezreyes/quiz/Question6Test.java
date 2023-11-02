package org.velezreyes.quiz;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.velezreyes.quiz.question6.Drink;
import org.velezreyes.quiz.question6.NotEnoughMoneyException;
import org.velezreyes.quiz.question6.UnknownDrinkException;
import org.velezreyes.quiz.question6.VendingMachine;
import org.velezreyes.quiz.question6.VendingMachineImpl;

public class Question6Test {

  @Test
  public void canCreateVendingMachineInstance() {
    VendingMachine vm = VendingMachineImpl.getInstance();
    assertNotNull(vm);
  }

  @Test
  public void drinkNotFree() { //bebida no gratuita
    VendingMachine vm = VendingMachineImpl.getInstance();

    Exception exception = assertThrows(NotEnoughMoneyException.class, () -> {
      vm.pressButton("ScottCola");
    });
  }

  @Test
  public void canGetScottColaFor75Cents() throws Exception { // "puede obtener una Cola Scott por 75 centavos"
    VendingMachine vm = VendingMachineImpl.getInstance();

    vm.insertQuarter(); //introducir un cuarto de dólar
    vm.insertQuarter();
    vm.insertQuarter();

    Drink drink = vm.pressButton("ScottCola");
    
    assertTrue(drink.isFizzy());
    assertEquals(drink.getName(), "ScottCola");
  }

  @Test
  public void machineResets() throws Exception { // reiniciar la máquina
    VendingMachine vm = VendingMachineImpl.getInstance();

    vm.insertQuarter();
    vm.insertQuarter();
    vm.insertQuarter();

    Drink drink = vm.pressButton("ScottCola");
    assertNotNull(drink);
    //Vuelve a llamear a pressButton y falla
    Exception exception = assertThrows(NotEnoughMoneyException.class, () -> {
      vm.pressButton("ScottCola");
    });
  }

  @Test
  public void canGetKarenTeaForOneDollar() throws Exception {// puede obtener té de Karen por un dólar
    VendingMachine vm = VendingMachineImpl.getInstance();

    vm.insertQuarter();
    vm.insertQuarter();
    vm.insertQuarter();

    // Test that KarenTea costs more than 75 cents.
    // Aca falla
    assertThrows(NotEnoughMoneyException.class, () -> {
      vm.pressButton("KarenTea");
    });
    // Aca agrega mas dinero 25 mas y pasa
    vm.insertQuarter();

    Drink drink = vm.pressButton("KarenTea");
    assertFalse(drink.isFizzy());
    assertEquals(drink.getName(), "KarenTea");
  }

  //Otras bebidas desconocidas" o "bebidas no identificadas
  @Test
  public void otherDrinksUnknown() throws Exception {
    VendingMachine vm = VendingMachineImpl.getInstance();
    // Agrego 100
    vm.insertQuarter();
    vm.insertQuarter();
    vm.insertQuarter();
    vm.insertQuarter();
    // Aca falla porque esa bebida no esta registrada
    assertThrows(UnknownDrinkException.class, () -> {
      vm.pressButton("BessieBooze");
    });
  }
}
