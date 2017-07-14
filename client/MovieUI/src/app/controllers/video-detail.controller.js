(function () {
    'use strict';
    
    
    angular
        .module('movieApp')
        .controller('VideoDetailController', VideoDetailController);

    VideoDetailController.$inject = ['videoService', '$routeParams'];
    
    function VideoDetailController(videoService, $routeParams) {

        var videoDetailVm = this;

        videoDetailVm.video = {};

        init();

        function init() {

            console.log('video detail controller invoked');
            console.log($routeParams);

            videoService
                .getVideoById($routeParams.id)
                .then(function (response) {
                    videoDetailVm.video = response;
                    console.log(response);
                },function (error) {
                   console.log(error);
                });


        }


    }
    
    
})();