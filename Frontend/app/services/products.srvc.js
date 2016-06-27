(function() {
	'use strict';
	angular
		.module('Frontend')
		.factory('products.srvc', productsSrvc);
	
	productsSrvc.$inject = [
        'Product'
	];
	
	function productsSrvc(Product) {
		var product;
		
		var service = {
				getAllProducts : getAllProducts,
				setAllProducts : setAllProducts,
				addProduct : addProduct,
				getProductById : getProductById
		};
		
		return service;
		
		function getAllProducts() {
			
		}
		
		function setAllProduct() {
			
		}
		
		function addProduct() {
			
		}
		
		function getProductById() {
			
		}
	}
})();