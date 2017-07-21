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
        self.createVideo = createVideo;
        self.deleteVideo = deleteVideo;
        self.editVideo = editVideo;
        
        function getVideos() {
          return  $http.get(CONFIG.API_HOST + '/videos')
                .then(successFn, errorFn);
        }


        function getVideoById(id) {

            return $http.get(CONFIG.API_HOST + '/videos/' + id)
                .then(successFn, errorFn);
        }

        function createVideo(video) {

            return $http.post(CONFIG.API_HOST + '/videos', video)
                .then(successFn, errorFn);
        }

        function deleteVideo(id) {
            return $http.delete(CONFIG.API_HOST + '/videos/' + id)
                .then(successFn, errorFn);
        }

        function editVideo(id, video) {
            return $http.put(CONFIG.API_HOST + '/videos/' + id, video)
                .then(successFn, errorFn);
        }

        function successFn(response) {

            return response.data; //RESOLVE

        }

        function errorFn(response) {

            return $q.reject('Error:' + response.statusText); //REJECT
        }


    }



})();
