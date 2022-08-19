# Reads strings and rolls dice based on those strings.
# Inputs are in the traditional DnD dice rolling format, or ndx, where n is the number of dice to roll and x is the number of sides on each die.
# Valid input examples: "1d6", "2d4", "2d6+5", "3d20+6d4", "1d15+4d7+13"

import random
import re

def roll(inputString):
	"""Parse an input string and generate a dice roll."""
	# Use regex to validate the input
	validity_check = re.match('((\d*d\d+\+?)+(\d)*)', inputString)
	if (not validity_check):
		return "Invalid argument: {}".format(inputString)
	# Split the input
	argument = validity_check.group(1)
	sections = argument.split('+')
	# Initialize some variables
	all_dice = "Rolling " + argument + ": "
	total = 0
	addAmount = ""
	# If there are multiple dice to be rolled, split them apart
	if not re.match('\d*d+\d+', sections[-1]):
		addAmount = " + " + sections[-1]
		total += (int) (sections[-1])
		del sections[-1]
	# Iterate through each die
	for die in sections:
		# Split the number of dice from the number of sides
		nums = die.split('d')
		# If no number is specified, assume 1
		if nums[0] == "":
			nums[0] = '1'
		# Iterate through each die we have to roll
		for i in range(0, (int) (nums[0])):
			sides = (int) (nums[1])
			# Can't roll a die with less than 1 side
			if sides < 1:
				return "Invalid argument: {}".format(inputString)
			# Generate a random number
			result = random.randint(1, sides)
			# Add a plus sign if this isn't the first die
			if i > 0:
				all_dice += " + "
			# Add the result to the total
			total += result
			all_dice += str(result)

		# Add a plus sign
		all_dice += " + "
	# Remove the last plus sign
	all_dice = all_dice[:-3]
	# If there is more than one argument, output the total. Otherwise, only output dice roll.
	if (len(sections) > 1) or (int(nums[0]) > 1) or (addAmount != ""):
		return all_dice + addAmount + " = " + (str) (total)
	else:
		return all_dice
# End function roll(inputString)

if __name__ == "__main__": 
	print("Dice roller app created by Will Bohlen.")
	inputString = input("Enter some dice to roll (d6, 3d20+3, 2d4+1d8, etc.): ")
	print (roll(inputString))
	input("Press enter to close.")