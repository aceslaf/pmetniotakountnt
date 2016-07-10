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
				origin : product.origin,
				description : product.description,
				type : product.type,
				thumbnail : product.thumbnail
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
			setOrigin : setOrigin,
			getDescription : getDescription,
			setDescription : setDescription,
			getType : getType,
			setType : setType,
			getThumbnail : getThumbnail,
			setThumbnail : setThumbnail
		});
		
		return Product;
		
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
		
		function getOrigin() {
			return origin;
		}
		
		function setOrigin(origin) {
			this.origin = origin;
		}
		
		function getDescription() {
			return description;
		}
		
		function setDescription(description) {
			this.description = description;
		}
		
		function getType() {
			return type;
		}
		
		function setType(type) {
			this.type = type;
		}
		
		function getThumbnail() {
			return thumbnail;
		}
		
		function setThumbnail(thumbnail) {
			this.thumbnail = thumbnail;
		}
	}
})();