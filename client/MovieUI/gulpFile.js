var gulp = require('gulp');
var clean = require('gulp-clean');
var inject = require('gulp-inject');
var browsersync = require('browser-sync').create();
var angularFilesort = require('gulp-angular-filesort');
var bowerFiles = require('main-bower-files');


var config = {
    paths: {
        src: './src',
        build: './build',
        bower: './bower_components'
    }
};

gulp.task('clean', function () {

    return gulp.src(config.paths.build, {read: false})
        .pipe(clean());
});



gulp.task('inject', function () {

        var cssFiles = gulp.src([
            config.paths.src + '/**/*.css'
        ], {read: false});

        var jsFiles = gulp.src([
            config.paths.src + '/**/*.js'
        ]);

        return gulp.src(config.paths.src + '/index.html')
            .pipe(inject(gulp.src(bowerFiles(), {read: false}), {name: 'bower'}))
            .pipe(inject(cssFiles, {ignorePath: 'src', addRootSlash: false}))
            .pipe(inject(jsFiles.pipe(angularFilesort()), {ignorePath: 'src', addRootSlash: false}))
            .pipe(gulp.dest(config.paths.build));

});

gulp.task('serve',['inject'], function () {

    browsersync.init({

        server: {
            baseDir: [config.paths.build, config.paths.src, config.paths.bower],

            routes: {
                '/bower_components': 'bower_components'
            }
        },
        files: [
            config.paths.src + '/**/*'
        ]
    });
});
