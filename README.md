This is a Verity calculator created by https://github.com/ThomazFB

# For those who have no idea of what Verity is

Verity is an encounter inside the Destiny 2 game, and this calculator was created to help our team solve a specific challenge within the game.

If you don't know anything regarding this game or its raids, this code will have no use for you.

# For those who know about Destiny 2 and the Salvation's Edge raid

This calculator is designed to help the person handling the dissections during the Verity encounter. It can generate the steps for normal dissections and the Varied Geometry challenge. 

Run the `main` function with the expected parameters of the EncounterCycle, and all steps will be printed on the console.

For the Varied Geometry challenge, simply create an EncounterCycle with the shouldTargetPureShapes parameter set to true. The steps will be generated targeting pure shapes.

Also, be sure to sync with your raid team the following Internal Room strategy:
- The Internal Room holding a TRIANGLE will flee with a CUBE shape
- The Internal Room holding a [SQUARE] will flee with a [SPHERE] shape
- The Internal Room holding a [CIRCLE] will flee with a [PYRAMID] shape

# Side notes

There is no UI implementation in this repository, but since it's fully written in standard Kotlin, feel free to use this code for any UI case you want to implement.
