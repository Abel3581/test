class MagicalOven:
    def __init__(self):
        self.ingredients = []
        self.output = None

    def add(self, item):
        self.ingredients.append(item)

    def freeze(self):
        self.output = "snow"

    def pizza(self):
        self.output = "pizza"

    def boil(self):
        self.output = "gold"

    def wait(self):
        self.output = "pausa"

    def get_output(self):
        return self.output
