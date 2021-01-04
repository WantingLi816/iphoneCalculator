# iphoneCalculator

This is an emulation of the calculator embedded in iphone. 
It is a side-project I made when I was taking the Udemy course "The Complete Android 11 Developer Course: Build AMAZING apps".
Below are some of my personal thoughts when I was building the project.

PROBLEMS ENCOUNTERED

First, I had trouble deciding how to display the calculation result because it could be int or double. 
Then I decided to make a var of double type - "operand" and use a method to control when it should be displayed as int in the textview.

Second, I had a hard time deciding how the input numbers should appear in textview correctly. 
I made a mistake by thinking double and int input should be handled separately at first and it turned out that the data type was not the key.
This problem had not been handled until I made a boolean value "isInput" to keep track of when users are constantly inputting values.
Whenever users click on non-number buttons, they end the input of their operand and want to start a new input.
I even tried to update the input by calculation like 10*ANS + num in the first place 
but I figured out a better way to simply treat it as a string and convert it to double afterwards.

Third, I figured out there might be cases where users want to do consecutive operations without hitting the “=” button like 2+3-1. 
To solve this, I enforce the plus and minus buttons to print out intermediate results similar to the equal button.
