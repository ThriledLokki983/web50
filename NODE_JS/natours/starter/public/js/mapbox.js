/*eslint-disable */
/**
 * Integrate this to run on the client's side
 */

const locations = JSON.parse(document.getElementById('map').dataset.locations);
console.log(locations);

mapboxgl.accessToken =
  'pk.eyJ1Ijoibmltb2hnaWRlb24iLCJhIjoiY2tvdmxnM2FxMDlmejJwcGVidmxieGd0NyJ9.8O0ydCHRwTFPbWwgbfF1hA';

var map = new mapboxgl.Map({
  container: 'map',
  style: 'mapbox://styles/nimohgideon/ckovm5y120epz17rurczgopou',
  scrollZoom: false,
  //   center: [-118.1134941, 34.111745],
  //   zoom: 10,
  //   interactive: false,
});

const bounds = new mapboxgl.LngLatBounds();

/**
 * Create the Marker
 * Add the marker
 * Add a Popup
 * Extend the map bounds to include current location
 */
locations.forEach((loc) => {
  const el = document.createElement('div');
  el.className = 'marker';

  new mapboxgl.Marker({
    element: el,
    anchor: 'bottom',
  })
    .setLngLat(loc.coordinates)
    .addTo(map);

  new mapboxgl.Popup({
    offset: 30,
  })
    .setLngLat(loc.coordinates)
    .setHTML(`<p>Day ${loc.day}: ${loc.description}</p>`)
    .addTo(map);

  bounds.extend(loc.coordinates);
});

/**
 * Fitting the bounds
 */
map.fitBounds(bounds, {
  padding: {
    top: 200,
    bottom: 150,
    left: 100,
    right: 100,
  },
});
