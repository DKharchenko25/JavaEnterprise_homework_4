# Online shop control description

## Main HTTP Requests:

1. To get a Postman collection click following button:

[![Run in Postman](https://run.pstmn.io/button.svg)](https://www.postman.com/descent-module-engineer-29235143/workspace/onlineshoph2)

2. Database URL: 

```jdbc:h2:file:./src/main/resources/asnDB```

3. Create new shop with request (with text body):

```http://localhost:8080/shops/add```

4. Create new product with request (with body):

```http://localhost:8080/products/add```

5. Add person with request (with body):

```http://localhost:8080/persons/add```

6. Create carts for person with request (where "id" is a person id):

```http://localhost:8080/carts/add?id=1```

7. Add products to carts with request:

```http://localhost:8080/carts/cart-1/add-product?productId=1```

8. To get all carts:

```http://localhost:8080/carts/all```

## Additional requests:

1. Get all products - ```http://localhost:8080/products/all```
2. Remove product by id - ```http://localhost:8080/products/remove?id=1```
3. Get product by id - ```http://localhost:8080/products/product?id=1```
4. Update product name by id (with body) - ```http://localhost:8080/products/update-name?id=1```
5. Update product price by id (with body) - ```http://localhost:8080/products/update-price?id=1```
6. Get all persons - ```http://localhost:8080/persons/all```
7. Remove person by id - ```http://localhost:8080/persons/remove?id=1```
8. Get person by id - ```http://localhost:8080/persons/person?id=1```
9. Update person first name by id (with body) - ```http://localhost:8080/persons/update-first-name?id=1```
10. Update person last name by id (with body) - ```http://localhost:8080/persons/update-last-name?id=1```
11. Update person phone number by id (with body) - ```http://localhost:8080/persons/update-phone-number?id=1```
12. Remove shop by id - ```http://localhost:8080/shops/remove?id=1```
13. Get all shops - ```http://localhost:8080/shops/all```
14. Update shop name by id - ```http://localhost:8080/shops/update?id=1```
15. Remove cart by id - ```http://localhost:8080/carts/remove?id=1```
16. Get cart by id - ```http://localhost:8080/carts/cart?id=1```
17. Remove product from cart by cart id and product id - ```http://localhost:8080/carts/cart-1/remove-product?productId=1```
18. Remove all products from cart by id - ```http://localhost:8080/carts/cart-1/remove-all```

