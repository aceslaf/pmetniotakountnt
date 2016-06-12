exports.config = {
	allScriptsTimeout: 11000,
	seleniumAddress: 'http://localhost:4444/wd/hub',
	specs: [
		'e2e/basicScenario.js',
		'e2e/account1Scenario.js',
		'e2e/account2Scenario.js',
		'e2e/account3Scenario.js',
		'e2e/account4Scenario.js'
		/*NOTE
		account1Scenario.js ,account2Scenario.js ,account3Scenario.js ,account4Scenario.js
		If running these test one after another, they will fail, because the Asterisk server
		logs out the users approx. 1 min after they had logged out, rather than logging them out
		momentarily. This is a bug.
		*/
	],
	capabilities: {
		browserName: 'chrome',
		//declaring chrome flags for using mocked 'getUserMedia' with fake mic and cam
		'chromeOptions': {
			args: [
				'--use-fake-device-for-media-stream',
				'--use-fake-ui-for-media-stream'
			]
		},
		count: 1, //for parallel testing
		shardTestFiles: true, //for executing saperate files in different browser instances
		maxInstances: 2 //setting active browser windows
	},
	handlesAlerts: true,
	framework: 'jasmine',
	jasmineNodeOpts: {
		defaultTimeoutInterval: 15000,
		showColors: true
	}
};
