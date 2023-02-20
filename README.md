#### Assumptions
The Melody Mars Mission is to explore the surface of Mars. Initially one vehicle, the Mars Rover, will be sent to the surface. The rover will be controlled from Mission Control, initially from Earth, later from a space station or a ground station.

Due to the distance between Earth and Mars, there will be a signal lag of between 5 and 20 minutes. So initially commute rover will be controlled using  batch commands. The rover will have to decide if the received command is safe or possible.

It will be guided by our detailed maps Mars, and (to be implemented) real-time data from an on-board camera.

#### Work To Do
Used a TDD approach to get things up and running.
1. Needs more thorough testing to allow refactoring with confidence.
2. Need to move Plateau related functionality from Rover to Plateau or map. This is all specific too coordinates.   Then it can be accessed via the Plateau link in the Rover. When it is constructed or ‘placed’ on Mars, it should have direct access to its own plateau.
3. Improve all documentation.
4. Allow for a second rover to be added.
