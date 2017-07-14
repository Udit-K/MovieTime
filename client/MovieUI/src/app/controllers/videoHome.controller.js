(function () {
    'use strict';

    angular
        .module('movieApp')
        .controller('VideoHomeController', VideoHomeController);

    VideoHomeController.$inject = ['videoService', '$rootScope', 'userService', '$location'];

    function VideoHomeController(videoService, $rootScope, userService, $location) {
        var videoVm = this;

        videoVm.allMovies = [];
        var getUserName = localStorage.getItem('myUser');

        videoVm.myUser = JSON.parse(getUserName);


        videoVm.logOut = logOut;
        
        init();

        function init() {

            console.log("my user is " + videoVm.myUser);


            videoService.getVideos()
                    .then(function(data){
                        videoVm.allMovies = data;
                        console.log(data);
                    }, function (error) {

                        console.log("ERRRRR : " + error );
                    });





            videoVm.sorter = {
                sortBy: 'imdbRating',
                sortOrder: false
            };


        }

        function logOut() {

            localStorage.removeItem('myUser');

            $location.path('/login');

        }
        


    }

})();