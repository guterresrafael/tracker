var map;

function initialize() {

    var mapOptions = {
        zoom: 13,
        mapTypeId: google.maps.MapTypeId.ROADMAP
                // HYBRID //SATELLITE //TERRAIN
    };

    map = new google.maps.Map(document.getElementById('map_canvas'), mapOptions);
    google.maps.event.addDomListener(window, "load", initialize);
    setPosition(-31.7550485, -52.3760609);
}

function setPosition(latitude, longitude) {

    var pos = new google.maps.LatLng(latitude,
            longitude);

    var infowindow = new google.maps.InfoWindow({
        map: map,
        position: pos,
        content: 'My car is Here! :)'
    });

    map.setCenter(pos);

}

function handleNoGeolocation(errorFlag) {
    if (errorFlag) {
        var content = 'Error: The Geolocation service failed.';
    } else {
        var content = 'Error: Your browser doesn\'t support geolocation.';
    }

    var options = {
        map: map,
        position: new google.maps.LatLng(60, 105),
        content: content
    };

    var infowindow = new google.maps.InfoWindow(options);
    map.setCenter(options.position);
}

google.maps.event.addDomListener(window, 'load', initialize);