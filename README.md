# Quad Tree Image Processing:

This project was my first indepth working with QuadTree data structure. For this project I used quadtrees and color processing to subdivide an image in order to create graphic art. This process is used for image processing and hitbox detection as some examples for its scope.


The results went better than expected and everything can be seen in the executable jar file. The QuadTree data structure utilizes breaking an image into four quadrants repeatedly based on some form of error or measurment. In my case I used average color differences, as I will talk further below, in order to subdivide an image and refine its higher detail sections into smaller and smaller parts (correclating to more subdivisions of that one area).


Being my first real Java Project this was a valuable learning experience overall. The inspiration for this project comes from a similar python and javascript implementation by Michael Fogleman at [his quad project.](https://github.com/fogleman/Quads) My project expands on his project and allows the user to more easily create varied images as well as save them to their local computer. The UI is not perfect, but it is straight forward and gets the job done.


Enjoy the read and if you have any reccomendations or bug finds please post or ask about them below. I hope to redo this project one day in the future and improve both the UI and overall power the user has in functionality.



The most valuable takeways I have and give to growing developers are as follows:
## Do not undererestimate the size of your project overall 
I origionally expected this project to be 5-6 classes in total and ended up being about 20 with ~400-500 lines of code total.
## Bugs are unexpected 
Using print statements are invaluable and taking a break from the code can help immensily. When using double for looped walking through the code can almost be impossible so think of creative solutions to find the bug as needed. Treat it as its own little programming challenge altogehter.
## Do not underestimate the size of the front end
The logic can be much simpler than the backend, but require 2-3x as much wiring overall. Additionally even for this simple looking project I had to use threads, a timer in this case, and taking care of allowing the user to issues multiple commands and get through all the concurrency issues was not wasy overall.
## Color processing is Difficult and Anti-intuitive. 
Firstly you cannot just added and divide 2 colors by 2 to find the average you must square them, add them, divide by 2, then take the square root. Also for color processing look into L*A*B colors which eliminate light componenets of colors which allow them to correctly be added. 
Using statistics by taking the weighted average can allow for quick and efficent erorr detection. This project uses the lumanace error method which is error = r * .2126 + g * .7152 + b * .0722. This formula is based on research and how the eye precieves color the best; green being the highest according to this formula. Otherwise calculating error between two color can create odd results. These errors can include the image being too dark overall or in my case subdividing low detail areas. If you want to use color in your future projects do your research before coding your project and look up materials. One of my life savers was this video by minute physics on  [colors](https://www.youtube.com/watch?v=LKnqECcg6Gw)

## Below are some samples creates from this project:

## Apple QuadTree made with triangles
![text](http://i.imgur.com/gL5rbNb.png, "Apple QuadTree made with triangles")

## New York Square QuadTree made with squares and skeleton frame
![text](http://i.imgur.com/yIHrweL.png, "New York square made with squares and skeleton frame")

## Flowers QuadTree made with circles
![text](http://i.imgur.com/7XjNu91.png, "Flowers QuadTree made with circles")

## Stary Night QuadTree made with squares and skeleton frame
![text](http://i.imgur.com/SURBJY9.png, "Stary Night made with squares and skeleton frame")

## World map QuadTree made with circles
![text](http://i.imgur.com/uAaeL8O.png, "World map made with circles")
