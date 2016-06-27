module.exports = function(grunt) {

    // load tasks
    //grunt.loadNpmTasks('grunt-contrib-jshint');
    grunt.loadNpmTasks('grunt-html2js');
    grunt.loadNpmTasks('grunt-contrib-clean');
    grunt.loadNpmTasks('grunt-contrib-copy');
    grunt.loadNpmTasks('grunt-contrib-concat');
    grunt.loadNpmTasks('grunt-contrib-uglify');
    grunt.loadNpmTasks('grunt-contrib-less');
    grunt.loadNpmTasks('grunt-ng-annotate');
    grunt.loadNpmTasks('grunt-text-replace');
    grunt.loadNpmTasks('grunt-cachebuster');
    grunt.loadNpmTasks('grunt-wiredep');
    grunt.loadNpmTasks('grunt-war');
    grunt.loadNpmTasks('grunt-tomcat-deploy');
    grunt.loadNpmTasks('grunt-contrib-watch');

    grunt.initConfig({
        pkg: grunt.file.readJSON('package.json'),

        env: grunt.option('env') || 'Dev',

        clean: {
            beforeBuild: ['.tmp', 'dist'],
            tmp: ['.tmp'],
            // Remove annotated files
            afterBuildDev: ['<%= ngAnnotate.dest %>', '<%= ngAnnotate.dest %>.map'],
            // Remove annotated js, concat js and source map for prod
            afterBuildProd: ['<%= ngAnnotate.dest %>', '<%= concat.default.dest %>', 'dist/*.map']
        },

        // Compile less files
        less: {
            default: {
                options: {
                    compress: true
                },
                files: {
                    "assets/css/main.css": "resources/less/main.less"
                }
            }
        },

        //For now not using jshint finds too many errors in the files to fix them
        //Verify js files for code quality
        jshint: {
            all: [
                'Gruntfile.js',

                // libraries from assets
                'assets/libs/stomp/stomp.js',
                'assets/libs/ui_bootstrap/ui-bootstrap-tpls-0.12.1.js',
                'assets/libs/angular-notify/dist/angular-notify.min.js',

                // our angular files
                'app/app.module.js',
                'app/app.routes.js',
                'app/components/**/*.js',
                'app/services/*.js',
                'app/filters/*.js',
                'app/directives/**/*.js',
                'app/constants/*.js',
                'app/configs/*.js'
            ]
        },

        html2js: {
            options: {
                base: './'
            },
            default: {
                src: ['app/components/**/*.tmpl.html', 'app/directives/**/*.tmpl.html'],
                dest: '.tmp/templates.js'
            }
        },

        copy: {
            default: {
                files: [{
                    src: ['index.html'],
                    dest: 'dist/index.html'
                }, {
                    src: ['assets/**', 'bower_components/**/*.js', 'bower_components/**/*.css', 'bower_components/**/*.png'],
                    dest: 'dist/'
                }]
            },
            rawProject: {
                files: [{
                    src: ['app/**'],
                    dest: 'dist/'
                }]
            },
            forTemplatesInjection: {
                files: [{
                    src: 'app/app.module.js',
                    dest: '.tmp/'
                }]
            }
        },

        replace: {
            injectTemplateModule: {
                src: ['.tmp/app/app.module.js'],
                overwrite: true,
                replacements: [{
                    // make sure to inject the template module
                    from: '.module(\'Frontend\', [',
                    to: '.module(\'Frontend\', [\'templates-default\','
                }]
            },
            // Unused but helpful if you want to
            // raw (one to one file copy) deploy on host:port/some/other/path istead of host:port/
            // Be sure to change tomcat_deploy's path and the default deploy task
            rawTemplatesPath: {
                src: ['dist/app/**/*.js'],
                overwrite: true,
                replacements: [{
                    from: '../',
                    to: '../Frontend'
                }]
            },
            css: {
                src: ['dist/index.html'],
                overwrite: true,
                replacements: [{
                    // Remove all link tags
                    from: /\s*<link rel="stylesheet"[^>]*>\s*/g,
                    to: ''
                }, {
                    // Add compiled bootstrap and compiled stylesheet via link to head
                    // Don't forget to add any new stylesheets here instead of adding them directly into index.html
                    from: /(<\/head>)/,
                    to: '\n\t<link rel="stylesheet" href="assets/css/bootstrap.min.css"/>' +
                        // TODO: merge main.css and app.css into a single file
                    '\n\t<link rel="stylesheet" href="assets/css/main.css"/>' +
                    '\n\t<link rel="stylesheet" href="assets/css/app.css"/>' +
                    '\n\t<link rel="stylesheet" href="assets/libs/angular-notify/angular-notify.min.css" />' +
                    '\n\t<link rel="stylesheet" href="bower_components/jquery-ui/themes/smoothness/jquery-ui.css" />\n$1'
                }]
            },
            useConcatJs: {
                src: ['dist/index.html'],
                overwrite: true,
                replacements: [{
                    // Remove all script tags
                    from: /\s*<script[^>]+><\/script>\s*/g,
                    to: ''
                }, {
                    //add concated script to body
                    from: /(<\/body>)/,
                    to: '\n\t<script src="core.js"></script>\n$1'
                }]
            },
            useMinJs: {
                src: ['dist/index.html'],
                overwrite: true,
                replacements: [{
                    // Remove all script tags
                    from: /\s*<script[^>]+><\/script>\s*/g,
                    to: ''
                }, {
                    //add minified script to body
                    from: /(<\/body>)/,
                    to: '\n\t<script src="core.min.js"></script>\n$1'
                }]
            }
        },

        concat: {
            options: {
                //Separator between concatenated files
                separator: ';'
            },
            default: {
                src: [

                    // libraries from assets
                    'assets/libs/angular-notify/**/*.js',
                    //Order of concationation of the following two files matters
                    'assets/libs/flowType/**/*.js',
                    'assets/libs/stomp/**/*.js',
                    // our angular files
                    // template cache module added
                    '.tmp/app/app.module.js',
                    'app/!(app.module).js',
                    'app/constants/*.js',
                    'app/configs/environment<%= env %>.cnst.js',
                    'app/configs/application.cnst.js',
                    'app/configs/protocolResolver.srvc.js',
                    'app/objects/*.js',
                    'app/components/**/*.js',
                    'app/services/*.js',
                    'app/filters/*.js',
                    'app/directives/**/*.js',

                    // freshly created  tamplates module form html2js
                    '.tmp/templates.js'
                ],

                dest: 'dist/core.js'
            }
        },

        cachebuster: {
            build: {
                options: {
                    format: 'json',
                    basedir: 'dist'
                },
                src: ['<%= concat.default.dest %>', 'dist/assets/css/app.css'],
                dest: 'dist/cachebusters.json'
            }
        },

        wiredep: {
            app: {
                src: [
                    'dist/index.html'
                ],
                options: {
                    ignorePath: '../'
                }
            }
        },

        ngAnnotate: {
            options: {
                // Separator between concatenated files if any
                separator: ';',
                // Generate source map so the stack trace maps to the original core.js when using minified js
                sourceMap: '<%= ngAnnotate.dest %>.map'
            },
            dist: {
                files: {
                    '<%= ngAnnotate.dest %>': ['<%= concat.default.dest %>']
                }
            },
            dest: 'dist/core.annotated.js'
        },

        uglify: {
            options: {
                banner: '/*! <%= pkg.name %> <%= grunt.template.today("dd-mm-yyyy") %> */\n',
                // Use source map genned by ngAnnotate based on core.js
                sourceMap: true,
                sourceMapIn: '<%= ngAnnotate.options.sourceMap %>'
            },
            dist: {
                files: {
                    'dist/core.min.js': ['<%= ngAnnotate.dest %>']
                }
            }
        },

        war: {
            target: {
                options: {
                    war_dist_folder: 'build/',
                    war_name: 'Website',
                    //webxml_welcome: 'dist/index.html',
                    webxml_display_name: 'Front End',
                    webxml_mime_mapping: [{
                        extension: 'woff',
                        mime_type: 'application/font-woff'
                    }]
                },
                files: [{
                    expand: true,
                    cwd: 'dist/',
                    src: ['**'],
                    dest: '.'
                }]
            }
        },

        tomcat_deploy: {
            war: 'build/Website.war',
            host: '10.1.3.97',
            login: 'tomcat',
            password: 'tomcat',
            // Here you can change your frontend deploy path
            // Be sure to update the replace task and
            // the default deploy task if you want a raw deploy on a different path
            path: '/',
            port: 8080,
            dist: 'dist',
            deploy: '/manager/text/deploy',
            undeploy: '/manager/text/undeploy'
        },

        watch: {
            options: {
                dateFormat: function(time) {
                    grunt.log.writeln('The watch finished in ' + time + 'ms at' + (new Date()).toString());
                    grunt.log.writeln('Waiting for more changes...');
                }
            },
            files: ['app/*'],
            tasks: ['default']
        }
    });

    grunt.event.on('watch', function(action, filepath, target) {
        grunt.log.writeln(target + ': ' + filepath + ' has ' + action);
    });

    // Build task for local dev environment (raw)
    grunt.registerTask('default', [
        'clean:beforeBuild',
        'less:default',						// compile less files to css
        'copy:default',						// copy the assets folder and index.html to dist directory
        'copy:rawProject',					// copy the project file tree to dist
        // 'replace:rawTemplatesPath',			// change the templates lookup dir
        'war:target',						// builds a war file in build directory
        'tomcat_redeploy:default'			// deploys the war on the local tomcat
    ]);

    // Build task for local dev environment (concat only)
    grunt.registerTask('nomin', [
        'clean:beforeBuild',
        'less:default',						// compile less files to css
        //'jshint:all',
        'html2js:default',					// generate templates.js
        'copy:default',						// copy the assets folder and index.html to dist directory
        'copy:forTemplatesInjection',		// copy the app.module.js to .tmp directory
        'replace:injectTemplateModule',		// make sure the template module is loaded
        'replace:css',
        'replace:useConcatJs',
        'concat:default',					// concat all *.js
        'cachebuster:build',				// removes chache
        'wiredep:app',						// auto wire bower dependecies to html
        'clean:tmp',
        'war:target',						// builds a war file in build directory
        'tomcat_redeploy:default'			// deploys the war on the local tomcat
    ]);

    // Build task for local dev environment (concat + minify + source map)
    grunt.registerTask('min', [
        'clean:beforeBuild',
        'less:default',						// compile less files to css
        //'jshint:all',
        'html2js:default',					// generate templates.js
        'copy:default',						// copy the assets folder and index.html to dist directory
        'copy:forTemplatesInjection',		// copy the app.module.js to .tmp directory
        'replace:injectTemplateModule',		// make sure the template module is loaded
        'replace:css',
        'replace:useMinJs',
        'concat:default',					// concat all *.js
        'cachebuster:build',				// removes chache
        'wiredep:app',						// auto wire bower dependecies to html
        'ngAnnotate:dist',					// annotate js files to make Angular work properly
        'uglify:dist',						// uglify will break Angular without annotate
        'clean:tmp',
        'clean:afterBuildDev',
        'war:target',						// builds a war file in build directory
        'tomcat_redeploy:default'			// deploys the war on the local tomcat
    ]);

    // Build without deploying (minified)
    // If env is Prod source map will be removed
    // Jenkins uses this to build for dev, test, prod
    grunt.registerTask('build-nodeploy', [
        'clean:beforeBuild',
        'less:default',						// compile less files to css
        //'jshint:all',
        'html2js:default',					// generate templates.js
        'copy:default',						// copy the assets folder and index.html to dist directory
        'copy:forTemplatesInjection',		// copy the app.module.js to .tmp directory
        'replace:injectTemplateModule',		// make sure the template module is loaded
        'replace:css',
        'replace:useMinJs',
        'concat:default',					// concat all *.js
        'cachebuster:build',				// removes chache
        'wiredep:app',						// auto wire bower dependecies to html
        'ngAnnotate:dist',					// annotate js files to make Angular work properly
        'uglify:dist',						// uglify will break Angular without annotate
        'clean:tmp',
        'clean:afterBuild' + grunt.config.get('env'),
        'war:target'						// builds a war file in build directory
    ]);
};
