(function () {
    'use strict';

    angular
        .module('movieApp')
        .controller('AddVideoController', AddVideoController);

    AddVideoController.$inject = ['videoService', '$rootScope', 'userService', '$location'];

    function AddVideoController(videoService, $rootScope, userService, $location) {
        var addVideoVm = this;

        addVideoVm.allMovies = [];
        var getUserName = localStorage.getItem('myUser');

        addVideoVm.myUser = JSON.parse(getUserName);
        addVideoVm.createVideo = createVideo;
        addVideoVm.deleteVideo = deleteVideo;
        addVideoVm.logOut = logOut;

        init();

        function init() {

           //console.log("my user is " + videoVm.myUser);


            videoService
                .getVideos()
                .then(function(data){
                    addVideoVm.allMovies = data;
                    console.log(data);
                }, function (error) {

                    console.log("ERRRRR : " + error );
                });




            // videoVm.sorter = {
            //     sortBy: 'imdbRating',
            //     sortOrder: false
            // };


        }

        function createVideo() {
            videoService
                .createVideo(addVideoVm.newVideo)
                .then(function (response) {
                    console.log("video created: " + response);
                    window.location.reload();
                },
                function (error) {
                   console.log("error creating video: " + error);
                });
        }

        function deleteVideo(id) {
            console.log("delete function invoked with video id: " +id);
            videoService
                .deleteVideo(id)
                .then(function (response) {
                    console.log("video deleted");
                    window.location.reload();
                }, function (error) {
                    console.log(error);
                });
        }


        function logOut() {

            localStorage.removeItem('myUser');

            $location.path('/login');

        }



    }

})();