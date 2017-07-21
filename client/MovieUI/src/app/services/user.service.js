(function () {
    'use strict';

    angular
        .module('movieApp')
        .service('userService', userService);

    userService.$inject = ['$http','$q', 'CONFIG'];

    function userService($http,$q,CONFIG){
        var self = this;

        self.signUpUser=signUpUser;
        self.signInUser = signInUser;

        
        function signInUser(email, pass) {
            return $http.get(CONFIG.API_HOST + "/users/" + email + "/" + pass)
                .then(successFn, errorFn);
        }
        

        function signUpUser(user) {
            return $http.post(CONFIG.API_HOST + '/users', user)
                .then(successFn, errorFn);
        }
        function successFn(response) {
            return response.data;
        }

        function errorFn(response) {
            return $q.reject('ERROR: ' + response.statusText)

        }

    }

})();