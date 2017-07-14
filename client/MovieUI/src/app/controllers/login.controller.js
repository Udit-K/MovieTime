(function () {
    'use strict';

    angular
        .module('movieApp')
        .controller('LoginController', LoginController);

    LoginController.$inject = ['userService', '$location'];

    function LoginController(userService, $location) {

        var loginVm = this;

        loginVm.signIn = signIn;
        
        
        
        
        function signIn() {

            console.log("Trying login using :" + loginVm.email + ", " + loginVm.pass);

            userService
                .signInUser(loginVm.email, loginVm.pass)
                .then(function (response) {
                        console.log(response);
                            console.log("user signed in..");
                            localStorage.setItem('myUser', JSON.stringify(response));
                            $location.path('/video');
                        },
                        function (error) {
                            console.log(error);
                            alert("Error signing in... INVALID CREDENTIALS");
                        });

        }
    }


})();
