import random

initial_red = int(input("How many troops does team red start with? "))
initial_blue = int(input("How many troops does team blue start with? "))

simulations = 0

blue_win = False

print("Red size: " + (str) (initial_red))
print("Blue size: " + (str) (initial_blue))

print("Current Simulation: ")

while (not blue_win):
    rounds = 0

    red_size = initial_red
    blue_size = initial_blue

    while (red_size > 1 and blue_size > 0):
        red_rolls_num = red_size - 1
        if red_rolls_num > 3: red_rolls_num = 3

        blue_rolls_num = blue_size
        if blue_rolls_num > 2: blue_rolls_num = 2

        red_rolls = []
        blue_rolls  = []
        for i in range(red_rolls_num):
            red_rolls.append(random.randrange(1, 6))
        for i in range(blue_rolls_num):
            blue_rolls.append(random.randrange(1, 6))

        for i in range(blue_rolls_num):
            if (i < red_rolls_num):
                if red_rolls[i] > blue_rolls[i]:
                    blue_size -= 1
                else:
                    red_size -= 1
        rounds += 1

    simulations += 1
    print("\033[FCurrent Simulation: "+ (str) (simulations))

    if (blue_size != 0):
        print("\nBLUE WINS")
        print("Red size: " + (str) (red_size))
        print("Blue size: " + (str) (blue_size))
        print("Rounds: " + (str) (rounds))
        blue_win = True


print("Simulation complete")