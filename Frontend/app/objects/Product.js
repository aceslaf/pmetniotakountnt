(function() {
	'use strict';
	angular
		.module('Frontend')
		.factory('Product', product);
	
	product.$inject = [];
	
	function product() {
		
		var Product = function Product(product) {
			angular.extend(this, {
				id : product.id,
				name : product.name,
				price : product.price,
				weight : product.weight,
				origin : product.origin
			});
		};
		
		angular.extend(Product.prototype, {
			getId : getId,
			setId : setId,
			getName : getName,
			setName : setName,
			getPrice : getPrice,
			setPrice : setPrice,
			getWeight : getWeight,
			setWeight : setWeight,
			getOrigin : getOrigin,
			setOrigin : setOrigin
		});
		
		return Prodict;
		
		function getId() {
			return id;
		}
		
		function setId(id) {
			this.id = id;
		}
		
		function getName() {
			return name;
		}
		
		function setName(name) {
			this.name = name;
		}
		
		function getPrice() {
			return price;
		}
		
		function setPrice(price) {
			this.price = price;
		}
		
		function getWeight() {
			return weight;
		}
		
		function setWeight(weight) {
			this.weight = weight;
		}
	}
})();