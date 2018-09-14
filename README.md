# Mandelbrot
### Introduction:
Mandlebrot Visualizer is an AWT-based Java application that allows users to zoom in on a Mandlebrot visualization
and (eventually) generate an animation of their chosen path.

### Display:
The display consists of a simple form window which contains the rendering of the Mandlebrot. Colors are determined
by the ColorMap class, which maps the sequence's divergence number to a particular color.

### Zooming:
To zoom in on the Mandlebrot, simply click the screen. The program will render a zoomed version of the Mandlebrot at the
clicked location.

### Image Capture:
Whenever a frame is rendered, the pixels are saved to an image file. There is also a feature built in (but not currently
actived) which breaks each zoom into a series of smaller zooms, and captures an image for each sub-zoom.

### Video Generation:
Eventually, the idea is to take these images and convert them into a video, allowing users to create cool animations of
Mandlebrots. However, as of right now I've been unable to find a simple and light-weight video library to do this processing,
so for now it'll have to wait.

### Multi-Threading:
Since each pixel has its own Mandlebrot sequence associated with it, the rendering process lends itself well to multi-threading.
However, my testing indicated that multi-threading caused the program to be slower, and in some cases didn't work. This lead me
to temporarily disable this feature. I hope to eventually bring this back, since I have a good guess as to the cause of the problem.

### Why Zoom is Limited:
Because of the limitations of floating point precision, numbers in the complex plane can't always be properly represented with doubles. As a result, when zoom levels exceed a certain threshold, the render begins to get choppy. The intended fix for this is to create a RealNumber class which allows for arbitrary precision by containing a list of digits, and adding more as needed. As of right now, this hasn't been implemented.
