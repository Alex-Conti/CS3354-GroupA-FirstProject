1) Environment & dependencies (Java version, build tool)

This game was built in Visual Studio Code with Java version 25.0.2.

2) One command to run (CLI / GUI / Integrated)

javac src/**/*.java && java -cp src game.Game

3) How to play (controls, inputs)

The game starts with White first. A board will appear with all pieces in their standard position. The player will input the starting coordinates of the piece they wish to move and the coordinates of where they want it moved to. If the placement is valid, the piece will be moved and the next player will be asked to move. If the placement is invalid (i.e. collides with another piece, off the board, not allowed, etc.) the player will be asked to move again.

4) Feature list + checklist (implemented / not implemented / limitations)

Features Implemented:

All pieces can move correctly with their set movement patterns. White can not take white pieces, and vice versa. The pieces can not go off the board or collide with eachother. 

The board is an 8x8 with alernating colors. 

The game will only recognize one format for inputs; A1 - H8. 

Not Implemented:

Pawns can not be promoted by reaching the end.

The game does not recognize when the King is in check. 

Castling has not been added.

There is no current win condition. 