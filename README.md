This project exists to reproduce [this issue](https://github.com/mapbox/mapbox-maps-android/issues/2398)
with Mapbox's Compose extensions for Android. To run the project, you will need to add
a string resource named `mapbox_access_token`, in addition to being generally set up to build
Mapbox-enabled projects.

When you run the app, you will see a map of the Earth on the top half of the screen, with a
white `Box()` below it. Tap the white box, and its height will be cut in half. You will see the
map's scale bar move downward as the `MapboxMap()` expands, but otherwise the newly-used space
is untouched. Notably, map tiles are not rendered there.

This is not tied to the viewport &mdash; you can change the center and zoom and get the same
results. However, if you change the code to simply remove the `Box()` instead of changing
its height, then the map redraws as expected.
