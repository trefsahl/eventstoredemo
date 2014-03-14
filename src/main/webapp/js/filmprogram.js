var kinoApp = angular.module('KinoApp', []);

kinoApp.controller('filmprogram', function ($scope, $http) {


    function setupServerSideEvents () {
        $scope.sse = [];
        var handleCallback = function (msg) {
            $scope.sse.unshift(msg.data);
            console.log("got event from server: " + msg.data);
            updateFilmprogram();
        }
        var source = new EventSource('rest/events');
        source.addEventListener('message',handleCallback);
    }

    function updateFilmprogram() {
        $http.get('rest/filmprogram').success(function (data) {
            $scope.filmprogram = data;
        });
    }

    $scope.opprettFilm = function () {
        $http.put('rest/filmprogram', {
            "navn": $scope.navn,
            "ledigeSeter": $scope.antallSeter
        });
    };

    $scope.reserverSete = function(film, reserverteSeter) {
        $http.put('rest/setereservering', {
            "forestilling": film,
            "reserverteSeter":reserverteSeter
        });
    };

    setupServerSideEvents();
    updateFilmprogram();
});

