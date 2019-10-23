After running a multitude of tests, it seems every feature of my GUI View and GUI Controller works as expected.
Initially, I intended to add a feature that allowed the user to set the speed with which a shape animation is animated. Essentially, the GUI View receives data form the GUI controller in the form of a list of animations (IViewMotions). The GUI controller gets form the model all the shapes that are present at a given frame. The GUI controller then parses this data, extracting the relevant shape animations to then pass to the view. To ensure that the animations look fluid and consistent, when two animations associated with a given shape occur at the same time, the most recent animation of the two takes on as many attributes as the earlier animation without writing over its own relevant data. For example, a move animation scheduled during a color change will take on the color change animations color-related attributes such that the shape will move and continue changing color.

Unfortunately, I couldn't figure out an effective way to implement this feature without making the animation look
choppy and inconsistent.

If a user wants to render a visual animation using the GUI View, they can pass in an output source (using the -o flag)
or not, the animation will play regardless.

As for the extra credit features, I implemented a working play/pause button as well as a restart button. When a user
clicks the play/pause button, the animation will pause if it is playing at the time the button is clicked or will play
if the animation is paused at the time the button is clicked.

When the user clicks the restart button, if the animation is currently playing, it will immediately restart from frame/
tick 0. If the animation is paused at the time the restart button is clicked, the animation will not seem to change,
however, upon clicking the play/pause button, the animation will start over playing from frame/tick 0.
