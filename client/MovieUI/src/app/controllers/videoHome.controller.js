(function () {
    'use strict';

    angular
        .module('movieApp')
        .controller('VideoHomeController', VideoHomeController);

    VideoHomeController.$inject = ['videoService', '$rootScope'];

    function VideoHomeController(videoService, $rootScope) {
        var videoVm = this;

        videoVm.allMovies = [];
        
        init();

        function init() {


            videoService.getVideos()
                    .then(function(data){
                        videoVm.allMovies = data;
                        console.log(data);
                    }, function (error) {

                        console.log("ERRRRR : " + error );
                    });


        }
        


    }

})();