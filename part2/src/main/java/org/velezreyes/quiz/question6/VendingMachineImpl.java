package org.velezreyes.quiz.question6;

public class VendingMachineImpl implements VendingMachine {

  private static VendingMachineImpl instance;

  private int moneyInserted;

  private VendingMachineImpl() { // Maquina con dinero en cero
    moneyInserted = 0;
  }

  //Crea una instancia en singleton
  public static VendingMachine getInstance() {
    if (instance == null) {
      instance = new VendingMachineImpl();
    }
    return instance;
  }

  @Override
  public void insertQuarter() { //introducir un cuarto de dóla
    moneyInserted += 25;
  }

  @Override
  public Drink pressButton(String name) throws NotEnoughMoneyException, UnknownDrinkException {
    if ("ScottCola".equals(name)) {
      if (moneyInserted >= 75) {
        moneyInserted -= 75;
        return new DrinkImpl("ScottCola", true);
      } else {
        throw new NotEnoughMoneyException();
      }
    } else if ("KarenTea".equals(name)) {
      if (moneyInserted >= 100) {
        moneyInserted -= 100;
        return new DrinkImpl("KarenTea", false);
      } else {
        throw new NotEnoughMoneyException();
      }
    } else {
      throw new UnknownDrinkException();
    }
  }


}
