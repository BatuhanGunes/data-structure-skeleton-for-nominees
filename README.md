# data-structure-skeleton-for-nominees
An example project to provide an insight about Singly Linked List Node. 

## [Explanation of the Traveling Dealer problem solution]

* Let's assume that the dealer starts from the factory and comes to the factory after going around every customer.

> Suppose a dealer has traveled X distance for a customer. The same dealer will travel X to return to the factory.
> For this reason, the total distance traveled by the dealer for this customer will be 2*X. 
> This will result in the same for all customers.
> 
> In this problem, there is no shortest or longest route as it has to stop by the factory after every customer.
> All roads will be equidistant.
> 
> To find the total path, it will be sufficient to add the distances of all customers to the factory and multiply by 2.

* Let's assume that the dealer starts at point 'A' and reaches the factory reaching the first customer and goes around each remaining customer separately.

> Suppose the dealer takes the distance X from starting point 'A' to the first customer. Since it will return to the factory later, 
> it will travel the road between first customer and the factory. Will not return to the first customer again.
> 
> In this case, the total distance is found with the method described above in order to find the shortest distance.
> For the reasons explained earlier, first the distance between the first customer and the factory is subtracted from the total distance.
> As a second step, the distance to the first customer at the starting point 'A' is added.
> 
> Also, in order to make this road the shortest, it was provided to start from the customer closest to the starting point.

Considering the situations described above, necessary improvements have been made.

> * **Note:** I have defined the above node definitions by making sense of the graph in the document.

> * **Note2:** I multiplied the fractional numbers by 1000 during this definitions. So I got decimal numbers. To get a fractional result, I divide the result by 1000 and convert it to double.

## Contributors

* **Batuhan Güneş**  - [BatuhanGunes](https://github.com/BatuhanGunes)

See also the list of [contributors](https://github.com/BatuhanGunes/SaleApp/graphs/contributors) who participated in this project.

