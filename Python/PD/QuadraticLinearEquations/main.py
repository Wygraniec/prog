import Equations


def parameters_to_equation(a: float, b: float, c: float) -> Equations.Equation:
    if a == 0:
        return Equations.LinearEquation(b, c)

    return Equations.QuadraticEquation(a, b, c)


def main():
    print("ax^2 + bx + c = 0")
    a = float(input("Podaj parametr a: "))
    b = float(input("Podaj parametr b: "))
    c = float(input("Podaj parametr c: "))

    equation = parameters_to_equation(a, b, c)
    try:
        solutions = equation.calculate_solutions()

        if isinstance(solutions, tuple):
            print("Rozwiązania", end=' ')
        else:
            print("Rozwiązanie", end=' ')

        print(f"równania {equation} to {solutions}")
    except Equations.NoRealSolutions:
        print("Równanie nie ma rozwiązań rzeczywistych")
    except Equations.InfinitelyManySolutions:
        print("Równanie ma nieskończenie wiele rozwiązań")


if __name__ == '__main__':
    main()
