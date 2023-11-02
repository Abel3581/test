from question3 import alchemy_combine, make_oven

def test_alchemy_combine():

  assert alchemy_combine(
    make_oven(),
    ["lead", "mercury"],
    5000
  ) == "gold"

  assert alchemy_combine(
    make_oven(),
    ["water", "air"],
    -100
  ) == "snow"

  assert alchemy_combine(
    make_oven(),
    ["cheese", "dough", "tomato"],
    150
  ) == "pizza"
  #Se crea un test para probar cuando esta en espera
  assert alchemy_combine(
    make_oven(),
    ["En espera"],
    0
  ) == "pausa"