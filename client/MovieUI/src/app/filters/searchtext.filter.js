(function() {
    'use strict';

    angular
        .module('movieApp')
        .filter('searchFor', searchFilter);

    function searchFilter() {
        return function(arr, searchString) {

            if(!searchString) {
                return arr;
            }

            var result = [];

            angular.forEach(arr, function(item){
                if(item.title.toLowerCase().indexOf(searchString) !== -1 || item.genre.toLowerCase().indexOf(searchString) !== -1 || item.released.indexOf(searchString) !== -1 || item.type.indexOf(searchString) !== -1)
                {
                    result.push(item);
                }

            });

            return result;

        };
    }
})();