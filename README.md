# Snake
My advanced Hello World program is a version of the old game Snake.

## Features
- normal playing experience of Snake
- 5 different fruits that can be eaten to enlarge the Snake
- theoretically Start- and Endscreen, currently mostly unused
- theoretically visual display whether a result is good or bad, commented out for now as it does not appear to work as expected

## Classes
- Snake:
  - stores the body parts, their position and the general direction of the Snake
  - checks, whether the Snake touches itself, the outer bounds or food
- Main:
  - the class where public static void main(String[] args){} is located
  - stores the GameWindow used
- GameWindow:
  - displays all visual components used in the game
  - stores the Snake object
- FoodFactory:
  - generates new Food
- other classes in the ui-package:
  - as the name suggests, defines the visual appearance before and after games 
  
## JAR of the final version
If you follow <a href="https://github.com/delvh/Snake/releases">**this link**</a> and click on release "Snake - almost finished", you can download the runnable JAR of how the completed project should look like. Unfortunately due to poor Version-Control-skills, the original code got lost and had to be rewritten, however it should resemble the executed code closely
