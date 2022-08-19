# !/usr/bin/env python
# -*- coding: utf-8 -*-

"""
    CPS 202--Intermediate Computer Programming
    Spring 2021
    Dr. Close

    Copyright (C) 2021 Daryl Close.  This work is licensed under the Creative
    Commons Attribution-Noncommercial-No Derivative Works 3.0 United States
    License.
    
    File name:    BabyloniaWithProcedure.py

    Description:  Graded Homework #1: Savitch 6e, Ch. 2, p. 95, Programming
                  Project #1.                  
                  This program uses the Babylonian algorithm to estimate square 
                  roots, and keeps looping until the current guess is within 1% 
                  of the previous guess value.  
                  
    __author__ = "Daryl Close dclose@heidelberg.edu"              
    __version__ = "13-Jan-2021"
"""

import re # For regular expression functions compile() and match()

def obtain_valid_radicand() -> float:
    """Prompt the user to enter the radicand.

    Keyboard entry is fully bullet-proofed to allow only positive floats.
    """

    radicand_string: str = input("Enter the radicand: ")
    while (not is_valid_number(radicand_string)
           or (eval(radicand_string) < 0.0)):           
        radicand_string = input("Enter the radicand: ")
        
    return eval(radicand_string)

def estimate_square_root(radicand: float) -> float:
    """Estimate a square root with the Babylonia algorithm."""

    # Declare and initialize local variables
    guess_counter: int = 1
    old_estimate: float = radicand
    new_estimate: float = radicand / 2        
    
    # Loop to refine estimates
    while (((old_estimate - new_estimate) / old_estimate) > 0.001):
        old_estimate = new_estimate
        new_estimate = (old_estimate + (radicand / old_estimate)) / 2
        print(f"\nGuess {guess_counter:d} = {new_estimate:.4f}")
        guess_counter += 1
        
    return new_estimate

def is_valid_number(number_string: str) -> bool:
    """Use regular expression pattern matching to validate numeric string.

    Allow scientific notation.
    """
        
    regex: str = ("^[+\-]?"                  # Match optional sign in the set
                  + "(?:0|[1-9]\d*)"         # Match digits
                  + "(?:\.\d*)?"             # Match dot and more digits
                  + "(?:[eE][+\-]?\d+)?$")   # Match scientific    
    
    number_format: str = re.compile(regex)
    is_number: bool = re.match(number_format, number_string)
    
    return is_number
    
def main() -> None:
    """Main function to estimate square roots."""

    # Declare and initialize local variables
    radicand: float = 0.0
    square_root: float = 0.0        

    # Print program header
    print("\n\t\tCOMPUTE A SQUARE ROOT\n\n"
          + "Dr. Close\n"
          + "January 25, 2021\n")
    print("This program estimates square roots using"
          + " the Babylonian algorithm.\n")

    # Prompt user for input
    radicand = obtain_valid_radicand()
    
    # Call the Babylonia estimate_square_root function
    if (radicand == 0):
        square_root = 0
    elif (radicand == 1):
        square_root = 1
    else:
        square_root = estimate_square_root(radicand)
    
    # Display root with string modulo C-style "printf" formatting
    print("\nThe estimated square root of %.2f is %.4f \n"
          %(radicand, square_root))
        
if __name__ == "__main__":
    main()
    
# End module BabyloniaWithProcedure
