################################################################################
#     ____                          __     _                          ___ 
#    / __ \  __  __  ___    _____  / /_   (_)  ____    ____          |__ \
#   / / / / / / / / / _ \  / ___/ / __/  / /  / __ \  / __ \         __/ /
#  / /_/ / / /_/ / /  __/ (__  ) / /_   / /  / /_/ / / / / /        / __/ 
#  \___\_\ \__,_/  \___/ /____/  \__/  /_/   \____/ /_/ /_/        /____/ 
#                                                                         
#  Question 2
################################################################################
#
# Instructions:
# Write a function that will swap a tuple of two items. For example, the function 
# should change (x, y) into (y, x). 
# Assign the function to `swapper` so that the function `run_swapper(..)` can use
# it. As always, there is a test suite that checks the result. It is in 
# `question2_test.py.`

# Escribe una función que intercambie una tupla de dos elementos. Por ejemplo, la función
# debería cambiar (x, y) a (y, x).
# Asigna la función a swapper para que la función run_swapper(..) pueda utilizarla.
swapper = None

def run_swapper(list_of_tuples):
  swapper(list_of_tuples)
  return list(map(swapper, list_of_tuples))

def swapper(tupla):
    # Intercambia los elementos de la tupla.
    return (tupla[1], tupla[0])
