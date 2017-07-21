(function () {
    'use strict';

    angular
        .module('movieApp')
        .controller('ReviewController', ReviewController);

    ReviewController.$inject = ['reviewService','$routeParams'];

    function ReviewController(reviewService, $routeParams) {

        var reviewVm = this;

        reviewVm.review = {};
        reviewVm.getComments = getComments;

        function getComments() {
            reviewService
                .getComments($routeParams.id)
                .then(function (comments) {
                    reviewVm.comments = comments;
                }, function (error) {
                    console.log(error);
                });
        }

        function createComment() {
            reviewService
                .createComment($routeParams.id, review)
                .then(function (response) {
                    console.log(response);
                }, function (error) {
                    console.log(error);
                });
        }

    }

})();