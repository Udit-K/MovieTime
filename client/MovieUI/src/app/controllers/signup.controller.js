(function () {
    'use strict';

    angular
        .module('movieApp')
        .controller('SignupController', SignupController);

    SignupController.$inject = ['userService','$location'];

    function SignupController(userService, $location) {

       var signupVm = this;

        signupVm.createUser=createUser;

        function createUser(){
        console.log(signupVm.newUser);
            userService
                .signUpUser(signupVm.newUser)
                .then(function (data) {
                    if(data){
                        alert("Sign up Successful, Redirecting...")
                        $location.path('/login');
                    }
                }, function (error) {
                    console.log(error);
                });
        }

    }


})();
