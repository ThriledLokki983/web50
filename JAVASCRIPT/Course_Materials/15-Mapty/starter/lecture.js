navigator.geolocation && navigator.geolocation.getCurrentPosition(function (pos) {
    const {
        latitude
    } = pos.coords;
    const {
        longitude
    } = pos.coords;
    console.log(pos.coords);
    console.log(`https://www.google.com/maps/@${latitude},${longitude}`);

}, function () {
    alert('Could not get your location')
});