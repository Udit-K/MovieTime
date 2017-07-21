(function ()  {
    'use strict';


    angular
        .module('movieApp', ['ngRoute', 'ngMessages'])
        .config(moduleConfig)
        .run(runModule);


    moduleConfig.$inject = ['$routeProvider'];

    function moduleConfig($routeProvider) {

        $routeProvider
            .when('/login', {
                templateUrl: 'app/views/login.view.html',
                controller: 'LoginController',
                controllerAs: 'loginVm'
            })
            .when('/signup', {
                templateUrl: 'app/views/signup.view.html',
                controller: 'SignupController',
                controllerAs: 'signupVm'
            })
            .when('/video', {
                templateUrl: 'app/views/videohome.html',
                controller: 'VideoHomeController',
                controllerAs: 'videoVm'
            })
            .when('/video-detail/:id', {
                templateUrl: 'app/views/video-detail.tmpl.html',
                controller: 'VideoDetailController',
                controllerAs: 'videoDetailVm'
            })
            .when('/comments/:id', {
                templateUrl: 'app/views/review.tmpl.html',
                controller: 'ReviewController',
                controllerAs: 'reviewVm'
            })
            .when('/admin', {
                templateUrl: 'app/views/add-video.tmpl.html',
                controller: 'AddVideoController',
                controllerAs: 'addVideoVm'
            })
            .when('/edit-video/:id',{
                templateUrl: 'app/views/edit-video.tmpl.html',
                controller: 'EditVideoController',
                controllerAs: 'editVideoVm'
            })
            .when('/top-rated', {
                templateUrl: 'app/views/toprated.tmpl.html',
                controller: 'VideoHomeController',
                controllerAs: 'videoVm'
            })
            .otherwise({redirectTo: '/login'});
    }

    runModule.$inject = [];

    function runModule() {
        console.log('running..');
    }


})();