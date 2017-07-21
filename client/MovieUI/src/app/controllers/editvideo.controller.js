(function () {
    'use strict';

    angular
        .module('movieApp')
        .controller('EditVideoController', EditVideoController);

    EditVideoController.$inject = ['videoService', '$location', '$routeParams'];

    function EditVideoController(videoService, $location, $routeParams) {
        var editVideoVm = this;

        editVideoVm.video = {};
        editVideoVm.updateVideo = updateVideo;

        var getUserName = localStorage.getItem('myUser');

        editVideoVm.myUser = JSON.parse(getUserName);

        editVideoVm.logOut = logOut;

        init();

        function init() {



            videoService
                .getVideoById($routeParams.id)
                .then(function(data){
                    editVideoVm.video = data;
                    console.log(data);
                }, function (error) {
                    console.log("ERRRRR : " + error );
                });




        }

        function updateVideo() {
            console.log("update function invoked");
            videoService
                .editVideo($routeParams.id, editVideoVm.video)
                .then(function (response) {
                        console.log("video edited: " + response);
                        $location.path('/admin');
                    },
                    function (error) {
                        console.log("error creating video: " + error);
                    });
        }


        function logOut() {

            localStorage.removeItem('myUser');

            $location.path('/login');

        }



    }

})();