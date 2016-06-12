// Karma configuration
// Generated on Fri Dec 19 2014 15:35:58 GMT+0200 (FLE Standard Time)

module.exports = function(config) {
    config.set({

        // base path that will be used to resolve all patterns (eg. files, exclude)
        basePath: '../',


        // frameworks to use
        // available frameworks: https://npmjs.org/browse/keyword/karma-adapter
        frameworks: ['jasmine'],


        // list of files / patterns to load in the browser
        files: [
            'assets/libs/jquery.min.js',
            'assets/libs/bootstrap.min.js',
            'assets/js/angular/angular.js',
            'assets/js/angular/angular-resource.min.js',
            'assets/js/angular/angular-route.min.js',
            'assets/js/angular/angular-mocks.js',
            'assets/libs/popup/modal.js',
            'assets/libs/popup/translation.js',
            'assets/js/sipml/SIPml-api.js',
            'app/app.module.js',
            'app/components/signalling/signallingService.js',
            'app/components/login/controllers/controller.js',
            'app/components/login/services/service.js',
            'app/components/dashboard/controllers/controller.js',
            'app/components/popup/controllers/readVoicemail.js',
            'app/components/popup/controllers/recordVoicemail.js',
            'app/components/popup/services/service.js',
            'test/unit/servicesSpec.js',
            'test/unit/loginControllerSpec.js',
            'test/unit/routeSpec.js'
        ],


        // list of files to exclude
        exclude: [],


        // preprocess matching files before serving them to the browser
        // available preprocessors: https://npmjs.org/browse/keyword/karma-preprocessor
        preprocessors: {},


        // test results reporter to use
        // possible values: 'dots', 'progress'
        // available reporters: https://npmjs.org/browse/keyword/karma-reporter
        reporters: ['progress'],


        // web server port
        port: 9876,


        // enable / disable colors in the output (reporters and logs)
        colors: true,


        // level of logging
        // possible values: config.LOG_DISABLE || config.LOG_ERROR || config.LOG_WARN || config.LOG_INFO || config.LOG_DEBUG
        logLevel: config.LOG_INFO,


        // enable / disable watching file and executing tests whenever any file changes
        autoWatch: true,


        // start these browsers
        // available browser launchers: https://npmjs.org/browse/keyword/karma-launcher
        browsers: ['Chrome'],

        plugins: [
            'karma-chrome-launcher',
            'karma-firefox-launcher',
            'karma-jasmine'
        ],


        // Continuous Integration mode
        // if true, Karma captures browsers, runs the tests and exits
        singleRun: false
    });
};
