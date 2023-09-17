from abc import ABC, abstractmethod
from typing import Union


class NoRealSolutions(Exception):
    pass


class InfinitelyManySolutions(Exception):
    pass


class Equation(ABC):
    @abstractmethod
    def calculate_solutions(self):
        raise NotImplementedError


class LinearEquation(Equation):
    __slots__ = ('a', 'b')

    def __init__(self, a: float, b: float):
        self.a = a
        self.b = b

    def calculate_solutions(self) -> float:
        if self.a == 0 and self.b != 0:
            raise NoRealSolutions

        if self.a == 0 and self.b == 0:
            raise InfinitelyManySolutions

        return -self.b / self.a

    def __str__(self):
        return f"{self.a}x + {self.b} = 0" if self.b > 0 else f"{self.a}x - {-self.b} = 0"


class QuadraticEquation(Equation):
    __slots__ = ('a', 'b', 'c')

    def __init__(self, a: float, b: float, c: float):
        self.a = a
        self.b = b
        self.c = c

    def _calculate_discriminant(self) -> float:
        return self.b ** 2 - 4 * self.a * self.c

    def calculate_solutions(self) -> Union[float, tuple[float, float]]:
        discriminant = self._calculate_discriminant()

        if discriminant < 0:
            raise NoRealSolutions

        if discriminant == 0:
            return -self.b / (2 * self.a)

        return (
            (-self.b + discriminant ** (1/2)) / (2 * self.a),
            (-self.b - discriminant ** (1/2)) / (2 * self.a)
        )

    def __str__(self):
        eq = f"{self.a}x^2 " if self.a != 1 else "x^2 "

        if self.b < 0:
            eq += f"- {-self.b}x "
        elif self.b == 1:
            eq += "+ x "
        elif self.b > 0:
            eq += f"+ {self.b}x "

        if self.c < 0:
            eq += f"- {-self.c} "
        elif self.c > 0:
            eq += f"+ {self.c} "

        return eq + "= 0"
