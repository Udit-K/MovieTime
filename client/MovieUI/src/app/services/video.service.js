(function () {
    'use strict';

    angular
        .module('movieApp')
        .service('videoService', videoService);

    videoService.$inject = ['$http', '$q', 'CONFIG'];

    function videoService($http, $q, CONFIG) {
        var self = this;

        self.getVideos = getVideos;
        self.getVideoById = getVideoById;

        
        function getVideos() {
          return  $http.get(CONFIG.API_HOST + '/videos')
                .then(successFn, errorFn);
        }


        function getVideoById(id) {

            return $http.get(CONFIG.API_HOST + '/videos/' + id)
                .then(successFn, errorFn);
        }


        function successFn(response) {

            return response.data; //RESOLVE
           // console.log("RESOLVE: " + response.data)
        }

        function errorFn(response) {

            return $q.reject('Error:' + response.statusText); //REJECT
        }


    }



})();
