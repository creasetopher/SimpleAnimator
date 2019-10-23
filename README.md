# A simple SVG Animator

## CLI

### *The easiest, most fun way to use this simple SVG animator is as a command line program*

The command-line arguments will be of the form

`<-if name-of-animation-file> <-iv type-of-view> <-o where-output-show-go> <-speed integer-ticks-per-second>`


Here are some examples of valid command-line arguments and what they mean:

`-if smalldemo.txt -iv text -o out -speed 2`:

use smalldemo.txt for the animation file, and open a text view with its output going to System.out, and a speed of 2 ticks per second.

`-iv svg -o out.svg -if buildings.txt`:

use buildings.txt for the animation file, and open an SVG view with its output going to the file out.svg, with a speed of 1 tick per second.

`-if smalldemo.txt -iv text: use smalldemo.txt` for the animation file, and open a text view with its output going to System.out.
