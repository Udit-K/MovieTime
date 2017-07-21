(function() {

    'use strict';

    angular.module('movieApp')
        .service('reviewService', reviewService);

    reviewService.$inject = ['$http', '$q', 'CONFIG'];
    function reviewService($http, $q, CONFIG) {

        var self = this;

        self.getComments = getComments;
        self.createComment = createComment;


        function getComments(id) {
            return $http.get(CONFIG.API_HOST+ '/comment/' + id + "/comments/")
                .then(successFn, errorFn);
        }

        function createComment(id, userId, review) {
            return $http.post(CONFIG.API_HOST +'/comment/'+ id + '/comments/' + userId, review)
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