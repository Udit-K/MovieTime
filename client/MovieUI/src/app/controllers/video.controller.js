(function () {

    angular
        .module('movietimeApp')
        .controller('VideoController', VideoController);

    VideoController.$inject = [];

    function VideoController() {
        var vm = this;

        vm.title = "THIS IS MY APP";

    }

})();