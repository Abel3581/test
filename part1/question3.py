
from MagicalOven import MagicalOven


def make_oven():
    return MagicalOven()

def alchemy_combine(oven, ingredients, temperature):
    for item in ingredients:
        oven.add(item)
    
    if temperature < 0:
        oven.freeze()
    elif temperature >= 100 and temperature != 150:
        oven.boil() #hervir
    elif temperature == 150:
        oven.pizza()
    else:
        oven.wait()

    return oven.get_output()