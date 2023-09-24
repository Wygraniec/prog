from pathlib import Path
from random import randrange

RANGE_MIN = 0
RANGE_MAX = 100


def print_menu():
    print("0. Zakończ działanie programu")
    print("1. Wylosuj nowe liczby")
    print("2. Zapisz liczby do pliku")


def main():
    print(f"Generowanie liczb pseudolosowych z zakresu [{RANGE_MIN}; {RANGE_MAX}]")
    random_numbers = list()
    while True:
        print_menu()
        selection = int(input("Wybór: "))
        if selection == 0:
            exit(0)

        if selection == 1:
            amount = int(input('Ile liczb chcesz wygenerować?\n'))
            random_numbers = [randrange(RANGE_MIN, RANGE_MAX) for _ in range(amount)]
            print('Wygenerowane liczby to: ', random_numbers, sep='\n')

        if selection == 2:
            if not random_numbers:
                print('Liczby nie zostały jeszcze wygenerowane')
                continue

            path = Path(input("Podaj ścieżkę do pliku .txt, do którego liczby zostaną zapisane: "))

            if path.suffix != ".txt":
                print("Podana ścieżka nie prowadzi do pliku .txt")
                continue

            try:
                open(path, 'w').close()
            except FileNotFoundError:
                print("Podana ścieżka nie istnieje")
                continue

            with open(path, 'a') as f:
                for number in random_numbers:
                    f.write(f"{number}\n")
                print(f"Liczby zostały pomyślnie zapisane do pliku {path.absolute()}")


if __name__ == '__main__':
    main()
