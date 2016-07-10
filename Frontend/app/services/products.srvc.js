(function() {
	'use strict';
	angular
		.module('Frontend')
		.factory('products.srvc', productsSrvc);
	
	productsSrvc.$inject = [
        'Product'
	];
	
	function productsSrvc(Product) {
		var products = [];
		
		var service = {
				getAllProducts : getAllProducts,
				setAllProducts : setAllProducts,
				addProduct : addProduct,
				getProductById : getProductById
		};
		
		return service;
		
		function getAllProducts() {
			return products;
		}
		
		function setAllProducts(products) {
			this.products = products;
		}
		
		function addProduct(product) {
			products.push(product);
		}
		
		function getProductById(id) {
			//TODO implement this later
		}
	}
})();